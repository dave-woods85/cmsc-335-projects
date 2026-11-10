import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;

/*
David Woods
CMSC335
5 Nov 2026
Project 2

This serves as the GUI creator for the Shape Maker application. This class handles the
creation of the GUI, button/textfield handling, and object drawing.

The directory for each image file will need to be updated to your own directory.

 */
public class Project2 extends Application{
    // Correct the file directory for each user
    private final String fileDir = System.getProperty("user.dir");

    //Setup for GUI, buttons and events
    public void start(Stage primaryStage) {

        //Create a Grid Pane to organize the rest of the frames
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(0));
        pane.setPrefSize(800, 500);
        pane.setMinSize(800, 500);
        pane.setMaxSize(800, 500);
        pane.setHgap(0);
        pane.setVgap(0);
        pane.setGridLinesVisible(false);

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
        buttonGroup.selectToggle(circleButton);

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
        tfAtt1.setTextFormatter(textFormat());
        tfAtt2.setTextFormatter(textFormat());
        tfAtt3.setTextFormatter(textFormat());
        tfAtt4.setTextFormatter(textFormat());
        shapeOptions.addRow(0, att1, tfAtt1);
        shapeOptions.addRow(1, att2, tfAtt2);
        shapeOptions.addRow(2, att3, tfAtt3);
        shapeOptions.addRow(3, att4, tfAtt4);
        ComboBox<String> cbColor = new ComboBox<>();
        cbColor.getItems().addAll(
                "Black", "Red", "Blue", "Green", "Yellow",
                "Orange" , "Purple", "Brown", "White");
        cbColor.setMaxWidth(90);
        cbColor.setValue("Black");
        shapeOptions.addRow(4,lbColor, cbColor);
        Button btnApply = new Button("APPLY!");
        btnApply.setPrefSize(100, 50);
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
        shapeDetails.setWrapText(true);
        shapeDetails.setFont(new Font(20));
        shapeDetails.setText("""
                Welcome to the Shape Maker!
                Please select a shape from the grid and press "APPLY!"
                """);
        shapeDetails.setEditable(false);
        shapeDetailsPane.setCollapsible(false);
        pane.add(shapeDetailsPane, 1, 1);
        shapeDetailsPane.setContent(shapeDetails);

        //Create Column constraints so the columns in the GridPane cannot be crushed
        ColumnConstraints column0 = new ColumnConstraints(300);
        ColumnConstraints column1 = new ColumnConstraints(400);
        pane.getColumnConstraints().addAll(column0, column1);
        RowConstraints row0 = new RowConstraints(280);
        RowConstraints row1 = new RowConstraints(300);
        pane.getRowConstraints().addAll(row0, row1);

        //Set a scene with the grid pane and vbox
        Scene scene = new Scene(pane);

