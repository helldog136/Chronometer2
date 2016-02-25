package Chronometer;

public class PauseState implements ClockState
{
    private static PauseState instance = null;
    public static PauseState instance() {
        if(instance == null) instance = new PauseState();
        return instance;
    }

    @Override
    public void startStop(ChronoContext context) {
        context.offset = System.currentTimeMillis() - context.pauseTime;
        context.transition(RunningState.instance());
    }

    @Override
    public void laps(ChronoContext context) {
        // Do nothing
    }

    @Override
    public void reset(ChronoContext context) {
        context.transition(ZeroState.instance());
    }

    @Override
    public String getDisplayString(ChronoContext context) {
        return new Long(context.pauseTime/1000).toString();
    }

    @Override
    public String getStateString() {
        return "Pause";
    }
}
