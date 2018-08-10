package com.zukuzuku.nextorbis.cinemahack;

/**
 * Created by Jakub on 10/08/2018.
 */

public class APIUtils {

    public static final String BASE_URL = "https://64629eaf.ngrok.io";

    public static MainService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(MainService.class);
    }
}
