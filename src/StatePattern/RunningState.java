package StatePattern;


public class RunningState implements ClockState
{
    private static RunningState instance = null;
    public static RunningState Instance() {
        if(instance == null) instance = new RunningState();
        return instance;
    }

    @Override
    public void left(ChronoContext context) {
        context.pauseTime = System.currentTimeMillis() - context.offset;
        context.transition(PauseState.Instance());

    }

    @Override
    public void middle(ChronoContext context) {
        context.lapsTime = System.currentTimeMillis() - context.offset;
        context.transition(LapsState.Instance());
    }

    @Override
    public void right(ChronoContext context) {
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
