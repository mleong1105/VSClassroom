package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class LectureDesk extends ClassObj {

    private boolean exist;
    
     // Singleton instance
     private volatile static LectureDesk uniqueInstanceLectureDesk;    

     // Private constructor
     private LectureDesk() {
         super("/function/mainfx/resources/image/lecturedesk.png", 300, 200, 10, 260);
        this.exist = true;
     }
 
     // Public method to get the singleton instance
     public static LectureDesk getInstanceLectureDesk() {
         if (uniqueInstanceLectureDesk == null) {
             synchronized (LectureDesk.class) {
                 if (uniqueInstanceLectureDesk == null) {
                     uniqueInstanceLectureDesk = new LectureDesk();
                 }
             }
         }
         return uniqueInstanceLectureDesk;
     }

    public void addLectureDesk(){
        if(exist==false){
            this.exist = true;
        }
    }

    public void removeLectureDesk(){
        this.exist = false;
    }


}
