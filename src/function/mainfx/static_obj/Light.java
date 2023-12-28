package function.mainfx.static_obj;

import function.mainfx.ClassObj;
import javafx.scene.image.Image;

public class Light extends ClassObj {

    private String description;

    // Singleton instance
    private volatile static Light uniqueInstanceLight;    

    // Private constructor
    private Light(String description) {
        super("/function/mainfx/resources/image/lightoff.png", 100, 100, 350, 5);
        this.description = description;
    }

    // Public method to get the singleton instance
    public static Light getInstanceLight(String description) {
        if (uniqueInstanceLight == null) {
            synchronized (Light.class) {
                if (uniqueInstanceLight == null) {
                    uniqueInstanceLight = new Light(description);
                }
            }
        }
        return uniqueInstanceLight;
    }

    public void on(){
        changeImage("/function/mainfx/resources/image/lighton.png");
        System.out.println(description + " on");
    }

    public void off(){
        changeImage("/function/mainfx/resources/image/lightoff.png");
        System.out.println(description + " off");
    }

    public void dim(int level){
        System.out.println(description + " dim at level "+ level);
    }

   
    public String toString(){
        return description;
    }

     private void changeImage(String imagePath) {
        getObjectImageView().setImage(new Image(getClass().getResourceAsStream(imagePath)));
    }


}
