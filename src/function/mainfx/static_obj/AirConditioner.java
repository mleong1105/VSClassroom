package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class AirConditioner extends ClassObj {
    private String onImgPath, offImgPath;
    // Singleton instance
    private volatile static AirConditioner uniqueInstanceAirConditioner;

    private AirConditioner(String description, String onImgPath, String offImgPath) {
        super(offImgPath, 180, 180, 620, -40, description);
        this.onImgPath = onImgPath;
        this.offImgPath = offImgPath;
    }

    // Public method to get the singleton instance
    public static AirConditioner getInstanceAirCon(String description, String onImgPath, String offImgPath) {
        if (uniqueInstanceAirConditioner == null) {
            synchronized (AirConditioner.class) {
                if (uniqueInstanceAirConditioner == null) {
                    uniqueInstanceAirConditioner = new AirConditioner(description, onImgPath, offImgPath);
                }
            }
        }
        return uniqueInstanceAirConditioner;
    }

    public void on(){
        this.setClassObject(onImgPath, 180, 180, 620, -40);
    }

    public void off(){
        this.setClassObject(offImgPath, 180, 180, 620, -40);
    }

    public String getOnImgPath() {
        return this.onImgPath;
    }

    public String getOffImgPath() {
        return this.offImgPath;
    }
}
