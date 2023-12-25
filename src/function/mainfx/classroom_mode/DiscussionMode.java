package function.mainfx.classroom_mode;

import java.util.ArrayList;
import java.util.List;

import function.mainfx.ClassObj;
import function.mainfx.ClassroomMode;
import function.mainfx.static_obj.DiscussionTable;
import function.mainfx.static_obj.LectureDesk;
import function.mainfx.static_obj.Light;
import function.mainfx.static_obj.Noticeboard;
import javafx.scene.layout.Pane;

public class DiscussionMode extends ClassroomMode {

    private Pane objPane;
    private List<ClassObj> objList;

    public DiscussionMode() {
         objPane = new Pane();
        objList = new ArrayList<>();
        Light light = new Light("Light");
        LectureDesk lectureDesk = new LectureDesk();
        Noticeboard noticeboard = new Noticeboard();
        DiscussionTable discussionTable = new DiscussionTable();
        addObjectinList(light);
        addObjectinList(lectureDesk);
        addObjectinList(noticeboard);
        addObjectinList(discussionTable);
    }

    public void addObjectinList(ClassObj obj) {
        objPane.getChildren().add(obj.getObjectImageView());
        objList.add(obj);
    }

    public void removeObjectinList(ClassObj obj) {
        objPane.getChildren().remove(obj.getObjectImageView());
        objList.remove(obj);
    }

    public Pane getObjPane() {
        return objPane;
    }

    public List<ClassObj> getObjList() {
        return objList;
    }
}
