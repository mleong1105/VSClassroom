package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Blackboard extends ClassObj {

    // Singleton instance
    private volatile static Blackboard uniqueInstanceBlackboard;

    // Private constructor
    private Blackboard() {
        super("/function/mainfx/resources/image/blackboard.png", 400, 200, 200, 100);
    }

    // Public method to get the singleton instance
    public static Blackboard getInstanceBlackboard() {
        if (uniqueInstanceBlackboard == null) {
            synchronized (Blackboard.class) {
                if (uniqueInstanceBlackboard == null) {
                    uniqueInstanceBlackboard = new Blackboard();
                }
            }
        }
        return uniqueInstanceBlackboard;
    }
}
