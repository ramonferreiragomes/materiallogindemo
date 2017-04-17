package com.sourcey.materiallogindemo.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sourcey.materiallogindemo.dados.Usuarios;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ramon Lopes on 12/04/2017.
 */

public interface UserGet {
    @FormUrlEncoded
    @GET("dados")
    Call<List<Usuarios>> getUsers();

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.100.106/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
}
