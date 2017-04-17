package com.sourcey.materiallogindemo.service;

import com.sourcey.materiallogindemo.dados.Usuarios;
import com.squareup.okhttp.Call;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Ramon Lopes on 04/04/2017.
 */

public interface UserService {

    @FormUrlEncoded
    @POST("/cadastrarUser")
    retrofit2.Call<Usuarios> insertUser(
            @Field("nome") String nome,
            @Field("andress") String andress,
            @Field("email") String email,
            @Field("numCel") String numCel,
            @Field("senha") String senha,
            Callback<Response> callback);
}
