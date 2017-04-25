package com.sourcey.materiallogindemo.service;

import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sourcey.materiallogindemo.MainActivity;
import com.sourcey.materiallogindemo.R;
import com.sourcey.materiallogindemo.SignupActivity;
import com.sourcey.materiallogindemo.dados.Usuarios;
import com.sourcey.materiallogindemo.model.UserGet;
import com.sourcey.materiallogindemo.util.UserJson;

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
    private static final String URL_ROST = "http://localhost:3000";

    public static void returnJson() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Usuarios.class, new UserJson())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_ROST)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        UserGet apiServer = retrofit.create(UserGet.class);
        Call<List<Usuarios>> usuer = apiServer.getUsers();
        usuer.enqueue(new Callback<List<Usuarios>>() {
            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {

                if (response.isSuccessful()) {
                    List<Usuarios> user = response.body();
                    for (Usuarios u : user) {
                        Log.d("USER", u.getName() +
                                "=====" + u.getEndereco() +
                                "=====" + u.getEmail() +
                                "=====" + u.getNumberCel() +
                                "=====" + u.getSenha());
                        Log.d("USER", "==========================");

                    }
                } else {
                    final MainActivity re = new MainActivity();
                    final String text = response.message();
                    re.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            final ProgressDialog progressDialog = new ProgressDialog(re,
                                    R.style.AppTheme_Dark_Dialog);
                            progressDialog.setIndeterminate(true);
                            progressDialog.setMessage("BAIXANDO.....");
                            progressDialog.show();
                            Toast.makeText(re, "DANDO EEROR: " + text, Toast.LENGTH_LONG).show();

                        }
                    });
                    Log.d("DANDO EEROR: ", String.valueOf(response.code()));
                    Toast.makeText(re, "DANDO EEROR: " + response.code(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Usuarios>> call, Throwable t) {

                //Toast.makeText(, "DANDO EEROR: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("ERROR", t.getMessage());


            }
        });


    }
}
