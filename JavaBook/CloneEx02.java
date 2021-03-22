import java.util.Arrays;

public class CloneEx02 {
    public static void main(String[] args) {
        int[] i_arr= {1,2,3,4,5};
        int[] i_clone_arr= i_arr.clone();

//        *복사한 배열은 기존 배열과 같은 객체이다.
//        앝은 복사
        i_clone_arr[0]= 6;
        System.out.println(Arrays.toString(i_arr));
        System.out.println(Arrays.toString(i_clone_arr));
    }
}
