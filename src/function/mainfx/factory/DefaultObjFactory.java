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
import function.mainfx.static_obj.Speaker;
import function.mainfx.static_obj.Whiteboard;

public class DefaultObjFactory implements ClassObjFactory {

    public Blackboard createBlackboard() {
        return Blackboard.getInstanceBlackboard(
                "/function/mainfx/resources/image/blackboard.png");
    }

    public Light createLight() {
        return Light.getInstanceLight(
                "/function/mainfx/resources/image/lighton.png",
                "/function/mainfx/resources/image/lightoff.png");
    }

    public Speaker createSpeaker() {
        return Speaker.getInstanceSpeaker(
                "/function/mainfx/resources/image/active_speaker.png",
                "/function/mainfx/resources/image/disactive_speaker.png",
                "Song 1");
    }

    public LearningDesk createLearningDesk() {
        return LearningDesk.getInstanceLearningDesk(
                "/function/mainfx/resources/image/learningdesk.png");
    }

    public LectureDesk createLectureDesk() {
        return LectureDesk.getInstanceLectureDesk(
                "/function/mainfx/resources/image/lecturedesk.png");
    }

    public Noticeboard createNoticeboard() {
        return Noticeboard.getInstanceNoticeboard(
                "/function/mainfx/resources/image/noticeboard.png");
    }

    public DiscussionTable createDiscussionTable() {
        return DiscussionTable.getInstanceDiscussionTable("/function/mainfx/resources/image/discussion_table.png");
    }

    public Whiteboard createWhiteboard() {
        return Whiteboard.getInstanceWhiteboard(
                "/function/mainfx/resources/image/whiteboard.png");
    }

    public Balloon createBalloon() {
        return Balloon.getInstanceBalloon(
                "/function/mainfx/resources/image/balloon.png");
    }

    public DiscoBall createDiscoBall() {
        return DiscoBall.getInstanceDiscoBall(
                "/function/mainfx/resources/image/discoball.png",
                "Red");
    }

    public BeverageDispenser createBeverageDispenser() {
        return BeverageDispenser.getInstanceBeverageDispenser(
                new String[]{
                    "/function/mainfx/resources/image/water1.png",
                    "/function/mainfx/resources/image/water2.png",
                    "/function/mainfx/resources/image/water3.png",
                    "/function/mainfx/resources/image/water4.png",
                    "/function/mainfx/resources/image/water5.png",
                    "/function/mainfx/resources/image/water6.png"
                },
                1,
                100);
    }

    public FoodTable createFoodTable() {
        return FoodTable.getInstanceFoodTable(
                "/function/mainfx/resources/image/foodtable.png");
    }

    public Fan createFan() {
        return Fan.getInstanceFan(
                "/function/mainfx/resources/image/fan_on.png",
                "/function/mainfx/resources/image/fan_off.png");
    }

    public AirConditioner createAirCon() {
        return AirConditioner.getInstanceAirCon(
                "/function/mainfx/resources/image/airCon_on.png",
                "/function/mainfx/resources/image/airCon_off.png");
    }

    public ProjectorBoard createProjectorBoard() {
        return ProjectorBoard.getInstanceProjectorBoard(
                "/function/mainfx/resources/image/projectorScreen_on.png",
                "/function/mainfx/resources/image/projectorScreen_off.png");

    }
}
