package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Fan extends ClassObj {

    private String description;

    // Singleton instance
    private volatile static Fan uniqueInstanceFan;

    // Private constructor
    private Fan(String description) {
        super("/function/mainfx/resources/image/fan_off.png", 150, 150, 200, -25);
        this.description = description;
    }

    // Public method to get the singleton instance
    public static Fan getInstanceFan(String description) {
        if (uniqueInstanceFan == null) {
            synchronized (Fan.class) {
                if (uniqueInstanceFan == null) {
                    uniqueInstanceFan = new Fan(description);
                }
            }
        }
        return uniqueInstanceFan;
    }

    public void on() {
        this.setClassObject("/function/mainfx/resources/image/fan_on.png", 150, 150, 200, -25);
    }

    public void off() {
        this.setClassObject("/function/mainfx/resources/image/fan_off.png", 150, 150, 200, -25);
    }
}
