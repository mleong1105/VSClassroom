package function.mainfx.command;
import function.mainfx.static_obj.Fan;

public class FanOff implements Command {
    private Fan fan;

    public FanOff(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }
    
}