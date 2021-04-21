import java.rmi.MarshalledObject;
import java.util.*;

class PersonVo
{
    int age; String name;

    PersonVo(){}
    PersonVo(int age, String name) { setAge(age); setName(name); }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<PersonVo> saveFamily()
    {
        PersonVo granFa= new PersonVo(80, "FI");
        PersonVo granMo= new PersonVo(85, "NI");
        PersonVo fa= new PersonVo(30, "Mo");
        PersonVo mo= new PersonVo(30, "AO");
        PersonVo sister= new PersonVo(16, "ZE");
        PersonVo brother= new PersonVo(15, "MY");

        Vector<PersonVo> Family_A= new Vector<>();
        Family_A.add(granFa); Family_A.add(granMo);
        Family_A.add(fa); Family_A.add(mo);
        Family_A.add(sister); Family_A.add(brother);

        return Family_A;
    }

    public void printFamilyInfo()
    {
        Vector<PersonVo> family= saveFamily();
        for (Iterator<PersonVo> it = family.iterator(); it.hasNext(); )
        {
            PersonVo obj = it.next();
            System.out.println("Name: "+obj.name);
            System.out.println("Age: "+obj.age);
        }
    }
}

class StudentVo
{
    String name; int eng; int chn;
    { name= ""; eng= 0; chn=0; }

    StudentVo()
    {
        Scanner sc= new Scanner(System.in);
        loop1:while (true)
        {
            System.out.printf("이름 "); name= sc.next();
            System.out.printf("영어 점수 "); eng= sc.nextInt();
            System.out.printf("중국어 점수 "); chn= sc.nextInt();
            if (eng<0 || chn<0 || eng>100 || chn>100) { System.out.println("Out of Range!"); continue; }
            else break loop1;
        }
    }
    StudentVo(String name, int eng, int chn)
    {
        this.name= name; this.eng= eng; this.chn= chn;
    }

    private ArrayList<StudentVo> setClassValue()
    {
        ArrayList<StudentVo> ST= new ArrayList<>();
        ST.add(new StudentVo(name,eng,chn));
        return ST;
    }

    private void printStudentInfo(ArrayList<StudentVo> student)
    {
        for (Iterator<StudentVo> it= student.iterator(); it.hasNext();)
        {
            StudentVo obj= it.next();
            System.out.printf("Name: %s\n", obj.name);
            System.out.printf("eng: %d\n", obj.eng);
            System.out.printf("chn: %s\n", obj.chn);
        }
    }
    public void init()
    {
        printStudentInfo(setClassValue());
    }
}

class Example03
{
    final int COUNT= 10;
    ArrayList<Integer> random_numbers= new ArrayList<>();
    {
        for (int i=0; i<COUNT; i++) random_numbers.add((int)Math.floor(Math.random()*90)+10);
    }

    Example03(){}
    public int sumRandomNumbers()
    {
        int sum= 0;
        for (Iterator it= random_numbers.iterator(); it.hasNext();)
        {
            Integer numbers= (Integer) it.next();
            System.out.printf("%d ", numbers);
            sum+= numbers;
        }
        System.out.println();
        return sum;
    }
}

class Example04
{
    int RANGE= 100;
    LinkedList<Integer> random_numbers= new LinkedList<>();
    {
        for (int i=1; i<=RANGE; i++) random_numbers.add(i);
    }

    public void init()
    {
        int sum= 0;
        for (Iterator it= random_numbers.iterator(); it.hasNext();)
        {
            Integer number= (Integer) it.next();
            if (number%2 == 0) sum+= number;
            else continue;
        }
        System.out.printf("총합: %d", sum);
    }
}

class Example05
{
    HashMap phone_numbers= new HashMap();

    public void saveNumbers()
    {
        String name= ""; String Ph= "";
        Scanner sc= new Scanner(System.in);
        while (true)
        {
            System.out.printf("이름입력>>"); name= sc.next();
            System.out.printf("전화번호입력>>"); Ph= sc.next();
            if (name != "" && Ph != "")
            {
                System.out.println("전화번호가 저장되었습니다.");
                phone_numbers.put(name, Ph);
                break;
            }
            else continue;
        }
    }

    public void printPhoneNumbers()
    {
        System.out.println("저장된 정보를 모두 출력합니다.");
        Iterator itr= phone_numbers.keySet().iterator();
        while (itr.hasNext())
        {
            String key= (String) itr.next();
            System.out.printf("%s : %s", key, phone_numbers.get(key));
        }
    }
}

public class javacore_15 {
    public static void main(String[] args) {
//        EX 01
//        PersonVo te= new PersonVo();
//        te.printFamilyInfo();

//        EX 02
//        StudentVo test= new StudentVo();
//        test.init();

//        EX 03
//        Example03 test3= new Example03();
//        System.out.println(test3.sumRandomNumbers());

//        Example04 test4= new Example04();
//        test4.init();

        Example05 test5= new Example05();
        test5.saveNumbers();
        test5.printPhoneNumbers();
    }
}
