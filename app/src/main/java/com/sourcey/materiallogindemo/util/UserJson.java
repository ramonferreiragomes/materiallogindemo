package com.sourcey.materiallogindemo.util;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.sourcey.materiallogindemo.dados.Usuarios;

import java.lang.reflect.Type;

/**
 * Created by Ramon Lopes on 11/04/2017.
 */

public class UserJson implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonElement elemento = json.getAsJsonObject();
        if (json.getAsJsonObject() != null) {
            elemento = json.getAsJsonObject();

        }
        return (new Gson().fromJson(elemento, Usuarios.class));
    }
}
