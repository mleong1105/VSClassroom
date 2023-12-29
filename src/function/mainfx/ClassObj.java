package function.mainfx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ClassObj {
    private ImageView objectImageView;
    private double fitWidth, fitHeight, layoutX, layoutY;

    public ClassObj(String imagePath, double fitWidth, double fitHeight, double layoutX, double layoutY) {
        objectImageView = new ImageView();
        updateImage(imagePath, fitWidth, fitHeight, layoutX, layoutY);
    }

    private void updateImage(String imagePath, double fitWidth, double fitHeight, double layoutX, double layoutY){
        Image image = new Image(getClass().getResourceAsStream(imagePath));
       
        objectImageView.setImage(image);
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;
        this.layoutX = layoutX;
        this.layoutY = layoutY;

        configImageSize(this.fitWidth, this.fitHeight);
        configImageLayout(this.layoutX, this.layoutY);
    }

    private void configImageSize(double fitWidth, double fitHeight) {
        objectImageView.setFitWidth(fitWidth);
        objectImageView.setFitHeight(fitHeight);
    }

    private void configImageLayout(double layoutX, double layoutY) {
        objectImageView.setLayoutX(layoutX);
        objectImageView.setLayoutY(layoutY);
    }

    public ImageView getObjectImageView() {
        return objectImageView;
    }

    public void setClassObject(String imagePath, double fitWidth, double fitHeight, double layoutX, double layoutY){
        updateImage(imagePath, fitWidth, fitHeight, layoutX, layoutY);
    }
    
}
