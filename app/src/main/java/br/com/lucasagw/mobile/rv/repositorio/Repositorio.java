package br.com.lucasagw.mobile.rv.repositorio;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.lucasagw.mobile.rv.model.Tarefa;

public class Repositorio {

    private TarefaDAO dao;
    private LiveData<List<Tarefa>> tarefas;

    public Repositorio(Context context) {
        BancoDados bd = BancoDados.getInstance(context);
        dao = bd.getTarefaDao();
        tarefas = dao.getAll();
    }

    public LiveData<List<Tarefa>> getAllContatos() {
        return tarefas;
    }

    public void insert(Tarefa tarefa) {
        BancoDados.dbWriteExecutor.execute(() -> {
            dao.insert(tarefa);
        });
//        BancoDados.dbWriteExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                dao.insert(contato);
//            }
//        });
    }

}
