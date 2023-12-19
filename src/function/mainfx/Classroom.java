package function.mainfx;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Classroom {
    
    private ImageView backgroundImageView;
    private Pane objPane;
    private List<ClassObj> objList;

    public Classroom(String mode) {
        initializeBackground();
        initializeObjectPane();
        objList = new ArrayList<>();

        initializeModeObjects(mode);
    }

    private void initializeBackground() {
        Image backgroundImage = new Image(getClass().getResourceAsStream("/function/mainfx/resources/image/background.jpg"));
        backgroundImageView = new ImageView(backgroundImage);
    }

    private void initializeObjectPane() {
        objPane = new Pane();
    }

    protected abstract void initializeModeObjects(String mode);

    public void addObjectinList(ClassObj obj) {
        objPane.getChildren().add(obj.getObjectImageView());
        objList.add(obj);
    }

    public void removeObjectinList(ClassObj obj) {
        objPane.getChildren().remove(obj.getObjectImageView());
        objList.remove(obj);
    }

    public ImageView getBackgroundImageView() {
        return backgroundImageView;
    }

    public Pane getObjPane() {
        return objPane;
    }

    public List<ClassObj> getObjList() {
        return objList;
    }
}