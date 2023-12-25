package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Light extends ClassObj {
    
    String description;
    
    public Light(String description) {
        super("/function/mainfx/resources/image/lightoff.png", 100, 100, 350, 5);
        this.description = description;
    }

    public void on(){
        System.out.println(description + " on");
    }

    public void off(){
        System.out.println(description + " off");
    }

    public void dim(int level){
        System.out.println(description + " dim at level "+ level);
    }

   
    public String toString(){
        return description;
    }


}
