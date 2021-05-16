import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class java19 {
    private void ex01(){
        final String PATH= "C:\\Users\\Administrator\\IdeaProjects\\Korea-s_Employment_program\\12_Week\\DATA\\";
        final String INPUT= PATH + "text1.txt";
        final String OUTPUT= PATH + "output1.txt";

        try( FileInputStream fileInputStream= new FileInputStream(INPUT);
             FileOutputStream fileOutputStream= new FileOutputStream(OUTPUT)) {


        } catch (FileNotFoundException e) {
            System.out.println("path err");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO err");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Unexpected err");
            e.printStackTrace();
        }

    }
}
