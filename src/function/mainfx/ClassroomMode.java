package function.mainfx;

import javafx.scene.layout.Pane;
import java.util.List;

public abstract class ClassroomMode {
    
    // private Pane objPane;
    // private List<ClassObj> objList;

    // public ClassroomMode() {
    //     objPane = new Pane();
    //     objList = new ArrayList<>();
    // }

    // public void addObjectinList(ClassObj obj) {
    //     objPane.getChildren().add(obj.getObjectImageView());
    //     objList.add(obj);
    // }

    // public void removeObjectinList(ClassObj obj) {
    //     objPane.getChildren().remove(obj.getObjectImageView());
    //     objList.remove(obj);
    // }

    // public Pane getObjPane() {
    //     return objPane;
    // }

    // public List<ClassObj> getObjList() {
    //     return objList;
    // }
    public abstract void addObjectinList(ClassObj obj);
    public abstract void removeObjectinList(ClassObj obj);
    public abstract Pane getObjPane();
    public abstract List<ClassObj> getObjList();
}
