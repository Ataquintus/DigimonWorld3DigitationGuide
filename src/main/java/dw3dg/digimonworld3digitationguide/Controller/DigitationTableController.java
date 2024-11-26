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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    private TextField vordigitationField;

    @FXML
    public void suchenButton_Action(ActionEvent event) {
        String partnername = partnernameField.getText();
        String digitationsname = digitationsnameField.getText();
        String digitationsstufe = digitationsstufeField.getText();
        String vordigitation1 = vordigitationField.getText();
        String vordigitation2 = vordigitationField.getText();
        tableView.getItems().setAll(handler.getDigitationList(partnername, digitationsname, digitationsstufe, vordigitation1, vordigitation2));
    }

    public void guidesButton_Action(ActionEvent event) {
        Platform.runLater(new Runnable() {
            public void run() {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("guides.fxml"));
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
        tableView.getItems().addAll(handler.getAllDigitationList());
    }
}
