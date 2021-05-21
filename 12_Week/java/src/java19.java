import java.io.*;

public class java19 {
    public void ex01(){
        final String PATH= System.getProperty("user.dir") + "/12_Week/DATA";
        final String INPUT= PATH + "/text1.txt";
        final String OUTPUT= PATH + "/output1.txt";

//        fileOutputStream= new FileOutputStream(OUTPUT)
        try(FileInputStream fileInputStream= new FileInputStream(new File(INPUT));
            FileOutputStream fileOutputStream= new FileOutputStream(new File(OUTPUT));) {
            fileInputStream.transferTo(fileOutputStream);
        } catch (Exception e){
            System.out.println(e+"err");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new java19().ex01();
    }
}
