module dw3dg.digimonworld3digitationguide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports dw3dg.digimonworld3digitationguide.main;
    opens dw3dg.digimonworld3digitationguide.main to javafx.fxml;
    exports dw3dg.digimonworld3digitationguide.controller;
    opens dw3dg.digimonworld3digitationguide.controller to javafx.fxml;
}