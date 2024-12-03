package dw3dg.digimonworld3digitationguide.Handler;

import dw3dg.digimonworld3digitationguide.model.Digitation;
import dw3dg.digimonworld3digitationguide.model.Guide;
import dw3dg.digimonworld3digitationguide.model.Partner;
import dw3dg.digimonworld3digitationguide.repos.DBSteuerung;

import java.util.List;

public class Handler {

    private DBSteuerung dw3dg;

    public Handler() {
        this.dw3dg = new DBSteuerung("src/main/resources/dw3dg/digimonworld3digitationguide/dw3dg.db");
    }

    public List<Digitation> getAllDigitationList() {
        return dw3dg.getAllDigitation();
    }

    public List<Digitation> getDigitationList(String partnername, String digitationsname, String digitationsstufe, String vordigitation1, String vordigitation2) {
        return dw3dg.getDigitation(partnername, digitationsname, digitationsstufe, vordigitation1, vordigitation2);
    }

    public Partner getPartnerQuest(String partnername) {
        return dw3dg.getPartnerQuest(partnername);
    }

    public Guide getGuide(String akt) {
        return dw3dg.getGuide(akt);
    }

    public Guide getNextAkt() {
        return dw3dg.getNextAkt();
    }

    public Guide getPreviousAkt() {
        return dw3dg.getPreviousAkt();
    }

    public void close() {
        dw3dg.close();
    }
}
