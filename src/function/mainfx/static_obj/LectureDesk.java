package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class LectureDesk extends ClassObj {

    boolean exist;
    
    public LectureDesk() {
        super("/function/mainfx/resources/image/lecturedesk.png", 300, 200, 10, 260);
        this.exist = true;
    }

    public void addLectureDesk(){
        if(exist==false){
            this.exist = true;
        }
    }

    public void removeLectureDesk(){
        this.exist = false;
    }


}
