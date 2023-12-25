package function.mainfx.static_obj;

public class ProjectorBoard {
    String description;

    public ProjectorBoard(String description){
        this.description = description;
    }

    public void up(){
        System.out.println(description + "screen is up");
    }

    public void down(){
        System.out.println(description + "screen is down");
    }

    
}
