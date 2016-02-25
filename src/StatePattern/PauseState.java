package StatePattern;

public class PauseState implements ClockState
{
    private static PauseState instance = null;
    public static PauseState Instance() {
        if(instance == null) instance = new PauseState();
        return instance;
    }

    @Override
    public void left(ChronoContext context) {
        context.offset = System.currentTimeMillis() - context.pauseTime;
        context.transition(RunningState.Instance());
    }

    @Override
    public void middle(ChronoContext context) {
        // Do nothing
    }

    @Override
    public void right(ChronoContext context) {
        context.transition(ZeroState.Instance());
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
