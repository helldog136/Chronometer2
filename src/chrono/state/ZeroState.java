package chrono.state;

import chrono.ChronometerMain;

import static java.lang.System.currentTimeMillis;

public class ZeroState extends ClockState {
    private static ZeroState instance = null;

    public static ZeroState instance() {
        if (instance == null) instance = new ZeroState();
        return instance;
    }

    @Override
    public void startStop() {
        ChronometerMain.setOffset(currentTimeMillis());
        ChronometerMain.setCurrentState(RunningState.instance());
    }

    @Override
    public void laps() {
        // Do nothing
    }

    @Override
    public void reset() {
        // Do nothing
    }

    @Override
    public String getDisplayString() {
        return "0";
    }

    @Override
    public String getStateString() {
        return "Zero";
    }
}
