package function.mainfx;

import function.mainfx.class_mode.DefaultMClass;
import function.mainfx.class_mode.LessonMClass;
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
    Speaker speaker;
    Noticeboard noticeboard;
    Balloon balloon;
    LearningDesk learningDesk;
    LectureDesk lectureDesk;
    Light light;
    DiscoBall discoBall;
    SmartBoard smartBoard;
    Projector projector;
    ProjectorBoard projectorBoard;
    BeverageDispenser beverageDispenser;
    LaptopPlayer laptopPlayer;

    public ClassroomFacade(Speaker speaker, Noticeboard noticeboard, Balloon ballon, LearningDesk learningDesk, LectureDesk lectureDesk, Light light, DiscoBall discoBall,SmartBoard smartBoard, Projector projector, ProjectorBoard projectorBoard,BeverageDispenser beverageDispenser, LaptopPlayer laptopPlayer) {
        Classroom classroom = new DefaultMClass();
        classroom.addObjectinList(projector);
        this.speaker = speaker;
        this.noticeboard = noticeboard;
        this.balloon = balloon;
        this.learningDesk = learningDesk;
        this.lectureDesk = lectureDesk;
        this.light = light;
        this.discoBall = discoBall;
        this.smartBoard = smartBoard;
        this.projector = projector;
        this.projectorBoard = projectorBoard;
        this.beverageDispenser = beverageDispenser;
        this.laptopPlayer = laptopPlayer;
        
          
    }

    public void initialClassSetting() {
        // prepare all the object in the classroom
        // dark background
        startClass();
        classroom.addObjectinList(balloon);

    }

    public void startClass() {
        speaker.on();
        lectureDesk.addLectureDesk();
        light.on();
        smartBoard.on();
    }

    public void changeClassMode(String mode) {
        classroom.addObjectinList(noticeboard);
        if (mode == "Lesson") {
            classroom.addObjectinList(lectureDesk);
            projector.on();
            projectorBoard.down();
            light.dim(4);
            speaker.setStereoSound();
            laptopPlayer.play("youtube url");
        } else if (mode == "Discussion") {

            speaker.off();
            laptopPlayer.off();
        } else if (mode == "Party") {
            discoBall.on();
            discoBall.changeColor("Red");
            beverageDispenser.randomBeverage();
            beverageDispenser.refill();
            light.dim(3);
            speaker.setVolume(10);
        }
    }

    public void endClass() {
        light.off();
        projector.off();
        speaker.off();
        discoBall.off();
        laptopPlayer.off();
        projectorBoard.up();

    }
}
