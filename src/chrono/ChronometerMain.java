package chrono;

import javax.swing.*;
import java.awt.*;

public class ChronometerMain {

    private JButton startStopButton, lapsButton, resetButton;
    private JLabel timeLabel;
    private JLabel stateLabel;
    
    private ChronoContext myContext;

    public ChronometerMain() {
        init();
    }
    
    // it is considered good programming practice that the actual
    // user interface code is not put in the class Constructor itself 
    private void init() {
        startStopButton = new JButton("start/stop");
        startStopButton.addActionListener(e -> {
            myContext.getCurrentState().startStop(myContext);
            updateUIText();
        });
        lapsButton = new JButton("laps");
        lapsButton.addActionListener(e -> {
            myContext.getCurrentState().laps(myContext);
            updateUIText();
        });
        resetButton = new JButton("reset");
        resetButton.addActionListener(e -> {
            myContext.getCurrentState().reset(myContext);
            updateUIText();
        });
        timeLabel = new JLabel();
        stateLabel = new JLabel();

        myContext = new ChronoContext(timeLabel);
        updateUIText();
        

        JFrame myFrame = new JFrame("chrono");
        Container myContent = myFrame.getContentPane();
        // grid layout with 2 rows and 3 columns
        myContent.setLayout(new GridLayout(2,3));
        // filling first row of grid (3 columns) with text information
        myContent.add(timeLabel,0);
        myContent.add(stateLabel,1);
        myContent.add(new JLabel());    // Don't ask…
        // filling second row of grid (3 columns) with buttons
        myContent.add(startStopButton);
        myContent.add(lapsButton);
        myContent.add(resetButton);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myContext.run();
    }

    private void updateUIText() {
        timeLabel.setText(myContext.getDisplayText());
        stateLabel.setText(myContext.getStateText());
    }

    public static void main(String[] args) {
        ChronometerMain myClock = new ChronometerMain();
    }

}
