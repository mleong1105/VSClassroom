package function.mainfx.static_obj;

import function.mainfx.ClassObj;
import function.mainfx.static_obj.Speaker;

public class LaptopPlayer extends ClassObj{

    private String description;
    private Speaker speaker;
    private String movieUrl;

    // Singleton instance
    private volatile static LaptopPlayer uniqueInstanceLaptopPlayer;    

    // Private constructor
    private LaptopPlayer(String description, Speaker speaker) {
        super("/function/mainfx/resources/image/laptop_player.png", 20, 20, 220, 90);
        this.description = description;
        this.speaker = speaker;
    }

    // Public method to get the singleton instance
    public static LaptopPlayer getInstanceLaptopPlayer(String description, Speaker speaker) {
        if (uniqueInstanceLaptopPlayer == null) {
            synchronized (LaptopPlayer.class) {
                if (uniqueInstanceLaptopPlayer == null) {
                    uniqueInstanceLaptopPlayer = new LaptopPlayer(description, speaker);
                }
            }
        }
        return uniqueInstanceLaptopPlayer;
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
        System.out.println(description + " paused \"" + movieUrl + "\"");
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
