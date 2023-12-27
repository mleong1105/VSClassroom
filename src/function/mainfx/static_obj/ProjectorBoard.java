package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class ProjectorBoard extends ClassObj {
    public ProjectorBoard() {
        super("/function/mainfx/resources/image/projectorScreen_off.png", 380, 200, 210, 100);
    }

    public void on(){
        this.setClassObject("/function/mainfx/resources/image/projectorScreen_off.png",  380, 200, 210, 100);
    }

    public void off(){
        // this.setClassObject("/function/mainfx/resources/image/projectorScreen_off.png",  380, 200, 210, 100);
        this.setClassObject("/function/mainfx/resources/image/blackboard.png", 400, 200, 200, 100);
    }
}