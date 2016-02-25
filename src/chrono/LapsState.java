package chrono;


public class LapsState extends ClockState {
    private static LapsState instance = null;

    public static LapsState instance() {
        if (instance == null) instance = new LapsState();
        return instance;
    }

    @Override
    public void startStop(ChronoContext context) {
        context.transition(RunningState.instance());
    }

    @Override
    public void laps(ChronoContext context) {
        context.transition(RunningState.instance());
    }

    @Override
    public void reset(ChronoContext context) {
        context.transition(ZeroState.instance());
    }

    @Override
    public String getDisplayString(ChronoContext context) {
        return new Long(context.getLapsTime() / 1000).toString();
    }

    @Override
    public String getStateString() {
        return "Laps";
    }
}
