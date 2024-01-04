package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class DiscoBall extends ClassObj{

    private String color;

    // Singleton instance
    private volatile static DiscoBall uniqueInstanceDiscoBall;    

    // Private constructor
    private DiscoBall(String imgPath, String color){
        super(imgPath, 150, 150, 450, 5);
        this.color = color;
    }

    // Public method to get the singleton instance
    public static DiscoBall getInstanceDiscoBall(String imgPath, String color) {
        if (uniqueInstanceDiscoBall == null) {
            synchronized (DiscoBall.class) {
                if (uniqueInstanceDiscoBall == null) {
                    uniqueInstanceDiscoBall = new DiscoBall(imgPath, color);
                }
            }
        }
        return uniqueInstanceDiscoBall;
    }
}
