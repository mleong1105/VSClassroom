package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Whiteboard extends ClassObj{
    
    // Singleton instance
    private volatile static Whiteboard uniqueInstanceWhiteboard;    

    // Private constructor
    private Whiteboard(String imgPath) {
        super(imgPath, 250, 250, 400, 200);
    }

    // Public method to get the singleton instance
    public static Whiteboard getInstanceWhiteboard(String imgPath) {
        if (uniqueInstanceWhiteboard == null) {
            synchronized (Whiteboard.class) {
                if (uniqueInstanceWhiteboard == null) {
                    uniqueInstanceWhiteboard = new Whiteboard(imgPath);
                }
            }
        }
        return uniqueInstanceWhiteboard;
    }
}
