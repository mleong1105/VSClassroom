package function.mainfx;

import function.mainfx.class_mode.DefaultMClass;
import function.mainfx.class_mode.LessonMClass;
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
        classroom = new DefaultMClass();
        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());

        Button startClassBtn = new Button("Start Class");
        startClassBtn.setLayoutX(520);
        startClassBtn.setLayoutY(5);
        startClassBtn.setOnAction(e -> {
            startClass();
        });

        Button endClassBtn = new Button("End Class");
        endClassBtn.setLayoutX(600);
        endClassBtn.setLayoutY(5);
        endClassBtn.setOnAction(e -> {
            endClass();
        });

        modeComboBox = new ComboBox<>(FXCollections.observableArrayList("Lesson", "Discussion", "Party"));
        modeComboBox.setLayoutX(680);
        modeComboBox.setLayoutY(5);
        modeComboBox.setPromptText("Select Mode");
        modeComboBox.setOnAction(e -> handleModeSelection());

        objPane.getChildren().addAll(classroom.getObjPane(), startClassBtn, endClassBtn, modeComboBox);
    }

    private void startClass() {
        System.out.println("Class Started");
    }

    private void endClass() {
          backgroundImageView.setImage(classroom.getBackgroundDarkImageView().getImage());
    }

    private void handleModeSelection() {
        String selectedMode = modeComboBox.getValue();
        System.out.println("Selected Mode: " + selectedMode);

        // // Adjust logic based on the selected mode
        // switch (selectedMode) {
        //     case "Lesson":
        //         classroom = new LessonMClass();
        //         break;
        //     // Add cases for other modes as needed
        // }

        // Update the background image or perform other actions based on the selected mode
        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());
    }
}
