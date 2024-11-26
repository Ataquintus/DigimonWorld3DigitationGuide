package dw3dg.digimonworld3digitationguide.Handler;

import dw3dg.digimonworld3digitationguide.model.Digitation;
import dw3dg.digimonworld3digitationguide.repos.DBSteuerung;

import java.util.List;

public class Handler {

    private DBSteuerung dw3dg;

    public Handler() {
        this.dw3dg = new DBSteuerung("dw3dg.db");
    }

    public List<Digitation> getAllDigitationList() {
        return dw3dg.getDigitation();
    }

    public List<Digitation> getDigitationList(String partnername, String digitationsname, String digitationsstufe, String vordigitation1, String vordigitation2) {
        return dw3dg.getDigitation(partnername, digitationsname, digitationsstufe, vordigitation1, vordigitation2);
    }

    public void close() {
        dw3dg.close();
    }
}
