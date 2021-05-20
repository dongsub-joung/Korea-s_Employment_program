import javax.swing.*;
import java.awt.*;

class Info{
    final static String TITLE= "txt";
    final static String[] MENUS= {"Next", "Previous", "First", "Last"};
    final static int W= 350, H= 250;
}

//    final int NEXT=0, PREVIOUS=1, FIRST=2, LAST=3;
class Panel_L extends JPanel{
    int MENUS_SIZE = Info.MENUS.length;
    public JButton[] buttons;
    {
        for (int i = 0; i < MENUS_SIZE; i++) {
            buttons = new JButton[MENUS_SIZE];
            buttons[i]= new JButton(Info.MENUS[i]);
            add(buttons[i]);
        }
    }
    public Panel_L(){
//        EventHandler
    }
}

class Panel_R extends JPanel{
    int MENUS_SIZE = Info.MENUS.length;
    public JPanel[] panels;

    {
        panels = new JPanel[MENUS_SIZE];
        for (int i = 0; i < MENUS_SIZE; i++) {
            panels[i] = new JPanel();
        }
    }
    public Panel_R(){
        final String DEFAULT_STR;
        int count;

        // Add Component at panel
        DEFAULT_STR= "Panel"; count= 1;
        for (JPanel panel: panels){
            String count_str= (count++) + "";
            panel.add(new JLabel(DEFAULT_STR + count_str));
        }
    }
}

public class java016 extends JFrame {
    Container container;
    JPanel panel_L= null;
    JPanel panel_R= null;

    java016(){
        container= getContentPane();
        JPanel panel_L= new Panel_L();
        JPanel panel_R= new Panel_R();
        panel_L.setLayout(new GridLayout(4,1));
        panel_R.setLayout(new CardLayout());

//        Setting Head
        setTitle(Info.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Info.W, Info.H);
        setVisible(true);

//        Setting Body
        container.add(panel_L);
        container.add(panel_R);
    }

    public static void main(String[] args) {
        new java016();
    }
}
