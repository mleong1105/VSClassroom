package function.mainfx.static_obj;

import function.mainfx.ClassObj;
import function.mainfx.strategy.LowOutputPower;
import function.mainfx.strategy.SpeakerBehaviour;

public class Speaker extends ClassObj {

    private String musicName, activeImgPath, disactiveImgPath;
    SpeakerBehaviour speakerBehaviour;

    // Singleton instance
    private volatile static Speaker uniqueInstanceSpeaker;

    // Private constructor
    private Speaker(String description, String activeImgPath, String disactiveImgPath, String musicName) {
        super(disactiveImgPath, 80, 80, 10, 10, description);
        this.activeImgPath = activeImgPath;
        this.disactiveImgPath = disactiveImgPath;
        this.musicName = musicName;
        this.speakerBehaviour = new LowOutputPower();
    }

    // Public method to get the singleton instance
    public static Speaker getInstanceSpeaker(String description, String activeImgPath, String disactiveImgPath,
            String musicName) {
        if (uniqueInstanceSpeaker == null) {
            synchronized (Speaker.class) {
                if (uniqueInstanceSpeaker == null) {
                    uniqueInstanceSpeaker = new Speaker(description, activeImgPath, disactiveImgPath, musicName);
                }
            }
        }
        return uniqueInstanceSpeaker;
    }

    public void on() {
        this.setClassObject(activeImgPath, 80, 80, 10, 10);
        speakerBehaviour.playingSound();
        System.out.println("Play " + musicName);
    }

    public void off() {
        this.setClassObject(disactiveImgPath, 80, 80, 10, 10);
        System.out.println("Speaker stop playing");
    }

    public void setStereoSound() {
        System.out.println("streo sound on");
    }

    public void setMonauralSound() {
        System.out.println("Mono sound on");
    }

    public void setVolume(int volumeSize) {
        System.out.println("Volume set to " + volumeSize);
    }

    public String toString() {
        return musicName;
    }

    public void setSpeakerBehaviour(SpeakerBehaviour speakerBehaviour) {
        this.speakerBehaviour = speakerBehaviour;
    }

    public void playingSound() {
        speakerBehaviour.playingSound();
    }
}
