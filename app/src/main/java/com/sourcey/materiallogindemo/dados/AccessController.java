package com.sourcey.materiallogindemo.dados;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.sourcey.materiallogindemo.MainActivity;
import com.sourcey.materiallogindemo.service.CreateSQL;

/**
 * Created by Ramon Lopes on 06/05/2017.
 */

public class AccessController extends Activity {
    private Context context;
    //CreateSQL sql = new CreateSQL(context);

    public void carregaDados() {
        Log.d("carregarDados", "==========================");


        String[] listDados = {
                CreateSQL.NAME_EMAIL,
                CreateSQL.NAME_SENHA
        };

        String name = MainActivity.sql.getDatabaseName();
        Log.d("name SQLite", name);

        SQLiteDatabase sqLiteDatabase = MainActivity.sql.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(CreateSQL.NAME_TABELA, listDados, null, null, null, null, null);


        if (cursor != null) {
            cursor.moveToFirst();
            Usuarios user = new Usuarios();
            int colunas = cursor.getColumnCount();
            user.setEmail(cursor.getString(cursor.getColumnIndex("_email")));
            user.setEmail(cursor.getString(cursor.getColumnIndex("_senha")));


            Log.d("carregarDados", String.valueOf(colunas));
            Log.d("carregarDados", String.valueOf(user));

            //MainActivity.txtJson.setText((CharSequence) user);


        } else {
            MainActivity.sql.close();
        }

        //Log.d("AccessController", cursor.getColumnName(Integer.parseInt(CreateSQL.NAME_EMAIL)));
        //MainActivity.txtJson.setText(cu);


    }
}
