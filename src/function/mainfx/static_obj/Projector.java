package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Projector extends ClassObj {

    String description;
    LaptopPlayer laptopPlayer;
    

    public Projector(String description, LaptopPlayer laptopPlayer){
        super("/function/mainfx/resources/image/projector.png", 100, 100, 350, 5);
        this.description = description;
        this.laptopPlayer = laptopPlayer;
    }

    public void on(){
        //open projector
        //open showing screen
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void wideScreenMode() {
        System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
    }

    public void tvMode() {
        System.out.println(description + " in tv mode (4x3 aspect ratio)");
    }

    public String toString() {
        return description;
    }




}
