package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class DiscoBall extends ClassObj{

    int height;
    int width;
    String color;

    public DiscoBall(int height, int width, String color){
        super("/function/mainfx/resources/image/discoball.png", width, height, 300, 5);
        this.height = height;
        this.width = width;
        this.color = color;
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
