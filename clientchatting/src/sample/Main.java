package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Main extends Application {


    private static Socket socket ;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        try {
            socket = new Socket("localhost",9996);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread(new ClientInput(socket));
        //t1.setPriority(10);
        //t.setPriority(8);
        t1.start();
        Thread t = new Thread(new ClientOutput(socket));
        t.start();
        launch(args);


    }
}
