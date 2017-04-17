package com.sourcey.materiallogindemo.dados;

import java.io.Serializable;

/**
 * Created by Ramon Lopes on 04/04/2017.
 */

public class Usuarios implements Serializable {
    public Usuarios() {
    }

    public Usuarios(String name, String endereco, String email, int numberCel, int senha) {
        this.name = name;
        this.endereco = endereco;
        this.email = email;
        this.numberCel = numberCel;
        this.senha = senha;
    }

    private String name;
    private String endereco;
    private String email;
    private int numberCel;
    private int senha;

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

    public int getNumberCel() {
        return numberCel;
    }

    public void setNumberCel(int numberCel) {
        this.numberCel = numberCel;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return "Nome: " + this.getName() + "/n"+
                "Endereço: " + this.getEndereco()+"/n"+
                "Email: "+ this.getEmail()+"/n"+
                "Celular: "+ this.getNumberCel()+"/n"+
                "Senha: "+ this.getSenha()+"/n";
    }

}
