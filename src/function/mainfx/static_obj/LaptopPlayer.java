package function.mainfx.static_obj;

import function.mainfx.static_obj.Speaker;

public class LaptopPlayer {

    String description;
    Speaker speaker;
    String movieUrl;

    public LaptopPlayer(String description, Speaker speaker) {
        this.description = description;
        this.speaker = speaker;
    }

    public void on() {
        System.out.println(description + " on");
    }

    public void off() {
        System.out.println(description + " off");
    }

    public void eject() {
        movieUrl = null;
        System.out.println(description + " eject");
    }

    public void pause() {
        System.out.println(description + " paused \"" + movie + "\"");
    }

    public void play(String movieUrl) {
        this.movieUrl = movieUrl;

        System.out.println(description + " playing \"" + movieUrl + "\"");
    }

    public void play(int chapter) {
        if (movieUrl == null) {
            System.out.println(description + " can't play chapter " + chapter + " no movie selected");
        } else {
            System.out.println(description + " playingb " + movieUrl + "\"");
        }
    }

    public void stop() {
        System.out.println(description + " stopped \"" + movieUrl + "\"");
    }

    public void setTwoChannelAudio() {
        speaker.setMonauralSound();
        System.out.println(description + " set two channel audio");
    }

    public void setSurroundAudio() {
        speaker.setStereoSound();
        System.out.println(description + " set surround audio");
    }

    @Override
    public String toString() {
        return description;
    }
}
