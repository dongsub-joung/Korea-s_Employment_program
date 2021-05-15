import java.util.*;

public class java18 {
    Scanner sc = new Scanner(System.in);

    private void ex01() {
        Vector<Integer> vector = new Vector<>();
        int max = 0;
        while (true) {
            int num = sc.nextInt();
            vector.add(num);
            if (num == -1) break;
        }
        for (Iterator itr = vector.iterator(); itr.hasNext(); ) {
            int tmp;
            tmp = (int) itr.next();
            if (tmp > max) max = tmp;
        }
        System.out.println(max);
    }

    private void ex02() {
        ArrayList<String> chars1 = new ArrayList<>();
        double result = 0;
//        String[] strs= {"A", "C", "A", "B", "F", "D"};
        final double A = 4.0, B = 3.0, C = 2.0, D = 1.0, F = 0;
        final int CHARS = 6;
        for (int i = 0; i < CHARS; i++) {
            chars1.add(sc.next());
        }

        for (Iterator itr = chars1.iterator(); itr.hasNext(); ) {
            String str = (String) itr.next();
            switch (str) {
                case "A":
                    result += A;
                    break;
                case "B":
                    result += B;
                    ;
                    break;
                case "C":
                    result += C;
                    ;
                    break;
                case "D":
                    result += D;
                    ;
                    break;
                case "F":
                    result += F;
                    ;
                    break;
                default:
                    System.out.println("Out of Range");
                    break;
            }
        }

        System.out.println(result / CHARS);
    }
}
