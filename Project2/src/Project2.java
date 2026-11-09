import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.sql.Array;

public class Project2 extends Application{

    //Setup for GUI, buttons and events
    public void start(Stage primaryStage) {

        //Create a grid Pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setGridLinesVisible(true);


        // Create a TilePane for the shape buttons
        TitledPane shapeButtonPane = new TitledPane();
        shapeButtonPane.setText("Shape");
        shapeButtonPane.setCollapsible(false);
        TilePane shapeWindow = new TilePane();
        shapeWindow.setHgap(5);
        shapeWindow.setVgap(5);
        shapeWindow.setPadding(new Insets(10));
        shapeWindow.setPrefColumns(3);
        shapeWindow.setPrefSize(280, 200);
        shapeButtonPane.setMaxSize(290, 300);
        shapeButtonPane.setMinSize(290, 300);
        GridPane.setHgrow(shapeButtonPane, Priority.ALWAYS);
        GridPane.setVgrow(shapeButtonPane, Priority.ALWAYS);
        shapeButtonPane.setContent(shapeWindow);
        pane.add(shapeButtonPane, 0, 0);



        // Create Shape buttons

        ToggleButton circleButton = new ToggleButton("CIRCLE");
        ToggleButton coneButton = new ToggleButton("CONE");
        ToggleButton cubeButton = new ToggleButton("CUBE");
        ToggleButton cylinderButton = new ToggleButton("CYLINDER");
        ToggleButton squareButton = new ToggleButton("SQUARE");
        ToggleButton rectangleButton = new ToggleButton("RECTANGLE");
        ToggleButton sphereButton = new ToggleButton("SPHERE");
        ToggleButton triangleButton = new ToggleButton("TRIANGLE");
        ToggleButton torusButton = new ToggleButton("TORUS");
        ToggleButton[] toggleButtons = {circleButton, coneButton,cubeButton, cylinderButton, squareButton,
        rectangleButton, sphereButton, triangleButton, torusButton};

        // Group toggle buttons so only one button can be pressed at a time and resize them
        final ToggleGroup buttonGroup = new ToggleGroup();
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
        TilePane shapeOptions = new TilePane();
        shapeWindow.setHgap(5);
        shapeWindow.setVgap(5);
        shapeWindow.setPadding(new Insets(15));
        shapeWindow.setMaxSize(280, 200);
        shapeButtonPane.setMinSize(280, 200);
        pane.add(shapeOptionsPane, 0, 1);
        shapeOptionsPane.setContent(shapeOptions);


        // Create text fields for shape properties, dropdown for shape color, and button to apply the options
        TextField tfAtt1 = new TextField();
        TextField tfAtt2 = new TextField();
        TextField tfAtt3 = new TextField();
        TextField tfAtt4 = new TextField();
        Label att1 = new Label("Attribute 1");
        Label att2 = new Label("Attribute 2");
        Label att3 = new Label("Attribute 3");
        Label att4 = new Label("Attribute 4");
        shapeOptions.getChildren().addAll(att1, tfAtt1, att2, tfAtt2, att3, tfAtt3, att4, tfAtt4);
        ComboBox<Color> cbColor = new ComboBox<>();




        // Create a display window for the shape drawing
        TitledPane displayArea = new TitledPane();
        displayArea.setText("Display Area");
        displayArea.setCollapsible(false);
        displayArea.setMaxSize(200, 200);
        displayArea.setMinSize(200, 200);

        pane.getChildren().add(displayArea);
        GridPane.setColumnIndex(displayArea, 1);








        /*
        //Create Column constraints so the columns cannot be crushed
        ColumnConstraints column0 = new ColumnConstraints();
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        column0.setMinWidth(100);
        column1.setMinWidth(100);
        column2.setMinWidth(100);
        pane.getColumnConstraints().addAll(column0, column1, column2);
        */

        //Set a scene with the grid pane and vbox
        Scene scene = new Scene(pane);

        //Set up the window and display the scene
        primaryStage.setTitle("Shape Display");
        primaryStage.setMaxHeight(500);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(800);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

