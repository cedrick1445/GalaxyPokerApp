package io.galaxy.pukeeer.tips;

public class TipsViewModel {

    String tname;
    String tdesc;

    public TipsViewModel(String name, String description) {
        this.tname = name;
        this.tdesc = description;
    }

    public String getName() {
        return tname;
    }

    public void setName(String name) {
        this.tname = name;
    }

    public String getDescription() {
        return tdesc;
    }

    public void setDescription(String description) {
        this.tdesc = description;
    }



}
