package dw3dg.digimonworld3digitationguide.model;

public class Digitation {
    private String partnername;
    private String digitationsname;
    private String digitationsstufe;
    private String vordigitation1;
    private String level1;
    private String vordigitation2;
    private String level2;
    private String wertebedingung;

    public Digitation(String partnername, String digitationsname, String digitationsstufe, String vordigitation1, String level1, String vordigitation2, String level2, String wertebedingung) {
        this.partnername = partnername;
        this.digitationsname = digitationsname;
        this.digitationsstufe = digitationsstufe;
        this.vordigitation1 = vordigitation1;
        this.level1 = level1;
        this.vordigitation2 = vordigitation2;
        this.level2 = level2;
        this.wertebedingung = wertebedingung;
    }

    public String getPartnername() {
        return partnername;
    }

    public void setPartnername(String partnername) {
        this.partnername = partnername;
    }

    public String getDigitationsname() {
        return digitationsname;
    }

    public void setDigitationsname(String digitationsname) {
        this.digitationsname = digitationsname;
    }

    public String getDigitationsstufe() {
        return digitationsstufe;
    }

    public void setDigitationsstufe(String digitationsstufe) {
        this.digitationsstufe = digitationsstufe;
    }

    public String getVordigitation1() {
        return vordigitation1;
    }

    public void setVordigitation1(String vordigitation1) {
        this.vordigitation1 = vordigitation1;
    }

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getVordigitation2() {
        return vordigitation2;
    }

    public void setVordigitation2(String vordigitation2) {
        this.vordigitation2 = vordigitation2;
    }


    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getWertebedingung() {
        return wertebedingung;
    }

    public void setWertebedingung(String wertebedingung) {
        this.wertebedingung = wertebedingung;
    }
}
