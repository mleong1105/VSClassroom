package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Projector extends ClassObj {

    private String description;
    private LaptopPlayer laptopPlayer;
    
    // Singleton instance
    private volatile static Projector uniqueInstanceProjector;    

    // Private constructor
    private Projector(String description, LaptopPlayer laptopPlayer){
        super("/function/mainfx/resources/image/projector.png", 100, 100, 350, 5);
        this.description = description;
        this.laptopPlayer = laptopPlayer;
    }

    // Public method to get the singleton instance
    public static Projector getInstanceProjector(String description, LaptopPlayer laptopPlayer) {
        if (uniqueInstanceProjector == null) {
            synchronized (Projector.class) {
                if (uniqueInstanceProjector == null) {
                    uniqueInstanceProjector = new Projector(description, laptopPlayer);
                }
            }
        }
        return uniqueInstanceProjector;
    }

    public void on(){
        //open projector
        //open showing screen
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void wideScreenMode() {
        System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
    }

    public void tvMode() {
        System.out.println(description + " in tv mode (4x3 aspect ratio)");
    }

    public String toString() {
        return description;
    }




}
