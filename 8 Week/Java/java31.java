import java.util.Arrays;
import java.util.Scanner;

abstract class Student
{
    public String name;
    public String grade;
    public int score;

    { name= " "; score= 0; grade= "F"; }
    Student() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    abstract public void computeGrade();
}

class College extends Student
{
    public College() {}
    public College(String name) { this.name= name; }

    @Override
    public void computeGrade()
    {
        int score= getScore();
        if (score>=90)                   grade= "A";
        else if (score>= 80 && score<90) grade= "B";
        else if (score>=70 && score<80)  grade= "C";
        else if (score>=60 && score<70)  grade= "D";
    }
}

class Graduate extends Student
{
    public Graduate(String name) { this.name= name; }

    @Override
    public void computeGrade() {
        int score= getScore();
        if (score>= 70) grade= "Pass";
        else grade= "Fail";
    }
}

class Student_02
{
    final int MAX= 10;
    String[] student;

    Scanner sc= new Scanner(System.in);
    { student= setDefaultDate(); }

    public String[] setDefaultDate()
    {
        char[] arr= new char[MAX];
        String[] std= new String[MAX];

        for(int i=0; i<MAX; i++) { arr[i]= (char) ('a'+i); }
        int j= 0;
        for (char val:arr) { std[j]= Character.toString(val); j++; }
        return std;
    }

    public String[] setInputDate()
    {
        System.out.println(MAX + "명의 학생 이름을 입력해주세요. (공백 입력)");
        return sc.nextLine().split(" ");
    }

    public int getArrayIndex(String[] arr)
    {
        int index=0 ; int find_index= -1;
        String str= sc.next();

        for (String val: arr)
        {
            if (val.equals(str)) find_index= index;
        }
        return find_index;
    }
}

class CheckHangul
{
    Scanner sc= new Scanner(System.in);
    String hangul; String text;
    { hangul= " "; text= " "; }

    public CheckHangul()
    {
        System.out.println("문장 입력");
        hangul = sc.nextLine();
        System.out.println("세고 싶은 글자 하나 입력");
        text= sc.next();
    }

    public int printCnt(String str, String c)
    {
        int index= str.indexOf(c);
        int result= 0;
        for (char val:str.substring(index).toCharArray())
        {
            boolean b= c.equals(val);
            if (b) result+= 1;
        }
        System.out.println(result+"개");
        return result;
    }
}

class CheckEng
{
    Scanner sc= new Scanner(System.in);
    String eng; int consonant; int vowel;
    { eng= " "; consonant= 0; vowel= 0; }

    public CheckEng()
    {
        System.out.println("영어 문장 입력");
        eng = sc.nextLine();
    }

    public void separate(String str)
    {
        str= str.toLowerCase();
        int x=0, y=0;
        for (char c:str.toCharArray())
        {
            switch (c)
            {
                case 'i': case 'o': case 'u': case 'a': case 'e':
                    x++;
                default:
                    y++;
            }
        }
        vowel= x;
        consonant= y;
    }
}

public class java31
{
    public static void main(String[] args)
    {
        CheckEng e= new CheckEng();
        e.separate(e.eng);
    }
}
