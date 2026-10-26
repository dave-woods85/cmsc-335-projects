import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a class that creates a torus object with a major radius, minor radius, and volume.

 */
public class Torus extends ThreeDimensionalShape{
    private double majorRadius;
    private double minorRadius;

    // Default
    Torus(){
        this.minorRadius = 1;
        this.majorRadius = 1;
    }

    // Specified radii
    Torus(double major, double minor){
        this.minorRadius = minor;
        this.majorRadius = major;
    }

    // Torus setParameters takes an input for both major and minor radii
    public static void setParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a major radius (size of the donut) for the torus: ");
        if (scanner.hasNextInt()) { // Check input
            int tempRadius = scanner.nextInt();
            System.out.println("Enter a minor radius (THICCness of the donut) for the torus: ");
            if (scanner.hasNextInt()) { // Check input
                Torus t = new Torus(tempRadius, scanner.nextInt());
                System.out.println("The major radius is: " + t.getMajorRadius() +
                        "\nThe minor radius is: " + t.getMinorRadius() +
                        "\nThe volume is: " + t.getVolume());
            } else { //Invalid input
                System.out.println("Please enter a valid integer:");
                setParameters();
            }
        } else { // Invalid input
            System.out.println("Please enter a valid integer:");
            setParameters();
        }
        if (Project1.retry("torus")) { //check for retry
            setParameters();
        } else { // Return to main menu
            Project1.runMenu();
        }

    }

    @Override
    public double getVolume(){
        //Formula for volume of a Torus 2PI^2 * R * r^2
        return (2 * Math.pow(Math.PI, 2)) * majorRadius * Math.pow(minorRadius, 2);
    }

    // Getter and setter methods
    public double getMajorRadius() {
        return majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
    }

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }
}
