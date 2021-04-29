import javax.swing.*;
import java.awt.*;

class DATA
{
    public final static int W= 400, H= 300;
    public final static int SIZE= 100;
    public final static String TITLE= "Calculator";
    public final int ROW= 4, COLUMN= 4;
    public final int V_GAP= 0, H_GAP= 0;
}

public class Calculator_Swing extends JFrame
{
    Container CP;
    DATA D;
    Calculator_Swing()
    {
        setTitle(D.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CP= getContentPane();
        CP.setLayout(new GridLayout(D.ROW, D.COLUMN, D.V_GAP, D.H_GAP));

//        Component
        JTextField jTextField= new JTextField(D.SIZE);
        jTextField.setEditable(false);
        CP.add(jTextField);

        setSize(D.W, D.H);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator_Swing();
    }
}