package function.mainfx;

import java.util.ArrayList;
import java.util.List;

import function.mainfx.classroom_mode.DefaultMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Classroom {

    private ImageView backgroundImageView;
    private ClassroomMode mode;

    // beloow two should put under ClassroomMode class
    // private Pane objPane;
    // private List<ClassObj> objList;

    public Classroom() {
        this.mode = new DefaultMode();
        initializeBackground();
        // initializeObjectPane();
        // objList = new ArrayList<>();

        // initializeModeObjects(mode);
    }

    private void initializeBackground() {
        Image backgroundImage = new Image(getClass().getResourceAsStream("/function/mainfx/resources/image/background.jpg"));
        backgroundImageView = new ImageView(backgroundImage);
    }

    public void setMode(ClassroomMode mode) {
        this.mode = mode;
    }

    public ClassroomMode getMode() {
        return mode;
    }

    // private void initializeObjectPane() {
    //     objPane = new Pane();
    // }

    //  protected abstract void initializeModeObjects(String mode);
    // public void addObjectinList(ClassObj obj) {
    //     objPane.getChildren().add(obj.getObjectImageView());
    //     objList.add(obj);
    // }

    // public void removeObjectinList(ClassObj obj) {
    //     objPane.getChildren().remove(obj.getObjectImageView());
    //     objList.remove(obj);
    // }

    public ImageView getBackgroundImageView() {
        return backgroundImageView;
    }

    public ImageView getBackgroundDarkImageView() {
        Image backgroundImage = new Image(getClass().getResourceAsStream("/function/mainfx/resources/image/background-dark.png"));
        ImageView backgroundDarkImageView = new ImageView(backgroundImage);
        return backgroundDarkImageView;
    }

    // public Pane getObjPane() {
    //     return objPane;
    // }

    // public List<ClassObj> getObjList() {
    //     return objList;
    // }
}
