package project2;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class DATA
{
    public final static int W= 300, H= 500;
    public final static String TITLE= "Calculator";
    public final static int ROW= 4, COLUMN= 4;
}

class Logic
{
    private static ArrayList<String> number_value= new ArrayList<>();
    private static ArrayList<String> operator_value= new ArrayList<>();
    private static double result= 0;

    public static void saveCurrentVal(String current_Value) { number_value.add(current_Value); }
    public static void saveOperateVal(String c) { operator_value.add(c); }

    public static void cal()
    {
        String[] numbers = number_value.toArray(new String[number_value.size()]);
        String[] operators= operator_value.toArray(new String[operator_value.size()]);

        for (String v : numbers) System.out.println(v);
        System.out.println("=========");
        for (String v: operators) System.out.println(v);
        System.out.println("======");
        final int RANGE= numbers.length;

        double a= (double) Integer.parseInt(numbers[0]), b= (double) Integer.parseInt(numbers[1]);
        if (RANGE<=2) result= cal_operate(a, b, operators[0].charAt(0));
        else
        {
            result= cal_operate(result, Integer.parseInt(numbers[RANGE-1]), operators[operators.length-1].charAt(0));
        }
        System.out.println(result);
        System.out.println("============");
    }
    public static double cal_operate(double a, double b, char c)
    {
        double result= 0;
        switch (c)
        {
            case '+':
                result= a+b;
                break;
            case '-':
                result= a-b;
                break;
            case '*':
                result= a*b;
                break;
            case '/':
                result= a/b;
                break;
            default:
                System.out.println("Out of Range");
                break;
        }
        return result;
    }

    public static double getResult() { return  result; }
}



public class Calculator_Swing extends JFrame
{
    DATA D;
    Container CP;
    JPanel panel;
    JTextField label;
    static String view_value= "";
    Logic logic= new Logic();

    Calculator_Swing()
    {
        setTitle(D.TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        Set GridLayout
        CP= getContentPane();
        GridLayout layout= new GridLayout(D.ROW, D.COLUMN);

//        Set Panel
        panel= new JPanel();

//        Component: View
        label= new JTextField("", SwingConstants.RIGHT);
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setEditable(false);
        CP.add(label, BorderLayout.NORTH);

//        Component: BTN NUMBERS (4*4)
//        Or JButton[] bt = new JButton[16];
//        Create BTN
        JButton div = new JButton("/"); evenHandlerOperator(div);
        JButton mul = new JButton("*"); evenHandlerOperator(mul);
        JButton sub = new JButton("-"); evenHandlerOperator(sub);
        JButton add = new JButton("+"); evenHandlerOperator(add);
        JButton equal = new JButton("="); evenHandlerEqual(equal);
        JButton AC = new JButton("C");  evenHandlerClear(AC);
        JButton b0 = new JButton("0");  evenHandlerNumber(b0);
        JButton b1 = new JButton("1");  evenHandlerNumber(b1);
        JButton b2 = new JButton("2");  evenHandlerNumber(b2);
        JButton b3 = new JButton("3");  evenHandlerNumber(b3);
        JButton b4 = new JButton("4");  evenHandlerNumber(b4);
        JButton b5 = new JButton("5");  evenHandlerNumber(b5);
        JButton b6 = new JButton("6");  evenHandlerNumber(b6);
        JButton b7 = new JButton("7");  evenHandlerNumber(b7);
        JButton b8 = new JButton("8");  evenHandlerNumber(b8);
        JButton b9 = new JButton("9");  evenHandlerNumber(b9);
        CP.add(panel);
        panel.setLayout(layout);


//        Add
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(add);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(sub);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(mul);
        panel.add(b0);
        panel.add(AC);
        panel.add(equal);
        panel.add(div);
        CP.add(panel, BorderLayout.CENTER);

//        Function Calculator
// 버튼 클릭, 해당 버튼 Char value 를 받아와서 표시
//        1. 숫자 반복 입력 2.연산
//        숫자 문자 추가 / 연산자가 들어오면 text String을 불러와서 A[0]에 저장 후 텍스트 초기화, 
//        '=' 연산자가 들어오면 그 동안 버퍼했던 값들을 연산 후 A[0]에 저장
//        반복

//        Options
        pack();
        CP.setLayout(layout);
        setSize(D.W, D.H);
        setVisible(true);
    }


    private void evenHandlerNumber(JButton btn)
    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current_val= label.getText();
                String val= btn.getText();
                String sum_str= current_val+val;

                label.setText(sum_str);
            }
        });
    }

    String pre_operator= "";
    private void evenHandlerOperator(JButton btn)
    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current_val= label.getText();
                logic.saveCurrentVal(current_val);

                logic.saveOperateVal(btn.getText());
                label.setText("");
            }
        });
    }

    private void evenHandlerEqual(JButton btn)
    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String current_val= label.getText();
                logic.saveCurrentVal(current_val);

                logic.cal();
                view_value= logic.getResult() + "";
                label.setText(view_value);
            }
        });
    }

    private void evenHandlerClear(JButton btn)
    {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("");
            }
        });
    }


    public static void main(String[] args) {
        new Calculator_Swing();
    }
}