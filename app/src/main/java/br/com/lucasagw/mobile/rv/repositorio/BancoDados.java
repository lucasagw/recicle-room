package br.com.lucasagw.mobile.rv.repositorio;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.lucasagw.mobile.rv.model.Tarefa;

@Database( //Banco de dados para armazenamento do dispositivo. A biblioteca de persistência do Room cria e mantém esse banco de dados.
        entities = {Tarefa.class},
        version = 1,
        exportSchema = false //ele tenta gerar um json do schema do banco no tempo de execução
)
public abstract class BancoDados extends RoomDatabase { //Ponto de acesso ao banco de dados SQLite (oculta SQLiteOpenHelper).

    public static BancoDados instancia = null;

    public abstract TarefaDAO getTarefaDao();

    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(4);

    public static BancoDados getInstance(Context context) {
        if (instancia == null) {
            synchronized (BancoDados.class) {
                if (instancia == null) {
                    instancia = Room.databaseBuilder(context, BancoDados.class, "banco")
                            //.allowMainThreadQueries() //permitir que as queries rodem na thread main.
                            .build();
                }
            }
        }
        return instancia;
    }

}
