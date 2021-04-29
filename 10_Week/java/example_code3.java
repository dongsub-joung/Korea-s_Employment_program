import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Example GenJTextArea
public class example_code3 extends JFrame
{
    Container contentPane;
    final int W= 350, H= 300;
    final String TITLE= "title";

    example_code3()
    {
        setTitle(TITLE);    // 없어도 에러 안남.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane= getContentPane();
        contentPane.add(new MYCenterPanel(), BorderLayout.CENTER);
        setSize(W, H);
        setVisible(true);
    }

    class MYCenterPanel extends JPanel
    {
        JTextField tf;
        JButton btn;
        JTextArea ta;

        MYCenterPanel()
        {
            tf= new JTextField(20);
            btn= new JButton("ADD");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ta.append(tf.getText()+"\n");
                }
            });
            ta= new JTextArea("Hello", 7, 20);
            add(new JLabel("Please write something blow area, than click button."));
            add(tf); add(btn); add(new JScrollPane(ta));
        }
    }

    public static void main(String[] args) {
        new example_code3();
    }
}
