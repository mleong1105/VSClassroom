package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class DiscussionTable extends ClassObj{
    
    // Singleton instance
    private volatile static DiscussionTable uniqueInstanceDiscussionTable;    

    // Private constructor
    private DiscussionTable(String description, String imgPath) {
        super(imgPath, 300, 300, 150, 340, description);
    }

    // Public method to get the singleton instance
    public static DiscussionTable getInstanceDiscussionTable(String description, String imgPath) {
        if (uniqueInstanceDiscussionTable == null) {
            synchronized (DiscussionTable.class) {
                if (uniqueInstanceDiscussionTable == null) {
                    uniqueInstanceDiscussionTable = new DiscussionTable(description, imgPath);
                }
            }
        }
        return uniqueInstanceDiscussionTable;
    }
}
