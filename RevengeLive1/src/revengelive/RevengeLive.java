package revengelive;
import java.io.*;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;
public class RevengeLive extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception  {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(root, 1500, 700);
        primaryStage.setTitle("Login page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
