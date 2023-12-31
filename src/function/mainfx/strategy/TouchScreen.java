package function.mainfx.strategy;

import function.mainfx.MultipurposeClassroom;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class TouchScreen implements ProjectorBehaviour {

    @Override
    public void project() {
        MultipurposeClassroom classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        Canvas canvas = new Canvas(340, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(2.0);
        gc.setStroke(Color.BLACK);

        canvas.setOnMousePressed(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                gc.beginPath();
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
            }
        });

        canvas.setOnMouseDragged(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                gc.lineTo(e.getX(), e.getY());
                gc.stroke();
            }
        });
        canvas.setTranslateX(230);
        canvas.setTranslateY(80);
        classroom.getObjPane().getChildren().add(canvas);
    }

}
