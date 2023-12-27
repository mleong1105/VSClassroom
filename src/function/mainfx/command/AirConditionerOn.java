package function.mainfx.command;
import function.mainfx.static_obj.AirConditioner;

public class AirConditionerOn implements Command {
    private AirConditioner airConditioner;

    public AirConditionerOn(AirConditioner airConditioner){
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.on();
    }
    
}