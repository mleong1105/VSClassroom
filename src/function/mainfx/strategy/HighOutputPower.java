package function.mainfx.strategy;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class HighOutputPower implements SpeakerBehaviour {

    @Override
    public void playingSound() {
        Alert pAlert = new Alert(AlertType.INFORMATION);
        pAlert.setHeaderText("Current Speaker Mode: High Output Power");
        pAlert.setContentText("Maximum sound for this speaker can be until 100");
        pAlert.showAndWait();
    }

}
