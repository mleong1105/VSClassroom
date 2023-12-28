package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Balloon extends ClassObj {

    // Singleton instance
    private volatile static Balloon uniqueInstanceBalloon;    

    // Private constructor
    private Balloon() {
        super("/function/mainfx/resources/image/balloon.png", 100, 200, 100, 240);
    }

    // Public method to get the singleton instance
    public static Balloon getInstanceBalloon() {
        if (uniqueInstanceBalloon == null) {
            synchronized (Balloon.class) {
                if (uniqueInstanceBalloon == null) {
                    uniqueInstanceBalloon = new Balloon();
                }
            }
        }
        return uniqueInstanceBalloon;
    }
}
