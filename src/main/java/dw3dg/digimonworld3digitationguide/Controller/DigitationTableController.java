package dw3dg.digimonworld3digitationguide.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dw3dg.digimonworld3digitationguide.Handler.Handler;
import dw3dg.digimonworld3digitationguide.main.Main;
import dw3dg.digimonworld3digitationguide.model.Digitation;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DigitationTableController implements Initializable {

    Handler handler = new Handler();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button beendenButton;

    @FXML
    private TextField digitationsnameField;

    @FXML
    private TextField digitationsstufeField;

    @FXML
    private Button guidesButton;

    @FXML
    private TextField partnernameField;

    @FXML
    private Button suchenButton;

    @FXML
    private TableView<Digitation> tableView;

    @FXML
    private TableColumn<Digitation, String> partnernameColumn;

    @FXML
    private TableColumn<Digitation, String> digitationsnameColumn;

    @FXML
    private TableColumn<Digitation, String> digitationsstufeColumn;

    @FXML
    private TableColumn<Digitation, String> vordigitation1Column;

    @FXML
    private TableColumn<Digitation, String> level1Column;

    @FXML
    private TableColumn<Digitation, String> vordigitation2Column;

    @FXML
    private TableColumn<Digitation, String> level2Column;

    @FXML
    private TableColumn<Digitation, String> wertebedingungColumn;

    @FXML
    private TextField vordigitationField;

    @FXML
    public void suchenButton_Action(ActionEvent event) {
        if (partnernameField.getText().isEmpty() && digitationsnameField.getText().isEmpty() && digitationsstufeField.getText().isEmpty() && vordigitationField.getText().isEmpty() && vordigitationField.getText().isEmpty()) {
            tableView.getItems().setAll(handler.getAllDigitationList());
        } else {
            String partnername = partnernameField.getText();
            String digitationsname = digitationsnameField.getText();
            String digitationsstufe = digitationsstufeField.getText();
            String vordigitation1 = vordigitationField.getText();
            String vordigitation2 = vordigitationField.getText();
            tableView.getItems().setAll(handler.getDigitationList(partnername, digitationsname, digitationsstufe, vordigitation1, vordigitation2));
        }
    }

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
        tableView.getItems().addAll(handler.getAllDigitationList());
    }
}
