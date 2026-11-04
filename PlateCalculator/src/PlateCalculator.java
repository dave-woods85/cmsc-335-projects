import javax.swing.*;
import java.util.Arrays;

public class PlateCalculator {

    // Create GUI window
    private static void showGUI(){
        JFrame frame = new JFrame("Plate Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Enter a Weight");
        frame.getContentPane().add(label);
        frame.setSize(500, 500);
        frame.pack();
        frame.setVisible(true);
    }
    // Add text-fields

    // Add plate graphics

    // Add workout dropdown

    // Add Calculate Button
 public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showGUI();
            }
        });
     // PlateHelper myWeight = new PlateHelper(245);
     // System.out.println(Arrays.toString(myWeight.getPlateBreakdown()));
 }


}
