package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Blackboard extends ClassObj {
    
    private String imgPath;
    // Singleton instance
    private volatile static Blackboard uniqueInstanceBlackboard;

    // Private constructor
    private Blackboard(String description, String imgPath) {
        super(imgPath, 400, 200, 200, 100, description);
        this.imgPath = imgPath;
    }

    // Public method to get the singleton instance
    public static Blackboard getInstanceBlackboard(String description, String imgPath) {
        if (uniqueInstanceBlackboard == null) {
            synchronized (Blackboard.class) {
                if (uniqueInstanceBlackboard == null) {
                    uniqueInstanceBlackboard = new Blackboard(description, imgPath);
                }
            }
        }
        return uniqueInstanceBlackboard;
    }
}
