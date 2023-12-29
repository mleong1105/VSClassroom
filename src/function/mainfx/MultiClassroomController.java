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

public class MultiClassroomController {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private Pane objPane;

    @FXML
    private ComboBox<String> modeComboBox;

    private MultipurposeClassroom classroom;
    private Blackboard blackboard;
    private Light light;
    private Speaker speaker;
    private LearningDesk learningDesk;
    private LectureDesk lectureDesk;
    private Noticeboard noticeboard;
    private DiscussionTable discussionTable;
    private Whiteboard whiteboard;
    private SmartBoard smartBoard;
    private Balloon balloon;
    private DiscoBall discoBall;
    private BeverageDispenser bd;
    private FoodTable ft;
    private AirConditioner airCon;
    private Fan fan;
    private ProjectorBoard projectorBoard;
    private RemoteControl remoteControl;

    @FXML
    public void initialize() {
        classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        blackboard = Blackboard.getInstanceBlackboard();
        light = Light.getInstanceLight("Light");
        speaker = Speaker.getInstanceSpeaker("Song 1");
        learningDesk = LearningDesk.getInstanceLearningDesk();
        lectureDesk = LectureDesk.getInstanceLectureDesk();
        noticeboard = Noticeboard.getInstanceNoticeboard();

        discussionTable = DiscussionTable.getInstanceDiscussionTable();
        whiteboard = Whiteboard.getInstanceWhiteboard();
        smartBoard = SmartBoard.getInstanceSmartBoard(230, 350);
        balloon = Balloon.getInstanceBalloon();
        discoBall = DiscoBall.getInstanceDiscoBall(150, 150, "Red");
        bd = BeverageDispenser.getInstanceBeverageDispenser(1, 100);
        ft = FoodTable.getInstanceFoodTable();
        fan = Fan.getInstanceFan("Fan");
        airCon = AirConditioner.getInstanceAirCon("AirCon");
        projectorBoard = ProjectorBoard.getInstanceProjectorBoard("ProjectorBoard");

        ClassroomFacade cf = new ClassroomFacade(classroom, speaker, noticeboard, learningDesk, lectureDesk, light,
                smartBoard, balloon, discoBall, bd, ft, discussionTable, whiteboard, fan, airCon, projectorBoard);
        cf.initialClassSetting();

        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());

        addComponents(cf, classroom); // Pass the ClassroomFacade argument
        setUpRemoteControl();
        addControl();

        // Use ChangeListener to detect changes in the combo box value
        modeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            handleModeSelection(cf);
        });
    }

    private void addComponents(ClassroomFacade cf, MultipurposeClassroom classroom) {
        modeComboBox = new ComboBox<>(FXCollections.observableArrayList("Lesson", "Discussion", "Party"));
        modeComboBox.setLayoutX(680);
        modeComboBox.setLayoutY(550);
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
        addControl();
    }

    private void addControl() {
        VBox VBoxControlScene = new VBox(10);
        Scene controlScene = new Scene(VBoxControlScene, 300, 450);

        Stage controlStage = new Stage();
        controlStage.setScene(controlScene);

        Button toControlSceneButton = new Button("Control");
        toControlSceneButton.setLayoutX(610);
        toControlSceneButton.setLayoutY(550);
        toControlSceneButton.setOnAction(e -> controlStage.show());

        // Remote Control Button
        Button airConOnButton = new Button("Air Conditioner On");
        Button airConOffButton = new Button("Air Conditioner Off");
        Button fanOnButton = new Button("Fan On");
        Button fanOffButton = new Button("Fan Off");
        Button lightOnButton = new Button("Light On");
        Button lightOffButton = new Button("Light Off");
        Button speakerOnButton = new Button("Speaker On");
        Button speakerOffButton = new Button("Speaker Off");
        Button projectorOnButton = new Button("Projector On");
        Button projctorOffButton = new Button("Projector Off");
        Button enterClassButton = new Button("Enter Class");
        Button leaveClassButton = new Button("Leave Class");

        // Set up command for each button
        airConOnButton.setOnAction(e -> remoteControl.onButtonWasPressed(0));
        airConOffButton.setOnAction(e -> remoteControl.offButtonWasPressed(0));
        fanOnButton.setOnAction(e -> remoteControl.onButtonWasPressed(1));
        fanOffButton.setOnAction(e -> remoteControl.offButtonWasPressed(1));
        lightOnButton.setOnAction(e -> remoteControl.onButtonWasPressed(2));
        lightOffButton.setOnAction(e -> remoteControl.offButtonWasPressed(2));
        speakerOnButton.setOnAction(e -> remoteControl.onButtonWasPressed(3));
        speakerOffButton.setOnAction(e -> remoteControl.offButtonWasPressed(3));
        projectorOnButton.setOnAction(e -> remoteControl.onButtonWasPressed(4));
        projctorOffButton.setOnAction(e -> remoteControl.offButtonWasPressed(4));
        enterClassButton.setOnAction(e -> remoteControl.onButtonWasPressed(5));
        leaveClassButton.setOnAction(e -> remoteControl.offButtonWasPressed(5));

        VBoxControlScene.getChildren().addAll(airConOnButton, airConOffButton, fanOnButton, fanOffButton,
                lightOnButton, lightOffButton, speakerOnButton, speakerOffButton, projectorOnButton,
                projctorOffButton, enterClassButton, leaveClassButton);

        objPane.getChildren().addAll(toControlSceneButton);
    }

    private void setUpRemoteControl() {
        remoteControl = new RemoteControl();
        Command airConOn = new AirConditionerOn(airCon);
        Command airConOff = new AirConditionerOff(airCon);
        Command fanOn = new FanOn(fan);
        Command fanOff = new FanOff(fan);
        Command lightOn = new LightOn(light);
        Command lightOff = new LightOff(light);
        Command speakerOn = new SpeakerOn(speaker);
        Command speakerOff = new SpeakerOff(speaker);
        Command projectorOn = new ProjectorOn(projectorBoard);
        Command projectorOff = new ProjectorOff(projectorBoard);

        Command[] enterClass = { airConOn, fanOn, lightOn, speakerOn, projectorOn };
        Command[] leaveClass = { airConOff, fanOff, lightOff, speakerOff, projectorOff };

        MacroCommand enterClassMacro = new MacroCommand(enterClass);
        MacroCommand leaveClassMacro = new MacroCommand(leaveClass);

        remoteControl.setCommands(0, airConOn, airConOff);
        remoteControl.setCommands(1, fanOn, fanOff);
        remoteControl.setCommands(2, lightOn, lightOff);
        remoteControl.setCommands(3, speakerOn, speakerOff);
        remoteControl.setCommands(4, projectorOn, projectorOff);
        remoteControl.setCommands(5, enterClassMacro, leaveClassMacro);

    }
}
