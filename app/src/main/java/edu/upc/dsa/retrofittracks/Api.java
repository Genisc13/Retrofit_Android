package edu.upc.dsa.retrofittracks;


import java.util.List;

import edu.upc.dsa.retrofittracks.models.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Api {
    @PUT("maps")
    Call<Void> updateMap(@Body Map map);

    @DELETE("maps/{id_map}")
    Call<Void> deleteMap(@Path("id_map") String id );

    @GET("maps")
    Call<List<Map>> getMaps();
}