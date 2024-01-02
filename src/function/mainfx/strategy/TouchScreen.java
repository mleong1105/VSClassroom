package function.mainfx.strategy;

import function.mainfx.MultipurposeClassroom;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class TouchScreen implements ProjectorBehaviour {

    Canvas canvas;
    GraphicsContext gc;

    @Override
    public void project() {
        MultipurposeClassroom classroom = MultipurposeClassroom.getInstanceMultipurposeClassroom();
        canvas = new Canvas(340, 200);
        gc = canvas.getGraphicsContext2D();
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
        canvas.setDisable(false);
    }

    @Override
    public void clearCanvas() {
        // Clear the entire canvas
        gc.clearRect(0, 0, 340, 200);
        canvas.setDisable(true);
    }

}
