package br.com.lucasagw.mobile.rv.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tarefa { //classe que descreve uma tabela de banco de dados ao trabalhar com Room

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String titulo;

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
}
