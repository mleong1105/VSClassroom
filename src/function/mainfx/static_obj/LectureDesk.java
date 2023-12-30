package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class LectureDesk extends ClassObj {

    private boolean exist;
    
    // Singleton instance
    private volatile static LectureDesk uniqueInstanceLectureDesk;    

    // Private constructor
    private LectureDesk(String description, String imgPath) {
        super(imgPath, 300, 200, 10, 260, description);
        this.exist = true;
    }

    // Public method to get the singleton instance
    public static LectureDesk getInstanceLectureDesk(String description, String imgPath) {
        if (uniqueInstanceLectureDesk == null) {
            synchronized (LectureDesk.class) {
                if (uniqueInstanceLectureDesk == null) {
                    uniqueInstanceLectureDesk = new LectureDesk(description, imgPath);
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
