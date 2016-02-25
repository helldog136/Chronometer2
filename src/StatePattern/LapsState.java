package StatePattern;


public class LapsState implements ClockState
{
    private static LapsState instance = null;
    public static LapsState Instance() {
        if(instance == null) instance = new LapsState();
        return instance;
    }

    @Override
    public void left(ChronoContext context) {
        context.transition(RunningState.Instance());
    }

    @Override
    public void middle(ChronoContext context) {
        context.transition(RunningState.Instance());
    }

    @Override
    public void right(ChronoContext context) {
        context.transition(ZeroState.Instance());
    }

    @Override
    public String getDisplayString(ChronoContext context) {
        return new Long(context.lapsTime / 1000).toString();
    }

    @Override
    public String getStateString() {
        return "Laps";
    }
}
