package function.mainfx.static_obj;

public abstract class ClassEquipment {

    ProjectorBehaviour projectorBehaviour;
    SpeakerBehaviour speakerBehaviour;

    public void setProjectorBehaviour(ProjectorBehaviour projectorBehaviour) {
        this.projectorBehaviour = projectorBehaviour;
    }

    public void setSpeakerBehaviour(SpeakerBehaviour speakerBehaviour) {
        this.speakerBehaviour = speakerBehaviour;
    }

    public String projectingScreen() {
        return projectorBehaviour.project();
    }

    public String playingSound() {
        return speakerBehaviour.playSound();
    }
}
