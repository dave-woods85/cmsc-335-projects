
/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is an interface for all 2-D shape objects in Project 1

 */
public class TwoDimensionalShape extends Shape{
    double area = 0;

    TwoDimensionalShape(){
        this.setNumberOfDimensions(2);
    }

    public double getArea(){
        return area;
    }

}
