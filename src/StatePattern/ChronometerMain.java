package StatePattern;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChronometerMain implements ActionListener {
    
    private JButton b1, b2, b3;
    private JLabel myText1;
    private JLabel myText2;
    
    private ChronoContext myContext;

    public ChronometerMain() {
        Init();
    }
    
    // it is considered good programming practice that the actual
    // user interface code is not put in the class Constructor itself 
    private void Init() {
        b1 = new JButton("left");
        b1.addActionListener(this);
        b2 = new JButton("up");
        b2.addActionListener(this);
        b3 = new JButton("right");
        b3.addActionListener(this);
        myText1 = new JLabel();
        myText2 = new JLabel();

        myContext = new ChronoContext(myText1);
        myText1.setText(myContext.getDisplayText());
        myText2.setText(myContext.getStateText());
        

        JFrame myFrame = new JFrame("Chronometer");
        Container myContent = myFrame.getContentPane();
        // grid layout with 2 rows and 3 columns
        myContent.setLayout(new GridLayout(2,3));
        // filling first row of grid (3 columns) with text information
        myContent.add(myText1,0);
        myContent.add(myText2,1);
        myContent.add(new JLabel());    // Don't ask…
        // filling second row of grid (3 columns) with buttons
        myContent.add(b1);
        myContent.add(b2);
        myContent.add(b3);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myContext.run();
    }
    
    public void actionPerformed(ActionEvent e) {
        if((JButton)e.getSource()==b1) {
            myContext.buttonpushed(ButtonType.left);
        }
        else if((JButton)e.getSource()==b2){
            myContext.buttonpushed(ButtonType.up);
         }
        else if((JButton)e.getSource()==b3){
        	myContext.buttonpushed(ButtonType.right);
        }
        
        myText1.setText(myContext.getDisplayText());
        myText2.setText(myContext.getStateText());
    }
    
    public static void main(String[] args) {
        ChronometerMain myClock = new ChronometerMain();
    }
   
}
