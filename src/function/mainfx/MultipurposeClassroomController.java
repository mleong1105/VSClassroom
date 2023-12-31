package function.mainfx;

import function.mainfx.static_obj.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import function.mainfx.command.*;
import function.mainfx.factory.DefaultObjFactory;
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
    private ClassObjFactory objFactory;

    @FXML
    public void initialize() {
        classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        objFactory = new DefaultObjFactory();

        MultipurposeClassroomFacade mcf = new MultipurposeClassroomFacade(classroom, objFactory, backgroundImageView,
                objPane, modeComboBox);
        mcf.initialClassSetting();
        mcf.setBackgroundImg();
        mcf.addModeComponents();
        mcf.setUpRemoteControl();
        mcf.addControl();
        mcf.setSpeakerBehaviour();
        mcf.setProjectorBehaviour();

        // Use ChangeListener to detect changes in the combo box value
        // modeComboBox.valueProperty().addListener((observable, oldValue, newValue) ->
        // {
        // cf.handleModeSelection();
        // });
    }
}
