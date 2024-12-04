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

    public Partner getPartnerQuest(String partner) {
        return dw3dg.getPartnerQuest(partner);
    }

    public Guide getGuide(Integer akt) {
        return dw3dg.getGuide(akt);
    }

    public Guide getNextGuide(Integer akt) {
        return dw3dg.getNextGuide(akt);
    }

    public Guide getPreviousGuide(Integer akt) {
        return dw3dg.getPreviousGuide(akt);
    }

    public List<Guide> getGuideComboBoxMenu() {
        return dw3dg.getFullGuide();
    }

    public List<Partner> getPartnerQuestMenu() {
        return dw3dg.getPartnerQuestMenu();
    }

    public void close() {
        dw3dg.close();
    }
}
