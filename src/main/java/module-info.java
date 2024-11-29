module dw3dg.digimonworld3digitationguide {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports dw3dg.digimonworld3digitationguide.main;
    opens dw3dg.digimonworld3digitationguide.main to javafx.fxml;
    exports dw3dg.digimonworld3digitationguide.Handler;
    opens dw3dg.digimonworld3digitationguide.Handler to javafx.fxml;
    exports dw3dg.digimonworld3digitationguide.Controller;
    opens dw3dg.digimonworld3digitationguide.Controller to javafx.fxml;
    exports dw3dg.digimonworld3digitationguide.model;
    opens dw3dg.digimonworld3digitationguide.model to javafx.base;
    exports dw3dg.digimonworld3digitationguide.repos;
    opens dw3dg.digimonworld3digitationguide.repos to javafx.base;
}