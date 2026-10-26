import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a class that creates a sphere object with a radius and volume

 */
public class Sphere extends ThreeDimensionalShape{
    private double radius;
    // Default
    Sphere(){
        this.radius = 1;
    }

    // Specified radius
    Sphere(double radius){
        this.radius = radius;
    }

    // Sphere setParameters takes an input for radius
    public static void setParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a radius for the sphere: ");
        if (scanner.hasNextInt()) { //Check input
            Sphere s = new Sphere(scanner.nextInt());
            System.out.println("The radius is: " + s.getRadius() +
                    "\nThe volume is: " + s.getVolume());
        } else { // invalid input
            System.out.println("Please enter a valid integer:");
            setParameters();
        }
        if (Project1.retry("sphere")) { // Check for retry
            setParameters();
        } else { // Exit to main menu
            Project1.runMenu();
        }

    }

    @Override
    public double getVolume(){
        // Formula for volume of a sphere: 4/3(PI * r^3)
        return (4.0/3.0) * (Math.PI * (Math.pow(radius, 3)));
    }

    // Getter and setter methods
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
