package br.com.lucasagw.mobile.rv.repositorio;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.lucasagw.mobile.rv.api.GitHubService;
import br.com.lucasagw.mobile.rv.model.Tarefa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repositorio {

    private TarefaDAO dao;
    private GitHubService api;
    private LiveData<List<Tarefa>> tarefas;

    public Repositorio(Context context) {
        BancoDados bd = BancoDados.getInstance(context);
        dao = bd.getTarefaDao();
        tarefas = dao.getAll();
        api = GitHubService.create();
        Call<List<Tarefa>> call = api.listFollowers("lucasagw");
        call.enqueue(new Callback<List<Tarefa>>() {
            @Override
            public void onResponse(Call<List<Tarefa>> call, Response<List<Tarefa>> response) {
                List<Tarefa> body = response.body();
                BancoDados.dbWriteExecutor.execute(() -> {
                    dao.insert(body.toArray(new Tarefa[body.size()]));
                });
            }

            @Override
            public void onFailure(Call<List<Tarefa>> call, Throwable t) {
                Log.e("FALHOU", "erro de acesso");
            }
        });
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
//                dao.insert(tarefa);
//            }
//        });
    }

}
