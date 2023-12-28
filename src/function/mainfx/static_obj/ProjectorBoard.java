package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class ProjectorBoard extends ClassObj{
    private String description;

     // Singleton instance
     private volatile static ProjectorBoard uniqueInstanceProjectorBoard;    

     // Private constructor
     private ProjectorBoard(String description){
         super("/function/mainfx/resources/image/projectorboard.png", 100, 100, 350, 5);
         this.description = description;
     }
 
     // Public method to get the singleton instance
     public static ProjectorBoard getInstanceProjectorBoard(String description) {
         if (uniqueInstanceProjectorBoard == null) {
             synchronized (ProjectorBoard.class) {
                 if (uniqueInstanceProjectorBoard == null) {
                     uniqueInstanceProjectorBoard = new ProjectorBoard(description);
                 }
             }
         }
         return uniqueInstanceProjectorBoard;
     }

    public void up(){
        System.out.println(description + "screen is up");
    }

    public void down(){
        System.out.println(description + "screen is down");
    }

    
}
