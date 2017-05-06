package com.sourcey.materiallogindemo.dados;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ramon Lopes on 04/04/2017.
 */

public class Usuarios implements Serializable {
    public Usuarios() {
    }

    public Usuarios(String name, String endereco, String email, String numberCel, String senha) {
        this.name = name;
        this.endereco = endereco;
        this.email = email;
        this.numberCel = numberCel;
        this.senha = senha;
    }

    private String name;
    private String endereco;
    private String email;
    private String numberCel;
    private String senha;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberCel() {
        return numberCel;
    }

    public void setNumberCel(String numberCel) {
        this.numberCel = numberCel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {

        return
                "\nNome: " + this.getName() +
                        "\nEndereço: " + this.getEndereco() +
                        "\nEmail: " + this.getEmail() +
                        "\nCelular: " + this.getNumberCel() +
                        "\nSenha: " + this.getSenha();
    }

}
