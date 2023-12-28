package function.mainfx.static_obj;
import java.util.Random;
import function.mainfx.ClassObj;
import function.mainfx.static_obj.BeverageDispenser;

public class FoodTable extends ClassObj{

    // Singleton instance
    private volatile static FoodTable uniqueInstanceFoodTable;    

    // Private constructor
    private FoodTable() {
        super("/function/mainfx/resources/image/foodtable.png", 300, 200, 350, 350);
    }

    // Public method to get the singleton instance
    public static FoodTable getInstanceFoodTable() {
        if (uniqueInstanceFoodTable == null) {
            synchronized (FoodTable.class) {
                if (uniqueInstanceFoodTable == null) {
                    uniqueInstanceFoodTable = new FoodTable();
                }
            }
        }
        return uniqueInstanceFoodTable;
    }

    public void addBeverageDispenser() {
        Random rand = new Random();
        int randNum = rand.nextInt(1, 7);
        BeverageDispenser beverageDispenser = BeverageDispenser.getInstanceBeverageDispenser(randNum,100);
        beverageDispenser.getObjectImageView().setX(350);
        beverageDispenser.getObjectImageView().setY(5);
    }
}
