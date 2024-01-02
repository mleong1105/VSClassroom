package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Fan extends ClassObj {
    private String onImgPath, offImgPath;
    // Singleton instance
    private volatile static Fan uniqueInstanceFan;

    private Fan(String onImgPath, String offImgPath) {
        super(offImgPath, 150, 150, 200, -25);
        this.onImgPath = onImgPath;
        this.offImgPath = offImgPath;
    }

    // Public method to get the singleton instance
    public static Fan getInstanceFan(String onImgPath, String offImgPath) {
        if (uniqueInstanceFan == null) {
            synchronized (Fan.class) {
                if (uniqueInstanceFan == null) {
                    uniqueInstanceFan = new Fan(onImgPath, offImgPath);
                }
            }
        }
        return uniqueInstanceFan;
    }

    public void on() {
        this.setClassObject(onImgPath, 150, 150, 200, -25);
    }

    public void off() {
        this.setClassObject(offImgPath, 150, 150, 200, -25);
    }
}
