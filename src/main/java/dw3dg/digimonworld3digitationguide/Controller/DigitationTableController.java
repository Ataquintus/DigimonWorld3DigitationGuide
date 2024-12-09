package dw3dg.digimonworld3digitationguide.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dw3dg.digimonworld3digitationguide.Handler.Handler;
import dw3dg.digimonworld3digitationguide.main.Main;
import dw3dg.digimonworld3digitationguide.model.Digitationsbedingung;
import dw3dg.digimonworld3digitationguide.model.Partner;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class DigitationTableController implements Initializable {

    Handler handler = new Handler();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox partnernameComboBox;

    @FXML
    private ComboBox digitationsnameComboBox;

    @FXML
    private ComboBox digitationsstufeComboBox;

    @FXML
    private ComboBox vordigitationComboBox;

    @FXML
    private TableView<Digitationsbedingung> tableView;

    @FXML
    private TableColumn<Digitationsbedingung, String> partnernameColumn;

    @FXML
    private TableColumn<Digitationsbedingung, String> digitationsnameColumn;

    @FXML
    private TableColumn<Digitationsbedingung, String> digitationsstufeColumn;

    @FXML
    private TableColumn<Digitationsbedingung, String> vordigitation1Column;

    @FXML
    private TableColumn<Digitationsbedingung, String> level1Column;

    @FXML
    private TableColumn<Digitationsbedingung, String> vordigitation2Column;

    @FXML
    private TableColumn<Digitationsbedingung, String> level2Column;

    @FXML
    private TableColumn<Digitationsbedingung, String> wertebedingungColumn;

    @FXML
    private Button suchenButton;

    @FXML
    private Button guidesButton;

    @FXML
    private Button beendenButton;

    @FXML
    public void suchenButton_Action() {
        if (partnernameComboBox.getValue() == null && digitationsnameComboBox.getValue() == null && digitationsstufeComboBox.getValue() == null && vordigitationComboBox.getValue() == null && vordigitationComboBox.getValue() == null) {
            tableView.getItems().setAll(handler.getAllDigitationsbedingung());
        } else {
            String partnername = String.valueOf(partnernameComboBox.getValue());
            String digitationsname = String.valueOf(digitationsnameComboBox.getValue());
            String digitationsstufe = String.valueOf(digitationsstufeComboBox.getValue());
            String vordigitation1 = String.valueOf(vordigitationComboBox.getValue());
            String vordigitation2 = String.valueOf(vordigitationComboBox.getValue());
            tableView.getItems().setAll(handler.getDigitationsbedingung(partnername, digitationsname, digitationsstufe, vordigitation1, vordigitation2));
        }
    }

    @FXML
    public List<String> partnernameComboBoxMenu() {
        List<String> partnerList = new ArrayList<>();
        for (Partner partner : handler.getAllPartner()) {
            partnerList.add(partner.getPartnername());
        }
        return partnerList;
    }

    @FXML
    public void partnernameComboBoxAutofill() {
        List<String> partnerList = new ArrayList<>();
        for (Partner partner : handler.getAllPartner()) {
            if (partner.getPartnername().contains(partnernameComboBox.getEditor().getText())) {
                partnerList.add(partner.getPartnername());
            }
        }
        partnernameComboBox.getItems().setAll(partnerList);
    }
    
    @FXML
    public List<String> digitationsnameComboBoxMenu() {
        return handler.getAllDigitation();
    }

    @FXML
    public void digitationsnameComboBoxAutofill() {
        List<String> digitationList = new ArrayList<>();
        for (String digitation : handler.getAllDigitation()) {
            if (digitation.contains(String.valueOf(digitationsnameComboBox.getValue()))) {
                digitationList.add(digitation);
            }
        }
        digitationsnameComboBox.getItems().setAll(digitationList);
    }

    @FXML
    public List<String> digitationsstufeComboBoxMenu() {
        List<String> digitationsstufeList = new ArrayList<>();
        digitationsstufeList.addAll(handler.getAllDigitationsstufe());
        digitationsstufeList.removeFirst();
        return digitationsstufeList;
    }

    @FXML
    public void digitationsstufeComboBoxAutofill() {
        List<String> stufenList = new ArrayList<>();
        for (String stufe : handler.getAllDigitationsstufe()) {
            if (stufe.contains(String.valueOf(digitationsstufeComboBox.getValue()))) {
                stufenList.add(stufe);
            }
        }
        digitationsstufeComboBox.getItems().setAll(stufenList);
    }

    @FXML
    public List<String> vordigitationComboBoxMenu() {
        return handler.getAllVordigitation();
    }

    @FXML
    public void vordigitationComboBoxAutofill() {
        List<String> vordigitationList = new ArrayList<>();
        for (String vordigitation : handler.getAllDigitation()) {
            if (vordigitation.contains(String.valueOf(vordigitationComboBox.getValue()))) {
                vordigitationList.add(vordigitation);
            }
        }
        vordigitationComboBox.getItems().setAll(vordigitationList);
    }

    @FXML
    public void guidesButton_Action(ActionEvent event) {
        Platform.runLater(new Runnable() {
            public void run() {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/dw3dg/digimonworld3digitationguide/guides.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 800, 600);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setTitle("Digimon World 3 Digitation Guide");
                stage.setScene(scene);
                stage.show();
            }
        });
    }

    @FXML
    public void beendenButton_Action(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partnernameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getPartnername()));
        digitationsnameColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDigitationsname()));
        digitationsstufeColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDigitationsstufe()));
        vordigitation1Column.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getVordigitation1()));
        level1Column.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getLevel1()));
        vordigitation2Column.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getVordigitation2()));
        level2Column.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getLevel2()));
        wertebedingungColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getWertebedingung()));
        tableView.getItems().addAll(handler.getAllDigitationsbedingung());
        partnernameComboBox.getItems().addAll(partnernameComboBoxMenu());
        digitationsnameComboBox.getItems().addAll(digitationsnameComboBoxMenu());
        digitationsstufeComboBox.getItems().addAll(digitationsstufeComboBoxMenu());
        vordigitationComboBox.getItems().addAll(vordigitationComboBoxMenu());
    }
}
