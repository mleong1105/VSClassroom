package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class SmartBoard extends ClassObj{
    int screenHeight;
    int screenWidth;
    boolean touchCapability;
    
    public SmartBoard(int screenHeight, int screenWidth) {
        super("/function/mainfx/resources/image/smartboard.png", screenWidth, screenHeight, 220, 90);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.touchCapability = false;
    }

    public void on(){
        System.out.println("smartboard on");
    }

    public void off(){
        System.out.println("smartboard off");
    }

    public void enableTouch(){
        this.touchCapability = true;
        System.out.println("Enable Touch");
    }

    public void disableTouch(){
        this.touchCapability = false;
        System.out.println("Disable Touch");
    }

    public void displayContent(String content){
        System.out.println(content);
    }
}
