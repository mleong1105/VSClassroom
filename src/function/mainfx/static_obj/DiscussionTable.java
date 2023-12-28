package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class DiscussionTable extends ClassObj{

    // Singleton instance
    private volatile static DiscussionTable uniqueInstanceDiscussionTable;    

    // Private constructor
    private DiscussionTable() {
        super("/function/mainfx/resources/image/discussion_table.png", 300, 300, 150, 340);
    }

    // Public method to get the singleton instance
    public static DiscussionTable getInstanceDiscussionTable() {
        if (uniqueInstanceDiscussionTable == null) {
            synchronized (DiscussionTable.class) {
                if (uniqueInstanceDiscussionTable == null) {
                    uniqueInstanceDiscussionTable = new DiscussionTable();
                }
            }
        }
        return uniqueInstanceDiscussionTable;
    }
}
