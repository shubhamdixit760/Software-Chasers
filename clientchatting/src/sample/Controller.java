package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller{


    @FXML
    public TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private Button send;
    @FXML
    private AnchorPane topContainer;
    @FXML
    private ImageView back;
    @FXML
    private ImageView profile;
    @FXML
    private ImageView menu;
    @FXML
    private ImageView call;
    @FXML
    private ImageView video;

        public void closeEvent ()
        {
            if (back.isPressed())
                System.exit(1);
        }

    public void send() {
            String s = textField.getText();
            textField.setText(s);
            textArea.appendText(s+"\n");
            textField.clear();
    }
    public void setTextArea(String textArea) {
        this.textArea.appendText(textArea);
    }
    public String getTextField() {
        return textField.getText();
    }

}
