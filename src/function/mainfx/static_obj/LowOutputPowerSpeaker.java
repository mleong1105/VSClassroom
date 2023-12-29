package function.mainfx.static_obj;

import java.io.File;

import function.mainfx.ClassObj;
import function.mainfx.MultipurposeClassroom;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class LowOutputPowerSpeaker extends ClassObj implements SpeakerBehaviour {

    private volatile static LowOutputPowerSpeaker uniqueInstancLowOutputPowerSpeaker;

    private LowOutputPowerSpeaker(String musicName) {
        super("/function/mainfx/resources/image/disactive_speaker.png", 80, 80, 10, 10);
    }

    public static LowOutputPowerSpeaker getInstancLowOutputPowerSpeaker(String musicName) {
        if (uniqueInstancLowOutputPowerSpeaker == null) {
            synchronized (LowOutputPowerSpeaker.class) {
                if (uniqueInstancLowOutputPowerSpeaker == null) {
                    uniqueInstancLowOutputPowerSpeaker = new LowOutputPowerSpeaker(musicName);
                }
            }
        }
        return uniqueInstancLowOutputPowerSpeaker;
    }

    @Override
    public void playingSound(String musicName) {
        MultipurposeClassroom classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        classroom.removeObjectinList(HighOutputPowerSpeaker.getInstancHighOutputPowerSpeaker(musicName));
        classroom.addObjectinList(uniqueInstancLowOutputPowerSpeaker);
        // Media media = new Media(new File(musicName).toURI().toString());
        // MediaPlayer mediaPlayer = new MediaPlayer(media);
        // mediaPlayer.setAutoPlay(true);
        Slider volumeSlider = new Slider(0, 100, 10);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(1);
        volumeSlider.setTranslateX(250);
        volumeSlider.setTranslateY(30);
        // mediaPlayer.volumeProperty().bind(volumeSlider.valueProperty());
        // classroom.getObjPane().getChildren().addLast(volumeSlider);
    }

}
