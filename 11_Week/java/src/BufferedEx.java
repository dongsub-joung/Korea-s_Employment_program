// buffered Vs normal
// https://eskeptor.tistory.com/77

import java.io.*;
import java.util.Date;

public class BufferedEx {

    final static String PATH = "C:\\Users\\Administrator\\IdeaProjects\\Korea-s_Employment_program\\11_Week\\java\\data\\",
            LOAD = PATH + "data.txt",           // 복사 대상의 파일
            SAVE_BOS = PATH + "n_output.txt",   // 버퍼링을 이용하여 저장할 경로 
            SAVE_OS = PATH + "output.txt";      // 일반적인 방법으로 저장할 경로

    public static void main( String[] args ) {
        long timer_start_buff = 0L, timer_end_buff = 0L;
        long timer_start_normal = 0L, timer_end_normal = 0L;

        try (
                BufferedInputStream bis = new BufferedInputStream( new FileInputStream( LOAD ) );
                BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream( SAVE_BOS ) );
                InputStream is = new FileInputStream( LOAD );
                OutputStream os = new FileOutputStream( SAVE_OS )
        ) {
            int res;    // 파일을 불러와서 임시적으로 저장할 변수
            Date timer;

//            Buffer
            timer = new Date( );
            timer_start_buff = timer.getTime( );

            while ( ( res = bis.read( ) ) != -1 ) bos.write( res );

            timer = new Date( );
            timer_end_buff = timer.getTime( );

//            Normal
            timer = new Date( );
            timer_start_normal = timer.getTime( );

            while ( ( res = is.read( ) ) != -1 ) os.write( res );

            timer = new Date( );
            timer_end_normal = timer.getTime( );
        }
        catch ( IOException e ) {
            e.printStackTrace( );
        }
        finally {
            System.out.printf( "Buffered 복사 시간: %d\n", ( timer_end_buff - timer_start_buff ) );
            System.out.printf( "Normal 복사 시간: %d\n", ( timer_end_normal - timer_start_normal ) );
        }
    }
}
