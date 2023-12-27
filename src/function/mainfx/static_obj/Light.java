package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Light extends ClassObj {
    
    String description;
    
    public Light(String description) {
        super("/function/mainfx/resources/image/lightoff.png", 100, 100, 350, 5);
        this.description = description;
    }

    public void on(){
        this.setClassObject("/function/mainfx/resources/image/lighton.png", 100, 100, 350, 5);
    }

    public void off(){
        this.setClassObject("/function/mainfx/resources/image/lightoff.png", 100, 100, 350, 5);
    }

    public void dim(int level){
        System.out.println(description + " dim at level "+ level);
    }

   
    public String toString(){
        return description;
    }


}
