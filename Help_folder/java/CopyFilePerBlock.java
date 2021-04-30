// 출처: https://hackeen.tistory.com/15?category=606083 [hackeen]

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFilePerBlock
{
//    Example path
    final String SRC= "C:\\Intel\\0.png";
    final String DEST= "d:\\picture.png";

    public static void main(String[] args) throws FileNotFoundException
    {
        File src= new File(SRC);
        File dest= new File(DEST);

        try ( FileInputStream fi= new FileInputStream(src);
              FileOutputStream fo= new FileOutputStream(dest) )
        {
            byte[] buf= new byte[1024 * 10];
            while (true)
            {
                int n= fi.read(buf);
                fo.write(buf, 0, n);
                if (n < buf.length) break;
            }
            System.out.printf("[%s] 를 [%s]에 복사하였습니다.", src.getPath(), dest.getPath());
        }
        catch (IOException e) {  System.out.printf("IO Exception"); }
    }
}