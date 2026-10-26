/*
David Woods
CMSC335
24 Oct 2026
Project 1

This is a class for all 3-D shape objects in Project 1

 */
public class ThreeDimensionalShape extends Shape{
    double volume;

    ThreeDimensionalShape(){
        this.setNumberOfDimensions(3);
    }

    //Getter and setter methods
    public double getVolume(){
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
