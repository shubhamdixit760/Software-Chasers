package revengelive;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomePageController {
    @FXML
    private Button login;
    @FXML
    private Button register;
    @FXML
    public void loginAction(ActionEvent event)throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        Scene scene = new Scene(root, 1500, 700);
        primaryStage.setTitle("LoginPage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @FXML
    public void registerAction(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("RegisterPage.fxml"));
        Scene scene = new Scene(root, 1500, 700);
        primaryStage.setTitle("RegisterPage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
