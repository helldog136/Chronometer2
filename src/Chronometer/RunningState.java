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
        context.setPauseTime(System.currentTimeMillis() - context.getOffset());
        context.transition(PauseState.instance());

    }

    @Override
    public void laps(ChronoContext context) {
        context.setLapsTime(System.currentTimeMillis() - context.getOffset());
        context.transition(LapsState.instance());
    }

    @Override
    public void reset(ChronoContext context) {
        context.setOffset(System.currentTimeMillis());
        context.transition(this);
    }

    @Override
    public String getDisplayString(ChronoContext context) {
        return new Long((System.currentTimeMillis() - context.getOffset())/1000).toString();
    }

    @Override
    public String getStateString() {
        return "Running";
    }
}
