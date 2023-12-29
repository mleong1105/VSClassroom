package function.mainfx;

import function.mainfx.static_obj.Balloon;
import function.mainfx.static_obj.BeverageDispenser;
import function.mainfx.static_obj.DiscoBall;
import function.mainfx.static_obj.DiscussionTable;
import function.mainfx.static_obj.FoodTable;
import function.mainfx.static_obj.LaptopPlayer;
import function.mainfx.static_obj.LearningDesk;
import function.mainfx.static_obj.LectureDesk;
import function.mainfx.static_obj.Light;
import function.mainfx.static_obj.Noticeboard;
import function.mainfx.static_obj.Projector;
import function.mainfx.static_obj.ProjectorBoard;
import function.mainfx.static_obj.SmartBoard;
import function.mainfx.static_obj.Speaker;
import function.mainfx.static_obj.TriangleBanner;
import function.mainfx.static_obj.Whiteboard;

public class ClassroomFacade {

    MultipurposeClassroom classroom;
    Speaker speaker;
    Noticeboard noticeboard;
    LearningDesk learningDesk;
    LectureDesk lectureDesk;
    Light light;
    SmartBoard smartBoard;
    Balloon balloon;
    DiscoBall discoBall;
    BeverageDispenser beverageDispenser;
    FoodTable foodTable;
    DiscussionTable discussionTable;
    Whiteboard whiteboard;
    Projector projector;

    public ClassroomFacade(MultipurposeClassroom classroom, Speaker speaker, Noticeboard noticeboard,
            LearningDesk learningDesk, LectureDesk lectureDesk, Light light, SmartBoard smartBoard, Balloon balloon,
            DiscoBall discoBall, BeverageDispenser beverageDispenser, FoodTable foodTable,
            DiscussionTable discussionTable, Whiteboard whiteboard) {
        this.classroom = classroom;
        this.speaker = speaker;
        this.noticeboard = noticeboard;
        this.learningDesk = learningDesk;
        this.lectureDesk = lectureDesk;
        this.light = light;
        this.smartBoard = smartBoard;
        this.balloon = balloon;
        this.discoBall = discoBall;
        this.beverageDispenser = beverageDispenser;
        this.foodTable = foodTable;
        this.discussionTable = discussionTable;
        this.whiteboard = whiteboard;
    }

    public void setMode(String mode) {
        if (mode == null) {
            return;
        }
        switch (mode) {
            case "Lesson":
                initialClassSetting();
                classroom.addObjectinList(learningDesk);
                break;
            case "Party":
                initialClassSetting();
                classroom.addObjectinList(balloon);
                classroom.addObjectinList(discoBall);
                classroom.addObjectinList(beverageDispenser);
                classroom.addObjectinList(foodTable);
                break;
            case "Discussion":
                initialClassSetting();
                classroom.addObjectinList(discussionTable);
                classroom.addObjectinList(whiteboard);
                break;
            default:
                initialClassSetting();
                break;
        }
    }

    public void initialClassSetting() {
        classroom.clearObjectinList();
        // classroom.addObjectinList(speaker);
        classroom.addObjectinList(noticeboard);
        classroom.addObjectinList(lectureDesk);
        classroom.addObjectinList(light);
    }

    public MultipurposeClassroom getClassroom() {
        return classroom;
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public Noticeboard getNoticeboard() {
        return noticeboard;
    }

    public LearningDesk getLearningDesk() {
        return learningDesk;
    }

    public LectureDesk getLectureDesk() {
        return lectureDesk;
    }

    public Light getLight() {
        return light;
    }

    public SmartBoard getSmartBoard() {
        return smartBoard;
    }

    public Balloon getBalloon() {
        return balloon;
    }

    public DiscoBall getDiscoBall() {
        return discoBall;
    }

    public BeverageDispenser getBeverageDispenser() {
        return beverageDispenser;
    }

    public FoodTable getFoodTable() {
        return foodTable;
    }

    public DiscussionTable getDiscussionTable() {
        return discussionTable;
    }

    public Whiteboard getWhiteboard() {
        return whiteboard;
    }

    public Projector getProjector() {
        return projector;
    }
}
