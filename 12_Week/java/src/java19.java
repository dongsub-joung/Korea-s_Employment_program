import java.io.*;
import java.util.ArrayList;

public class java19 {
    final String PATH= System.getProperty("user.dir") + "/12_Week/DATA";
    final String INPUT= PATH + "/text1.txt";
    // transferTo buffer size= 8192

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

    public void ex03(){
        final String OUTPUT= PATH + "/output3.txt";

        try(FileReader fileReader= new FileReader(new File(INPUT));
            FileWriter fileWriter= new FileWriter(new File(OUTPUT))) {
            fileReader.transferTo(fileWriter);
        } catch (Exception e) {
            System.out.println(e + "err");
            e.printStackTrace();
        }
    }

    //        BufferedInputStream: byte,array size= readUnsignedShort * 2
    public void ex04(){
        final String INPUTS= PATH + "/word.txt";
        ArrayList<String> strs= new ArrayList<>();

        try(FileReader fileReader= new FileReader(new File(INPUTS));
            BufferedReader bufferedReader= new BufferedReader(fileReader)) {
            String line= "";
            while ((line= bufferedReader.readLine()) != null){
                strs.add(line);
            }
            final int MAX= strs.size();
            int selected_index= (int) (Math.random()*MAX);

            System.out.println(strs.get(selected_index));
        } catch (Exception e) {
            System.out.println(e + "err");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        java19 j19= new java19();
//        j19.ex01();
//        j19.ex02();
//        j19.ex03();
        j19.ex04();
    }
}
