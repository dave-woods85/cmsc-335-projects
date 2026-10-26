
/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is an interface for 3-D shape objects in Project 1

 */
public class ThreeDimensionalShape extends Shape{
    double volume = 0;

    ThreeDimensionalShape(){
        this.setNumberOfDimensions(3);
    }

    public double getVolume(){
        return volume;
    }
}
