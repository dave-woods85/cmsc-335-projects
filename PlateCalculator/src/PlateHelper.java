public class PlateHelper {
    // fields for plate types
    private int numOf2_5s, numOf5s, numOf10s, numOf25s, numOf35s, numOf45s, totalWeight;
    // Array of plate types [45s, 25s, 10s, 5s, 2.5s]
    int[] plateBreakdown;


    // Create Plate helper object
    public PlateHelper (int weight){
        totalWeight = weight;
        plateBreakdown = howManyPlates(totalWeight);
        numOf45s = plateBreakdown[0];
        numOf25s = plateBreakdown[1];
        numOf10s = plateBreakdown[2];
        numOf5s = plateBreakdown[3];
        numOf2_5s = plateBreakdown[4];

    }

    private int[] howManyPlates(int weight){
        int [] plateList = {0, 0, 0, 0, 0};
        // remove bar weight
        weight -= 45;
        if (weight < 0) {
            plateList[0] = -1;
            return plateList;
        }
        // Calculate how many 45s
        if((weight / 45) % 2 == 1){
            plateList[0] = (weight / 45) - 1;
            weight -=  plateList[0] * 45;
        }
        else {
            plateList[0] = weight /45;
            weight -=  plateList[0] * 45;
        }

        // Calculate how many 25s
        if((weight / 25) % 2 == 1){
            plateList[1] = (weight / 25) - 1;
            weight -=  plateList[1] * 25;
        }
        else{
            plateList[1] = weight /25;
            weight -=  plateList[1] * 25;
        }
        // Calculate how many 10s
        if((weight / 10) % 2 == 1){
            plateList[2] = (weight / 10) - 1;
            weight -=  plateList[2] * 10;
        }
        else{
            plateList[2] = weight / 10;
            weight -=  plateList[2] * 10;
        }


        // Calculate how many 5s
        if((weight / 5) % 2 == 1){
            plateList[3] = (weight / 5) - 1;
            weight -=  plateList[3] * 5;
        }
        else{
            plateList[3] = weight /5;
            weight -=  plateList[3] * 5;
        }

        // Calculate how many 2.5s
        if((int)(weight / 2.5) % 2.0 == 1){
            plateList[4] = (int) (weight / 2.5) - 1;
            weight -=  plateList[4] * 2.5;
        }
        else{
            plateList[4] = (int) (weight / 2.5);
            weight -=  plateList[4] * 2.5;
        }
        if (weight != 0){ // Catch not divisible by 5 weight
            plateList[0] = -1;
        }

        // Return plate type/quantities
        return plateList;
    }


    // Getters/Setters
    public int getNumOf2_5s() {
        return numOf2_5s;
    }

    public void setNumOf2_5s(int numOf2_5s) {
        this.numOf2_5s = numOf2_5s;
    }

    public int getNumOf5s() {
        return numOf5s;
    }

    public void setNumOf5s(int numOf5s) {
        this.numOf5s = numOf5s;
    }

    public int getNumOf10s() {
        return numOf10s;
    }

    public void setNumOf10s(int numOf10s) {
        this.numOf10s = numOf10s;
    }

    public int getNumOf25s() {
        return numOf25s;
    }

    public void setNumOf25s(int numOf25s) {
        this.numOf25s = numOf25s;
    }

    public int getNumOf35s() {
        return numOf35s;
    }

    public void setNumOf35s(int numOf35s) {
        this.numOf35s = numOf35s;
    }

    public int getNumOf45s() {
        return numOf45s;
    }

    public void setNumOf45s(int numOf45s) {
        this.numOf45s = numOf45s;
    }

    public int[] getPlateBreakdown(){
        return plateBreakdown;
    }
}
