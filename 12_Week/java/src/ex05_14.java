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

    private void addInteger(List<Integer> list, int ...numbers){
        for (int num : numbers) {
            list.add(num);
        }
    }
    public void Example066(){
        List<Integer> arr1= new ArrayList<>(),
                arr2= new ArrayList<>();
        addInteger(arr1, 10,20,30);
        addInteger(arr2,40,50,60);
        Iterator<Integer> itr1= arr1.iterator(),
                itr2= arr2.iterator();
        while (itr1.hasNext()) {
            int a= itr1.next();
            int b= itr2.next();
            System.out.println(a+b);
        }
    }

    private void addChars(ArrayList<Character> list, char ...chars){
        for (char c : chars) list.add(c);
    }
    public void Exam069(){
        ArrayList<Character> list= new ArrayList<>();
        addChars(list,'A','C','D','H','Z');
        Iterator itr= list.iterator();
        int len= list.size();
        String[] result= new String[len];
        for (int i = 0; i < len; i++) {
            result[i]= (String) itr.next();
        }
    }

    public void Exam070(){
        ArrayList<Integer> list= new ArrayList<Integer>();
        addInteger(list, 12, 20, 12, 25, 60);
        Set<Integer> set = new HashSet<>(list);
        for (Integer integer : set) {
            System.out.println(integer + " ");
        }
    }

    public static void main(String[] args) {

    }
}
