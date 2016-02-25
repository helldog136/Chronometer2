package chrono;


import static java.lang.System.currentTimeMillis;

public class RunningState extends ClockState {
    private static RunningState instance = null;

    public static RunningState instance() {
        if (instance == null) instance = new RunningState();
        return instance;
    }

    @Override
    public void startStop() {
        context.setPauseTime(currentTimeMillis() - context.getOffset());
        ChronometerMain.setCurrentState(PauseState.instance());

    }

    @Override
    public void laps() {
        context.setLapsTime(currentTimeMillis() - context.getOffset());
        ChronometerMain.setCurrentState(LapsState.instance());
    }

    @Override
    public void reset() {
        context.setOffset(currentTimeMillis());
        ChronometerMain.setCurrentState(this);
    }

    @Override
    public String getDisplayString() {
        return new Long((currentTimeMillis() - context.getOffset()) / 1000).toString();
    }

    @Override
    public String getStateString() {
        return "Running";
    }
}
