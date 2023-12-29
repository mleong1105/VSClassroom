package function.mainfx.command;
import function.mainfx.static_obj.Speaker;

public class SpeakerOff implements Command {
    private Speaker speaker;

    public SpeakerOff(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.off();
    }
    
}