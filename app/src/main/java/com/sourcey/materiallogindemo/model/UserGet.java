package com.sourcey.materiallogindemo.model;


import com.sourcey.materiallogindemo.dados.Usuarios;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by Ramon Lopes on 12/04/2017.
 */

public interface UserGet {
    //@FormUrlEncoded
    @GET("dados")
    Call<List<Usuarios>> getUsers();
}
