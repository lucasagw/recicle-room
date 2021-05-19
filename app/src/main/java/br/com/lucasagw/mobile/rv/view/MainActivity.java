package br.com.lucasagw.mobile.rv.view;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.lucasagw.mobile.rv.R;
import br.com.lucasagw.mobile.rv.model.Tarefa;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void adicionar(View view) {
        Tarefa t = new Tarefa();
        t.setTitulo("Título " + (int) (Math.random() * 100));
     //   viewModel.inserir(t);

    }
}