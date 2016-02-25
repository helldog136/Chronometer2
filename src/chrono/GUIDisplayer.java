package chrono;

public class GUIDisplayer implements ChronoListener {
    public GUIDisplayer() {
    }

    public void refreshTime() {
        ChronometerMain.getTimeLabel().setText(ChronometerMain.getCurrentState().getDisplayString());
        ChronometerMain.getStateLabel().setText(ChronometerMain.getCurrentState().getStateString());
    }
}