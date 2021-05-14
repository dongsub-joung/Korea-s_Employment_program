import java.util.*;

public class ex05_14 {
    public void Exam061(){
        final int LEN= 5, NUMBER=5;
        int[] nums= {9, 5, 6, 7, 3};
        for (int a:nums){
            if (a == NUMBER) System.out.println("True");
            else System.out.println("False");
        }
    }

    public void Example064(){
        final int TIME= 14400;
        int after= 0, line= 1000;

        System.out.println( (TIME % line)
                + "Min, "
                + (TIME % line)
                + "Sec");
    }

    public void Example066(){
        List arr1= new ArrayList(), arr2= new ArrayList();
        arr1.add(10); arr1.add(20); arr1.add(30);
        arr2.add(40); arr2.add(50); arr2.add(60);
        Iterator itr1= arr1.iterator();
        Iterator itr2= arr2.iterator();
        for (;itr1.hasNext();) {
            int a= (int) itr1.next();
            int b= (int) itr2.next();
            System.out.println(a+b);
        }
    }

    public void Exam069(){
        ArrayList list= new ArrayList();
        list.add('A'); list.add('C'); list.add('D'); list.add('H'); list.add('Z');
        Iterator itr= list.iterator();
        int len= list.size();
        String[] result= new String[len];
        for (int i = 0; i < len; i++) {
            result[i]= (String) itr.next();
        }
    }

    public void Exam070(){
        ArrayList list= new ArrayList();
        list.add(12); list.add(20); list.add(12); list.add(25); list.add(60);
        Set set= new HashSet();
        set.addAll(list);
        Iterator itr= set.iterator();
        for (; itr.hasNext(); ) System.out.println((int) itr.next()+" ");
    }
}
