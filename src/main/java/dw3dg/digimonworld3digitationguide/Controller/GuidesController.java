package dw3dg.digimonworld3digitationguide.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import dw3dg.digimonworld3digitationguide.Handler.Handler;
import dw3dg.digimonworld3digitationguide.model.Guide;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private Button guideButton;

    @FXML
    private TextArea textAreaField;

    @FXML
    private ComboBox guideComboBox;

    @FXML
    private Button aktPlusButton;

    @FXML
    private Button aktMinusButton;

    @FXML
    public void backButton_Action(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void guideButton_Action(ActionEvent event) {
        textAreaField.setText(handler.getGuide(guideComboBox.getValue()).getGuide());
    }

    @FXML
    public void aktPlusButton_Action(ActionEvent event) {
        textAreaField.setText(handler.getNextAkt().getGuide());
    }

    @FXML
    public void aktMinusButton_Action(ActionEvent event) {
        textAreaField.setText(handler.getPreviousAkt().getGuide());
    }

    @FXML
    public void partnerQuestButton_Action(ActionEvent event) {
        textAreaField.setText(handler.getPartnerQuest(partnerQuestField.getText()).getQuest());
    }

    @FXML
    public void beendenButton_Action(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {}
}