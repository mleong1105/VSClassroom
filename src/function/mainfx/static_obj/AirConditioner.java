package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class AirConditioner extends ClassObj {

    private String description;

    // Singleton instance
    private volatile static AirConditioner uniqueInstanceAirConditioner;

    // Private constructor
    private AirConditioner(String description) {
        super("/function/mainfx/resources/image/airCon_off.png", 180, 180, 620, -40);
        this.description = description;
    }

    // Public method to get the singleton instance
    public static AirConditioner getInstanceAirCon(String description) {
        if (uniqueInstanceAirConditioner == null) {
            synchronized (AirConditioner.class) {
                if (uniqueInstanceAirConditioner == null) {
                    uniqueInstanceAirConditioner = new AirConditioner(description);
                }
            }
        }
        return uniqueInstanceAirConditioner;
    }

    public void on(){
        this.setClassObject("/function/mainfx/resources/image/airCon_on.png", 180, 180, 620, -40);
    }

    public void off(){
        this.setClassObject("/function/mainfx/resources/image/airCon_off.png", 180, 180, 620, -40);
    }
}
