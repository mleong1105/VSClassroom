package function.mainfx;

import function.mainfx.command.AirConditionerOff;
import function.mainfx.command.AirConditionerOn;
import function.mainfx.command.Command;
import function.mainfx.command.FanOff;
import function.mainfx.command.FanOn;
import function.mainfx.command.LightOff;
import function.mainfx.command.LightOn;
import function.mainfx.command.MacroCommand;
import function.mainfx.command.ProjectorOff;
import function.mainfx.command.ProjectorOn;
import function.mainfx.command.RemoteControl;
import function.mainfx.command.SpeakerOff;
import function.mainfx.command.SpeakerOn;
import function.mainfx.static_obj.*;
import function.mainfx.strategy.HighOutputPower;
import function.mainfx.strategy.LowOutputPower;
import function.mainfx.strategy.NormalScreen;
import function.mainfx.strategy.TouchScreen;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipurposeClassroomFacade {

    ImageView backgroundImageView;
    Pane objPane;
    ComboBox<String> modeComboBox;
    RemoteControl remoteControl;
    ComboBox<String> speakerMode;
    ComboBox<String> projectorMode;

    MultipurposeClassroom classroom;
    Speaker speaker;
    Noticeboard noticeboard;
    LearningDesk learningDesk;
    LectureDesk lectureDesk;
    Light light;
    SmartBoard smartBoard;
    Balloon balloon;
    DiscoBall discoBall;
    BeverageDispenser beverageDispenser;
    FoodTable foodTable;
    DiscussionTable discussionTable;
    Whiteboard whiteboard;
    Fan fan;
    AirConditioner airCon;
    ProjectorBoard projectorBoard;

    public MultipurposeClassroomFacade(MultipurposeClassroom classroom, ClassObjFactory objFac,
            ImageView backgroundImageView, Pane objPane, ComboBox<String> modeComboBox) {
        this.backgroundImageView = backgroundImageView;
        this.objPane = objPane;
        this.modeComboBox = modeComboBox;
        this.classroom = classroom;

        this.speaker = objFac.createSpeaker();
        this.noticeboard = objFac.createNoticeboard();
        this.learningDesk = objFac.createLearningDesk();
        this.lectureDesk = objFac.createLectureDesk();
        this.light = objFac.createLight();
        this.smartBoard = objFac.createSmartBoard();
        this.balloon = objFac.createBalloon();
        this.discoBall = objFac.createDiscoBall();
        this.beverageDispenser = objFac.createBeverageDispenser();
        this.foodTable = objFac.createFoodTable();
        this.discussionTable = objFac.createDiscussionTable();
        this.whiteboard = objFac.createWhiteboard();
        this.fan = objFac.createFan();
        this.airCon = objFac.createAirCon();
        this.projectorBoard = objFac.createProjectorBoard();
    }

    public void setMode(String mode) {
        if (mode == null) {
            return;
        }
        switch (mode) {
            case "Lesson":
                initialClassSetting();
                classroom.addObjectinList(learningDesk);
                break;
            case "Party":
                initialClassSetting();
                classroom.addObjectinList(balloon);
                classroom.addObjectinList(discoBall);
                classroom.addObjectinList(beverageDispenser);
                classroom.addObjectinList(foodTable);
                break;
            case "Discussion":
                initialClassSetting();
                classroom.addObjectinList(discussionTable);
                classroom.addObjectinList(whiteboard);
                break;
            default:
                initialClassSetting();
                break;
        }
    }

    public void initialClassSetting() {
        classroom.clearObjectinList();
        classroom.addObjectinList(speaker);
        speaker.playingSound();
        classroom.addObjectinList(noticeboard);
        classroom.addObjectinList(lectureDesk);
        classroom.addObjectinList(light);
        classroom.addObjectinList(fan);
        classroom.addObjectinList(airCon);
        classroom.addObjectinList(projectorBoard);
    }

    public void setBackgroundImg() {
        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());
    }

    public void addModeComponents() {
        modeComboBox = new ComboBox<>(FXCollections.observableArrayList("Lesson", "Discussion", "Party"));
        modeComboBox.setLayoutX(680);
        modeComboBox.setLayoutY(550);
        modeComboBox.setPromptText("Select Mode");
        modeComboBox.setOnAction(e -> addModeCBChangeListener());

        objPane.getChildren().addAll(classroom.getObjPane(), modeComboBox);
    }

    public void addModeCBChangeListener() {
        String selectedMode = modeComboBox.getValue();
        System.out.println("Selected Mode: " + selectedMode);
        setMode(selectedMode);

        objPane.getChildren().clear();
        objPane.getChildren().addAll(classroom.getObjPane().getChildren());
        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());
        addModeComponents();
        addControl();
        setSpeakerBehaviour();
        setProjectorBehaviour();
    }

    public void setSpeakerBehaviour() {
        speakerMode = new ComboBox<>(FXCollections.observableArrayList("Low Output Power", "High Output Power"));
        speakerMode.setLayoutX(440);
        speakerMode.setLayoutY(550);
        speakerMode.setPromptText("Low Output Power");
        speakerMode.setOnAction(e -> setSpeakerBehaviourChangeListener());

        objPane.getChildren().addAll(speakerMode);
    }

    public void setSpeakerBehaviourChangeListener() {
        String mode = speakerMode.getValue();

        if (mode.equalsIgnoreCase("High Output Power")) {
            speaker.setSpeakerBehaviour(new HighOutputPower());
            speaker.playingSound();
        } else if (mode.equalsIgnoreCase("Low Output Power")) {
            speaker.setSpeakerBehaviour(new LowOutputPower());
            speaker.playingSound();
        }
    }

    public void setProjectorBehaviour() {
        projectorMode = new ComboBox<>(FXCollections.observableArrayList("Normal Screen", "Touch Screen"));
        projectorMode.setLayoutX(440);
        projectorMode.setLayoutY(510);
        projectorMode.setPromptText("Normal Screen");
        projectorMode.setOnAction(e -> setProjectorBehaviourChangeListener());

        objPane.getChildren().addAll(projectorMode);
    }

    public void setProjectorBehaviourChangeListener() {
        String mode = projectorMode.getValue();

        if (mode.equalsIgnoreCase("Touch Screen")) {
            projectorBoard.setProjectorBehaviour(new TouchScreen());
        } else if (mode.equalsIgnoreCase("Normal Screen")) {
            projectorBoard.setProjectorBehaviour(new NormalScreen());
        }
    }

    public void addControl() {
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

    public void setUpRemoteControl() {
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
