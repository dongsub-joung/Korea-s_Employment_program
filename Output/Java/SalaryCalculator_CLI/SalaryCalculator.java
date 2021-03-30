package SalaryCalculator_CLI;

import java.util.Scanner;

class STRING
{
    public static final String LINE=  "=================================";
    public static final String START= "Time(0: END): ";
    public static final String DENY= "Only accessable admin user";

//    In Loop
    public static final String CHANGE_SALARY= "Change a per salary (Yes: 1, No: 2)\n";
    public static final String SET_ID=  "Enter user ID:  ";
    public static final String SET_PW=  "Enter user PW:  ";
    public static final String SET_RATE="Enter rate you want:  ";
}

class ControlSalary
{
    private static boolean control_rate;
    private static boolean control_hour;
    static { control_rate= false; control_hour= false; }
    public static boolean isControl_rate() { return control_rate; }
    public static boolean isControl_hour() { return control_hour; }

    public static void setControl_rate(boolean control_rate) {
        ControlSalary.control_rate = control_rate;
    }
    public static void setControl_hour(boolean control_hour) {
        ControlSalary.control_hour = control_hour;
    }
    public static void off_control() { control_rate= false; control_hour= false; }
}

class Salary extends ControlSalary
{
    private int rate;
    private int hour;
    private int middle;
    private int money;
    { rate=1000; hour=0; middle=0; money=0;}

    //    Getter
    public int getRate() { return rate; }
    public int getHour() { return hour; }
    public int getMiddle() { return middle; }
    public int getMoney() { return money; }

    //    Setter
    protected void setRate(int rate)
    {
        System.out.printf("%d => %d\n", this.rate, rate);
        this.rate = rate;
        setControl_rate(true);
    }
    public void setHour(int hour)
    {
        System.out.printf("%d => %d\n", this.hour, hour);
        this.hour = hour;
        setControl_hour(true);
    }
    protected void setMiddle(int middle) {
        this.middle = middle;
    }
    protected void setMoney(int money) {
        this.money+= money;
    }
}

class Calculator extends Salary
{
    private static final String default_id= "admin";
    private static final String default_pw= "8090";

    private static String getDefault_id() { return default_id; }
    private static String getDefault_pw() { return default_pw; }

    private int calculateSalary()
    {
        int hour= super.getHour();
        int rate= super.getRate();
        int money= hour*rate;
        setMiddle(money);
        setMoney(money);
        return getMiddle();
    }
    public void printSalary() { System.out.printf("Calculating one step: %d\n", calculateSalary()); }
    public void printMoney() {
        System.out.printf("In amount salary: %d\n", getMoney());
    }

    protected boolean setRate(String id, String pw, int rate)
    {
        String default_id= getDefault_id();
        String default_pw= getDefault_pw();
        if (id.equals(default_id) && pw.equals(default_pw))
        {
            super.setRate(rate);
            return true;
        }
        else
        {
            System.out.println(STRING.DENY);
            return false;
        }
    }
}

public class SalaryCalculator {
    public static void main(String[] args) {
        STRING STR= new STRING();
        Calculator kim= new Calculator();
        Scanner sc= new Scanner(System.in);

        while (true)
        {
            System.out.printf(STR.START);
            int time= sc.nextInt();
            if (time == 0)
            {
                kim.printMoney();
                break;
            }
            kim.setHour(time);

            loop:while (true)
            {
                System.out.printf(STR.CHANGE_SALARY);
                int select= sc.nextInt();
                if (select == 2) break loop;

                System.out.print(STR.SET_ID);
                String id_str= sc.next();
                System.out.printf(STR.SET_PW);
                String pw_str= sc.next();
                System.out.println(pw_str);
                System.out.printf(STR.SET_RATE);
                int rate= sc.nextInt();
                if (kim.setRate(id_str, pw_str, rate)) break loop;
            }

            if (kim.isControl_hour() || kim.isControl_rate())
            {
                kim.printSalary();
                kim.off_control();
            }
            System.out.println(STR.LINE);
        }
    }
}