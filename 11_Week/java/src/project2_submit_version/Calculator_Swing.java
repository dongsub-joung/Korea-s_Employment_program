package project2_submit_version;

import project2_ver0.HoleOption;

import javax.swing.*;
import java.awt.*;

public class Calculator_Swing extends JFrame {

    Container CP = getContentPane();
    JPanel panel = new JPanel();

    JLabel number1 = new JLabel("Number1");
    JLabel number2 = new JLabel("Number2");
    JLabel result = new JLabel("result");
    JTextField numb1_field = new JTextField("", SwingConstants.RIGHT);
    JTextField numb2_field = new JTextField("", SwingConstants.RIGHT);
    JTextField result_field = new JTextField("", SwingConstants.RIGHT);

    static String view_value = "";
<<<<<<< HEAD
    String[] buff= new String[5];
=======
    String[] buff = new String[5];
>>>>>>> c68803b364881650f838424372cf8c6df01ee07d

    /**
     * Event Method
     */
<<<<<<< HEAD

    private void setFontJTextFields(JTextField ...fields){
        for(JTextField field : fields){
            field.setFont(new Font(project2.HoleOption.VIEW_FONT, Font.BOLD, project2.HoleOption.VIEW_SIZE));
        }
    }

    private void evenHandlerOperator(JButton btn) {
        btn.addActionListener(e -> {
            String value1= numb1_field.getText();
            String value2= numb2_field.getText();
            double a= 0, b= 0; char c= ' ';
            double result = 0;
            int buff_len= 0;
//            String temp, current_val= "";

//            Get Value entered by user && Null Checking.Verify
            buff_len= buff.length;
            if(!value1.equals("")) {
                a= Integer.parseInt(value1);
                b= Integer.parseInt(value2);
                c= btn.getText().charAt(0);

                if (buff_len > 0) {
                    switch (c) {
                        case '+':
                            result = a + b;
                            break;
                        case '-':
                            result = a - b;
                            break;
                        case '*':
                            result = a * b;
                            break;
                        case '/':
=======
    private void evenHandlerOperator(JButton btn) {
        btn.addActionListener(e -> {
            String value1 = numb1_field.getText();
            String value2 = numb2_field.getText();
            double a = 0, b = 0;
            String c = "";
            double result = 0;
            String view= "";
            int buff_len = 0;

//            Get Value entered by user && Null Checking.Verify
            buff_len = buff.length;
            if (!value1.equals("")) {
                a = Integer.parseInt(value1);
                b = Integer.parseInt(value2);
                c = btn.getText();

                if (buff_len > 0) {
                    switch (c) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "/":
>>>>>>> c68803b364881650f838424372cf8c6df01ee07d
                            result = a / b;
                            break;
                        default:
                            System.out.println("ERR");
                            break;
                    }
<<<<<<< HEAD

                    result_field.setText(Character.toString((int)result));
=======
                    view= String.valueOf(result);
                    result_field.setText(view);
>>>>>>> c68803b364881650f838424372cf8c6df01ee07d
                } else {
                    result_field.setText("Operator is null");
                    return;
                }
            } else {
                result_field.setText("First number is Null.");
                return;
            }
        });
    }

    private void evenHandlerClear(JButton btn) {
        btn.addActionListener(e -> {
            numb1_field.setText("");
            numb2_field.setText("");
            result_field.setText("");
        });
    }


    /**
     * Component Method
     */
    private void addSingingComponent(JLabel label, JTextField field){
        panel.add(label);
        panel.add(field);
    }

    private void addBtnToPanel(JButton... btns) {
        for (int i = 0; i < btns.length; i++) {
            panel.add(btns[i]);
        }
    }

<<<<<<< HEAD
    private void addEventHandler(JButton ...btns){
        for (JButton btn : btns){
=======
    private void addEventHandler(JButton... btns) {
        for (JButton btn : btns) {
>>>>>>> c68803b364881650f838424372cf8c6df01ee07d
            evenHandlerOperator(btn);
        }
    }

<<<<<<< HEAD
=======
    private void setFontJTextFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setFont(
                    new Font(project2.HoleOption.VIEW_FONT
                            , Font.BOLD
                            , project2.HoleOption.VIEW_SIZE));
        }
    }

>>>>>>> c68803b364881650f838424372cf8c6df01ee07d
    /**
     * Constructor: Init
     */
    private Calculator_Swing()
    {
        setTitle(project2_ver0.HoleOption.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

<<<<<<< HEAD
//        Set GridLayout
//        GridLayout layout = new GridLayout(project2_ver0.HoleOption.ROW, project2_ver0.HoleOption.COLUMN);


//        Set JTextField
        setFontJTextFields(numb1_field, numb2_field, result_field);
        numb1_field.setEditable(true); numb2_field.setEditable(true);
        result_field.setEditable(false);

//        Component: BTN NUMBERS (4*4): Create BTN
//        Or JButton[] bt = new JButton[16];
=======
        GridLayout grid = new GridLayout(10, 2);
        grid.setVgap(10);
        panel.setLayout(grid);

//        Set Component Options
        setFontJTextFields(numb1_field, numb2_field, result_field);
        numb1_field.setEditable(true);
        numb2_field.setEditable(true);
        result_field.setEditable(false);

//        Component: BTN NUMBERS (4*4): Create BTN
>>>>>>> c68803b364881650f838424372cf8c6df01ee07d
        JButton add = new JButton("+");
        JButton sub = new JButton("-");
        JButton div = new JButton("/");
        JButton mul = new JButton("*");
        addEventHandler(add, sub, div, mul);
<<<<<<< HEAD

        JButton AC = new JButton("Clear");
        evenHandlerClear(AC);

        JButton EXIT = new JButton("EXIT");
        EXIT.addActionListener(e-> setDefaultCloseOperation(EXIT_ON_CLOSE));

        CP.add(panel);
//        panel.setLayout(layout);

        addBtnToPanel(add, sub, mul, div);
        addBtnToPanel(AC, EXIT);
        CP.add(panel, BorderLayout.CENTER);

//        CP.setLayout(layout);
=======

        JButton AC = new JButton("Clear");
        evenHandlerClear(AC);

        JButton EXIT = new JButton("EXIT");
        EXIT.addActionListener(e -> System.exit(0) );

//        Attach components
        addSingingComponent( number1, numb1_field);
        addSingingComponent( number2, numb2_field);
        addSingingComponent( result, result_field);
        addBtnToPanel(add, sub, mul, div);
        addBtnToPanel(AC, EXIT);
        CP.add(panel);

>>>>>>> c68803b364881650f838424372cf8c6df01ee07d
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