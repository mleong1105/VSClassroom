package function.mainfx.static_obj;

import java.util.Random;

import function.mainfx.ClassObj;

public class BeverageDispenser extends ClassObj {

    int beverageOption;
    int capacity;

    public BeverageDispenser(int beverageOption, int capacity) {
        super("/function/mainfx/resources/image/water1.png", 20, 20, 220, 90);
        this.beverageOption = beverageOption;
        this.capacity = capacity;
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