        //Set up the window and display the scene
        primaryStage.setTitle("Shape Maker");
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(700);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(700);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        // BUTTONS! For shape selection and applying attributes
        btnApply.setOnAction(
                (ActionEvent e) -> {
                    // Reset the status of the text fields and combo box
                    tfAtt1.setDisable(false);
                    tfAtt2.setDisable(false);
                    tfAtt3.setDisable(false);
                    tfAtt4.setDisable(false);
                    cbColor.setDisable(false);
                    if (e == null) { // Catch null pointer
                        shapeDetails.setText("Select a shape from the grid to see details");
                    }
                    else{ // Instructions for each shape selected
                        switch (buttonGroup.getSelectedToggle().getUserData().toString()) {

                            case "Cone" -> { // Uses an image file instead of 3D shape
                                File file = new File(fileDir + "/Project2/src/images/cone.png");
                                Image image = new Image(file.toURI().toString());
                                ImageView imageView = new ImageView(image);
                                imageView.setFitWidth(200);
                                imageView.setPreserveRatio(true);
                                displayArea.setContent(imageView);
                                att1.setText("Radius");
                                att2.setText("Height");
                                att3.setText("");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                if (tfAtt2.getText().isEmpty()){
                                    tfAtt2.setText("100");
                                }
                                tfAtt3.setDisable(true);
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(true);
                                Cone cone = new Cone(Integer.parseInt(tfAtt1.getText()),Integer.parseInt(tfAtt2.getText()));
                                cone.draw("Cone");
                                shapeDetails.setText("This is a cone with radius " + cone.getRadius() +
                                        " and height " + cone.getHeight() + " with a volume of " +
                                        (Math.round(cone.getVolume())*100.0)/100.0 );

                            }
                            case "Cube" -> { // Uses an image file instead of 3D shape
                                File file = new File(fileDir + "/Project2/src/images/cube.png");
                                Image image = new Image(file.toURI().toString());
                                ImageView imageView = new ImageView(image);
                                imageView.setFitWidth(200);
                                imageView.setPreserveRatio(true);
                                displayArea.setContent(imageView);
                                att1.setText("Side");
                                att2.setText("");
                                att3.setText("");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                tfAtt2.setDisable(true);
                                tfAtt3.setDisable(true);
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(true);
                                Cube cube = new Cube(Integer.parseInt(tfAtt1.getText()));
                                shapeDetails.setText("This is a cube with sides " + cube.getSide() +
                                        " and a volume of " +
                                        (Math.round(cube.getVolume())*100.0)/100.0 );
                            }
                            case "Sphere" -> { // Uses an image file instead of 3D shape
                                File file = new File(fileDir + "/Project2/src/images/sphere.png");
                                Image image = new Image(file.toURI().toString());
                                ImageView imageView = new ImageView(image);
                                imageView.setFitWidth(200);
                                imageView.setPreserveRatio(true);
                                displayArea.setContent(imageView);
                                att1.setText("Radius");
                                att2.setText("");
                                att3.setText("");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                tfAtt2.setDisable(true);
                                tfAtt3.setDisable(true);
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(true);
                                Sphere sphere = new Sphere(Integer.parseInt(tfAtt1.getText()));
                                shapeDetails.setText("This is a sphere with radius " + sphere.getRadius() +
                                        " and a volume of " +
                                        (Math.round(sphere.getVolume())*100.0)/100.0 );
                            }
                            case "Cylinder" -> { // Uses an image file instead of 3D shape
                                File file = new File(fileDir + "/Project2/src/images/cylinder.png");
                                Image image = new Image(file.toURI().toString());
                                ImageView imageView = new ImageView(image);
                                imageView.setFitWidth(150);
                                imageView.setPreserveRatio(true);
                                displayArea.setContent(imageView);
                                att1.setText("Radius");
                                att2.setText("Height");
                                att3.setText("");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                if (tfAtt2.getText().isEmpty()){
                                    tfAtt2.setText("100");
                                }
                                tfAtt3.setDisable(true);
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(true);
                                Cylinder cylinder = new Cylinder(Integer.parseInt(tfAtt1.getText()),
                                        Integer.parseInt(tfAtt2.getText()));
                                shapeDetails.setText("This is a cylinder with radius " + cylinder.getRadius() +
                                        "and height " + cylinder.getHeight() + " with a volume of " +
                                        (Math.round(cylinder.getVolume())*100.0)/100.0 );
                            }
                            case "Torus" -> { // Uses an image file instead of 3D shape
                                File file = new File(fileDir + "/Project2/src/images/torus.png");
                                Image image = new Image(file.toURI().toString());
                                ImageView imageView = new ImageView(image);
                                imageView.setFitWidth(200);
                                imageView.setPreserveRatio(true);
                                displayArea.setContent(imageView);
                                att1.setText("Major Radius");
                                att2.setText("Minor Radius");
                                att3.setText("");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                if (tfAtt2.getText().isEmpty()){
                                    tfAtt2.setText("50");
                                }
                                tfAtt3.setDisable(true);
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(true);
                                Torus torus = new Torus(Integer.parseInt(tfAtt1.getText()),
                                        Integer.parseInt(tfAtt2.getText()));
                                shapeDetails.setText("This is a torus with major radius of " + torus.getMajorRadius() +
                                       " and minor radius of " + torus.getMinorRadius() + " with a volume of " +
                                        (Math.round(torus.getVolume())*100.0)/100.0 );
                            }
                            case "Square" -> {
                                att1.setText("Side");
                                att2.setText("");
                                att3.setText("");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                tfAtt2.setDisable(true);
                                tfAtt3.setDisable(true);
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(false);
                                Square square = new Square(Integer.parseInt(tfAtt1.getText()));
                                javafx.scene.shape.Rectangle squareFX = new javafx.scene.shape.Rectangle(
                                        Integer.parseInt(tfAtt1.getText()),
                                        Integer.parseInt(tfAtt1.getText()));
                                squareFX.setFill(getColor(cbColor.getValue()));
                                shapeDetails.setText("This is a square with sides of " + square.getSide() +
                                      " with an area of " +
                                        (Math.round(square.getArea())*100.0)/100.0 );
                                displayArea.setContent(squareFX);

                            }
                            case "Circle" -> {
                                att1.setText("Radius");
                                att2.setText("");
                                att3.setText("");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                tfAtt2.setDisable(true);
                                tfAtt3.setDisable(true);
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(false);
                                Circle circle = new Circle(Integer.parseInt(tfAtt1.getText()));
                                javafx.scene.shape.Circle circleFX = new javafx.scene.shape.Circle(
                                        Integer.parseInt(tfAtt1.getText()));
                                circleFX.setFill(getColor(cbColor.getValue()));
                                shapeDetails.setText("This is a circle with radius of " + circle.getRadius() +
                                        " with an area of " +
                                        (Math.round(circle.getArea())*100.0)/100.0 );
                                displayArea.setContent(circleFX);
                            }
                            case "Rectangle" -> {
                                att1.setText("Width");
                                att2.setText("Height");
                                att3.setText("");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                if (tfAtt2.getText().isEmpty()){
                                    tfAtt2.setText("100");
                                }
                                tfAtt3.setDisable(true);
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(false);
                                Rectangle rectangle = new Rectangle(Integer.parseInt(tfAtt1.getText()),
                                        Integer.parseInt(tfAtt2.getText()));
                                javafx.scene.shape.Rectangle rectangleFX = new javafx.scene.shape.Rectangle(
                                        Integer.parseInt(tfAtt1.getText()),
                                        Integer.parseInt(tfAtt2.getText()));
                                rectangleFX.setFill(getColor(cbColor.getValue()));
                                shapeDetails.setText("This is a rectangle with width of " + rectangle.getWidth() +
                                       " and height of " + rectangle.getHeight() + " with an area of " +
                                        (Math.round(rectangle.getArea())*100.0)/100.0 );
                                displayArea.setContent(rectangleFX);

                            }
                            case "Triangle" -> {
                                att1.setText("Side 1");
                                att2.setText("Side 2");
                                att3.setText("Side 3");
                                att4.setText("");
                                if (tfAtt1.getText().isEmpty()) {
                                    tfAtt1.setText("50");
                                }
                                if (tfAtt2.getText().isEmpty()){
                                    tfAtt2.setText("50");
                                }
                                if (tfAtt3.getText().isEmpty()){
                                    tfAtt3.setText("50");
                                }
                                tfAtt4.setDisable(true);
                                cbColor.setDisable(false);
                                Triangle triangle = new Triangle(Integer.parseInt(tfAtt1.getText()),
                                        Integer.parseInt(tfAtt2.getText()),
                                        Integer.parseInt(tfAtt3.getText()));
                                javafx.scene.shape.Polygon triangleFX = new javafx.scene.shape.Polygon(
                                        triangle.getVertices());
                                triangleFX.setFill(getColor(cbColor.getValue()));
                                shapeDetails.setText("This is a triangle with sides of " + triangle.getSide1() + ", "
                                         + triangle.getSide2() + ", and " + triangle.getSide3() + " with an area of " +
                                        (Math.round(triangle.getArea())*100.0)/100.0 );
                                displayArea.setContent(triangleFX);
                            }
                            default -> {
                                shapeDetails.setText("Please select a Shape.");
                            }
                        }
                    }
                }
        );
    }

    // Returns the correct Color class field for the combobox
    public Color getColor(String color) {
        switch (color) {
            case "White" -> {
                return Color.WHITE;
            }
            case "Purple" -> {
                return Color.PURPLE;
            }
            case "Blue" -> {
                return Color.BLUE;
            }
            case "Orange" -> {
                return Color.ORANGE;
            }
            case "Yellow" -> {
                return Color.YELLOW;
            }
            case "Green" -> {
                return Color.GREEN;
            }
            case "Red" -> {
                return Color.RED;
            }
            case "Brown" -> {
                return Color.BROWN;
            }
            default -> {
                return Color.BLACK;
            }
        }
    }
    // Text formatter that restricts text fields to digits only
    public TextFormatter<String> textFormat() {
        return new TextFormatter<>(change -> {

            String textBuffer = change.getControlNewText();

            if (textBuffer.length() > 5) {
                return null;
            }
            //Limits input to digits
            if (textBuffer.matches("[0-9]*")) {
                return change;
            } else {
                return null;
            }
        });
    }






    public static void main(String[] args) {
        launch(args);
    }
}

