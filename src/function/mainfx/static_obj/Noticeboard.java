package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Noticeboard extends ClassObj {
    
    // Singleton instance
    private volatile static Noticeboard uniqueInstanceNoticeboard;    

    // Private constructor
    private Noticeboard(String description, String imgPath) {
        super(imgPath, 170, 200, 600, 120, description);
    }

    // Public method to get the singleton instance
    public static Noticeboard getInstanceNoticeboard(String description, String imgPath) {
        if (uniqueInstanceNoticeboard == null) {
            synchronized (Noticeboard.class) {
                if (uniqueInstanceNoticeboard == null) {
                    uniqueInstanceNoticeboard = new Noticeboard(description, imgPath);
                }
            }
        }
        return uniqueInstanceNoticeboard;
    }
}
