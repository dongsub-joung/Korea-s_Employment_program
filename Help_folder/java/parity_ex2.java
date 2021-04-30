//https://sites.google.com/site/freecodestoeveryone/java-programming/networkingsocket-programmin/simple-parity-check
/*
    Simple parity programm
    this is sender
    data will send with parity bit
    packet=paritybit+message
*/
import java.io.*;
import java.net.*;
public class Sender
{
    Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    boolean check=true;
    Sender(){}

    void run()
    {
        try( BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); )
        {
            //1. creating a socket to connect to the server
            requestSocket = new Socket("localhost", 2004);
            System.out.println("Connected to localhost in port 2004");
            //2. get Input and Output streams
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
            //3: Communicating with the server
            message = (String)in.readObject();
            System.out.println("server>" + message);

            do{
                try{
                    System.out.println("Enter binary number to send:");
                    message = br.readLine();
                    if(checkbinary(message)){
                        check=false;
                        System.out.println("Parity bit >"+parity(message) );
                        message=String.valueOf(parity(message)).concat(message);
                        sendMessage(message);
                    }else{
                        System.out.println("Entered data is not in binary format.\n Re" );
                    }
                }
                catch(Exception classNot){
                    System.err.println("data received in unknown format");
                }
            }while(check);
            try{
                System.out.println("Data sent" );
                message = (String)in.readObject();
                System.out.println("server>" + message);
            }catch(Exception e){}

        }
        catch(UnknownHostException unknownHost){
            System.err.println("You are trying to connect to an unknown host!");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        catch(Exception e){}
        finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                requestSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }

    boolean checkbinary(String str){
        int n=Integer.valueOf(str);
        int len=str.length();
        int sum=0;
        for(int i=0;i<len;i++){
            sum=n%10;
            if(sum>1) return false;
        }
        return true;

    }
    int parity(String str){
        int n=Integer.valueOf(str);
        int len=str.length();
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=n%10;
            n/=10;
        }
        return (sum%2);

    }
    void sendMessage(String msg)
    {
        try{
            out.writeObject(msg);
            out.flush();
            System.out.println("client>" + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        Sender client = new Sender();
        client.run();
    }
}