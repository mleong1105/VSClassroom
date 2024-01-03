package function.mainfx;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MultipurposeClassroom {

    private ImageView backgroundImageView;
    private Pane objPane;
    private List<ClassObj> objList;

    // Singleton instance
    private volatile static MultipurposeClassroom uniqueInstanceMultipurposeClassroom;

    // Private constructor
    private MultipurposeClassroom() {
        initializeBackground();
        initializeObjectPane();
        objList = new ArrayList<>();
    }

    // Public method to get the singleton instance
    public static MultipurposeClassroom getInstanceMultipurposeClassroom() {
        if (uniqueInstanceMultipurposeClassroom == null) {
            synchronized (MultipurposeClassroom.class) {
                if (uniqueInstanceMultipurposeClassroom == null) {
                    uniqueInstanceMultipurposeClassroom = new MultipurposeClassroom();
                }
            }
        }
        return uniqueInstanceMultipurposeClassroom;
    }

    private void initializeBackground() {
        Image backgroundImage = new Image(
                getClass().getResourceAsStream("/function/mainfx/resources/image/background.jpg"));
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

    public Pane getObjPane() {
        return objPane;
    }

    public List<ClassObj> getObjList() {
        return objList;
    }
}
