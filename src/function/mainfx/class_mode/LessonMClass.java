package function.mainfx.class_mode;

import function.mainfx.Classroom;
import function.mainfx.static_obj.Blackboard;
import function.mainfx.static_obj.HighOutputSpeaker;
import function.mainfx.static_obj.LearningDesk;
import function.mainfx.static_obj.LectureDesk;
import function.mainfx.static_obj.Light;
import function.mainfx.static_obj.LowOutputSpeaker;
import function.mainfx.static_obj.NormalProjector;
import function.mainfx.static_obj.Noticeboard;
import function.mainfx.static_obj.Projector;
import function.mainfx.static_obj.ProjectorBoard;
import function.mainfx.static_obj.Speaker;
import function.mainfx.static_obj.TouchScreenProjector;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;

public class LessonMClass extends Classroom {

    private Label projectionLabel;

    public LessonMClass() {
        super("Lesson");
    }

    @Override
    protected void initializeModeObjects(String mode) {
        Blackboard blackboard = new Blackboard();
        addObjectinList(blackboard);

        Light light = new Light();
        addObjectinList(light);

        // Speaker speaker = new Speaker();
        // addObjectinList(speaker);

        LearningDesk learningDesk = new LearningDesk();
        addObjectinList(learningDesk);

        LectureDesk lecturedesk = new LectureDesk();
        addObjectinList(lecturedesk);

        Noticeboard noticeboard = new Noticeboard();
        addObjectinList(noticeboard);

        // No need initialize these two first
        ProjectorBoard projectorBoard = new ProjectorBoard();
        addObjectinList(projectorBoard);

        Alert pAlert = new Alert(AlertType.INFORMATION);
        Projector projector = new Projector();
        NormalProjector normalProjector = new NormalProjector();
        TouchScreenProjector touchScreenProjector = new TouchScreenProjector();

        ToggleButton projectorButton = new ToggleButton("Switch Projector");
        projectionLabel = new Label("");
        projectorButton.setOnAction(e -> {
            if (projectorButton.isSelected()) {
                projector.setProjectorBehaviour(touchScreenProjector);
                removeObjectinList(normalProjector);
                addObjectinList(touchScreenProjector);
                pAlert.setHeaderText(projector.projectingScreen());
                pAlert.showAndWait();
            } else {
                projector.setProjectorBehaviour(normalProjector);
                removeObjectinList(touchScreenProjector);
                addObjectinList(normalProjector);
                pAlert.setHeaderText(projector.projectingScreen());
                pAlert.showAndWait();
            }
        });
        projectorButton.setTranslateX(150);
        getObjPane().getChildren().addAll(projectorButton);

        Alert sAlert = new Alert(AlertType.INFORMATION);
        Speaker speaker = new Speaker();
        LowOutputSpeaker lowOutputSpeaker = new LowOutputSpeaker();
        HighOutputSpeaker highOutputSpeaker = new HighOutputSpeaker();

        ToggleButton speakerButton = new ToggleButton("Switch Speaker");
        speakerButton.setOnAction(e -> {
            if (speakerButton.isSelected()) {
                speaker.setSpeakerBehaviour(highOutputSpeaker);
                removeObjectinList(lowOutputSpeaker);
                addObjectinList(highOutputSpeaker);
                sAlert.setHeaderText(speaker.playingSound());
                sAlert.showAndWait();
            } else {
                speaker.setSpeakerBehaviour(lowOutputSpeaker);
                removeObjectinList(highOutputSpeaker);
                addObjectinList(lowOutputSpeaker);
                sAlert.setHeaderText(speaker.playingSound());
                sAlert.showAndWait();
            }
        });
        speakerButton.setTranslateX(150);
        speakerButton.setTranslateY(40);
        getObjPane().getChildren().addAll(speakerButton);

    }
}
