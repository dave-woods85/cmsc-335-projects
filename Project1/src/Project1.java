import java.time.LocalDateTime;
import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1
Project1.java

This is a shape constructing program that allows a users to choose a shape to create,
input parameters for that shape, and find the area (2D) or volume (3D).

 */
public class Project1 {
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){    // Create a menu system and prompt for input
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Select from the menu below by inputting the corresponding number:
                1. Construct a Square       6. Construct a Cube
                2. Construct a Rectangle    7. Construct a Cone
                3. Construct a Circle       8. Construct a Cylinder
                4. Construct a Triangle     9. Construct a Torus
                5. Construct a Sphere       10. Exit the Program
                """);

        // Get input and interpret
        if (scanner.hasNextInt()){ // Check input
            int choice = scanner.nextInt();
            switch (choice){ // Menu options
                case 1: Square.setParameters();
                case 2: Rectangle.setParameters();
                case 3: Circle.setParameters();
                case 4: Triangle.setParameters();
                case 5: Sphere.setParameters();
                case 6: Cube.setParameters();
                case 7: Cone.setParameters();
                case 8: Cylinder.setParameters();
                case 9: Torus.setParameters();
                case 10: {
                    LocalDateTime today = LocalDateTime.now();
                    System.out.println("Thank you for using the Shape Maker!" +
                            "\nToday is " + today.getDayOfWeek() + ", " +
                            today.getMonth() + " " + today.getDayOfMonth() +
                            " and the time is " + today.getHour() + ":" +
                            today.getMinute());
                    System.exit(1);
                }
                default: break;
            }

        }
        else { // Invalid input
            System.out.println("Please enter a valid selection [1-10]:");
            runMenu();
        }

    }
    // retry() asks the user if they want to make another of the same shape, or go back to menu
    public static boolean retry(String shape){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to make another " +
                shape + "?: [Y or N]");
        if (scanner.hasNext()){ // check input
            String choice = scanner.next();
            if (choice.matches("[Yy]")){ // regex for Y or y
                return true;
            }
            else if (choice.matches("[Nn]")) { // regex for N or n
                return false;
            }
            else { // Invalid input
                System.out.println("Please enter Y or N:");
                return retry(shape);
            }
        }
        else { // invalid input
            System.out.println("Please enter Y or N:");
            return retry(shape);
        }

    }
}
