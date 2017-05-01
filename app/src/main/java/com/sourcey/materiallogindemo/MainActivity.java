package com.sourcey.materiallogindemo;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sourcey.materiallogindemo.service.Service;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btnSearch;
    private static final String TAG = "MainActivity";
    public static final String URL = "https://raw.githubusercontent.com/mobilesiri/JSON-Parsing-in-Android/master/index.html";
    public static final String URL_ROST = "http://192.168.100.106";

    public static ProgressDialog dialog;

    @SuppressLint("StaticFieldLeak")
    public static TextView txtJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        btnSearch = (Button) findViewById(R.id.btn_buscar);
        btnSearch.setOnClickListener(this);
        txtJson = (TextView) findViewById(R.id.textViewSearch);


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

    @Override
    public void onClick(View v) {
        Log.d("USER", "==========================");
        dialog = new ProgressDialog(this);
        dialog.setMax(100);
        dialog.setMessage("Carregando contatos....");
        dialog.setTitle("Buscando Contatos");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();
        Log.d("USER", "==========================");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (dialog.getProgress() <= dialog.getMax()) {
                        Thread.sleep(100);
                        handle.sendMessage(handle.obtainMessage());
                        if (dialog.getProgress() == dialog.getProgress()) {


                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }

            }
        }).start();

        Log.d("USER", "==========================");
        Service.returnJson();

    }

    @SuppressLint("HandlerLeak")
    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dialog.incrementProgressBy(1);

        }
    };

}
