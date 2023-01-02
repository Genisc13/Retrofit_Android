package edu.upc.dsa.retrofittracks;


import java.util.List;

import edu.upc.dsa.retrofittracks.models.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @POST("shop/user/register")
    Call<Map> createTracks(@Body Map map);

    @POST("shop/user/login")
    Call<Map> logIn(@Body Map map);

    @GET("maps")
    Call<List<Map>> getMaps();
}
