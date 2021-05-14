import javax.swing.*;
import java.awt.*;

class Info{
    final static String TITLE= "txt";
    final static String[] MENUS= {"Next", "Previous", "First", "Last"};
}

public class java016 extends JFrame {
    Container container;
    JPanel jPanel;
    CardLayout cardLayout;
    JButton next, previous, first, last;

//    Create Components
    final int NEXT=0, PREVIOUS=1, FIRST=2, LAST=3;
    private void addBtns(JButton ...buttons){
        for (int i = 0; i < Info.MENUS.length; i++) {
            buttons[i]= new JButton(Info.MENUS[i]);
        }
    }

    java016(){
        container= getContentPane();
        jPanel= new JPanel();
        cardLayout= new CardLayout();

        setTitle(Info.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addBtns(next, previous, first, last);
    }

    public static void main(String[] args) {
        new java016();
    }
}
