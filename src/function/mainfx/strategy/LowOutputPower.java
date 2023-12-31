package function.mainfx.strategy;

import function.mainfx.MultipurposeClassroom;
import javafx.scene.control.Slider;

public class LowOutputPower implements SpeakerBehaviour {

    @Override
    public void playingSound() {
        MultipurposeClassroom classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        Slider volumeSlider = new Slider(0, 20, 10);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(1);
        volumeSlider.setTranslateX(100);
        volumeSlider.setTranslateY(60);
        classroom.getObjPane().getChildren().addAll(volumeSlider);
    }

}
