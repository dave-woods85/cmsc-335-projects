import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1
Cone.java

This is a class that creates a cone object with a radius, height, and volume

 */
public class Cone extends  ThreeDimensionalShape{
    private double radius;
    private double height;

    // Default
    Cone(){
        this.radius = 1;
        this.height = 1;
    }
    // Specified radius and height
    Cone(double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    // Cone setParameters takes an input for radius and height
    public static void setParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a radius for the cone: ");
        if (scanner.hasNextInt()) { // Check input
            int tempRadius = scanner.nextInt();
            System.out.println("Enter a height for the cone: ");
            if (scanner.hasNextInt()) { // Check input
                Cone c = new Cone(tempRadius, scanner.nextInt());
                System.out.println("The radius is: " + c.getRadius() +
                        "\nThe height is: " + c.getHeight() +
                        "\nThe volume is: " + c.getVolume());
            } else { //Invalid input
                System.out.println("Please enter a valid integer:");
                setParameters();
            }
        } else { // Invalid input
            System.out.println("Please enter a valid integer:");
            setParameters();
        }
        if (Project1.retry("cone")) { //check for retry
            setParameters();
        } else { // Return to main menu
            Project1.runMenu();
        }

    }

    @Override
    public double getVolume(){
        //Formula for volume of a Cone (1/3)(PI * r^2 * height)
        return (1.0/3.0) * (Math.PI * height * Math.pow(radius, 2));
    }

    // Getter and setter methods
    public double getRadius(){
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
