package function.mainfx;

import function.mainfx.static_obj.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import function.mainfx.command.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MultipurposeClassroomController {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private Pane objPane;

    @FXML
    private ComboBox<String> modeComboBox;

    private MultipurposeClassroom classroom;

    @FXML
    public void initialize() {
        classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        MultipurposeClassroomFacade mcf = new MultipurposeClassroomFacade(classroom, backgroundImageView,
                objPane, modeComboBox);
        mcf.initialClassSetting();
        mcf.setBackgroundImg();
        mcf.addModeComponents();
        mcf.setUpRemoteControl();
        mcf.addControl();
        mcf.setSpeakerBehaviour();
        mcf.setProjectorBehaviour();
    }
}
