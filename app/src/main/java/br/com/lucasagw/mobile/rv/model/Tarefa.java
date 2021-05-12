package br.com.lucasagw.mobile.rv.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity
public class Tarefa { //classe que descreve uma tabela de banco de dados ao trabalhar com Room

    @PrimaryKey(autoGenerate = true)
    private int id;

    @SerializedName(value = "login")
    private String titulo;

    @ColumnInfo(name = "avatar_url")
    @SerializedName(value = "avatar_url")
    private String avatar;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
