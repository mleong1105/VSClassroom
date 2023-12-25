package function.mainfx.static_obj;

import java.util.Random;

public class BeverageDispenser {

    int beverageOption;
    int capacity;

    public BeverageDispenser(int beverageOption, int capacity) {
        this.beverageOption = beverageOption;
        this.capacity = capacity;
    }

    public void randomBeverage() {
        Random rand = new Random();
        int randNum = rand.nextInt(1,7);
        this.beverageOption = randNum;
    }

    public void refill() {
        this.capacity = 100;
    }


}
