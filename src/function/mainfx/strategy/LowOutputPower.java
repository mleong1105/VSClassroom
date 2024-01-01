package function.mainfx.strategy;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LowOutputPower implements SpeakerBehaviour {

    @Override
    public void playingSound() {
        Alert pAlert = new Alert(AlertType.INFORMATION);
        pAlert.setHeaderText("Current Speaker Mode: Low Output Power");
        pAlert.setContentText("Maximum sound for this speaker can be until 50");
        pAlert.showAndWait();
    }

}
