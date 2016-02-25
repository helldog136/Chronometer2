package StatePattern;

public final class ZeroState implements ClockState
{
    private static ZeroState instance = null;
    public static ZeroState Instance() {
        if(instance == null) instance = new ZeroState();
        return instance;
    }

    @Override
    public void left(ChronoContext context) {
        context.offset = System.currentTimeMillis();
        context.transition(RunningState.Instance());
    }

    @Override
    public void middle(ChronoContext context) {
        // Do nothing
    }

    @Override
    public void right(ChronoContext context) {
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
