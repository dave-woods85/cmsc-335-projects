import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a class that creates a square object with a side length and area.

 */
public class Square extends TwoDimensionalShape{
    double side = 0;
    Square(){
        // default size
        this.side = 1;
    }

    Square(double side){
        this.side = side;
    }

    public static void getParameters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a length for the sides of the square: ");
        if (scanner.hasNextInt()){
            Square s = new Square(scanner.nextInt());
            System.out.println("The sides are: " + s.side + "\n" +
                    "The area is: " + s.getArea());

        }
        else { System.out.println("Please enter a valid integer"); }
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
