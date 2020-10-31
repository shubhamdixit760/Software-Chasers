/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revengelive;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

import java.security.*;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author Arun Nagar
 */
public class RegisterPageController {

    @FXML
    private Button register;
    
    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtname;

    @FXML
    private TextArea txtbio;

    @FXML
    private TextField txtusername;

    Connection con;
    PreparedStatement pst;
    Statement stmt;

   @FXML
    void RegisterResponse(ActionEvent event) throws IOException,ClassNotFoundException , SQLException {
        
        String name = txtname.getText();
        String username = txtusername.getText();
        String email = txtemail.getText();
        String bio = txtbio.getText();
        String password = getMd5(txtpassword.getText());
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/userdata","root","");
        
        if(!name.equals("") && !username.equals("") && !email.equals("") && !password.equals("")&& !bio.equals("")) {
        
//        stmt = con.createStatement();
//        
//        String query1 = "SELECT email FROM user WHERE email = Email";
//        
//        ResultSet rs = stmt.executeQuery(query1);
//        
        String query1 = "SELECT username , email FROM user where username = ? OR email = ?";
        pst = con.prepareStatement(query1);
        pst.setString(1,username);
        pst.setString(2,email);
        
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()) {
            String Username = rs.getString("username");
            String Email = rs.getString("email");
            
            if(!username.equals(Username) && !email.equals(Email) ) {
                 String query2 = "Insert into user values(?,?,?,?,?)";
        pst = con.prepareStatement(query2);
        pst.setString(1,name);
        pst.setString(2,username);
        pst.setString(3,Email);
        pst.setString(4,password);
        pst.setString(5,bio);
        
        int status = pst.executeUpdate();
        
        if(status==1) {
            JOptionPane.showMessageDialog(null,"User Registered Successfully !!!");
            
            txtname.setText("");
            txtusername.setText("");
            txtemail.setText("");
            txtpassword.setText("");
            txtbio.setText("");
            txtname.requestFocus();
                    
//        Stage primaryStage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("Streamer.fxml"));
//        Scene scene = new Scene(root, 1500, 700);
//        primaryStage.setTitle("StreamerPage");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        }
        else {
              JOptionPane.showMessageDialog(null,"User Registration Failed !!!");
        }
        }
        
        else {
               JOptionPane.showMessageDialog(null,"User already exists !!!"); 
        }
            
        }
        }
        else {
           
             JOptionPane.showMessageDialog(null,"Please Fill all the fields !!!");
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
