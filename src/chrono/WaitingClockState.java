package chrono;

/**
 * Created by helldog136 on 25/02/16.
 */
public abstract class WaitingClockState extends ClockState {
    @Override
    public void reset() {
        ChronometerMain.setCurrentState(ZeroState.instance());
    }
}
