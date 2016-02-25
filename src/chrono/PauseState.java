package chrono;

import static java.lang.System.currentTimeMillis;

public class PauseState extends WaitingClockState {
    private static PauseState instance = null;

    public static PauseState instance() {
        if (instance == null) instance = new PauseState();
        return instance;
    }

    @Override
    public void startStop() {
        context.setOffset(currentTimeMillis() - context.getPauseTime());
        ChronometerMain.setCurrentState(RunningState.instance());
    }

    @Override
    public void laps() {
        // Do nothing
    }

    @Override
    public String getDisplayString() {
        return new Long(context.getPauseTime() / 1000).toString();
    }

    @Override
    public String getStateString() {
        return "Pause";
    }
}
