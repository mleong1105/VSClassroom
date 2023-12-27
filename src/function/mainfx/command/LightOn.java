package function.mainfx.command;
import function.mainfx.static_obj.Light;

public class LightOn implements Command {
    private Light light;

    public LightOn(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
    
}