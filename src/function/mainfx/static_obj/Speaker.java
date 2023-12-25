package function.mainfx.static_obj;

import function.mainfx.ClassObj;

public class Speaker extends ClassObj {

    String musicName;

    public Speaker(String musicName) {
        super("/function/mainfx/resources/image/active_speaker.png", 80, 80, 10, 10);
        this.musicName = musicName;
    }

    public void on() {
        System.out.println("Play " + musicName);
    }

    public void off(){
        System.out.println("Stop Playing "+ musicName);
    }

    public void setStereoSound(){
        System.out.println("streo sound on");
    }

    public void setMonauralSound(){
        System.out.println("Mono sound on");
    } 

    public void setVolume(int volumeSize){
        System.out.println("Volume set to "+ volumeSize);
    }

    public String toString(){
        return musicName;
    }
}
