package Chronometer;

public final class ZeroState implements ClockState
{
    private static ZeroState instance = null;
    public static ZeroState instance() {
        if(instance == null) instance = new ZeroState();
        return instance;
    }

    @Override
    public void startStop(ChronoContext context) {
        context.offset = System.currentTimeMillis();
        context.transition(RunningState.instance());
    }

    @Override
    public void laps(ChronoContext context) {
        // Do nothing
    }

    @Override
    public void reset(ChronoContext context) {
        // Do nothing
    }

    @Override
    public String getDisplayString(ChronoContext context) {
        return "0";
    }

    @Override
    public String getStateString() {
        return "Zero";
    }
}
