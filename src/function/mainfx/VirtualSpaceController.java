package function.mainfx;

import function.mainfx.static_obj.Balloon;
import function.mainfx.static_obj.BeverageDispenser;
import function.mainfx.static_obj.Blackboard;
import function.mainfx.static_obj.DiscoBall;
import function.mainfx.static_obj.DiscussionTable;
import function.mainfx.static_obj.FoodTable;
import function.mainfx.static_obj.LearningDesk;
import function.mainfx.static_obj.LectureDesk;
import function.mainfx.static_obj.Light;
import function.mainfx.static_obj.Noticeboard;
import function.mainfx.static_obj.SmartBoard;
import function.mainfx.static_obj.Speaker;
import function.mainfx.static_obj.Whiteboard;
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

    @FXML
    private ComboBox<String> modeComboBox;

    private MultipurposeClassroom classroom;

    @FXML
    public void initialize() {
        classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        Blackboard blackboard = new Blackboard();
        Light light = new Light("Light");
        Speaker speaker = new Speaker("Song 1");
        LearningDesk learningDesk = new LearningDesk();
        LectureDesk lectureDesk = new LectureDesk();
        Noticeboard noticeboard = new Noticeboard();

        DiscussionTable discussionTable = new DiscussionTable();
        Whiteboard whiteboard = new Whiteboard();
        SmartBoard smartBoard = new SmartBoard(230, 350);
        Balloon balloon = new Balloon();
        DiscoBall discoBall = new DiscoBall(150, 150, "Red");
        BeverageDispenser bd = new BeverageDispenser(1, 100);
        FoodTable ft = new FoodTable();

        ClassroomFacade cf = new ClassroomFacade(classroom, speaker, noticeboard, learningDesk, lectureDesk, light,
                smartBoard, balloon, discoBall, bd, ft, discussionTable, whiteboard);
        cf.initialClassSetting();

        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());

        addComponents(cf, classroom); // Pass the ClassroomFacade argument

        // Use ChangeListener to detect changes in the combo box value
        modeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            handleModeSelection(cf);
        });
    }

    private void addComponents(ClassroomFacade cf, MultipurposeClassroom classroom) {
        modeComboBox = new ComboBox<>(FXCollections.observableArrayList("Lesson", "Discussion", "Party"));
        modeComboBox.setLayoutX(680);
        modeComboBox.setLayoutY(5);
        modeComboBox.setPromptText("Select Mode");
        modeComboBox.setOnAction(e -> handleModeSelection(cf));

        objPane.getChildren().addAll(classroom.getObjPane(), modeComboBox);
    }

    private void handleModeSelection(ClassroomFacade cf) {
        MultipurposeClassroom classroom = cf.getClassroom();
        String selectedMode = modeComboBox.getValue();
        System.out.println("Selected Mode: " + selectedMode);
        cf.setMode(selectedMode);

        objPane.getChildren().clear();
        objPane.getChildren().addAll(classroom.getObjPane().getChildren());
        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());
        addComponents(cf, classroom);
    }
}
