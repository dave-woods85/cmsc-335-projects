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
    public static void main(String[] args){
        Square test_square = new Square(4);
        System.out.println(test_square.side);
        System.out.println(test_square.getArea());

        // Create a menu system and prompt for input
        System.out.println("Select from the menu below by inputting the corresponding number:\n" +
                "1. Construct a Circle\n" +
                "2. Construct a Rectangle\n" +
                "3. Construct a Square\n" +
                "4. Construct a Triangle\n" +
                "5. Construct a Sphere\n" +
                "6. Construct a Cube\n" +
                "7. Construct a Cone\n" +
                "8. Construct a Cylinder\n" +
                "9. Construct a Torus\n" +
                "10. Exit the Program");

        // Get input and interpret
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()){
            int choice = scanner.nextInt();
            switch (choice){
                case 1: Square.getParameters();
                case 2: ;
                case 3: ;
                case 4: ;
                case 5: ;
                case 6: ;
                case 7: ;
                case 8: ;
                case 9: ;
                case 10: ;
                default: break;
            }

        }
        else { System.out.println("Please enter a valid selection [1-10]:"); }

        // Interpret input and advance menu

    }

}
