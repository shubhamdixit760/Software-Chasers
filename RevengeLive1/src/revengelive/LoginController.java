package revengelive;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class LoginController {

     @FXML
    private PasswordField txtpassword;

    @FXML
    private Button login;

    @FXML
    private TextField txtusername;
    
     Connection con;
     PreparedStatement pst;
     Statement stmt;

    @FXML
    void loginResponse(ActionEvent event) throws IOException,ClassNotFoundException , SQLException, Exception {
        
        String username = txtusername.getText();
        String password = getMd5(txtpassword.getText());
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/userdata","root","");
        
//        stmt = con.createStatement();
        
        String query = "SELECT username , password FROM user where username = ?";
        pst = con.prepareStatement(query);
        pst.setString(1,username);
        
        
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
//        String UserName = rs.getString("username");
        String Password = rs.getString("password");
          if(password.equals(Password)) {
             Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Streamer.fxml"));
        Scene scene = new Scene(root, 1500, 700);
        primaryStage.setTitle("StreamerPage");
        primaryStage.setScene(scene);
        primaryStage.show();
          }
          else {
               JOptionPane.showMessageDialog(null,"Invalid Password !!!");
          }
        }
        else {
           JOptionPane.showMessageDialog(null,"Username not Found !!!");
        }
        
    }
    
       public static String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }
}
