import java.io.*;

public class java19 {
    final String PATH= System.getProperty("user.dir") + "/12_Week/DATA";
    final String INPUT= PATH + "/text1.txt";

    public void ex01(){
        final String OUTPUT= PATH + "/output1.txt";

        try(FileInputStream fileInputStream= new FileInputStream(new File(INPUT));
            FileOutputStream fileOutputStream= new FileOutputStream(new File(OUTPUT));) {
            fileInputStream.transferTo(fileOutputStream);
        } catch (Exception e){
            System.out.println(e+"err");
            e.printStackTrace();
        }
    }

    public void ex02(){
        final String OUTPUT= PATH + "/output2.txt";

        try (BufferedInputStream bufferedInputStream= new BufferedInputStream(new FileInputStream(new File(INPUT)));
            BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(new FileOutputStream(new File(OUTPUT)))) {
            bufferedInputStream.transferTo(bufferedOutputStream);
        } catch (Exception e) {
            System.out.println(e + "err");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new java19().ex02();
    }
}
