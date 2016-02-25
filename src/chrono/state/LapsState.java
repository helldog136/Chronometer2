package chrono.state;


import chrono.ChronometerMain;

public class LapsState extends WaitingClockState {
    private static LapsState instance = null;

    public static LapsState instance() {
        if (instance == null) instance = new LapsState();
        return instance;
    }

    @Override
    public void startStop() {
        ChronometerMain.setCurrentState(RunningState.instance());
    }

    @Override
    public void laps() {
        ChronometerMain.setCurrentState(RunningState.instance());
    }

    @Override
    public String getDisplayString() {
        return Long.toString(ChronometerMain.getLapsTime() / 1000);
    }

    @Override
    public String getStateString() {
        return "Laps";
    }
}
