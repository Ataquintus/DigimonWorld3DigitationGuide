package dw3dg.digimonworld3digitationguide.Handler;

import dw3dg.digimonworld3digitationguide.model.Digitationsbedingung;
import dw3dg.digimonworld3digitationguide.model.Guide;
import dw3dg.digimonworld3digitationguide.model.Partner;
import dw3dg.digimonworld3digitationguide.repos.DBSteuerung;

import java.util.List;

public class Handler {

    private DBSteuerung dw3dg;

    public Handler() {
        this.dw3dg = new DBSteuerung("src/main/resources/dw3dg/digimonworld3digitationguide/dw3dg.db");
    }

    public List<Digitationsbedingung> getAllDigitationsbedingung() {
        return dw3dg.getAllDigitationsbedingung();
    }

    public List<Digitationsbedingung> getDigitationsbedingung(String partnername, String digitationsname, String digitationsstufe, String vordigitation1, String vordigitation2) {
        return dw3dg.getDigitationsbedingung(partnername, digitationsname, digitationsstufe, vordigitation1, vordigitation2);
    }

    public Partner getPartner(String partner) {
        return dw3dg.getPartner(partner);
    }

    public Guide getGuide(Integer akt) {
        return dw3dg.getGuide(akt);
    }

    public List<Guide> getFullGuide() {
        return dw3dg.getFullGuide();
    }

    public List<Partner> getAllPartner() {
        return dw3dg.getAllPartner();
    }

    public List<String> getAllDigitation() {
        return dw3dg.getAllDigitation();
    }

    public List<String> getAllDigitationsstufe() {
        return dw3dg.getAllDigitationsstufe();
    }

    public List<String> getAllVordigitation() {
        return dw3dg.getAllVordigitation();
    }

    public void close() {
        dw3dg.close();
    }
}
