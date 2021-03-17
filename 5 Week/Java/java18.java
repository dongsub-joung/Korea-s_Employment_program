// Ex03
class StudentVo
{
    int id;
    String name;
    StudentVo() {}
    StudentVo(String name) { this(1,name); }
    StudentVo(int id, String name) { this.name= name; this.id= id;}
    int getId() { return id; }
    String getName() { return  name; }
    void setId(int no) { id= no; }
    void setName(String nm) { name=nm; }
}

class Practice02
{
    public static void PrintMultiplicationTable(int dan, int depth)
    {
        final int depth_RANGE= 9;
        final int dan_RANGE=9;
        int result= dan*depth;
        System.out.println(dan+"*"+depth+"="+result);
        depth+= 1;
        if (depth>depth_RANGE)
        {
            System.out.println("========");
            dan+= 1;
            depth= 1;
        }
        if (dan < dan_RANGE)
            PrintMultiplicationTable(dan,depth);
        else
            System.out.println("끝");
    }
}

class Practice01
{
    //절대값 구하기
    int num;
    Practice01() {}
    Practice01 (int num)
    {
        if (num<0) this.num= num*-1;
        else this.num= num;
    }
    int myABS () {return num;}
}

class OverLoadEx
{
    OverLoadEx() {}
    public void line(char ch, int n)
    {
        for (int i=0; i<n; i++)
            System.out.printf("%c ", ch);
    }
    public void line(char ch)
    {
        line(ch,20);
    }
}

class Line
{
    char ch;
    int n;
    {
        System.out.println("Print enter char in range inputted integer.");
        System.out.println("Default value: char ' ', number 1 ");
    }
    Line()
    {
        ch= ' ';
        n= 1;
    }
    Line(char ch) { this(ch, 20); }
    Line(char ch, int n)
    {
        this.ch= ch;
        this.n= n;
        for (int i=0; i<n; i++)
            System.out.printf("%c ", ch);
    }
}

public class java18 {

    private static String printGraph(char ch, int value)
    {
        String result= "";
        for (int i=0; i<value; i++) result+= ch;
        return result;
    }

    public static void init()
    {
        final int RANGER= 10;
        int[] numbers= new int[RANGER];
        int[] counters= new int[RANGER];
        final int N_LEN= numbers.length;

        for (int i=0; i<RANGER; i++) numbers[i]= (int) (Math.random()*RANGER+1);

//        0~9가 몇번씩 나왔는지 나타내는 counters 증가
        for (int i=0; i<N_LEN; i++) counters[numbers[i]]++;

        for (int i=0; i<counters.length; i++)
            System.out.printf("%d 갯수: %s  %d \n", i, printGraph('❑', counters[i]), counters[i]);
    }

    public static void main(String[] args)
    {
//        랜덤한 숫자배열을 생성하고 시각화하기
        init();

//        Ex: overload
//        OverLoadEx ex= new OverLoadEx();
//        ex.line('*');

//        Ex: constructor
//        Line line= new Line('+',30);

//        Ex01
//        System.out.println("-- Ex01 --");
//        Practice01 p1= new Practice01(12);
//        System.out.println("절대값 출력: "+p1.myABS());
//
////        Ex02
//        System.out.println("-- Ex02 --");
//        Practice02.PrintMultiplicationTable(2,1);
//
////        Ex03
//        System.out.println("-- Ex03 --");
//        StudentVo sv= new StudentVo("kim");
//        sv.setId(2014);
//        System.out.println(sv.getName());
//        System.out.println(sv.getId());

    }
}