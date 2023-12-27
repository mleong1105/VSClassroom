package function.mainfx;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Classroom {

    private ImageView backgroundImageView;
    private Pane objPane;
    private List<ClassObj> objList;

    public Classroom() {
        initializeBackground();
        initializeObjectPane();
        objList = new ArrayList<>();
    }

    private void initializeBackground() {
        Image backgroundImage = new Image(getClass().getResourceAsStream("/function/mainfx/resources/image/background.jpg"));
        backgroundImageView = new ImageView(backgroundImage);
    }

    private void initializeObjectPane() {
        objPane = new Pane();
    }

    public void addObjectinList(ClassObj obj) {
        objPane.getChildren().add(obj.getObjectImageView());
        objList.add(obj);
    }

    public void removeObjectinList(ClassObj obj) {
        objPane.getChildren().remove(obj.getObjectImageView());
        objList.remove(obj);
    }

    public void clearObjectinList() {
        objPane.getChildren().clear();
        objList.clear();
    }

    public ImageView getBackgroundImageView() {
        return backgroundImageView;
    }

    public ImageView getBackgroundDarkImageView() {
        Image backgroundImage = new Image(getClass().getResourceAsStream("/function/mainfx/resources/image/background-dark.png"));
        ImageView backgroundDarkImageView = new ImageView(backgroundImage);
        return backgroundDarkImageView;
    }

    public Pane getObjPane() {
        return objPane;
    }

    public List<ClassObj> getObjList() {
        return objList;
    }
}
