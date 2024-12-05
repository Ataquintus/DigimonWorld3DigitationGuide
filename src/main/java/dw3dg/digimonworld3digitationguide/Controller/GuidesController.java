package dw3dg.digimonworld3digitationguide.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dw3dg.digimonworld3digitationguide.Handler.Handler;
import dw3dg.digimonworld3digitationguide.model.Guide;
import dw3dg.digimonworld3digitationguide.model.Partner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private ComboBox partnerQuestComboBox;

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
        if (guideComboBox.getValue() == null) {
            showAlert("Fehler", "Bitte wähle einen Akt aus der Liste aus.");
            return;
        }
        textAreaField.setText(handler.getGuide(Integer.parseInt(String.valueOf(guideComboBox.getValue()))).getGuide());
    }

    @FXML
    public void aktPlusButton_Action(ActionEvent event) {
        if (guideComboBox.getValue() == null) {
            showAlert("Fehler", "Bitte wähle einen Akt aus der Liste aus.");
            return;
        }
        int akt = Integer.parseInt(String.valueOf(guideComboBox.getValue()));
        akt++;
        if (akt >= 33) {
            akt = 33;
        }
        guideComboBox.setValue(akt);
        textAreaField.setText(handler.getGuide(akt).getGuide());
    }

    @FXML
    public void aktMinusButton_Action(ActionEvent event) {
        if (guideComboBox.getValue() == null) {
            showAlert("Fehler", "Bitte wähle einen Akt aus der Liste aus.");
            return;
        }
        int akt = Integer.parseInt(String.valueOf(guideComboBox.getValue()));
        akt--;
        if (akt <= 1) {
            akt = 1;
        }
        guideComboBox.setValue(akt);
        textAreaField.setText(handler.getGuide(akt).getGuide());
    }

    @FXML
    public void partnerQuestButton_Action(ActionEvent event) {
        if (partnerQuestComboBox.getValue() == null) {
            showAlert("Fehler", "Bitte wähle einen Akt aus der Liste aus.");
            return;
        }
        textAreaField.setText(handler.getPartner(String.valueOf(partnerQuestComboBox.getValue())).getQuest());
    }

    @FXML
    public List<Integer> guideComboBoxMenu() {
        List<Integer> aktList = new ArrayList<>();
        for (Guide g : handler.getFullGuide()) {
            aktList.add(g.getGuideID());
        }
        return aktList;
    }

    @FXML
    public List<String> partnerQuestComboBoxMenu() {
        List<String> partnerList = new ArrayList<>();
        for (Partner p : handler.getAllPartner()) {
            partnerList.add(p.getPartnername());
        }
        return partnerList;
    }

    @FXML
    public void beendenButton_Action(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        guideComboBox.getItems().addAll(guideComboBoxMenu());
        partnerQuestComboBox.getItems().addAll(partnerQuestComboBoxMenu());
    }
}