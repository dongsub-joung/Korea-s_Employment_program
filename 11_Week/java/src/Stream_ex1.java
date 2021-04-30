import java.io.*;
import java.util.Arrays;

class FileStream {
    final String DATA = "C:\\Users\\Administrator\\IdeaProjects\\Korea-s_Employment_program\\11_Week\\java\\data\\data.txt";

    //    Do I/O data from file.
    void ex01( String[] args ) {
        try (
                FileInputStream fis = new FileInputStream( args[0] );
                FileOutputStream fos = new FileOutputStream( args[1] )
        ) {
            int data = 0;
            while ( ( data = fis.read( ) ) != -1 ) {
                fos.write( data );
            }
        }
        catch ( IOException e ) {
            e.printStackTrace( );
        }
    }

    void ex02( ) {
        try ( FileOutputStream fos = new FileOutputStream( DATA ) ) {
            byte[] read_buffer = new byte[1024];

            String str = "asdfasdf";
            read_buffer = str.getBytes( );
            fos.write( read_buffer, 0, read_buffer.length );

            System.out.println( "Complete" );
        }
        catch ( IOException e ) {
            System.out.println( e + "IO Err" );
        }
    }

    void ex03( ) {
        try ( FileInputStream fin = new FileInputStream( DATA ) ) {
            int code = 0;
            byte[] read_buffer = new byte[fin.available( )];
            while ( ( code = fin.read( read_buffer ) ) != -1 ) {
                System.out.println( ( char ) code );
            }
            System.out.println( new String( read_buffer ) );
            System.out.println( "Complete" );
        }
        catch ( IOException e ) {
            e.printStackTrace( );
        }
    }
}

public class Stream_ex1 {
    //    Stream for byte-Base. Do I/O at data on byte array.
    void ex01( ) {
        byte[] msrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        byte[] result = null;

        ByteArrayInputStream ba_in = null;
        ByteArrayOutputStream ba_out = null;

        ba_in = new ByteArrayInputStream( msrc );
        ba_out = new ByteArrayOutputStream( );
        int temp = 0;

        while ( ( temp = ba_in.read( ) ) != -1 ) ba_out.write( temp );
        result = ba_out.toByteArray( );
        System.out.println( Arrays.toString( result ) );
    }

    void ex02( ) {
        byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = null;
        input = new ByteArrayInputStream( inSrc );
        ByteArrayOutputStream output = null;
        output = new ByteArrayOutputStream( );

        try {
            while ( input.available( ) > 0 ) {
                input.read( temp );
                output.write( temp );
            }
        }
        catch ( IOException e ) {
        }

        outSrc = output.toByteArray( );

        System.out.printf( "Input Source : %s\n", Arrays.toString( inSrc ) );
        System.out.printf( "temp : %s\n", Arrays.toString( temp ) );
        System.out.printf( "Output Source : %s\n", Arrays.toString( outSrc ) );
    }

    public static void main( String[] args ) {
        Stream_ex1 e = new Stream_ex1( );
//        e.ex01();
//        e.ex02();

        FileStream e2 = new FileStream( );
//        e2.ex01(args);
//        e2.ex02( );
//        e2.ex03( );
    }
}