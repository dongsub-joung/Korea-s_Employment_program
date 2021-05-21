import java.io.File;
import java.io.FileReader;

public class java0521 {
    private void Exam072(){
        final String MAIN_PATH= System.getProperty("user.dir");
        final String PATH= MAIN_PATH+"/13_Week/readOnly.txt";
        System.out.println(PATH);
    }

    public static void main(String[] args) {
        new java0521().Exam072();
    }
}
