package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Fan extends ClassObj {
    public Fan() {
        super("/function/mainfx/resources/image/fan_off.png", 150, 150, 200, -25);
    }

    public void on(){
        this.setClassObject("/function/mainfx/resources/image/fan_on.png",150, 150, 200, -25);
    }

    public void off(){
        this.setClassObject("/function/mainfx/resources/image/fan_off.png", 150, 150, 200, -25);
    }
}
