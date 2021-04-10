import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class Mapdist
{
    int x1, y1;
    int x2, y2;
    int DIST;
    { x1=0; y1=0; x2=0; y2=0; DIST=0; }

    private void setDot(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    private Double calculate()
    {
        return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
    }

    public void init()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("X1, Y1, X2, Y2");
        setDot(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        System.out.printf("X1, Y1, %d %d", x1, y1);
        System.out.printf("X2, Y2, %d %d", x2, y2);
        System.out.printf("AB 거리: %f", calculate());
    }
}

class printDate
{
    public void init()
    {
        final String[] DAY_OF_WEEK_S= {"", "일", "월", "화", "수", "목", "금", "토"};
        SimpleDateFormat format1 = new SimpleDateFormat("오늘의 날짜는 yyyy년 MM월 dd일 입니다.");
        SimpleDateFormat format2= new SimpleDateFormat("오늘의 요일은 : E 입니다.");

        Calendar calendar= Calendar.getInstance();
        Date setDefault = new Date(calendar.YEAR, calendar.MONTH, calendar.DATE);
        System.out.println(format1.format(setDefault));
        // > 오늘의 날짜는 1901년 03월 05일 입니다.

        Date day_of_week = new Date(calendar.DAY_OF_WEEK);
        System.out.println(DAY_OF_WEEK_S[calendar.get(Calendar.DAY_OF_WEEK)] + "요일입니다.");
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + "월");
        int index= calendar.get((int)Calendar.DAY_OF_WEEK);
        System.out.println(DAY_OF_WEEK_S[index] + "요일 입니다.");

        System.out.println(format2.format(calendar.get(Calendar.DAY_OF_WEEK)));
    }
}

class PrintCalendar
{
    final String[] DAY_OF_WEEK_S= {"", "일", "월", "화", "수", "목", "금", "토"};
    final char BLINK= '✶';
    int year; int month; int week_index; String days;
    int START_DAY_WEEK= 0; int END_DAY_WEEK= 0;
    Calendar calendar= Calendar.getInstance();
    {
        year= calendar.get(Calendar.YEAR);
        month= calendar.get(Calendar.MONTH);
        week_index= calendar.get((int)Calendar.DAY_OF_WEEK);
        days= DAY_OF_WEEK_S[week_index];
    }

    private void printTop()
    {
        System.out.println("========  " + year + " 년" + month + " 월" + "  ========");
        for (int i=1; i<DAY_OF_WEEK_S.length; i++) System.out.printf(" %s ", DAY_OF_WEEK_S[i]);
        System.out.println();
        System.out.println("===========================");
    }

    public void init()
    {
        printTop();
        Calendar sDay= Calendar.getInstance();
        Calendar eDay= Calendar.getInstance();
        eDay.set(year, month-1, 1);
        sDay.set(year, month, 1);
        eDay.add(Calendar.DATE,-1);
        START_DAY_WEEK= sDay.get(Calendar.DAY_OF_WEEK);
        END_DAY_WEEK= eDay.get(Calendar.DATE);

        for (int i=1; i< START_DAY_WEEK; i++) System.out.printf("  %c", BLINK);
        for (int i=1, n= START_DAY_WEEK; i<=END_DAY_WEEK; i++, n++)
        {
            System.out.print( (i<10) ? "  "+i : " "+i);
            if (n%7 == 0) System.out.println();
        }
//        System.out.println(DAY_OF_WEEK_S[Calendar.DATE-1]);
//        System.out.println(DAY_OF_WEEK_S[calendar.DATE]);
    }
}

public class java32 {
    public static void main(String[] args) {
        PrintCalendar pd= new PrintCalendar();
        pd.init();
    }
}
