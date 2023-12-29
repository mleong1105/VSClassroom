package function.mainfx.static_obj;

import java.io.File;

import function.mainfx.ClassObj;
import function.mainfx.MultipurposeClassroom;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class HighOutputPowerSpeaker extends ClassObj implements SpeakerBehaviour {

    private volatile static HighOutputPowerSpeaker uniqueInstancHighOutputPowerSpeaker;

    private HighOutputPowerSpeaker(String musicName) {
        super("/function/mainfx/resources/image/highoutputspeaker.png", 100, 100, 10, 10);
    }

    public static HighOutputPowerSpeaker getInstancHighOutputPowerSpeaker(String musicName) {
        if (uniqueInstancHighOutputPowerSpeaker == null) {
            synchronized (HighOutputPowerSpeaker.class) {
                if (uniqueInstancHighOutputPowerSpeaker == null) {
                    uniqueInstancHighOutputPowerSpeaker = new HighOutputPowerSpeaker(musicName);
                }
            }
        }
        return uniqueInstancHighOutputPowerSpeaker;
    }

    @Override
    public void playingSound(String musicName) {
        MultipurposeClassroom classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        classroom.removeObjectinList(LowOutputPowerSpeaker.getInstancLowOutputPowerSpeaker(musicName));
        classroom.addObjectinList(uniqueInstancHighOutputPowerSpeaker);

        // Media media = new Media(new File(musicName).toURI().toString());
        // MediaPlayer mediaPlayer = new MediaPlayer(media);
        // mediaPlayer.setAutoPlay(true);
        Slider volumeSlider = new Slider(0, 200, 10);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(1);
        volumeSlider.setTranslateX(250);
        volumeSlider.setTranslateY(30);
        // mediaPlayer.volumeProperty().bind(volumeSlider.valueProperty());
        // classroom.getObjPane().getChildren().addLast(volumeSlider);
    }

}
