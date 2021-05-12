package io.galaxy.pukeeer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainViewModel {


    @SerializedName("data")
    public List<Datum> data = null;


    public static class Datum{
        @SerializedName("name")
        public String name;

        @SerializedName("description")
        public String description;

        @SerializedName("image")
        public Integer image;


        public Datum(String name, String description, Integer image) {
            super();
            this.name = name;
            this.description = description;
            this.image = image;

        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
    public MainViewModel(List<Datum> data) {
        super();
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

}
