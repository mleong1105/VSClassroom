package function.mainfx;

import function.mainfx.static_obj.Balloon;
import function.mainfx.static_obj.BeverageDispenser;
import function.mainfx.static_obj.Blackboard;
import function.mainfx.static_obj.DiscoBall;
import function.mainfx.static_obj.DiscussionTable;
import function.mainfx.static_obj.FoodTable;
import function.mainfx.static_obj.HighOutputPowerSpeaker;
import function.mainfx.static_obj.LearningDesk;
import function.mainfx.static_obj.LectureDesk;
import function.mainfx.static_obj.Light;
import function.mainfx.static_obj.LowOutputPowerSpeaker;
import function.mainfx.static_obj.NormalProjector;
import function.mainfx.static_obj.Noticeboard;
import function.mainfx.static_obj.Projector;
import function.mainfx.static_obj.SmartBoard;
import function.mainfx.static_obj.Speaker;
import function.mainfx.static_obj.Whiteboard;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MultiClassroomController {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private Pane objPane;

    @FXML
    private ComboBox<String> modeComboBox;

    @FXML
    private ToggleButton projectorToggleButton;

    @FXML
    private ToggleButton speakerToggleButton;

    @FXML
    private ComboBox<String> songCollection;

    private MultipurposeClassroom classroom;

    private String song = "";

    @FXML
    public void initialize() {
        classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        Blackboard blackboard = Blackboard.getInstanceBlackboard();
        Light light = Light.getInstanceLight("Light");
        Speaker speaker = Speaker.getInstanceSpeaker("Song 1");
        LearningDesk learningDesk = LearningDesk.getInstanceLearningDesk();
        LectureDesk lectureDesk = LectureDesk.getInstanceLectureDesk();
        Noticeboard noticeboard = Noticeboard.getInstanceNoticeboard();

        DiscussionTable discussionTable = DiscussionTable.getInstanceDiscussionTable();
        Whiteboard whiteboard = Whiteboard.getInstanceWhiteboard();
        SmartBoard smartBoard = SmartBoard.getInstanceSmartBoard(230, 350);
        Balloon balloon = Balloon.getInstanceBalloon();
        DiscoBall discoBall = DiscoBall.getInstanceDiscoBall(150, 150, "Red");
        BeverageDispenser bd = BeverageDispenser.getInstanceBeverageDispenser(1, 100);
        FoodTable ft = FoodTable.getInstanceFoodTable();

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

        projectorToggleButton = new ToggleButton("Switch Projector");
        projectorToggleButton.setTranslateX(150);
        projectorToggleButton.setOnAction(e -> handleProjectorToggle(cf));

        songCollection = new ComboBox<>(FXCollections.observableArrayList("discosong.mp3"));
        songCollection.setTranslateX(150);
        songCollection.setTranslateY(60);
        songCollection.setOnAction(e -> selectSong());

        speakerToggleButton = new ToggleButton("Switch Speaker");
        speakerToggleButton.setTranslateX(150);
        speakerToggleButton.setTranslateY(30);
        speakerToggleButton.setOnAction(e -> handleSpeakerToggle(cf, song.toString()));

        objPane.getChildren().addAll(classroom.getObjPane(), modeComboBox, projectorToggleButton, songCollection,
                speakerToggleButton);
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

    private void handleProjectorToggle(ClassroomFacade cf) {
        // MultipurposeClassroom classroom = cf.getClassroom();
        Projector projector = Projector.getInstanceProjector();

        // Toggle between SmartBoard and Projector behaviors
        if (projectorToggleButton.isSelected()) {
            projector.setProjectorBehaviour(SmartBoard.getInstanceSmartBoard(0, 0));
            projector.projectingScreen();
        } else {
            projector.setProjectorBehaviour(NormalProjector.getInstanceNormalProjector(null, null));
            projector.projectingScreen();
        }
    }

    private void selectSong() {
        song = "/function/mainfx/resources/song/" + songCollection.getValue();
    }

    private void handleSpeakerToggle(ClassroomFacade cf, String musicName) {
        // MultipurposeClassroom classroom = cf.getClassroom();
        Speaker speaker = Speaker.getInstanceSpeaker(null);
        System.out.println(song);
        if (speakerToggleButton.isSelected()) {
            speaker.setSpeakerBehaviour(HighOutputPowerSpeaker.getInstancHighOutputPowerSpeaker(musicName));
            speaker.playingSound(musicName);
        } else {
            speaker.setSpeakerBehaviour(LowOutputPowerSpeaker.getInstancLowOutputPowerSpeaker(musicName));
            speaker.playingSound(musicName);
        }
    }
}
