package br.com.lucasagw.mobile.rv.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import br.com.lucasagw.mobile.rv.R;
import br.com.lucasagw.mobile.rv.model.Tarefa;

public class TarefaAdapter extends ListAdapter<Tarefa, TarefaAdapter.TarefaHolder> {

    protected TarefaAdapter(@NonNull DiffUtil.ItemCallback<Tarefa> diffCallback) {
        super(diffCallback); //diz quando será feito a atualização dos dados
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
        holder.getTitulo().setText(getItem(position).getTitulo()); //setando os dados na viewholder
        Picasso.get()
                .load(getItem(position).getAvatar())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(android.R.drawable.ic_dialog_alert)
                .resize(150, 150)
                .centerCrop()
                .into(holder.getImageView());
    }

    class TarefaHolder extends RecyclerView.ViewHolder {

        private TextView titulo;
        private ImageView imageView;

        public TarefaHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.main_item_texto);
            imageView = itemView.findViewById(R.id.main_item_avatar);
        }

        public TextView getTitulo() {
            return titulo;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    static class TarefaDiff extends DiffUtil.ItemCallback<Tarefa> {
        //para checar se são iguais
        @Override
        public boolean areItemsTheSame(@NonNull Tarefa oldItem, @NonNull Tarefa newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tarefa oldItem, @NonNull Tarefa newItem) {
            return (oldItem.getId() == newItem.getId()) && oldItem.getTitulo().equals(newItem.getTitulo());
        }
    }
}
