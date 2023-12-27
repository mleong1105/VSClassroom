package function.mainfx.classroom_mode;

import java.util.ArrayList;
import java.util.List;

import function.mainfx.ClassObj;
import function.mainfx.ClassroomMode;
import function.mainfx.static_obj.Blackboard;
import function.mainfx.static_obj.LearningDesk;
import function.mainfx.static_obj.LectureDesk;
import function.mainfx.static_obj.Light;
import function.mainfx.static_obj.Noticeboard;
import function.mainfx.static_obj.SmartBoard;
import function.mainfx.static_obj.Speaker;
import javafx.scene.layout.Pane;
import function.mainfx.static_obj.Fan;
import function.mainfx.static_obj.AirConditioner;
import function.mainfx.static_obj.Projector;
import function.mainfx.static_obj.ProjectorBoard;

public final class DefaultMode extends ClassroomMode {

    private Pane objPane;
    private List<ClassObj> objList;

    public DefaultMode() {
        objPane = new Pane();
        objList = new ArrayList<>();
        // add all item here
        Blackboard blackboard = new Blackboard();
        Light light = new Light("Light");
        Speaker speaker = new Speaker("Song 1");
        LearningDesk learningDesk = new LearningDesk();
        LectureDesk lectureDesk = new LectureDesk();
        Noticeboard noticeboard = new Noticeboard();
        ProjectorBoard projectorBoard = new ProjectorBoard();
        Projector projector = new Projector();
        AirConditioner airCon = new AirConditioner();
        Fan fan = new Fan();

        addObjectinList(fan);
        addObjectinList(airCon);
        addObjectinList(projector);
        addObjectinList(projectorBoard);
        addObjectinList(blackboard);
        addObjectinList(light);
        addObjectinList(speaker);
        addObjectinList(learningDesk);
        addObjectinList(lectureDesk);
        addObjectinList(noticeboard);
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
