package Chronometer;


public class RunningState implements ClockState
{
    private static RunningState instance = null;
    public static RunningState instance() {
        if(instance == null) instance = new RunningState();
        return instance;
    }

    @Override
    public void startStop(ChronoContext context) {
        context.pauseTime = System.currentTimeMillis() - context.offset;
        context.transition(PauseState.instance());

    }

    @Override
    public void laps(ChronoContext context) {
        context.lapsTime = System.currentTimeMillis() - context.offset;
        context.transition(LapsState.instance());
    }

    @Override
    public void reset(ChronoContext context) {
        context.offset = System.currentTimeMillis();
        context.transition(this);
    }

    @Override
    public String getDisplayString(ChronoContext context) {
        return new Long((System.currentTimeMillis() - context.offset)/1000).toString();
    }

    @Override
    public String getStateString() {
        return "Running";
    }
}
