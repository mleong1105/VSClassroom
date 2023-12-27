package function.mainfx.command;
import function.mainfx.static_obj.Fan;

public class FanOn implements Command {
    private Fan fan;

    public FanOn(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }
    
}