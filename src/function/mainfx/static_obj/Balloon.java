package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Balloon extends ClassObj {
    
    // Singleton instance
    private String imgPath;
    private volatile static Balloon uniqueInstanceBalloon;    

    // Private constructor
    private Balloon(String imgPath) {
        super(imgPath, 100, 200, 100, 240);
        this.imgPath = imgPath;
    }

    // Public method to get the singleton instance
    public static Balloon getInstanceBalloon(String imgPath) {
        if (uniqueInstanceBalloon == null) {
            synchronized (Balloon.class) {
                if (uniqueInstanceBalloon == null) {
                    uniqueInstanceBalloon = new Balloon(imgPath);
                }
            }
        }
        return uniqueInstanceBalloon;
    }
}
