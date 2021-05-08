package project2_ver0;

public class Init extends ValueChacker {

    //    Printer
    public String printNumbers() {
        String str = "[ ";
        for (int i = 0; i < buff.length; i++) {
            str+= buff[i] + " ,";
        }
        return str + " ]";
    }

    //    Core Method
    public static double initCalculate(double a, double b, char c) {
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
}
