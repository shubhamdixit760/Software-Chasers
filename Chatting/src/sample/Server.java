package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket)
    {
        this.serverSocket=serverSocket;
    }

    public void run() {
        Socket socket;
        System.out.println("Server Started");
        while(true)
        {
            try
            {
                socket = serverSocket.accept();
                Thread t1 = new Thread(new HandleServer(socket));
                // t1.setPriority(10);
                // t.setPriority(8);
                t1.start();
                Thread t = new Thread(new HandleClient(socket));
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
