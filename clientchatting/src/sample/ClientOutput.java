package sample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientOutput implements Runnable{

    private Socket socket;
    BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
    public ClientOutput(Socket socket) {
        this.socket=socket;
    }

    public void run() {

        try {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client created");
            System.out.println("Name: ");
            String name = bufferReader.readLine();
            new ClientOutput(socket).sendMessage(socket, name);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Already Offline");
        }
    }

    public  void sendMessage(Socket socket , String name) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Enter Message:");
        while(true)
        {
            String text = bufferReader.readLine();
                String from = name;
                Message message = new Message(text,from);
                objectOutputStream.writeObject(message);
                objectOutputStream.flush();

        }
    }
}

