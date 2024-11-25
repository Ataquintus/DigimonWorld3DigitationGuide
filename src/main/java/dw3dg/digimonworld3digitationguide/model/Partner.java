package dw3dg.digimonworld3digitationguide.model;

public class Partner {
    private String name;
    private String quest;

    public Partner(String name, String quest) {
        this.name = name;
        this.quest = quest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }
}
