import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1
Square.java

This is a class that creates a square object with a side length and area.

 */
public class Square extends TwoDimensionalShape{
    private double side;

    //Default
    Square(){
        // default size
        this.side = 1;
    }
    //Specified sides
    Square(double side){
        this.side = side;
    }

    // Square setParameters() takes in a side
    public static void setParameters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a length for the sides of the square: ");
        if (scanner.hasNextInt()){ // check input
            Square s = new Square(scanner.nextInt());
            System.out.println("The sides are: " + s.getSide() + "\n" +
                    "The area is: " + s.getArea());
        }
        else { // invalid input
            System.out.println("Please enter a valid integer:");
            setParameters();
        }
        if (Project1.retry("square")){ // check for retry
            setParameters();
        }
        else { Project1.runMenu(); } // return to main menu


    }

    @Override
    public double getArea() {
        //Formula for area of a square side^2
        return side * side;
    }

    // Getter and setter methods
    public void setSide(int side){
        this.side = side;
    }

    public double getSide(){
        return this.side;
    }
}
