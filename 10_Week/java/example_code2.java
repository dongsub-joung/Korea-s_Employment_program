import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//    CASE 2
//    Check Swing component's common method Example


public class example_code2 extends JFrame
{
    Container contentPane;
    JLabel la;
    JButton b1, b2, b3, b4;
    final int H= 250, W=200;

    class MyButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Object source= e.getSource();
            if (source == b1) {
                System.out.println("btn's Position and Size");
                positionAndSize(b1);

                JPanel c= (JPanel) b2.getParent();  // Gets the parent of this component.
                System.out.println("contentPan's Position and Size");
                positionAndSize(c);
            }
            else {
                if (b1.isVisible()) {
                    off(b1, b2, b3);
                } else {
                    on(b1, b2, b3);
                }
            }
        }
        private void positionAndSize(JComponent obj)
        {
            System.out.printf("Position= ( %d , %d )\n", obj.getX(), obj.getY());
            System.out.printf("Size= ( %d * %d )\n", obj.getWidth(), obj.getHeight());
        }
        private void off(JButton ...btn)
        {
            for (int i = 0; i < btn.length; i++) { btn[i].setVisible(false); }
        }
        private void on(JButton ...btn)
        {
            for (int i = 0; i < btn.length; i++) { btn[i].setVisible(true); }
        }
    }

    example_code2()
    {
        setTitle("Title");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane= getContentPane();
        contentPane.setLayout(new FlowLayout());    // Select FlowLayout

        b1= new JButton("Position && Size information");
        b1.addActionListener(new MyButtonListener());
        contentPane.add(b1);

        b2= new JButton("Form information");
        b2.setOpaque(true); // If true the component paints every pixel within its bounds
        b2.setForeground(Color.MAGENTA);
        b2.setBackground(Color.YELLOW);
        b2.setFont(new Font("고딕체", Font.ITALIC, 20));
        b2.addActionListener(new MyButtonListener());
        contentPane.add(b2);

        b3= new JButton("DONT work btn");
        b3.setEnabled(false);
        b3.addActionListener(new MyButtonListener());
        contentPane.add(b3);

        b4= new JButton("Hidden / Appear");
        b4.addActionListener(new MyButtonListener());
        contentPane.add(b4);

        setSize(W, H);
        setVisible(true);
    }

    public static void main(String[] args) {
        new example_code2();
    }
}


