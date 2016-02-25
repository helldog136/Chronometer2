package chrono.state;


import chrono.ChronometerMain;

import static java.lang.System.currentTimeMillis;

public class RunningState extends ClockState {
    private static RunningState instance = null;

    public static RunningState instance() {
        if (instance == null) instance = new RunningState();
        return instance;
    }

    @Override
    public void startStop() {
        ChronometerMain.setPauseTime(currentTimeMillis() - ChronometerMain.getOffset());
        ChronometerMain.setCurrentState(PauseState.instance());

    }

    @Override
    public void laps() {
        ChronometerMain.setLapsTime(currentTimeMillis() - ChronometerMain.getOffset());
        ChronometerMain.setCurrentState(LapsState.instance());
    }

    @Override
    public void reset() {
        ChronometerMain.setOffset(currentTimeMillis());
        ChronometerMain.setCurrentState(this);
    }

    @Override
    public String getDisplayString() {
        return Long.toString((currentTimeMillis() - ChronometerMain.getOffset()) / 1000);
    }

    @Override
    public String getStateString() {
        return "Running";
    }
}
