package function.mainfx.static_obj;
import java.util.Random;
import function.mainfx.ClassObj;
import function.mainfx.static_obj.BeverageDispenser;

public class FoodTable extends ClassObj{

    // Singleton instance
    private volatile static FoodTable uniqueInstanceFoodTable;    

    // Private constructor
    private FoodTable(String description, String imgPath) {
        super(imgPath, 300, 200, 350, 350, description);
    }

    // Public method to get the singleton instance
    public static FoodTable getInstanceFoodTable(String description, String imgPath) {
        if (uniqueInstanceFoodTable == null) {
            synchronized (FoodTable.class) {
                if (uniqueInstanceFoodTable == null) {
                    uniqueInstanceFoodTable = new FoodTable(description, imgPath);
                }
            }
        }
        return uniqueInstanceFoodTable;
    }

    // public void addBeverageDispenser() {
    //     Random rand = new Random();
    //     int randNum = rand.nextInt(1, 7);
    //     BeverageDispenser beverageDispenser = BeverageDispenser.getInstanceBeverageDispenser(randNum,100);
    //     beverageDispenser.getObjectImageView().setX(350);
    //     beverageDispenser.getObjectImageView().setY(5);
    // }
}
