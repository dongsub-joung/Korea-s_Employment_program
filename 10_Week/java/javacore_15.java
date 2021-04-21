import java.rmi.MarshalledObject;
import java.util.Iterator;
import java.util.Vector;

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



public class javacore_15 {
    public static void main(String[] args) {
        PersonVo te= new PersonVo();
        te.printFamilyInfo();
    }
}
