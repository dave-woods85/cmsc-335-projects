/*
David Woods
CMSC335
24 Oct 2026
Project 1
TwoDimensionalShape.java

This is a class for all 2-D shape objects in Project 1

 */
public class TwoDimensionalShape extends Shape{
    double area;

    TwoDimensionalShape(){
        this.setNumberOfDimensions(2);
    }

    //Getter and setter methods
    public double getArea(){
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
}
