package function.mainfx.strategy;

import function.mainfx.MultipurposeClassroom;
import javafx.scene.control.Slider;

public class HighOutputPower implements SpeakerBehaviour {

    @Override
    public void playingSound() {
        MultipurposeClassroom classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        Slider volumeSlider = new Slider(0, 50, 10);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(1);
        volumeSlider.setTranslateX(60);
        volumeSlider.setTranslateY(100);
        classroom.getObjPane().getChildren().addAll(volumeSlider);
    }

}
