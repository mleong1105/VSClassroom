package function.mainfx;

import function.mainfx.classroom_mode.DefaultMode;
import function.mainfx.classroom_mode.DiscussionMode;
import function.mainfx.classroom_mode.LessonMode;
import function.mainfx.classroom_mode.PartyMode;
import function.mainfx.static_obj.Balloon;
import function.mainfx.static_obj.BeverageDispenser;
import function.mainfx.static_obj.DiscoBall;
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

public class ClassroomFacade {

    Classroom classroom;
    // Speaker speaker;
    // Noticeboard noticeboard;
    // LearningDesk learningDesk;
    // LectureDesk lectureDesk;
    // Light light;
    // SmartBoard smartBoard;
    // Balloon balloon;
    // //DiscoBall discoBall;
    // BeverageDispenser beverageDispenser;

    public ClassroomFacade(Classroom classroom) {
        this.classroom = classroom;
        // this.speaker = speaker;
        // this.noticeboard = noticeboard;
        // this.learningDesk = learningDesk;
        // this.lectureDesk = lectureDesk;
        // this.light = light;
        // this.smartBoard = smartBoard;
        // this.balloon = balloon;
        // // this.discoBall = discoBall;
        // this.beverageDispenser = beverageDispenser;
    }

    public void setMode(String mode) {
        switch (mode) {
            case "Lesson":
                classroom.setMode(new LessonMode());
                break;
            case "Party":
                classroom.setMode(new PartyMode());
                break;
            case "Discussion":
                classroom.setMode(new DiscussionMode());
                break;
            default:
                classroom.setMode(new DefaultMode());
                break;
        }
    }

    public void initialClassSetting() {
        // prepare all the object in the classroom
        // dark background
        startClass();
    }

    public void startClass() {
        // DefaultMode defaultMode = new DefaultMode();
        // PartyMode partyMode = new PartyMode();

        // if (classroom.getMode().equals(partyMode)) {
        //     partyMode.getObjPane().getChildren().add(balloon.getObjectImageView());
        //     //  partyMode.getObjPane().getChildren().add(discoBall.getObjectImageView());
        //     partyMode.getObjPane().getChildren().add(beverageDispenser.getObjectImageView());
        // }
        // speaker.on();
        // lectureDesk.addLectureDesk();
        // light.on();
        // smartBoard.on();
        System.out.println("Class Started");
    }

    public void changeClassMode(String mode) {
        if (mode == "Lesson") {
            // projector.on();
            // projectorBoard.down();
            // light.dim(4);
            // speaker.setStereoSound();
            // laptopPlayer.play("youtube url");
        } else if (mode == "Discussion") {

            // speaker.off();
            // laptopPlayer.off();
        } else if (mode == "Party") {
            // discoBall.on();
            // discoBall.changeColor("Red");
            // beverageDispenser.randomBeverage();
            // beverageDispenser.refill();
            // light.dim(3);
            // speaker.setVolume(10);
        }
    }

    public void endClass() {
        // light.off();
        // // projector.off();
        // speaker.off();
        // discoBall.off();
        // laptopPlayer.off();
        // projectorBoard.up();

    }
}
