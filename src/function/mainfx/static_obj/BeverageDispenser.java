package function.mainfx.static_obj;

import java.util.Random;

import function.mainfx.ClassObj;

public class BeverageDispenser extends ClassObj {

    private int beverageOption;
    private int capacity;

    // Singleton instance
    private volatile static BeverageDispenser uniqueInstanceBeverageDispenser;    

    // Private constructor
    private BeverageDispenser(int beverageOption, int capacity) {
        super(decideImagePath(beverageOption), 70, 80, 400, 350);
        this.beverageOption = beverageOption;
        this.capacity = capacity;
    }

    // Public method to get the singleton instance
    public static BeverageDispenser getInstanceBeverageDispenser(int screenHeight, int screenWidth) {
        if (uniqueInstanceBeverageDispenser == null) {
            synchronized (BeverageDispenser.class) {
                if (uniqueInstanceBeverageDispenser == null) {
                    uniqueInstanceBeverageDispenser = new BeverageDispenser(screenHeight, screenWidth);
                }
            }
        }
        return uniqueInstanceBeverageDispenser;
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
