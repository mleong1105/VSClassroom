package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class LectureDesk extends ClassObj {

    private boolean exist;
    
    // Singleton instance
    private volatile static LectureDesk uniqueInstanceLectureDesk;    

    // Private constructor
    private LectureDesk(String imgPath) {
        super(imgPath, 300, 200, 10, 260);
        this.exist = true;
    }

    // Public method to get the singleton instance
    public static LectureDesk getInstanceLectureDesk(String imgPath) {
        if (uniqueInstanceLectureDesk == null) {
            synchronized (LectureDesk.class) {
                if (uniqueInstanceLectureDesk == null) {
                    uniqueInstanceLectureDesk = new LectureDesk(imgPath);
                }
            }
        }
        return uniqueInstanceLectureDesk;
    }
}
