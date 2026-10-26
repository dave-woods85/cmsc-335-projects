import java.util.Scanner;

/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a class that creates a cube object with a side length and volume.

 */
public class Cube extends ThreeDimensionalShape{
    private double side;

    //Default
    Cube(){
        this.side = 1;
    }

    // Specified side length
    Cube(double side){
        this.side = side;
    }
    // Cube setParameters takes 1 side length
    public static void setParameters(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a length for the sides of the cube: ");
        if (scanner.hasNextInt()){
            Cube c = new Cube(scanner.nextInt());
            System.out.println("The sides are: " + c.getSide() + "\n" +
                    "The volume is: " + c.getVolume());
        }
        else {
            System.out.println("Please enter a valid integer:");
            setParameters();}
        if (Project1.retry("cube")){
            setParameters();
        }
        else { Project1.runMenu(); }
    }

    @Override
    public double getVolume(){
        // Formula for volume of a cube side^3
        return Math.pow(side, 3);
    }
    // Getter and setter methods
    public void setSide(double side){
        this.side = side;
    }

    public double getSide(){
        return this.side;
    }
}
