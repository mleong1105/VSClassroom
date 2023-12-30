package function.mainfx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ClassObj {
    protected ImageView objectImageView;
    protected String description;
    protected double fitWidth, fitHeight, layoutX, layoutY;

    public ClassObj(String imagePath, double fitWidth, double fitHeight, double layoutX, double layoutY, String description) {
        this.description = description;
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;
        this.layoutX = layoutX;
        this.layoutY = layoutY;

        objectImageView = new ImageView();
        updateImage(imagePath);
    }

    private void updateImage(String imagePath){
        Image image = new Image(getClass().getResourceAsStream(imagePath));
       
        objectImageView.setImage(image);
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

    public String getDescription() {
        return description;
    }

    public void setClassObject(String imagePath, double fitWidth, double fitHeight, double layoutX, double layoutY){
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;
        this.layoutX = layoutX;
        this.layoutY = layoutY;
        updateImage(imagePath);
    }
    
}
