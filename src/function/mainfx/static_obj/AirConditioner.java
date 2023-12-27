package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class AirConditioner extends ClassObj {
    public AirConditioner() {
        super("/function/mainfx/resources/image/airCon_off.png", 180, 180, 620, -40);
    }

    public void on(){
        this.setClassObject("/function/mainfx/resources/image/airCon_on.png", 180, 180, 620, -40);
    }

    public void off(){
        this.setClassObject("/function/mainfx/resources/image/airCon_off.png", 180, 180, 620, -40);
    }
}
