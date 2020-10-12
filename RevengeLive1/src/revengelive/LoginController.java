package revengelive;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button login;

    @FXML
    void loginResponse(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Streamer.fxml"));
        Scene scene = new Scene(root, 1500, 700);
        primaryStage.setTitle("StreamerPage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
