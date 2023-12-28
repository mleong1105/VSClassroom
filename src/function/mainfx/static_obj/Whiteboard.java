package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Whiteboard extends ClassObj{
    
    // Singleton instance
    private volatile static Whiteboard uniqueInstanceWhiteboard;    

    // Private constructor
    private Whiteboard() {
        super("/function/mainfx/resources/image/whiteboard.png", 250, 250, 400, 200);
    }

    // Public method to get the singleton instance
    public static Whiteboard getInstanceWhiteboard() {
        if (uniqueInstanceWhiteboard == null) {
            synchronized (Whiteboard.class) {
                if (uniqueInstanceWhiteboard == null) {
                    uniqueInstanceWhiteboard = new Whiteboard();
                }
            }
        }
        return uniqueInstanceWhiteboard;
    }
}
