package br.com.lucasagw.mobile.rv.repositorio;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.lucasagw.mobile.rv.model.Tarefa;

@Database(
        entities = {Tarefa.class},
        version = 1,
        exportSchema = false //ele tenta gerar um json do schema do banco no tempo de execução
)
public abstract class BancoDados extends RoomDatabase {
    public static BancoDados instancia = null;

    public abstract TarefaDAO getTarefaDao();

    public static BancoDados getInstance(Context context) {
        if (instancia == null) {
            Room.databaseBuilder(context, BancoDados.class, "banco")
                    .allowMainThreadQueries() //permitir que as queries rodem na thread main.
                    .build();
        }
        return instancia;
    }

}
