package com.zukuzuku.nextorbis.cinemahack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jakub on 10/08/2018.
 */

public class UserPOJO {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("error")
    @Expose
    private String error;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
