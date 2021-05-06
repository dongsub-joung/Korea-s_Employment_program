package project2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Function Calculator
 * 버튼 클릭, 해당 버튼 Char value 를 받아와서 표시
 * 1. 숫자 반복 입력 2.연산
 * 숫자 문자 추가 / 연산자가 들어오면 text String을 불러와서 A[0]에 저장 후 텍스트 초기화,
 * '=' 연산자가 들어오면 그 동안 버퍼했던 값들을 연산 후 A[0]에 저장
 * 반복
 */
public class Logic {

    private static ArrayList<String> number_value = new ArrayList<>();
    private static ArrayList<String> operator_value = new ArrayList<>();
    private static double result = 0;

    public static boolean duplicateCheck(){
        String[] numbers = number_value.toArray(new String[number_value.size()]);
        String[] operators = operator_value.toArray(new String[operator_value.size()]);

        return ((numbers.length / operators.length) == 0);
    }

    public static String printNumbers() {
        String str = "";
        for (Iterator it = number_value.iterator(); it.hasNext(); ) {
            Object obj = it.next();
            str += (String) obj + ",";
        }
        return str;
    }

    public static boolean checkOperatorIsNotNull() {
        return operator_value.isEmpty();
    }

    public static void saveCurrentVal(String current_Value) {
        number_value.add(current_Value);
    }

    public static void saveOperateVal(String c) {
        operator_value.add(c);
    }

    public static void resetAll() {
        number_value.clear();
        operator_value.clear();
        result = 0;

    }

    public static void cal() {
        String[] numbers = number_value.toArray(new String[number_value.size()]);
        String[] operators = operator_value.toArray(new String[operator_value.size()]);

        //        Trace Value stream [numbers, operators]
        for (String v : numbers) System.out.println(v);
        System.out.println("=========");
        for (String v : operators) System.out.println(v);
        System.out.println("=========");

        final int RANGE = numbers.length;
        double a = (double) Integer.parseInt(numbers[0]), b = (double) Integer.parseInt(numbers[1]);
        if (RANGE <= 2) result = cal_operate(a, b, operators[0].charAt(0));
        else {
            result = cal_operate(result, Integer.parseInt(numbers[RANGE - 1]), operators[operators.length - 1].charAt(0));
        }

    }

    public static double cal_operate(double a, double b, char c) {
        double result = 0;
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
                result = a / b;
                break;
            default:
                System.out.println("Out of Range");
                break;
        }
        return result;
    }

    public static double getResult() {
        return result;
    }
}
