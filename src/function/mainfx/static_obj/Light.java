package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Light extends ClassObj {    

    String onImgPath, offImgPath;
    // Singleton instance
    private volatile static Light uniqueInstanceLight;    

    // Private constructor
    private Light(String description, String onImgPath, String offImgPath ) {
        super(offImgPath, 100, 100, 350, 5, description);
        this.onImgPath = onImgPath;
        this.offImgPath = offImgPath;
    }

    // Public method to get the singleton instance
    public static Light getInstanceLight(String description, String onImgPath, String offImgPath) {
        if (uniqueInstanceLight == null) {
            synchronized (Light.class) {
                if (uniqueInstanceLight == null) {
                    uniqueInstanceLight = new Light(description, onImgPath, offImgPath);
                }
            }
        }
        return uniqueInstanceLight;
    }

    public void on(){
        this.setClassObject(onImgPath, 100, 100, 350, 5);
        System.out.println(description + " on");
    }

    public void off(){
        this.setClassObject(offImgPath, 100, 100, 350, 5);
        System.out.println(description + " off");
    }

    public void dim(int level){
        System.out.println(description + " dim at level "+ level);
    }

    public String toString(){
        return description;
    }
}
