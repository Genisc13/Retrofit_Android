package edu.upc.dsa.retrofittracks;


import java.util.List;

import edu.upc.dsa.retrofittracks.models.Gadget;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @POST("shop/user/register")
    Call<Gadget> createTracks(@Body Gadget gadget);

    @POST("shop/user/login")
    Call<Gadget> logIn(@Body Gadget gadget);

    @GET("shop/gadget/all")
    Call<List<Gadget>> getGadgets();
}
