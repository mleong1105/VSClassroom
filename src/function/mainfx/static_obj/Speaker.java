package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Speaker extends ClassObj {

    private String musicName;
    private SpeakerBehaviour speakerBehaviour;

    // Singleton instance
    private volatile static Speaker uniqueInstanceSpeaker;

    // Private constructor
    private Speaker(String musicName) {
        super("/function/mainfx/resources/image/disactive_speaker.png", 80, 80, 10, 10);
        this.musicName = musicName;
        this.speakerBehaviour = LowOutputPowerSpeaker.getInstancLowOutputPowerSpeaker(musicName);
    }

    // Public method to get the singleton instance
    public static Speaker getInstanceSpeaker(String musicName) {
        if (uniqueInstanceSpeaker == null) {
            synchronized (Speaker.class) {
                if (uniqueInstanceSpeaker == null) {
                    uniqueInstanceSpeaker = new Speaker(musicName);
                }
            }
        }
        return uniqueInstanceSpeaker;
    }

    public void setSpeakerBehaviour(SpeakerBehaviour speakerBehaviour) {
        this.speakerBehaviour = speakerBehaviour;
    }

    public void playingSound(String musicName) {
        speakerBehaviour.playingSound(musicName);
    }

    public void on() {
        System.out.println("Play " + musicName);
    }

    public void off() {
        System.out.println("Stop Playing " + musicName);
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
}
