import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a class that creates a cylinder object with a radius, height, and volume

 */
public class Cylinder extends ThreeDimensionalShape{
    private double radius;
    private double height;

    // Default
    Cylinder(){
        this.radius = 1;
        this.height = 1;
    }
    // Specified radius and height
    Cylinder(double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    // Cylinder setParameters takes an input for radius and height
    public static void setParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a radius for the cylinder: ");
        if (scanner.hasNextInt()) { // Check input
            int tempRadius = scanner.nextInt();
            System.out.println("Enter a height for the cylinder: ");
            if (scanner.hasNextInt()) { // Check input
                Cylinder c = new Cylinder(tempRadius, scanner.nextInt());
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
        if (Project1.userContinue("cylinder")) { //check for retry
            setParameters();
        } else { // Return to main menu
            Project1.runMenu();
        }

    }

    @Override
    public double getVolume(){
        //Formula for volume of a Cylinder PI * r^2 * height
        return (Math.PI * height * Math.pow(radius, 2));
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
