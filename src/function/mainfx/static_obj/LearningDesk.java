package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class LearningDesk extends ClassObj {
    
    // Singleton instance
    private volatile static LearningDesk uniqueInstanceLearningDesk;    

    // Private constructor
    private LearningDesk(String imgPath) {
        super(imgPath, 250, 300, 300, 300);
    }

    // Public method to get the singleton instance
    public static LearningDesk getInstanceLearningDesk(String imgPath) {
        if (uniqueInstanceLearningDesk == null) {
            synchronized (LearningDesk.class) {
                if (uniqueInstanceLearningDesk == null) {
                    uniqueInstanceLearningDesk = new LearningDesk(imgPath);
                }
            }
        }
        return uniqueInstanceLearningDesk;
    }
}
