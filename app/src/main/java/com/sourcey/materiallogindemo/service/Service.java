package com.sourcey.materiallogindemo.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.sourcey.materiallogindemo.MainActivity;
import com.sourcey.materiallogindemo.dados.Usuarios;
import com.sourcey.materiallogindemo.model.UserGet;
import com.sourcey.materiallogindemo.util.UserJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ramon Lopes on 24/04/2017.
 */

public class Service {
    public Button btnSearch;
    private static final String TAG = "onResponse";
    public static final String URL = "https://raw.githubusercontent.com/mobilesiri/JSON-Parsing-in-Android/master/index.html";
    private static final String URL_ROST = "http://192.168.15.4:3000";
    private static ProgressDialog dialog;
    public Context context;

    public static void returnJson() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Usuarios.class, new UserJson())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_ROST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        UserGet apiServer = retrofit.create(UserGet.class);
        final Call<List<Usuarios>> usuer = apiServer.getUsers();
        usuer.enqueue(new Callback<List<Usuarios>>() {


            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {

                MainActivity.dialog.dismiss();

                if (response.isSuccessful()) {
                    List<Usuarios> user = response.body();
                    JSONArray array = new JSONArray(user);
                    JSONObject jsonObject;
                    jsonObject = new JSONObject();
                    Usuarios objetUser = new Usuarios();
                    try {
                        objetUser.setName(jsonObject.getString("nome"));
                        objetUser.setName(jsonObject.getString("nome"));
                        objetUser.setName(jsonObject.getString("nome"));
                        objetUser.setName(jsonObject.getString("nome"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    Log.i("PESSOA: ", "nome = " + jsonObject.optString("Email"));
                    Log.i("PESSOA: ", "nome = " + jsonObject.optString("Senha"));
                    Log.i("PESSOA: ", "nome = " + jsonObject.toString());


                } else {
                    Log.i("DANDO EEROR: ", String.valueOf(response.code()));

                }

            }

            @Override
            public void onFailure(Call<List<Usuarios>> call, final Throwable t) {
                MainActivity.dialog.dismiss();
                MainActivity.txtJson.setText(t.getMessage());
            }
        });


    }
}
