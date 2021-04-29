package br.com.lucasagw.mobile.rv.view;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.lucasagw.mobile.rv.R;
import br.com.lucasagw.mobile.rv.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaHolder> {

    private List<Tarefa> dados;
    // private Context contexto; //poderia fazer assim pra usar o contexto no from.

    public TarefaAdapter(List<Tarefa> dados) {
        this.dados = dados;
    }

    @NonNull
    @Override
    public TarefaHolder onCreateViewHolder(@NonNull ViewGroup recyclerView, int viewType) {
        View view = LayoutInflater.from(recyclerView.getContext())
                .inflate(R.layout.main_lista_tarefa, recyclerView, false);
        return new TarefaHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TarefaHolder holder, int position) {
        holder.getTitulo().setText(dados.get(position).getTitulo()); //setando os dados na viewholder
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }



    class TarefaHolder extends RecyclerView.ViewHolder{

        private TextView titulo;

        public TarefaHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.main_item_texto);
        }

        public TextView getTitulo() {
            return titulo;
        }

        public void setTitulo(TextView titulo) {
            this.titulo = titulo;
        }
    }

}
