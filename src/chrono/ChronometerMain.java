package chrono;

import javax.swing.*;
import java.awt.*;

public class ChronometerMain {

    static long offset;
    static long pauseTime;
    static long lapsTime;
    private static ClockState currentState;
    private JButton startStopButton, lapsButton, resetButton;
    private static JLabel timeLabel;
    private static JLabel stateLabel;


    public ChronometerMain() {
        init();
    }

    public static void run() {
  	  while (true) {
		  try { Thread.sleep(1000); }
	      catch (InterruptedException e) {
	          e.printStackTrace();
	      }
	      timeLabel.setText(getCurrentState().getDisplayString());
	      }
    }

    public static ClockState getCurrentState() {
        return currentState;
    }

    public static void setCurrentState(ClockState currentState) {
        ChronometerMain.currentState = currentState;
    }

    public static void setOffset(long offset) {
        ChronometerMain.offset = offset;
    }

    static void initChrono() {
        setCurrentState(ZeroState.instance());
        setOffset(System.currentTimeMillis());
    }

    // it is considered good programming practice that the actual
    // user interface code is not put in the class Constructor itself 
    private void init() {
        startStopButton = new JButton("start/stop");
        startStopButton.addActionListener(e -> {
            getCurrentState().startStop();
            updateUIText();
        });
        lapsButton = new JButton("laps");
        lapsButton.addActionListener(e -> {
            getCurrentState().laps();
            updateUIText();
        });
        resetButton = new JButton("reset");
        resetButton.addActionListener(e -> {
            getCurrentState().reset();
            updateUIText();
        });
        timeLabel = new JLabel();
        stateLabel = new JLabel();

        initChrono();
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
        run();
    }

    private void updateUIText() {
        timeLabel.setText(getCurrentState().getDisplayString());
        stateLabel.setText(getCurrentState().getStateString());
    }

    public static void main(String[] args) {
        ChronometerMain myClock = new ChronometerMain();
    }

}
