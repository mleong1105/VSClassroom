package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Projector extends ClassObj {

    private ProjectorBehaviour projectorBehaviour;

    // Singleton instance
    private volatile static Projector uniqueInstanceProjector;

    // Private constructor
    private Projector() {
        super("/function/mainfx/resources/image/projector.png", 100, 100, 350, 5);
        this.projectorBehaviour = NormalProjector.getInstanceNormalProjector(null, null);
    }

    // Public method to get the singleton instance
    public static Projector getInstanceProjector() {
        if (uniqueInstanceProjector == null) {
            synchronized (Projector.class) {
                if (uniqueInstanceProjector == null) {
                    uniqueInstanceProjector = new Projector();
                }
            }
        }
        return uniqueInstanceProjector;
    }

    public void setProjectorBehaviour(ProjectorBehaviour projectorBehaviour) {
        this.projectorBehaviour = projectorBehaviour;
    }

    public void projectingScreen() {
        projectorBehaviour.project();
    }

    // public void on() {
    // // open projector
    // // open showing screen
    // System.out.println(description + " on");
    // }

    // public void off() {
    // System.out.println(description + " off");
    // }

    // public void wideScreenMode() {
    // System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
    // }

    // public void tvMode() {
    // System.out.println(description + " in tv mode (4x3 aspect ratio)");
    // }

    // public String toString() {
    // return description;
    // }

}
