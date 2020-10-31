package sample;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientInput implements Runnable{

    private Socket socket;
    ObjectInputStream objectInputStream;

    public ClientInput(Socket socket)
    {
        this.socket=socket;
        try {
            objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true)
        {
            try {
                Message message = (Message) objectInputStream.readObject();
                System.out.println(message);
            } catch (Exception e) {
               // e.printStackTrace();
                System.out.println("Offline");
                return;
            }
        }
    }
}

