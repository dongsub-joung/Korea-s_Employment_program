package project2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator_Swing extends JFrame {

    Container CP = getContentPane();
    JTextField label = new JTextField("", SwingConstants.RIGHT);
    JPanel panel = new JPanel();
    TextArea TA = new TextArea(10, 10);

    HoleOption Opt;
    Logic logic = new Logic();
    static String view_value = "";

    /**
     * Event Method
     */
    private void evenHandlerNumber(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sum_str = label.getText() + btn.getText();
                label.setText(sum_str);
            }
        });
    }

    private void evenHandlerOperator(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current_val = label.getText();
                if (!(current_val.equals("")) || !(current_val.equals("0"))) {
                    logic.saveCurrentVal(current_val);
                    logic.saveOperateVal(btn.getText());
                    label.setText("");
                } else {
                    return;
                }
            }
        });
    }

    private void evenHandlerEqual(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!logic.checkOperatorIsNotNull() ) {
                    System.out.println(logic.duplicateCheck());
//                    if ()
//                    {
//                        logic.saveCurrentVal(label.getText());
//                        logic.cal();
//                        view_value = logic.getResult() + "";
//                        label.setText(view_value);
//                    } else  {
//                        System.out.println("duplication value");
//                    }
                } else {
                    return;
                }
            }
        });
    }

    private void evenHandlerClear(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TA.append(logic.printNumbers());
                logic.resetAll();
                label.setText("");
            }
        });
    }

    /**
     * Component Method
     */
    private void addBtnToPanel(JButton... btns) {
        for (int i = 0; i < btns.length; i++) {
            panel.add(btns[i]);
        }
    }

    /**
     * Constructor: Init
     */
    private Calculator_Swing() {
        setTitle(Opt.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        Set GridLayout
        GridLayout layout = new GridLayout(Opt.ROW, Opt.COLUMN);

//        Set JTextField
        label.setFont(new Font(Opt.VIEW_FONT, Font.BOLD, Opt.VIEW_SIZE));
        label.setEditable(false);
        CP.add(label, BorderLayout.NORTH);

//        Component: BTN NUMBERS (4*4): Create BTN
//        Or JButton[] bt = new JButton[16];
        JButton div = new JButton("/");
        evenHandlerOperator(div);
        JButton mul = new JButton("*");
        evenHandlerOperator(mul);
        JButton sub = new JButton("-");
        evenHandlerOperator(sub);
        JButton add = new JButton("+");
        evenHandlerOperator(add);
        JButton AC = new JButton("C");
        evenHandlerClear(AC);
        JButton equal = new JButton("=");
        evenHandlerEqual(equal);

        JButton b0 = new JButton("0");
        evenHandlerNumber(b0);
        JButton b1 = new JButton("1");
        evenHandlerNumber(b1);
        JButton b2 = new JButton("2");
        evenHandlerNumber(b2);
        JButton b3 = new JButton("3");
        evenHandlerNumber(b3);
        JButton b4 = new JButton("4");
        evenHandlerNumber(b4);
        JButton b5 = new JButton("5");
        evenHandlerNumber(b5);
        JButton b6 = new JButton("6");
        evenHandlerNumber(b6);
        JButton b7 = new JButton("7");
        evenHandlerNumber(b7);
        JButton b8 = new JButton("8");
        evenHandlerNumber(b8);
        JButton b9 = new JButton("9");
        evenHandlerNumber(b9);
        CP.add(panel);
        panel.setLayout(layout);

        addBtnToPanel(b7, b8, b9, add);
        addBtnToPanel(b4, b5, b6, sub);
        addBtnToPanel(b1, b2, b3, mul);
        addBtnToPanel(b0, AC, equal, div);
        CP.add(panel, BorderLayout.CENTER);

        TA.setText("--- Logging ---\n");
        TA.setEditable(false);
        CP.add(TA, BorderLayout.SOUTH);

        pack();
        CP.setLayout(layout);
        setSize(Opt.W, Opt.H);
        setVisible(true);

    }

    private static class InnerInstanceClass {
        private static final Calculator_Swing instance = new Calculator_Swing();
    }

    public static Calculator_Swing getInstance() {
        return InnerInstanceClass.instance;
    }

    public static void main(String[] args) {
        getInstance();
    }
}

// 디자인 참고할만한 사이트
// https://m.blog.naver.com/dawonchu99/221754223779