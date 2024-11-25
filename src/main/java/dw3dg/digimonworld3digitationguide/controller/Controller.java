package dw3dg.digimonworld3digitationguide.controller;

import dw3dg.digimonworld3digitationguide.model.Digitation;
import dw3dg.digimonworld3digitationguide.repos.DBSteuerung;

import java.util.List;

public class Controller {

    private DBSteuerung dw3dg;

    public Controller() {
        this.dw3dg = new DBSteuerung("dw3dg.db");
    }

    public List<Digitation> getDigitationList(String partnername) {
        return dw3dg.getDigitation(partnername);
    }

    public void close() {
        dw3dg.close();
    }
}
