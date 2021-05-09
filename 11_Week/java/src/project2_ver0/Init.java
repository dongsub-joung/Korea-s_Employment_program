package project2_ver0;

public class Init extends ValueChacker {
    int a, b; {a=0; b=0;}

    public Init(){
        try{
            String a_str= buff[0]; String b_str= buff[2];
            char c= buff[1].charAt(0);
        }catch (Exception e) {
            System.out.println(e + "");
        }
    }

    public

    //    Printer
    public String printNumbers() {
        String str = "[ ";
        for (int i = 0; i < buff.length; i++) {
            str+= buff[i] + " ,";
        }
        return str + " ]";
    }

    //    Core Method
    public double initCalculate() {
        int a= 0, b= 0; char c= ' ';

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
