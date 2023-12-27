package function.mainfx.classroom_mode;

import java.util.ArrayList;
import java.util.List;

import function.mainfx.ClassObj;
import function.mainfx.ClassroomMode;
import function.mainfx.static_obj.AirConditioner;
import function.mainfx.static_obj.Fan;
import function.mainfx.static_obj.LearningDesk;
import function.mainfx.static_obj.LectureDesk;
import function.mainfx.static_obj.Light;
import function.mainfx.static_obj.Noticeboard;
import function.mainfx.static_obj.Projector;
import function.mainfx.static_obj.ProjectorBoard;
import function.mainfx.static_obj.SmartBoard;
import function.mainfx.static_obj.Speaker;
import javafx.scene.layout.Pane;

public class LessonMode extends ClassroomMode {

    private Pane objPane;
    private List<ClassObj> objList;

    public LessonMode() {
        objPane = new Pane();
        objList = new ArrayList<>();
        Light light = new Light("Light");
        Speaker speaker = new Speaker("Song 1");
        LearningDesk learningDesk = new LearningDesk();
        LectureDesk lectureDesk = new LectureDesk();
        Noticeboard noticeboard = new Noticeboard();
        SmartBoard smartBoard = new SmartBoard(230, 350);

        ProjectorBoard projectorBoard = new ProjectorBoard();
        Projector projector = new Projector();
        AirConditioner airCon = new AirConditioner();
        Fan fan = new Fan();
        
        addObjectinList(light);
        addObjectinList(speaker);
        addObjectinList(learningDesk);
        addObjectinList(lectureDesk);
        addObjectinList(noticeboard);
        addObjectinList(smartBoard);

        addObjectinList(fan);
        addObjectinList(airCon);
        addObjectinList(projector);
        addObjectinList(projectorBoard);
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
