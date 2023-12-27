package function.mainfx.command;
import function.mainfx.static_obj.Light;

public class LightOff implements Command {
    private Light light;

    public LightOff(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
    
}