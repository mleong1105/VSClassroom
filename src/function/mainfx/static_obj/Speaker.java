package function.mainfx.static_obj;

public class Speaker extends ClassEquipment {
    public Speaker() {
        speakerBehaviour = new LowOutputSpeaker();
    }
}
