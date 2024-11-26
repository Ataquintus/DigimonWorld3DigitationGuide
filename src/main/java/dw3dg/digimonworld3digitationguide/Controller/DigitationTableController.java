package dw3dg.digimonworld3digitationguide.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import dw3dg.digimonworld3digitationguide.Handler.Handler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DigitationTableController {

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
    private TableView<?> tableView;

    @FXML
    private TextField vordigitationField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       tableView.getItems().addAll(handler.getAllDigitationList());
    }
}
