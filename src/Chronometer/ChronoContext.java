package Chronometer;

import javax.swing.*;

class ChronoContext {

    private long offset;
    private long pauseTime;
    private long lapsTime;

    public ClockState getCurrentState() {
        return currentState;
    }

    private ClockState currentState;
    
    private JLabel display;
    // The method run() ensures that every second the value of display is modified with setText(...).
    // In this sense, ChronometerMain acts as some kind of Observer of ChronoContext.

    public ChronoContext(JLabel d) {
        currentState = ZeroState.instance();
        setOffset(System.currentTimeMillis());
        display = d;
    }
    
    public void run() {
  	  while (true) {
		  try { Thread.sleep(1000); }
	      catch (InterruptedException e) {
	          e.printStackTrace(); 
	      }
	      display.setText(this.currentState.getDisplayString(this));
	      }
    }

    public void transition(ClockState NextState) {
        currentState = NextState;
    }
    
    public String getDisplayText() { return currentState.getDisplayString(this); }
    
    public String getStateText() { return currentState.getStateString(); }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public long getPauseTime() {
        return pauseTime;
    }

    public void setPauseTime(long pauseTime) {
        this.pauseTime = pauseTime;
    }

    public long getLapsTime() {
        return lapsTime;
    }

    public void setLapsTime(long lapsTime) {
        this.lapsTime = lapsTime;
    }
}
