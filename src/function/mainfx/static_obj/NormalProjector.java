package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class NormalProjector extends ClassObj implements ProjectorBehaviour {

    public NormalProjector() {
        super("/function/mainfx/resources/image/normalprojector.png", 200, 150, 300, 30);
    }

    @Override
    public String project() {
        return "Current Projection: Normal Projector";
    }

}
