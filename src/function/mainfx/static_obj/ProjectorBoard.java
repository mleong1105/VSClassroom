package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class ProjectorBoard extends ClassObj{
    private String description;

     // Singleton instance
     private volatile static ProjectorBoard uniqueInstanceProjectorBoard;    

     // Private constructor
     private ProjectorBoard(String description){
         super("/function/mainfx/resources/image/projectorScreen_off.png",  380, 200, 210, 100);
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

    public void on(){
        this.setClassObject("/function/mainfx/resources/image/projectorScreen_on.png",  380, 200, 210, 100);
    }

    public void off(){
        // this.setClassObject("/function/mainfx/resources/image/projectorScreen_off.png",  380, 200, 210, 100);
        this.setClassObject("/function/mainfx/resources/image/blackboard.png", 400, 200, 200, 100);
    }
}