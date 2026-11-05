import javax.swing.*;
import java.awt.*;

public class PlateCalculator {

    // Create GUI window
    private static void showGUI(){
        // Create main frame window
        JFrame frame = new JFrame("Plate Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(550, 400));
        frame.setResizable(false);

        // Create a split panel in the fram with another split panel for 3 sections
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        JPanel midPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JSplitPane mainPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, midPanel);
        JSplitPane main2Panel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainPanel, bottomPanel);


        // Create text area for title and instructions
        JTextArea intro = new JTextArea("""
                Welcome to the Plate Calculator, a gym bro's best friend!
                        Please enter a weight to put on the barbell.
                Remember:
                1. The bar weighs 45lbs, so enter a weight >= 45.
                2. Weight must be in multiples of 5.
                """);
        intro.setLineWrap(true);
        intro.setBackground(Color.DARK_GRAY);
        intro.setFont(new Font("SanSerif", Font.BOLD, 16));
        intro.setForeground(new Color(74, 255, 0));
        intro.setSize(new Dimension(500, 500));
        intro.setEditable(false);

        // Create text area for results
        JTextArea results = new JTextArea("Results will appear here!");
        bottomPanel.add(results);
        results.setForeground(new Color(74, 255, 0));
        results.setLineWrap(true);
        results.setBackground(Color.DARK_GRAY);
        results.setFont(new Font("SanSerif", Font.BOLD, 16));
        results.setSize(new Dimension(500, 500));
        results.setEditable(false);


        JTextField enterWeight = new JTextField("0");
        enterWeight.setColumns(5);

        // Add a calculate button
        JButton calculate = new JButton("Calculate!");
        midPanel.add(calculate);
        calculate.addActionListener(e -> {
            // Check for integer input
            if (enterWeight.getText().matches("[0-9]*")){
                PlateHelper phelp = new PlateHelper(Integer.parseInt(enterWeight.getText()));
                int[] pList = phelp.getPlateBreakdown();
                if (pList[0] == -1){ // Get correct input from 0 index of returned list
                    results.setText("Please enter a weight that is a multiple of 5 " +
                            "and greater than 45lbs.");
                }
                else{ // Display the plate breakdown in the results area
                    results.setText("""
                            For %s lbs. you will need to
                            put these plates on the bar:
                            45lb Plate: %d
                            25lb Plate: %d
                            10lb Plate: %d
                            5lb Plate: %d
                            2.5lb Plate: %d
                            """.formatted(enterWeight.getText(), pList[0], pList[1], pList[2], pList[3], pList[4]));
                }

            }
            else { // Catch all for improper input
                results.setText("Please enter a positive integer.");
            }
        });

        // Adding parts to the frame
        midPanel.add(enterWeight);
        frame.add(main2Panel);
        topPanel.add(intro);

        // prepping the frame
        frame.pack();
        frame.setVisible(true);
    }

    // Main method to launch app
 public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showGUI();
            }
        });
 }


}
