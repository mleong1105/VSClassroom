package function.mainfx.static_obj;

import java.util.Random;

import function.mainfx.ClassObj;

public class BeverageDispenser extends ClassObj {

    int beverageOption;
    int capacity;

    public BeverageDispenser(int beverageOption, int capacity) {
        super(decideImagePath(beverageOption), 70, 80, 400, 350);
        this.beverageOption = beverageOption;
        this.capacity = capacity;
    }

    public static String decideImagePath(int beverageOption){
        if(beverageOption==1){
            return "/function/mainfx/resources/image/water1.png";
        }
        else if(beverageOption==2){
            return "/function/mainfx/resources/image/water2.png";
        }
        else if(beverageOption==3){
            return "/function/mainfx/resources/image/water3.png";
        }
        else if(beverageOption==4){
            return "/function/mainfx/resources/image/water4.png";
        }
        else if(beverageOption==5){
            return "/function/mainfx/resources/image/water5.png";
        }
        else if(beverageOption==6){
            return "/function/mainfx/resources/image/water6.png";
        }
        else{
            return "/function/mainfx/resources/image/water1.png";
        }
    }

    public void randomBeverage() {
        Random rand = new Random();
        int randNum = rand.nextInt(1, 7);
        this.beverageOption = randNum;
    }

    public void refill() {
        this.capacity = 100;
    }

}
