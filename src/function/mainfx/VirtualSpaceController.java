package function.mainfx;

import function.mainfx.class_mode.LessonMClass;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VirtualSpaceController {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private Pane objPane;
    private Classroom classroom;

    @FXML
    public void initialize() {
        classroom = new LessonMClass();
        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());
        objPane.getChildren().add(classroom.getObjPane());
    }
}
