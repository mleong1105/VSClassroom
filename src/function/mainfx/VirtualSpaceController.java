package function.mainfx;

import function.mainfx.classroom_mode.DefaultMode;
import function.mainfx.classroom_mode.DiscussionMode;
import function.mainfx.classroom_mode.LessonMode;
import function.mainfx.classroom_mode.PartyMode;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VirtualSpaceController {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private Pane objPane;

    private Classroom classroom;

    @FXML
    private ComboBox<String> modeComboBox;

    @FXML
    public void initialize() {
        classroom = new Classroom();
    
        ClassroomFacade cf = new ClassroomFacade(classroom); // Default mode on initialization
        cf.initialClassSetting();
    
        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());
    
        addComponents(cf); // Pass the ClassroomFacade argument
    
        // Use ChangeListener to detect changes in the combo box value
        modeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            handleModeSelection(cf);
        });
    }

    private void addComponents(ClassroomFacade cf) {
        Button startClassBtn = new Button("Start Class");
        startClassBtn.setLayoutX(520);
        startClassBtn.setLayoutY(5);
        startClassBtn.setOnAction(e -> startClass());
    
        Button endClassBtn = new Button("End Class");
        endClassBtn.setLayoutX(600);
        endClassBtn.setLayoutY(5);
        endClassBtn.setOnAction(e -> endClass());
    
        modeComboBox = new ComboBox<>(FXCollections.observableArrayList("Lesson", "Discussion", "Party"));
        modeComboBox.setLayoutX(680);
        modeComboBox.setLayoutY(5);
        modeComboBox.setPromptText("Select Mode");
        modeComboBox.setOnAction(e -> handleModeSelection(cf));
    
        objPane.getChildren().addAll(classroom.getMode().getObjPane(), startClassBtn, endClassBtn, modeComboBox);
    }

    private void startClass() {
        System.out.println("Class Started");
    }

    private void endClass() {
        backgroundImageView.setImage(classroom.getBackgroundDarkImageView().getImage());
    }

    private void handleModeSelection(ClassroomFacade cf) {
        String selectedMode = modeComboBox.getValue();
        System.out.println("Selected Mode: " + selectedMode);
        cf.setMode(selectedMode);
    
        // Clear existing objects and add objects from the new mode
        objPane.getChildren().clear();
        objPane.getChildren().addAll(classroom.getMode().getObjPane().getChildren());
        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());
        // Explicitly set the layout coordinates for the buttons
        addComponents(cf); // Pass the ClassroomFacade argument
    }
}
