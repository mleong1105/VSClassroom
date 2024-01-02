package function.mainfx.static_obj;
import java.util.Random;
import function.mainfx.ClassObj;
import function.mainfx.static_obj.BeverageDispenser;

public class FoodTable extends ClassObj{

    // Singleton instance
    private volatile static FoodTable uniqueInstanceFoodTable;    

    // Private constructor
    private FoodTable(String imgPath) {
        super(imgPath, 300, 200, 350, 350);
    }

    // Public method to get the singleton instance
    public static FoodTable getInstanceFoodTable(String imgPath) {
        if (uniqueInstanceFoodTable == null) {
            synchronized (FoodTable.class) {
                if (uniqueInstanceFoodTable == null) {
                    uniqueInstanceFoodTable = new FoodTable(imgPath);
                }
            }
        }
        return uniqueInstanceFoodTable;
    }
}
