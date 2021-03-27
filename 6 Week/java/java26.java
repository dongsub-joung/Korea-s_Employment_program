import java.util.Scanner;

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
        if (id.equals("admin") && pw.equals("8090"))
        {
            super.setRate(rate);
            return true;
        }
        else
        {
            System.out.println("Only accessable admin user");
            return false;
        }
    }
}

public class java26 {
    public static void main(String[] args) {
        Calculator kim= new Calculator();
        Scanner sc= new Scanner(System.in);
        while (true)
        {
            System.out.printf("Time(0: END): ");
            int time= sc.nextInt();
            if (time == 0)
            {
                kim.printMoney();
                break;
            }
            kim.setHour(time);

            loop:while (true)
            {
                System.out.printf("Change a per salary (Yes: 1, No: 2)\n");
                int select= sc.nextInt();
                if (select == 2) break loop;
                System.out.print("Enter user ID:  ");
                String id_str= sc.next();

                System.out.println(id_str);
                System.out.printf("Enter user PW:  ");
                String pw_str= sc.next();
                System.out.println(pw_str);
                System.out.printf("Enter rate you want:  ");
                int rate= sc.nextInt();
                if (kim.setRate(id_str, pw_str, rate)) break loop;
            }

            if (kim.isControl_hour() || kim.isControl_rate())
            {
                kim.printSalary();
                kim.off_control();
            }
            System.out.println("=================================");
        }
    }
}