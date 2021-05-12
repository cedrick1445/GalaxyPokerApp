package io.galaxy.pukeeer;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainPlayerViewModel {

    @SerializedName("playerdata")
    public List<MainPlayerViewModel.Datum> playerdata = null;


    public static class Datum{
        @SerializedName("playername")
        public String playername;

        @SerializedName("earnings")
        public String earnigs;

        @SerializedName("playerdesc")
        public String playerdesc;

        @SerializedName("playerimage")
        public Integer playerimage;

        @SerializedName("playercirle")
        public Integer playercirle;

        public Datum(String playername, String earnigs, String playerdesc, Integer playerimage, Integer playercirle) {
            super();
            this.playername = playername;
            this.earnigs = earnigs;
            this.playerdesc = playerdesc;
            this.playerimage = playerimage;
            this.playercirle = playercirle;
        }

        public int getImage() {
            return playerimage;
        }

        public void setImage(int playerimage) {
            this.playerimage = playerimage;
        }


        public int getPlayercirler() {
            return playercirle;
        }

        public void setPlayercirle(int playercirle) {
            this.playercirle = playercirle;
        }

        public String getEarnigs(){
            return earnigs;
        }

        public void  setEarnigs(String earnigs){
            this.earnigs = earnigs;
        }

        public String getName() {
            return playername;
        }

        public void setName(String playername) {
            this.playername = playername;
        }

        public String getDescription() {
            return playerdesc;
        }

        public void setDescription(String playerdesc) {
            this.playerdesc = playerdesc;
        }


    }

    public MainPlayerViewModel(List<MainPlayerViewModel.Datum> playerdata) {
        super();
        this.playerdata = playerdata;
    }

    public List<MainPlayerViewModel.Datum> getplayerData() {
        return playerdata;
    }

}

