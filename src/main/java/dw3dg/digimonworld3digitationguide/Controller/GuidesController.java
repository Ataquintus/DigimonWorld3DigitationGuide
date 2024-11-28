package dw3dg.digimonworld3digitationguide.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dw3dg.digimonworld3digitationguide.main.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuidesController {

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
    private Button walkthroughButton;

    @FXML
    public void backButton_Action(ActionEvent event) {
//        Platform.runLater(new Runnable() {
//            public void run() {
//                Stage stage = new Stage();
//                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("digitationsTable.fxml"));
//                Scene scene = null;
//                try {
//                    scene = new Scene(fxmlLoader.load(), 800, 600);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                stage.setTitle("Digimon World 3 Digitation Guide");
//                stage.setScene(scene);
//                stage.show();
//            }
//        });
    }

    @FXML
    public void beendenButton_Action(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize(URL url, ResourceBundle rb) {}
}