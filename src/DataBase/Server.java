package DataBase;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(6000);
            while(true){
                System.out.println("................");
                Socket socket = serverSocket.accept();
                System.out.println("Connected.......");
                ServerThread st = new ServerThread(socket);
                st.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
