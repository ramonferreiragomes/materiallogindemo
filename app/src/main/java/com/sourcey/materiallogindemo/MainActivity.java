package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sourcey.materiallogindemo.dados.Usuarios;
import com.sourcey.materiallogindemo.service.UserGet;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch = (Button)findViewById(R.id.btn_buscar);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnSearch(View view) {
        UserGet userGet = UserGet.retrofit.create(UserGet.class);
        Call<List<Usuarios>> call = userGet.getUsers();
        try {
            List<Usuarios> result = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        call.enqueue(new Callback<List<Usuarios>>() {
            @Override
            public void onResponse(Call<List<Usuarios>> call, Response<List<Usuarios>> response) {
                final TextView txt = (TextView) findViewById(R.id.textViewSearch);
                txt.setText(response.body().toString());

            }

            @Override
            public void onFailure(Call<List<Usuarios>> call, Throwable t) {
                final TextView textView = (TextView) findViewById(R.id.textViewSearch);
                textView.setText("ERROR: " + t.getMessage());


            }
        });


    }
}
