package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class ProjectorBoard extends ClassObj{
    String onImgPath, offImgPath;
     // Singleton instance
     private volatile static ProjectorBoard uniqueInstanceProjectorBoard;    

     // Private constructor
     private ProjectorBoard(String description, String onImgPath, String offImgPath){
         super(offImgPath,  380, 200, 210, 100, description);
         this.onImgPath = onImgPath;
         this.offImgPath = offImgPath;
     }
 
     // Public method to get the singleton instance
     public static ProjectorBoard getInstanceProjectorBoard(String description, String onImgPath, String offImgPath) {
         if (uniqueInstanceProjectorBoard == null) {
             synchronized (ProjectorBoard.class) {
                 if (uniqueInstanceProjectorBoard == null) {
                     uniqueInstanceProjectorBoard = new ProjectorBoard(description, onImgPath, offImgPath);
                 }
             }
         }
         return uniqueInstanceProjectorBoard;
     }

    public void on(){
        this.setClassObject(onImgPath,  380, 200, 210, 100);
    }

    public void off(){
        this.setClassObject(offImgPath,  380, 200, 210, 100);
        // this.setClassObject("/function/mainfx/resources/image/blackboard.png", 400, 200, 200, 100);
    }
}