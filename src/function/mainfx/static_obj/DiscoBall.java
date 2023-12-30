package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class DiscoBall extends ClassObj{

    private String color;

    // Singleton instance
    private volatile static DiscoBall uniqueInstanceDiscoBall;    

    // Private constructor
    private DiscoBall(String description, String imgPath, String color){
        super(imgPath, 150, 150, 300, 5, description);
        this.color = color;
    }

    // Public method to get the singleton instance
    public static DiscoBall getInstanceDiscoBall(String description, String imgPath, String color) {
        if (uniqueInstanceDiscoBall == null) {
            synchronized (DiscoBall.class) {
                if (uniqueInstanceDiscoBall == null) {
                    uniqueInstanceDiscoBall = new DiscoBall(description, imgPath, color);
                }
            }
        }
        return uniqueInstanceDiscoBall;
    }

    public void on(){
        System.out.println("Disco ball is on");
    }

    public void off(){
        System.out.println("Disco ball is off");
    }

    public void changeColor(String color){
        this.color = color;
        System.out.println("Disco ball change color to " + color);
    }
}
