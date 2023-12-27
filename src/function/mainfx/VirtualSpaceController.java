package function.mainfx;

import function.mainfx.classroom_mode.DefaultMode;
import function.mainfx.classroom_mode.DiscussionMode;
import function.mainfx.classroom_mode.LessonMode;
import function.mainfx.classroom_mode.PartyMode;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import function.mainfx.command.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import function.mainfx.static_obj.*;

public class VirtualSpaceController {

    @FXML
    private ImageView backgroundImageView;

    @FXML
    private Pane objPane;

    private Classroom classroom;

    @FXML
    private ComboBox<String> modeComboBox;

    private RemoteControl remoteControl;

    @FXML
    public void initialize() {
        classroom = new Classroom();

        ClassroomFacade cf = new ClassroomFacade(classroom); // Default mode on initialization
        cf.initialClassSetting();

        backgroundImageView.setImage(classroom.getBackgroundImageView().getImage());

        addComponents(cf); // Pass the ClassroomFacade argument
        setUpRemoteControl();
        addControl();

        // Use ChangeListener to detect changes in the combo box value
        modeComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            handleModeSelection(cf);
        });
    }

    private void addComponents(ClassroomFacade cf) {
        Button startClassBtn = new Button("Start Class");
        startClassBtn.setLayoutX(520);
        startClassBtn.setLayoutY(300);
        startClassBtn.setOnAction(e -> startClass());

        Button endClassBtn = new Button("End Class");
        endClassBtn.setLayoutX(600);
        endClassBtn.setLayoutY(300);
        endClassBtn.setOnAction(e -> endClass());

        modeComboBox = new ComboBox<>(FXCollections.observableArrayList("Lesson", "Discussion", "Party"));
        modeComboBox.setLayoutX(680);
        modeComboBox.setLayoutY(300);
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
        setUpRemoteControl();
        addControl();
    }

    private void addControl() {
        VBox VBoxControlScene = new VBox(10);
        Scene controlScene = new Scene(VBoxControlScene, 500, 500);

        Stage controlStage = new Stage();
        controlStage.setScene(controlScene);

        Button toControlSceneButton = new Button("Control");
        toControlSceneButton.setLayoutX(450);
        toControlSceneButton.setLayoutY(300);
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
        Button partyOnButton = new Button("Party On");
        Button partyOffButton = new Button("Party Off");

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
        partyOnButton.setOnAction(e -> remoteControl.onButtonWasPressed(5));
        partyOffButton.setOnAction(e -> remoteControl.offButtonWasPressed(5));

        VBoxControlScene.getChildren().addAll(airConOnButton, airConOffButton, fanOnButton, fanOffButton,
                lightOnButton, lightOffButton, speakerOnButton, speakerOffButton, projectorOnButton,
                projctorOffButton, partyOnButton, partyOffButton);

        objPane.getChildren().addAll(toControlSceneButton);
    }

    private void setUpRemoteControl() {
        remoteControl = new RemoteControl();
        AirConditioner airCon = (AirConditioner) classroom.getMode().getObjList().stream()
                .filter(obj -> obj instanceof AirConditioner)
                .findFirst()
                .orElse(null);

        Fan fan = (Fan) classroom.getMode().getObjList().stream()
                .filter(obj -> obj instanceof Fan)
                .findFirst()
                .orElse(null);

        Light light = (Light) classroom.getMode().getObjList().stream()
                .filter(obj -> obj instanceof Light)
                .findFirst()
                .orElse(null);

        Speaker speaker = (Speaker) classroom.getMode().getObjList().stream()
                .filter(obj -> obj instanceof Speaker)
                .findFirst()
                .orElse(null);

        ProjectorBoard projectorBoard = (ProjectorBoard) classroom.getMode().getObjList().stream()
                .filter(obj -> obj instanceof ProjectorBoard)
                .findFirst()
                .orElse(null);

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

        Command[] partyOn = { airConOn, fanOn, lightOff, speakerOn, projectorOff };
        Command[] partyOff = { airConOff, fanOff, lightOff, speakerOff, projectorOff };

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommands(0, airConOn, airConOff);
        remoteControl.setCommands(1, fanOn, fanOff);
        remoteControl.setCommands(2, lightOn, lightOff);
        remoteControl.setCommands(3, speakerOn, speakerOff);
        remoteControl.setCommands(4, projectorOn, projectorOff);
        remoteControl.setCommands(5, partyOnMacro, partyOffMacro);

    }
}
