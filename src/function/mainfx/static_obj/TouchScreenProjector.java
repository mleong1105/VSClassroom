package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class TouchScreenProjector extends ClassObj implements ProjectorBehaviour {

    public TouchScreenProjector() {
        super("/function/mainfx/resources/image/touchscreenprojector.png", 150, 100, 300, 70);
    }

    @Override
    public String project() {
        return "Current Projection: Touch Screen Projector";
    }

}
