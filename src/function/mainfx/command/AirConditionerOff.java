package function.mainfx.command;
import function.mainfx.static_obj.AirConditioner;

public class AirConditionerOff implements Command {
    private AirConditioner airConditioner;

    public AirConditionerOff(AirConditioner airConditioner){
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.off();
    }
    
}
