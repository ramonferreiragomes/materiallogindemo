package com.sourcey.materiallogindemo.service;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Ramon Lopes on 06/05/2017.
 */


public class CreateSQL extends SQLiteOpenHelper {
    private static final String NAME_BANCO = "bancoLoguin.db";
    public static final String NAME_TABELA = "cadastroUser";
    private static final String NAME_ID = "_id";
    public static final String NAME_EMAIL = "_email";
    public static final String NAME_SENHA = "_senha";
    private static final int NAME_VERSION = 1;


    public CreateSQL(Context context) {
        super(context, NAME_BANCO, null, NAME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE "
                + NAME_TABELA + "("
                + NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + NAME_EMAIL + " TEXT ,"
                + NAME_SENHA + " TEXT"+")";

        db.execSQL(sql);
        Log.d("TABELA SQL", sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + NAME_TABELA);
        onCreate(db);
    }
}
