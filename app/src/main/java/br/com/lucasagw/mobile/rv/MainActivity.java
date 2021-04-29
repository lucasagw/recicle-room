package br.com.lucasagw.mobile.rv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> dados = new ArrayList<>();
    private BancoDados bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bancoDados = BancoDados.getInstance(this);
        dados = bancoDados.getTarefaDao().getAll(); //no primeiro acesso, provavelmente a lista pode está vazia
        if (dados.size() == 0) {
            criarLista();
            dados = bancoDados.getTarefaDao().getAll();
        }
        recyclerView = findViewById(R.id.main_lista_tarefas);
        tarefaAdapter = new TarefaAdapter(dados);
        recyclerView.setAdapter(tarefaAdapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    public void criarLista() {
        List<Tarefa> lista = new ArrayList<>();
        for (int i = 0; i <= 20; i++) {
            Tarefa t = new Tarefa();
            t.setTitulo("Título " + i);
            lista.add(t);
            // bancoDados.getTarefaDao().insert(t);
        }
        bancoDados.getTarefaDao().insert(lista.toArray(new Tarefa[lista.size()])); //insere todos de uma vez
    }

    public void adicionar(View view) {
        Tarefa t = new Tarefa();
        t.setTitulo("Título " + (int) (Math.random() * 100));
        bancoDados.getTarefaDao().insert(t);
        dados.clear(); //limpa a lista local
        dados.addAll(bancoDados.getTarefaDao().getAll());//adiciona todos os dados novamente, incluindo o dado inserido neste método.
        tarefaAdapter.notifyDataSetChanged();//avisa que houve mudança nos itens do adaptador

    }
}