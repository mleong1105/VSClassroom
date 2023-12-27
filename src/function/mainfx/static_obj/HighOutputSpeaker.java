package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class HighOutputSpeaker extends ClassObj implements SpeakerBehaviour {

    public HighOutputSpeaker() {
        super("/function/mainfx/resources/image/active_speaker.png", 80, 80, 10, 10);
    }

    @Override
    public String playSound() {
        return "Current Speaker: High Output Speaker";
    }

}
