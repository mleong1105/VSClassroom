package function.mainfx;

import function.mainfx.static_obj.*;

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
    Fan fan;
    AirConditioner airCon;
    ProjectorBoard projectorBoard;

    public ClassroomFacade(MultipurposeClassroom classroom, Speaker speaker, Noticeboard noticeboard,
            LearningDesk learningDesk, LectureDesk lectureDesk, Light light, SmartBoard smartBoard, Balloon balloon,
            DiscoBall discoBall, BeverageDispenser beverageDispenser, FoodTable foodTable,
            DiscussionTable discussionTable, Whiteboard whiteboard,
            Fan fan, AirConditioner airCon, ProjectorBoard projectorBoard) {
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
        this.fan = fan;
        this.airCon = airCon;
        this.projectorBoard = projectorBoard;
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
        classroom.addObjectinList(speaker);
        classroom.addObjectinList(noticeboard);
        classroom.addObjectinList(lectureDesk);
        classroom.addObjectinList(light);
        classroom.addObjectinList(fan);
        classroom.addObjectinList(airCon);
        classroom.addObjectinList(projectorBoard);
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

    public Fan getFan() {
        return fan;
    }

    public AirConditioner getAirConditioner() {
        return airCon;
    }

    public ProjectorBoard getProjectorBoard() {
        return projectorBoard;
    }
}
