import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a class that creates a circle object with radius and area.

 */
public class Circle extends TwoDimensionalShape{
    private double radius;

    // default circle
    Circle() {
        this.radius = 1;
    }
    //Specified radius
    Circle(double radius) {
        this.radius = radius;
    }
    // Circle setParameters takes an input for radius
    public static void setParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a radius for the circle: ");
        if (scanner.hasNextInt()) {
            Circle c = new Circle(scanner.nextInt());
            System.out.println("The radius is: " + c.getRadius() +
                    "\nThe area is: " + c.getArea());
        } else {
            System.out.println("Please enter a valid integer:");
            setParameters();
        }
        if (Project1.userContinue("circle")) {
            setParameters();
        } else {
            Project1.runMenu();
        }

    }

    @Override
    public double getArea(){
        //Formula for area of a circle PI * r^2
        return Math.PI * Math.pow(radius, 2);
    }

    // Getter and setter methods
    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }
}
