package chrono;

/**
 * Created by helldog136 on 25/02/16.
 */
public class ConsoleDisplayer implements ChronoListener {
    private boolean tic = true;
    @Override
    public void refreshTime() {
        if(tic){
            System.out.println("TIC");
        }else{
            System.out.println("TOC");
        }
        tic = !tic;

        System.out.println(ChronometerMain.getCurrentState().getDisplayString());
    }
}
