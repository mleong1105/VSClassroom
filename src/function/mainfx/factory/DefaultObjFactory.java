package function.mainfx.factory;

import function.mainfx.ClassObjFactory;
import function.mainfx.static_obj.AirConditioner;
import function.mainfx.static_obj.Balloon;
import function.mainfx.static_obj.BeverageDispenser;
import function.mainfx.static_obj.Blackboard;
import function.mainfx.static_obj.DiscoBall;
import function.mainfx.static_obj.DiscussionTable;
import function.mainfx.static_obj.Fan;
import function.mainfx.static_obj.FoodTable;
import function.mainfx.static_obj.LearningDesk;
import function.mainfx.static_obj.LectureDesk;
import function.mainfx.static_obj.Light;
import function.mainfx.static_obj.Noticeboard;
import function.mainfx.static_obj.ProjectorBoard;
import function.mainfx.static_obj.SmartBoard;
import function.mainfx.static_obj.Speaker;
import function.mainfx.static_obj.Whiteboard;

public class DefaultObjFactory implements ClassObjFactory {

    public Blackboard createBlackboard() {
        return Blackboard.getInstanceBlackboard();
    }

    public Light createLight() {
        return Light.getInstanceLight("Light");
    }

    public Speaker createSpeaker() {
        return Speaker.getInstanceSpeaker("Song 1");
    }

    public LearningDesk createLearningDesk() {
        return LearningDesk.getInstanceLearningDesk();
    }

    public LectureDesk createLectureDesk() {
        return LectureDesk.getInstanceLectureDesk();
    }

    public Noticeboard createNoticeboard() {
        return Noticeboard.getInstanceNoticeboard();
    }

    public DiscussionTable createDiscussionTable() {
        return DiscussionTable.getInstanceDiscussionTable();
    }

    public Whiteboard createWhiteboard() {
        return Whiteboard.getInstanceWhiteboard();
    }

    public SmartBoard createSmartBoard() {
        return SmartBoard.getInstanceSmartBoard(230, 350);
    }

    public Balloon createBalloon() {
        return Balloon.getInstanceBalloon();
    }

    public DiscoBall createDiscoBall() {
        return DiscoBall.getInstanceDiscoBall(150, 150, "Red");
    }

    public BeverageDispenser createBeverageDispenser() {
        return BeverageDispenser.getInstanceBeverageDispenser(1, 100);
    }

    public FoodTable createFoodTable() {
        return FoodTable.getInstanceFoodTable();
    }

    public Fan createFan() {
        return Fan.getInstanceFan("Fan");
    }

    public AirConditioner createAirCon() {
        return AirConditioner.getInstanceAirCon("AirCon");
    }

    public ProjectorBoard createProjectorBoard() { 
        return ProjectorBoard.getInstanceProjectorBoard("ProjectorBoard");
    }
}
