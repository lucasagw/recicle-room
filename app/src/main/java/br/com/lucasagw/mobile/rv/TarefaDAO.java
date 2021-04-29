package br.com.lucasagw.mobile.rv;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TarefaDAO {

    @Insert
    void insert(Tarefa... tarefas);

    @Delete
    void delete(Tarefa... tarefas);

    @Query("SELECT * FROM TAREFA")
    List<Tarefa> getAll();

}
