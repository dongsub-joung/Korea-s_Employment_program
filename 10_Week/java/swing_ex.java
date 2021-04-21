import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class swing_ex extends JFrame
{
    final int H= 300, W=300;

//    Example 01 Frame
//    swing_ex()
//    {
//        setTitle("Ex01");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        Container CP= getContentPane();
//        CP.setBackground(Color.BLUE);
//
//        CP.setLayout(new FlowLayout(0));
//        CP.add(new JButton("1"));
//        CP.add(new JButton("2"));
//        CP.add(new JButton("3"));
//
//        setSize(H,W);
//        setVisible(true);
//    }

//    Example 02 Frame
    swing_ex()
    {
        setTitle("Ex02");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container CP= getContentPane();
        CP.setLayout(new BorderLayout());
        CP.add(new JButton("1btn") ,BorderLayout.NORTH);
        CP.add(new JButton("2btn"), BorderLayout.EAST);
        CP.add(new JButton("3btn"), BorderLayout.WEST);
        CP.add(new JButton("4btn"), BorderLayout.SOUTH);
        CP.add(new JButton("5btn"), BorderLayout.CENTER);

        setSize(H,W);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new swing_ex();
    }

    //        Change ContentPane
//        JPanel p= new JPanel();
//        mf.setContentPane(p);
}
