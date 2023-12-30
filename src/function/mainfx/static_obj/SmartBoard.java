package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class SmartBoard extends ClassObj{
    private boolean touchCapability;
    
    // Singleton instance
    private volatile static SmartBoard uniqueInstanceSmartBoard;    

    // Private constructor
    private SmartBoard(String description, String imgPath) {
        super(imgPath, 230, 350, 220, 90, description);
        this.touchCapability = false;
    }

    // Public method to get the singleton instance
    public static SmartBoard getInstanceSmartBoard(String description, String imgPath) {
        if (uniqueInstanceSmartBoard == null) {
            synchronized (SmartBoard.class) {
                if (uniqueInstanceSmartBoard == null) {
                    uniqueInstanceSmartBoard = new SmartBoard(description, imgPath);
                }
            }
        }
        return uniqueInstanceSmartBoard;
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
