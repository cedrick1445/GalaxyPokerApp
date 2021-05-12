package io.galaxy.pukeeer.guides;

public class GuidesViewModel {
    String guidename;
    String description;

    public GuidesViewModel(String name, String description) {
        this.guidename = name;
        this.description = description;
    }

    public String getGuidename() {
        return guidename;
    }

    public void setGuidename(String guidename) {
        this.guidename = guidename;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
