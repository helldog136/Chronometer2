package chrono.state;

import chrono.ChronometerMain;

import static java.lang.System.currentTimeMillis;

public class PauseState extends WaitingClockState {
    private static PauseState instance = null;

    public static PauseState instance() {
        if (instance == null) instance = new PauseState();
        return instance;
    }

    @Override
    public void startStop() {
        ChronometerMain.setOffset(currentTimeMillis() - ChronometerMain.getPauseTime());
        ChronometerMain.setCurrentState(RunningState.instance());
    }

    @Override
    public void laps() {
        // Do nothing
    }

    @Override
    public String getDisplayString() {
        return Long.toString(ChronometerMain.getPauseTime() / 1000);
    }

    @Override
    public String getStateString() {
        return "Pause";
    }
}
