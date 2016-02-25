package chrono;

public abstract class ClockState {
    public abstract void startStop(ChronoContext context); // button 1 pressed
    public abstract void laps(ChronoContext context); // button 2 pressed
    public abstract void reset(ChronoContext context); // button 2 pressed
    public abstract String getDisplayString(ChronoContext context);
    public abstract String getStateString();
}
