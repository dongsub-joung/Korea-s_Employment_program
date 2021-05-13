package project2_submit_version;

import project2_ver0.HoleOption;
import project2_ver0.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_Swing extends JFrame {

    Container CP = getContentPane();
    JLabel number1= new JLabel("Number1");
    JLabel number2= new JLabel("Number2");
    JLabel result= new JLabel("result");
    JTextField numb1_field = new JTextField("", SwingConstants.RIGHT);
    JTextField numb2_field = new JTextField("", SwingConstants.RIGHT);
    JTextField result_field = new JTextField("", SwingConstants.RIGHT);
    JPanel panel = new JPanel();

    Init init= new Init();
    static String view_value = "";

    /**
     * Event Method
     */
    private void evenHandlerOperator(JButton btn) {
        btn.addActionListener(e -> {
            String temp, current_val= "";

//            Get Value entered by user && Null Checking.Verify
            init.saveFirstValue(current_val);
            init.saveOperateVal(btn.getText());
            label.setText("");
        });
    }

    private void evenHandlerEqual(JButton btn) {
        btn.addActionListener(e -> {
            String temp, current_val= "";

//            Get Value entered by user && Null Checking.Verify
            temp= label.getText();
            if(temp != null) {
                if (!temp.equals("")){
                    current_val= temp;
                }else{
                    System.out.println("Err: Default number");
                }
            }

            if (init.buff[1] != null) {
                if ()
                {
                    init.saveSecondValue(current_val);
                    logic.cal();
                    view_value = logic.getResult() + "";
                    label.setText(view_value);
                } else  {
                    System.out.println("duplication value");
                }
            } else {
                System.out.println("Operator is null");
                return;
            }
        });
    }

    private void evenHandlerClear(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.resetAll();
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
        setTitle(project2_ver0.HoleOption.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        Set GridLayout
        GridLayout layout = new GridLayout(project2_ver0.HoleOption.ROW, project2_ver0.HoleOption.COLUMN);

//        Set JTextField
        label.setFont(new Font(project2_ver0.HoleOption.VIEW_FONT, Font.BOLD, project2_ver0.HoleOption.VIEW_SIZE));
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

        CP.add(panel);
        panel.setLayout(layout);

        addBtnToPanel(add, sub,mul, div);;
        CP.add(panel, BorderLayout.CENTER);

        TA.setEditable(false);
        CP.add(TA, BorderLayout.SOUTH);

        CP.setLayout(layout);
        setSize(project2_ver0.HoleOption.W, HoleOption.H);
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