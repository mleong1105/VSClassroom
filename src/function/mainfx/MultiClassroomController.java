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

public class MultiClassroomController {

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

        ClassroomFacade cf = new ClassroomFacade(classroom, objFactory, backgroundImageView, objPane, modeComboBox);
        cf.initialClassSetting();
        cf.setBackgroundImg();
        cf.addModeComponents();
        cf.setUpRemoteControl();
        cf.addControl();

        // Use ChangeListener to detect changes in the combo box value
        // modeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
        //     cf.handleModeSelection();
        // });
    }
}
