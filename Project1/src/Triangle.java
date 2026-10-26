import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1
Triangle.java

This is a class that creates a triangle object with 3 sides and area. There is a special printout
for an equilateral triangle detected.

 */

public class Triangle extends TwoDimensionalShape{
    // fields for the sides
    private double side1;
    private double side2;
    private double side3;

    //Default
    Triangle() {
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }
    // Specified sides
    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Triangle setParameters takes 3 side values
    public static void setParameters() {
        Scanner scanner = new Scanner(System.in);
        // Prompt for measurement
        System.out.println("Enter the length of the first side: ");
        if (scanner.hasNextInt()) { // Check input
            int tempSide1 = scanner.nextInt();
            System.out.println("Enter the length of the second side: ");
            if (scanner.hasNextInt()) { // Check input
                int tempSide2 = scanner.nextInt();
                System.out.println("Enter the length of the third side: ");
                if (scanner.hasNextInt()) { // Check input
                    Triangle t = new Triangle(tempSide1, tempSide2, scanner.nextInt());
                    //Special printout if it's an equilateral
                    if (t.getSide1() == t.getSide2() && t.getSide1() == t.getSide3()){
                        System.out.println("This is an equilateral triangle!" +
                                "\nAll sides are: " + t.getSide1() +
                                "\nArea: " + t.getArea());
                    }
                    else { // Not equilateral
                        System.out.println("Side 1: " + t.getSide1() +
                                "\nSide 2: " + t.getSide2() +
                                "\nSide 3: " + t.getSide3() +
                                "\nArea: " + t.getArea());
                    }

                } else { // Rerun setParameters on invalid input
                    System.out.println("Please enter a valid integer:");
                    setParameters();
                }
            } else { // Rerun setParameters on invalid input
                System.out.println("Please enter a valid integer:");
                setParameters();
            }
        } else { // Rerun setParameters on invalid input
            System.out.println("Please enter a valid integer:");
            setParameters();
        }
        // Check for retry
        if (Project1.retry("triangle")) {
            setParameters();
        } else { // Return to main menu if no retry
            Project1.runMenu();
        }
    }

    @Override
    public double getArea(){
        // Formula for area of a triangle A = SQRT of s(s - a)(s - b)(s - c)
        // s = semiPerimeter (a + b + c) / 2
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) *
                s - side3);
    }

    // Getter and setter methods
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

}

