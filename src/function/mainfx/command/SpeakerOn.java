package function.mainfx.command;
import function.mainfx.static_obj.Speaker;

public class SpeakerOn implements Command {
    private Speaker speaker;

    public SpeakerOn(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.on();
    }
    
}