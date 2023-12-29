package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class DiscoBall extends ClassObj{

    private int height;
    private int width;
    private String color;

    // Singleton instance
    private volatile static DiscoBall uniqueInstanceDiscoBall;    

    // Private constructor
    private DiscoBall(int height, int width, String color){
        super("/function/mainfx/resources/image/discoball.png", width, height, 300, 5);
        this.height = height;
        this.width = width;
        this.color = color;
    }

    // Public method to get the singleton instance
    public static DiscoBall getInstanceDiscoBall(int height, int width, String color) {
        if (uniqueInstanceDiscoBall == null) {
            synchronized (DiscoBall.class) {
                if (uniqueInstanceDiscoBall == null) {
                    uniqueInstanceDiscoBall = new DiscoBall(height, width, color);
                }
            }
        }
        return uniqueInstanceDiscoBall;
    }

    public void on(){
        System.out.println("Disco ball is on");
    }

    public void off(){
        System.out.println("Disco ball is off");
    }

    public void changeColor(String color){
        this.color = color;
        System.out.println("Disco ball change color to " + color);
    }
}
