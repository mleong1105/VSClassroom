package function.mainfx.static_obj;

import function.mainfx.ClassObj;
import function.mainfx.MultipurposeClassroom;

public class SmartBoard extends ClassObj implements ProjectorBehaviour {
    private int screenHeight;
    private int screenWidth;
    private boolean touchCapability;

    // Singleton instance
    private volatile static SmartBoard uniqueInstanceSmartBoard;

    // Private constructor
    private SmartBoard(int screenHeight, int screenWidth) {
        super("/function/mainfx/resources/image/smartboard.png", screenWidth, screenHeight, 220, 90);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        this.touchCapability = false;
    }

    // Public method to get the singleton instance
    public static SmartBoard getInstanceSmartBoard(int screenHeight, int screenWidth) {
        if (uniqueInstanceSmartBoard == null) {
            synchronized (SmartBoard.class) {
                if (uniqueInstanceSmartBoard == null) {
                    uniqueInstanceSmartBoard = new SmartBoard(screenHeight, screenWidth);
                }
            }
        }
        return uniqueInstanceSmartBoard;
    }

    public void on() {
        System.out.println("smartboard on");
    }

    public void off() {
        System.out.println("smartboard off");
    }

    public void enableTouch() {
        this.touchCapability = true;
        System.out.println("Enable Touch");
    }

    public void disableTouch() {
        this.touchCapability = false;
        System.out.println("Disable Touch");
    }

    public void displayContent(String content) {
        System.out.println(content);
    }

    @Override
    public void project() {
        MultipurposeClassroom classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        classroom.removeObjectinList(NormalProjector.getInstanceNormalProjector(null, null));
        classroom.addObjectinList(uniqueInstanceSmartBoard);
    }
}
