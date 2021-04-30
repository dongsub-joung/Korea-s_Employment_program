//https://sites.google.com/site/freecodestoeveryone/java-programming/networkingsocket-programmin/simple-parity-check

/*
simple parity programm
this is reciever
reciver get the packet
extract the parity bit and message
recalculate parity bit and compare it
*/

import java.io.*;
import java.net.*;
public class Reciever
{
    ServerSocket RecieverSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message,parity1,parity2;
    Reciever(){}

    int parity(String str)
    {
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
            System.out.println("server>" + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    void run()
    {
        try(  BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); )
        {
            //1. creating a server socket
            RecieverSocket = new ServerSocket(2004, 10);
            //2. Wait for connection
            System.out.println("Waiting for connection");
            connection = RecieverSocket.accept();
            System.out.println("Connection received from " + connection.getInetAddress().getHostName());
            //3. get Input and Output streams
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            sendMessage("Connection successful ...");
            //4. The two parts communicate via the input and output streams
            //do{
            try{
                message = (String)in.readObject();
                System.out.println("client>" + message);
                parity1=message.substring(0,1);
                parity2=String.valueOf(parity(message.substring(1)));
                message=(parity1.equals(parity2))?"correct data":"corrupted data";
                sendMessage(message);
            }
            catch(ClassNotFoundException classnot){
                System.err.println("Data received in unknown format");
            }
            //}while(!message.equals("bye"));
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                RecieverSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Reciever server = new Reciever();
        while(true){
            server.run();
        }
    }
}