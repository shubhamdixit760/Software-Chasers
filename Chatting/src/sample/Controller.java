package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import java.awt.event.MouseAdapter;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    static ServerSocket ss;
    static Socket soc;
    static BufferedReader In;
    static PrintWriter Out;

    @FXML public TextArea textArea;
    @FXML private TextField textField;
    @FXML private Button send;
    @FXML private AnchorPane topContainer;
    @FXML private ImageView back;
    @FXML private ImageView profile;
    @FXML private ImageView menu;
    @FXML private ImageView call;
    @FXML private ImageView video;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void closeEvent()
    {
        if(back.isPressed())
        System.exit(1);
    }

//
    public void send()
    {
//        String s = textField.getText();
//        try {
////            ss = new ServerSocket(9876);
////            soc = ss.accept();
////            System.out.println("connected");
//            Out = new PrintWriter(soc.getOutputStream(), true);
//            Out.println("Server: "+s);
//            textArea.appendText("Server: "+s+"\n");
//            textField.clear();
////            BufferedReader In = new BufferedReader(new InputStreamReader(Controller.soc.getInputStream()));
////            String str;
////            str = In.readLine();
////            textArea.appendText(str + "\n");
////            soc.close();
////            ss.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
   }

}
