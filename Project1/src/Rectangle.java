import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a class that creates a rectangle object with height, width, and area.

 */
public class Rectangle extends TwoDimensionalShape{
    private double width = 0;
    private double height = 0;

    Rectangle(){
        // default size
        this.height = 1;
        this.width = 1;
    }

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public static void setParameters(){
        Scanner scanner = new Scanner(System.in);
        // Prompt for measurement
        System.out.println("Enter the width of the rectangle: ");
        if (scanner.hasNextInt()){ // check for valid input
            int tempWidth = scanner.nextInt();
            System.out.println("Enter the height of the rectangle: ");
            if (scanner.hasNextInt()){ // check for valid input
                Rectangle r = new Rectangle(tempWidth, scanner.nextInt());
                // print the results
                System.out.println("The width is: " + r.getWidth() +
                        "\nThe height is: " + r.getHeight() +
                        "\nThe area is: " + r.getArea());
            }
            else {
                System.out.println("Please enter a valid integer:");
                setParameters();
            }
        }
        else {
            System.out.println("Please enter a valid integer:");
            setParameters();}
        if (Project1.userContinue()){
            setParameters();
        }
        else { Project1.runMenu(); }


    }

    @Override
    public double getArea() {
        return width * height;
    }

    // Getter and setter methods
    public void setWidth(double width){
        this.width = width;
    }

    public double getWidth(){
        return this.width;
    }
    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return this.height;
    }
}


