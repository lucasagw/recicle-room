package br.com.lucasagw.mobile.rv.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import br.com.lucasagw.mobile.rv.model.Tarefa;
import br.com.lucasagw.mobile.rv.repositorio.Repositorio;

public class TarefaViewModel extends AndroidViewModel {
    private Repositorio repositorio;
    private LiveData<List<Tarefa>> tarefas;

    public TarefaViewModel(@NonNull Application application) {
        super(application);
        repositorio = new Repositorio(application);
        tarefas = repositorio.getAllContatos();
    }

    public LiveData<List<Tarefa>> getContatos() {
        return tarefas;
    }

    public void inserir(Tarefa tarefa) {
        repositorio.insert(tarefa);
    }
}
