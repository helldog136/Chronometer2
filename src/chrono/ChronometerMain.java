package chrono;

import chrono.state.ClockState;
import chrono.state.ZeroState;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChronometerMain {

    private static long offset;

    public static void setLapsTime(long lapsTime) {
        ChronometerMain.lapsTime = lapsTime;
    }

    private static long pauseTime;
    private static long lapsTime;
    private static ClockState currentState;
    private static final ArrayList<ChronoListener> chronoListeners = new ArrayList<>();
    private JButton startStopButton, lapsButton, resetButton;

    public static JLabel getTimeLabel() {
        return timeLabel;
    }

    public static JLabel getStateLabel() {
        return stateLabel;
    }

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
            notifyListeners();
        }
    }

    private static void notifyListeners() {
        for (ChronoListener chronoListener : chronoListeners) {
            chronoListener.refreshTime();
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

    public static long getLapsTime() {
        return lapsTime;
    }

    public static long getPauseTime() {
        return pauseTime;
    }
    public static void setPauseTime(long pauseTime) {
        ChronometerMain.pauseTime = pauseTime;
    }

    public static long getOffset() {
        return offset;
    }

    // it is considered good programming practice that the actual
    // user interface code is not put in the class Constructor itself 
    private void init() {
        chronoListeners.add(new ConsoleDisplayer());
        chronoListeners.add(new GUIDisplayer());

        startStopButton = new JButton("start/stop");
        startStopButton.addActionListener(e -> {
            getCurrentState().startStop();
            notifyListeners();
        });
        lapsButton = new JButton("laps");
        lapsButton.addActionListener(e -> {
            getCurrentState().laps();
            notifyListeners();
        });
        resetButton = new JButton("reset");
        resetButton.addActionListener(e -> {
            getCurrentState().reset();
            notifyListeners();
        });
        timeLabel = new JLabel();
        stateLabel = new JLabel();

        initChrono();
        notifyListeners();
        

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

    public static void main(String[] args) {
        ChronometerMain myClock = new ChronometerMain();
    }

}
