package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class ProjectorBoard extends ClassObj{
    String description;

    public ProjectorBoard(String description){
        super("/function/mainfx/resources/image/projectorboard.png", 100, 100, 350, 5);
        this.description = description;
    }

    public void up(){
        System.out.println(description + "screen is up");
    }

    public void down(){
        System.out.println(description + "screen is down");
    }

    
}
