package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HandleServer implements Runnable {
    private Socket socket;

    public HandleServer(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
            new HandleServer(socket).sendMessage(socket, bufferReader);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Already offline");
        }
    }

    public  void sendMessage(Socket socket , BufferedReader bufferReader) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Enter Message:");
        while(true)
        {
//            System.out.println("1 to exit");
//            int ch = Integer.parseInt(bufferReader.readLine());
//            if(ch==1)
//            {
//                objectOutputStream.writeObject(new Message("(Status)","Server"));
//                objectOutputStream.flush();
//                break;
//            }
            //System.out.println("Enter Message:");
            String text = bufferReader.readLine();
            Message message = new Message(text,"Server");
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();

        }
    }
}

