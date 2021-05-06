package br.com.lucasagw.mobile.rv.repositorio;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.lucasagw.mobile.rv.model.Tarefa;

@Dao
public interface TarefaDAO { //objeto de acesso a dados. Um mapeamento de consultas SQL para funções.

    @Insert
    void insert(Tarefa... tarefas);

    @Delete
    void delete(Tarefa... tarefas);

    @Query("SELECT * FROM TAREFA")
    LiveData<List<Tarefa>> getAll();

}
