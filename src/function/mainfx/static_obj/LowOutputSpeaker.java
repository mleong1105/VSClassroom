package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class LowOutputSpeaker extends ClassObj implements SpeakerBehaviour {

    public LowOutputSpeaker() {
        super("/function/mainfx/resources/image/disactive_speaker.png", 80, 80, 10, 10);
    }

    @Override
    public String playSound() {
        return "Current Speaker: Low Output Speaker";
    }

}
