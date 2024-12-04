package dw3dg.digimonworld3digitationguide.model;

public class Partner {
    private int partnerID;
    private String partnername;
    private String quest;

    public Partner(int partnerID, String Partnername, String quest) {
        this.partnerID = partnerID;
        this.partnername = Partnername;
        this.quest = quest;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getPartnername() {
        return partnername;
    }

    public void setPartnername(String partnername) {
        this.partnername = partnername;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }
}
