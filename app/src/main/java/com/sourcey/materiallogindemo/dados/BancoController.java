package com.sourcey.materiallogindemo.dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sourcey.materiallogindemo.service.CreateSQL;

/**
 * Created by Ramon Lopes on 06/05/2017.
 */

public class BancoController {
    private CreateSQL createSQL;
    private SQLiteDatabase sqLiteDatabase;

    public BancoController(Context context) {
        createSQL = new CreateSQL(context);
    }


    public String insertDados(String email, String senha) {
        ContentValues contentValues;
        long resultado;

        SQLiteDatabase database = createSQL.getWritableDatabase();

        contentValues = new ContentValues();
        contentValues.put(CreateSQL.NAME_EMAIL, email);
        contentValues.put(CreateSQL.NAME_SENHA, senha);

        resultado = database.insert(CreateSQL.NAME_TABELA, null, contentValues);
        database.close();

        if (resultado == -1) {
            return "Error ao inserir no Banco !";

        } else {
            return "Dados salvos com Sucesso ! ";

        }
    }


    public void searchData(){




    }




}
