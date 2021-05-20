import javax.swing.*;
import java.awt.*;

class Info{
    final static String TITLE= "txt";
    final static String[] MENUS= {"Next", "Previous", "First", "Last"};
    final static int W= 350, H= 250;
}

public class java016 extends JFrame {
    Container container;
    CardLayout cardLayout;
    GridLayout gridLayout;

//    final int NEXT=0, PREVIOUS=1, FIRST=2, LAST=3;
    final int MENUS_SIZE= Info.MENUS.length;
    JPanel[] panels= new JPanel[MENUS_SIZE];
    JButton[] buttons= new JButton[MENUS_SIZE];
    JLabel[] labels= new JLabel[MENUS_SIZE];

    java016(){
        container= getContentPane();
        cardLayout= new CardLayout();
        gridLayout= new GridLayout(4,1);

//        Setting Head
        setTitle(Info.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Info.W, Info.H);
        setVisible(true);

//        Setting Body
        //    Create Components
        for (int i = 0; i < MENUS_SIZE; i++) {
            buttons[i]= new JButton(Info.MENUS[i]);
            panels[i]= new JPanel();
            labels[i]= new JLabel(Info.MENUS[i]);
        }
        for (JButton button:buttons){
            add(button); // container
        }

        //    Add Component at panel
        final String DEFAULT_STR= "Panel"; int count= 1;
        for (JPanel panel:panels){
            String count_str= ((count++) +"");
            panel.add(new JLabel(DEFAULT_STR + count_str));
            container.add(panel);
        }
    }

    public static void main(String[] args) {
        new java016();
    }
}
