package chrono.state;

public abstract class ClockState {
    public abstract void startStop(); // button 1 pressed
    public abstract void laps(); // button 2 pressed
    public abstract void reset(); // button 2 pressed
    public abstract String getDisplayString();
    public abstract String getStateString();
}
