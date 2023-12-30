package function.mainfx.static_obj;

import java.util.Random;

import function.mainfx.ClassObj;

public class BeverageDispenser extends ClassObj {

    private int beverageOption;
    private int capacity;
    private String[] imgPathList;

    // Singleton instance
    private volatile static BeverageDispenser uniqueInstanceBeverageDispenser;    

    // Private constructor
    private BeverageDispenser(String description, String[] imgPathList, int beverageOption, int capacity) {
        super(imgPathList[0], 70, 80, 400, 350, description);
        this.beverageOption = beverageOption;
        this.imgPathList = imgPathList;
        this.capacity = capacity;
    }

    // Public method to get the singleton instance
    public static BeverageDispenser getInstanceBeverageDispenser(String description, String[] imgPathList, int beverageOption, int capacity) {
        if (uniqueInstanceBeverageDispenser == null) {
            synchronized (BeverageDispenser.class) {
                if (uniqueInstanceBeverageDispenser == null) {
                    uniqueInstanceBeverageDispenser = new BeverageDispenser(description, imgPathList, beverageOption, capacity);
                }
            }
        }
        return uniqueInstanceBeverageDispenser;
    }

    public String decideImagePath(String[] imgPathList, int beverageOption){
        if (beverageOption >= 0 && beverageOption < imgPathList.length) {
            return imgPathList[beverageOption];
        } else {
            return imgPathList[0];
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
