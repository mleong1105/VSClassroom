package function.mainfx.command;
import function.mainfx.static_obj.ProjectorBoard;

public class ProjectorOff implements Command {
    private ProjectorBoard projectorBoard;

    public ProjectorOff(ProjectorBoard projectorBoard){
        this.projectorBoard = projectorBoard;
    }

    @Override
    public void execute() {
        projectorBoard.off();
    }
    
}