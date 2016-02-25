package StatePattern;

public interface ClockState {
    void left(ChronoContext context); // button 1 pressed
    void middle(ChronoContext context); // button 2 pressed
    void right(ChronoContext context); // button 2 pressed
    String getDisplayString(ChronoContext context);
    String getStateString();
}
