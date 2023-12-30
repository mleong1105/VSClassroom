package function.mainfx;

import function.mainfx.static_obj.*;

public interface ClassObjFactory {
    Blackboard createBlackboard();
    Light createLight();
    Speaker createSpeaker();
    LearningDesk createLearningDesk();
    LectureDesk createLectureDesk();
    Noticeboard createNoticeboard();

    DiscussionTable createDiscussionTable();
    Whiteboard createWhiteboard();
    SmartBoard createSmartBoard();
    Balloon createBalloon();
    DiscoBall createDiscoBall();
    BeverageDispenser createBeverageDispenser();
    FoodTable createFoodTable();
    Fan createFan();
    AirConditioner createAirCon();
    ProjectorBoard createProjectorBoard();
}
