package function.mainfx.command;
import function.mainfx.static_obj.ProjectorBoard;

public class ProjectorOn implements Command {
    private ProjectorBoard projectorBoard;

    public ProjectorOn(ProjectorBoard projectorBoard){
        this.projectorBoard = projectorBoard;
    }

    @Override
    public void execute() {
        projectorBoard.on();
    }
    
}