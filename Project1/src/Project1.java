import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a shape constructing program that allows a users to choose a shape to create,
input parameters for that shape, and find the area (2D) or volume (3D).

 */
public class Project1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){    // Create a menu system and prompt for input
        System.out.println("""
                Select from the menu below by inputting the corresponding number:
                1. Construct a Square       6. Construct a Cube
                2. Construct a Rectangle    7. Construct a Cone
                3. Construct a Circle       8. Construct a Cylinder
                4. Construct a Triangle     9. Construct a Torus
                5. Construct a Sphere       10. Exit the Program
                """);

        // Get input and interpret
        if (scanner.hasNextInt()){
            int choice = scanner.nextInt();
            switch (choice){
                case 1: Square.setParameters();
                case 2: Rectangle.setParameters();
                case 3: Circle.setParameters();
                case 4: Triangle.setParameters();
                case 5: ;
                case 6: ;
                case 7: ;
                case 8: ;
                case 9: ;
                case 10: {
                    System.out.println("Thank you for using the Shape Maker!");
                    System.exit(1);
                }
                default: break;
            }

        }
        else {
            System.out.println("Please enter a valid selection [1-10]:");
            runMenu();
        }

        // Interpret input and advance menu

    }
    public static boolean userContinue(){
        System.out.println("Do you want to make another?: [Y or N]");
        if (scanner.hasNext()){
            String choice = scanner.next();
            if (choice.matches("[Yy]")){
                return true;
            }
            else if (choice.matches("[Nn]")) {
                return false;
            }
            else {
                System.out.println("Please enter Y or N:");
                return userContinue();
            }
        }
        else {
            System.out.println("Please enter Y or N:");
            return userContinue();
        }

    }
}
