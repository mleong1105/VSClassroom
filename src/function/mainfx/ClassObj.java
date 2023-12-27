package function.mainfx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public abstract class ClassObj {
    private Image objectImage;
    private ImageView objectImageView;
    private double fitWidth, fitHeight, layoutX, layoutY;

    public ClassObj(String imagePath, double fitWidth, double fitHeight, double layoutX, double layoutY) {
        objectImage = new Image(getClass().getResourceAsStream(imagePath));
        objectImageView = new ImageView(objectImage);
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;
        this.layoutX = layoutX;
        this.layoutY = layoutY;

        configImageSize(this.fitWidth, this.fitHeight);
        configImageLayout(this.layoutX, this.layoutY);
    }

    public void configImageSize(double fitWidth, double fitHeight) {
        objectImageView.setFitWidth(fitWidth);
        objectImageView.setFitHeight(fitHeight);
    }

    public void configImageLayout(double layoutX, double layoutY) {
        objectImageView.setLayoutX(layoutX);
        objectImageView.setLayoutY(layoutY);
    }

    // Method to rotate the image
    public void rotate(double angle) {
        ImageView imageView = getObjectImageView();
        Rotate rotate = new Rotate(angle, imageView.getFitWidth() / 2, imageView.getFitHeight() / 2);
        imageView.getTransforms().add(rotate);
    }

    public ImageView getObjectImageView() {
        return objectImageView;
    }

}
