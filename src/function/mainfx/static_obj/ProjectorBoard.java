package function.mainfx.static_obj;

import function.mainfx.ClassObj;
import function.mainfx.strategy.NormalScreen;
import function.mainfx.strategy.ProjectorBehaviour;

public class ProjectorBoard extends ClassObj {
    String onImgPath, offImgPath;
    ProjectorBehaviour projectorBehaviour;
    // Singleton instance
    private volatile static ProjectorBoard uniqueInstanceProjectorBoard;

    // Private constructor
    private ProjectorBoard(String onImgPath, String offImgPath) {
        super(offImgPath, 380, 200, 210, 100);
        this.onImgPath = onImgPath;
        this.offImgPath = offImgPath;
        this.projectorBehaviour = new NormalScreen();
    }

    // Public method to get the singleton instance
    public static ProjectorBoard getInstanceProjectorBoard(String onImgPath, String offImgPath) {
        if (uniqueInstanceProjectorBoard == null) {
            synchronized (ProjectorBoard.class) {
                if (uniqueInstanceProjectorBoard == null) {
                    uniqueInstanceProjectorBoard = new ProjectorBoard(onImgPath, offImgPath);
                }
            }
        }
        return uniqueInstanceProjectorBoard;
    }

    public void on() {
        this.setClassObject(onImgPath, 380, 200, 210, 100);
        projectorBehaviour.project();
    }

    public void off() {
        this.setClassObject(offImgPath, 380, 200, 210, 100);
        projectorBehaviour.clearCanvas();
    }

    public void setProjectorBehaviour(ProjectorBehaviour projectorBehaviour) {
        this.projectorBehaviour = projectorBehaviour;
    }

}