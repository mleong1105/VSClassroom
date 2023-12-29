package function.mainfx.static_obj;

import function.mainfx.ClassObj;
import function.mainfx.MultipurposeClassroom;

public class NormalProjector extends ClassObj implements ProjectorBehaviour {

    private String description;
    private LaptopPlayer laptopPlayer;

    // Singleton instance
    private volatile static NormalProjector uniqueInstanceNormalProjector;

    // Private constructor
    private NormalProjector(String description, LaptopPlayer laptopPlayer) {
        super("/function/mainfx/resources/image/projector.png", 100, 100, 350, 50);
        this.description = description;
        this.laptopPlayer = laptopPlayer;
    }

    // Public method to get the singleton instance
    public static NormalProjector getInstanceNormalProjector(String description, LaptopPlayer laptopPlayer) {
        if (uniqueInstanceNormalProjector == null) {
            synchronized (NormalProjector.class) {
                if (uniqueInstanceNormalProjector == null) {
                    uniqueInstanceNormalProjector = new NormalProjector(description, laptopPlayer);
                }
            }
        }
        return uniqueInstanceNormalProjector;
    }

    public void on() {
        // open NormalProjector
        // open showing screen
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

    @Override
    public void project() {
        MultipurposeClassroom classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        classroom.removeObjectinList(SmartBoard.getInstanceSmartBoard(0, 0));
        classroom.addObjectinList(NormalProjector.getInstanceNormalProjector(description, laptopPlayer));
    }

}
