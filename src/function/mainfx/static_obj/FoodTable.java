package function.mainfx.static_obj;
import java.util.Random;
import function.mainfx.ClassObj;
import function.mainfx.static_obj.BeverageDispenser;

public class FoodTable extends ClassObj{

    public FoodTable() {
        super("/function/mainfx/resources/image/foodtable.png", 300, 200, 350, 350);
    }


    public void addBeverageDispenser() {
        Random rand = new Random();
        int randNum = rand.nextInt(1, 7);
        BeverageDispenser beverageDispenser = new BeverageDispenser(randNum,100);
        beverageDispenser.getObjectImageView().setX(350);
        beverageDispenser.getObjectImageView().setY(5);
    }
}
