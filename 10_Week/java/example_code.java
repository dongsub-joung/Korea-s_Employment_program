import javax.swing.*;

public class example_code extends JFrame {

//    CASE 1
//    Set absolut position, size when setLayout's value is null.
    example_code()
    {
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label= new JLabel("Press BTN!");

        int x= 130, y= 50; int width= 200, height= 20;
        label.setLocation(x, y);
        label.setSize(width, height);
        add(label);

//        Generate BTNs
        int btn_size= 9; int multiple_valuable= 15;
        for (int i = 0; i < btn_size; i++)
        {
            int w= 50, h= 20;
            int size= i * multiple_valuable;
            JButton btn= new JButton(Integer.toString(i));
            btn.setLocation(size, size);
            btn.setSize(w,h);
            add(btn);
        }

//        Component Setting
        int cp_h= 300, cp_w= 200;
        setSize(cp_h, cp_w);
        setVisible(true);
    }

    public static void main(String[] args) {
        new example_code();
    }
}
