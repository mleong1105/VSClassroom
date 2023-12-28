package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Noticeboard extends ClassObj {
    
    // Singleton instance
    private volatile static Noticeboard uniqueInstanceNoticeboard;    

    // Private constructor
    private Noticeboard() {
        super("/function/mainfx/resources/image/noticeboard.png", 170, 200, 600, 120);
    }

    // Public method to get the singleton instance
    public static Noticeboard getInstanceNoticeboard() {
        if (uniqueInstanceNoticeboard == null) {
            synchronized (Noticeboard.class) {
                if (uniqueInstanceNoticeboard == null) {
                    uniqueInstanceNoticeboard = new Noticeboard();
                }
            }
        }
        return uniqueInstanceNoticeboard;
    }
}
