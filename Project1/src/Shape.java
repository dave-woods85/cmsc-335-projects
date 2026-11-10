/*
David Woods
CMSC335
24 Oct 2026
Project 1
Shape.java

This is a class for all shape objects in Project 1

 */

import java.io.File;

public class Shape {
    int numberOfDimensions;

    // Getter and setter methods
    public void setNumberOfDimensions(int dimension){
        this.numberOfDimensions = dimension;
    }

    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }

    public void draw(String shape){

    }
    /*
    // BUTTONS! For shape selection
        buttonGroup.selectedToggleProperty().addListener(
                (obs, oldToggle,newToggle) -> {
        if (newToggle == null) {
            shapeDetails.setText("Select a shape from the grid to see details");
        }
        else{
            switch (buttonGroup.getSelectedToggle().getUserData().toString()) {

                case "Cone" -> {
                    File file = new File("/Users/dave/IdeaProjects/CMSC_335/Project1/src/images/cone.png");
                    Image image = new Image(file.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(200);
                    imageView.setPreserveRatio(true);
                    displayArea.setContent(imageView);
                    Cone cone = new Cone();
                    cone.draw("Cone");
                }
                case "Cube" -> {
                    File file = new File("/Users/dave/IdeaProjects/CMSC_335/Project1/src/images/cube.png");
                    Image image = new Image(file.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(200);
                    imageView.setPreserveRatio(true);
                    displayArea.setContent(imageView);
                }
                case "Sphere" -> {
                    File file = new File("/Users/dave/IdeaProjects/CMSC_335/Project1/src/images/sphere.png");
                    Image image = new Image(file.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(200);
                    imageView.setPreserveRatio(true);
                    displayArea.setContent(imageView);
                }
                case "Cylinder" -> {
                    File file = new File("/Users/dave/IdeaProjects/CMSC_335/Project1/src/images/cylinder.png");
                    Image image = new Image(file.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(150);
                    imageView.setPreserveRatio(true);
                    displayArea.setContent(imageView);
                }
                case "Torus" -> {
                    File file = new File("/Users/dave/IdeaProjects/CMSC_335/Project1/src/images/torus.png");
                    Image image = new Image(file.toURI().toString());
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(200);
                    imageView.setPreserveRatio(true);
                    displayArea.setContent(imageView);
                }
                case "Square" -> {
                    displayArea.setContent(new javafx.scene.shape.Rectangle(100, 100));

                }
                case "Circle" -> {
                    displayArea.setContent(new javafx.scene.shape.Circle(50));
                }
                case "Rectangle" -> {
                    displayArea.setContent(new javafx.scene.shape.Rectangle(200, 100));

                }
                case "Triangle" -> {
                    displayArea.setContent(new javafx.scene.shape.Polygon(
                            150, 100,
                            100, 200,
                            200, 200));
                }
                default -> {
                    shapeDetails.setText("Please select a Shape.");
                }
            }
        }
    }
        ); */
}
