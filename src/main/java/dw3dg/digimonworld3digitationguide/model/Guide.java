package dw3dg.digimonworld3digitationguide.model;

public class Guide {

    private int guideID;
    private String guide;

    public Guide(int guideID, String guide) {
        this.guideID = guideID;
        this.guide = guide;
    }

    public int getGuideID() {
        return guideID;
    }

    public void setGuideID(int guideID) {
        this.guideID = guideID;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
