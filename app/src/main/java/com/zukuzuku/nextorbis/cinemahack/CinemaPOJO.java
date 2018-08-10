package com.zukuzuku.nextorbis.cinemahack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jakub on 10/08/2018.
 */

public class CinemaPOJO {
    @SerializedName("cinemaNames")
    @Expose
    private List<String> cinemaNames = null;

    public List<String> getCinemaNames() {
        return cinemaNames;
    }

    public void setCinemaNames(List<String> cinemaNames) {
        this.cinemaNames = cinemaNames;
    }
}
