package br.com.lucasagw.mobile.rv.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.lucasagw.mobile.rv.R;
import br.com.lucasagw.mobile.rv.model.Tarefa;
import br.com.lucasagw.mobile.rv.repositorio.BancoDados;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private TarefaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_lista_tarefas);
        tarefaAdapter = new TarefaAdapter(new TarefaAdapter.TarefaDiff());
        recyclerView.setAdapter(tarefaAdapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(TarefaViewModel.class);

        viewModel.getTarefas().observe(this, tarefas -> {
            tarefaAdapter.submitList(tarefas);
        });

    }

    public void adicionar(View view) {
        Tarefa t = new Tarefa();
        t.setTitulo("Título " + (int) (Math.random() * 100));
        viewModel.inserir(t);

    }
}