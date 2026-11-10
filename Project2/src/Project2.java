import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.stage.Stage;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.awt.*;
import java.io.File;
import java.sql.Array;

public class Project2 extends Application{

    //Setup for GUI, buttons and events
    public void start(Stage primaryStage) {

        //Create a grid Pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(0));
        pane.setPrefSize(800, 500);
        pane.setMinSize(800, 500);
        pane.setMaxSize(800, 500);
        pane.setHgap(0);
        pane.setVgap(0);
        pane.setGridLinesVisible(true);

        // Create a TilePane for the shape buttons
        TitledPane shapeButtonPane = new TitledPane();
        shapeButtonPane.setText("Shape");
        shapeButtonPane.setCollapsible(false);
        TilePane shapeWindow = new TilePane();
        shapeWindow.setHgap(5);
        shapeWindow.setVgap(5);
        shapeButtonPane.setPadding(new Insets(0, 0, 0, 0));
        shapeWindow.setPrefColumns(3);
        shapeButtonPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setHgrow(shapeButtonPane, Priority.ALWAYS);
        GridPane.setVgrow(shapeButtonPane, Priority.ALWAYS);
        shapeButtonPane.setContent(shapeWindow);
        pane.add(shapeButtonPane, 0, 0);

        // Create Shape buttons
        ToggleButton circleButton = new ToggleButton("CIRCLE");
        circleButton.setUserData("Circle");
        ToggleButton coneButton = new ToggleButton("CONE");
        coneButton.setUserData("Cone");
        ToggleButton cubeButton = new ToggleButton("CUBE");
        cubeButton.setUserData("Cube");
        ToggleButton cylinderButton = new ToggleButton("CYLINDER");
        cylinderButton.setUserData("Cylinder");
        ToggleButton squareButton = new ToggleButton("SQUARE");
        squareButton.setUserData("Square");
        ToggleButton rectangleButton = new ToggleButton("RECTANGLE");
        rectangleButton.setUserData("Rectangle");
        ToggleButton sphereButton = new ToggleButton("SPHERE");
        sphereButton.setUserData("Sphere");
        ToggleButton triangleButton = new ToggleButton("TRIANGLE");
        triangleButton.setUserData("Triangle");
        ToggleButton torusButton = new ToggleButton("TORUS");
        torusButton.setUserData("Torus");
        ToggleButton[] toggleButtons = {circleButton, coneButton,cubeButton, cylinderButton, squareButton,
        rectangleButton, sphereButton, triangleButton, torusButton};

        // Group toggle buttons so only one button can be pressed at a time and resize them
        ToggleGroup buttonGroup = new ToggleGroup();
        for (ToggleButton tb : toggleButtons){
            tb.setToggleGroup(buttonGroup);
            shapeWindow.getChildren().add(tb);
            tb.setMinSize(80, 80);
            tb.setMaxSize(80,80);
            tb.setPrefSize(80, 80);
        }

        // Create a Shape Options Window
        TitledPane shapeOptionsPane = new TitledPane();
        shapeOptionsPane.setText("Shape Options");
        shapeOptionsPane.setCollapsible(false);
        GridPane shapeOptions = new GridPane();
        shapeOptions.setPadding(new Insets(15));
        shapeOptions.setHgap(20);
        shapeOptions.setVgap(5);
        shapeOptionsPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setHgrow(shapeOptionsPane, Priority.ALWAYS);
        GridPane.setVgrow(shapeOptionsPane, Priority.ALWAYS);
        pane.add(shapeOptionsPane, 0, 1);
        shapeOptionsPane.setContent(shapeOptions);

        // Create text fields for shape properties, dropdown for shape color, and button to apply the options
        TextField tfAtt1 = new TextField();
        TextField tfAtt2 = new TextField();
        TextField tfAtt3 = new TextField();
        TextField tfAtt4 = new TextField();
        tfAtt1.setMaxWidth(90);
        tfAtt2.setMaxWidth(90);
        tfAtt3.setMaxWidth(90);
        tfAtt4.setMaxWidth(90);
        Label att1 = new Label("Attribute 1");
        Label att2 = new Label("Attribute 2");
        Label att3 = new Label("Attribute 3");
        Label att4 = new Label("Attribute 4");
        Label lbColor = new Label("Shape Color");
        shapeOptions.addRow(0, att1, tfAtt1);
        shapeOptions.addRow(1, att2, tfAtt2);
        shapeOptions.addRow(2, att3, tfAtt3);
        shapeOptions.addRow(3, att4, tfAtt4);
        ComboBox<String> cbColor = new ComboBox<>();
        cbColor.getItems().addAll(
                "Black", "Red", "Blue", "Green", "Yellow",
                "Orange" , "Purple", "Brown", "White");
        cbColor.setMaxWidth(90);
        shapeOptions.addRow(4,lbColor, cbColor);
        Button btnApply = new Button("APPLY!");
        shapeOptions.add(btnApply, 1, 5);

        // Create a display window for the shape drawing
        TitledPane displayArea = new TitledPane();
        displayArea.setText("Display Area");
        displayArea.setCollapsible(false);
        displayArea.setMaxSize(400, 300);
        displayArea.setMinSize(400, 300);
        pane.getChildren().add(displayArea);
        GridPane.setColumnIndex(displayArea, 1);

        // Create a Shape Details window to display area/volume, lengths, radii, etc.
        TitledPane shapeDetailsPane = new TitledPane();
        shapeDetailsPane.setText("Shape Details");
        shapeDetailsPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GridPane.setHgrow(shapeDetailsPane, Priority.ALWAYS);
        GridPane.setVgrow(shapeDetailsPane, Priority.ALWAYS);
        TextArea shapeDetails = new TextArea();
        shapeDetails.setText("Details of the custom shape will appear here.");
        shapeDetails.setEditable(false);
        shapeDetailsPane.setCollapsible(false);
        pane.add(shapeDetailsPane, 1, 1);
        shapeDetailsPane.setContent(shapeDetails);

        //Create Column constraints so the columns cannot be crushed
        ColumnConstraints column0 = new ColumnConstraints(300);
        ColumnConstraints column1 = new ColumnConstraints(400);
        pane.getColumnConstraints().addAll(column0, column1);
        RowConstraints row0 = new RowConstraints(280);
        RowConstraints row1 = new RowConstraints(300);
        pane.getRowConstraints().addAll(row0, row1);

        //Set a scene with the grid pane and vbox
        Scene scene = new Scene(pane);

        //Set up the window and display the scene
        primaryStage.setTitle("Shape Display");
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(700);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(700);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

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
        );

        // Apply button logic
        btnApply.setOnAction((ActionEvent e) -> {



        });


    }




    public static void main(String[] args) {
        launch(args);
    }
}

