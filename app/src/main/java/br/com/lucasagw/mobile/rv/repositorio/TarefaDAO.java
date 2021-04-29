package br.com.lucasagw.mobile.rv.repositorio;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.com.lucasagw.mobile.rv.model.Tarefa;

@Dao
public interface TarefaDAO {

    @Insert
    void insert(Tarefa... tarefas);

    @Delete
    void delete(Tarefa... tarefas);

    @Query("SELECT * FROM TAREFA")
    List<Tarefa> getAll();

}
