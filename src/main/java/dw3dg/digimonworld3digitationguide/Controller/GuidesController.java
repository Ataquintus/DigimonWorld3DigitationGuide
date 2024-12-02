package dw3dg.digimonworld3digitationguide.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import dw3dg.digimonworld3digitationguide.Handler.Handler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuidesController implements Initializable {

    Handler handler = new Handler();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private Button beendenButton;

    @FXML
    private Button partnerQuestButton;

    @FXML
    private TextField partnerQuestField;

    @FXML
    private Button completeGuideButton;

    @FXML
    private TextArea textAreaField;

    @FXML
    public void backButton_Action(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void completeGuideButton_Action(ActionEvent event) {
        textAreaField.setText(handler.getCompleteGuide());
    }

    @FXML
    public void partnerQuestButton_Action(ActionEvent event) {
        textAreaField.setText(handler.getPartnerQuest(partnerQuestField.getText()));
    }

    @FXML
    public void beendenButton_Action(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {}
}