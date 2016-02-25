package chrono;


import static java.lang.System.currentTimeMillis;

public class RunningState extends ClockState {
    private static RunningState instance = null;

    public static RunningState instance() {
        if (instance == null) instance = new RunningState();
        return instance;
    }

    @Override
    public void startStop(ChronoContext context) {
        context.setPauseTime(currentTimeMillis() - context.getOffset());
        context.transition(PauseState.instance());

    }

    @Override
    public void laps(ChronoContext context) {
        context.setLapsTime(currentTimeMillis() - context.getOffset());
        context.transition(LapsState.instance());
    }

    @Override
    public void reset(ChronoContext context) {
        context.setOffset(currentTimeMillis());
        context.transition(this);
    }

    @Override
    public String getDisplayString(ChronoContext context) {
        return new Long((currentTimeMillis() - context.getOffset()) / 1000).toString();
    }

    @Override
    public String getStateString() {
        return "Running";
    }
}
