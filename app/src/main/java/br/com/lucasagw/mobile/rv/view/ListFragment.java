package br.com.lucasagw.mobile.rv.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.lucasagw.mobile.rv.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TarefaViewModel viewModel;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.main_lista_tarefas);
        TarefaAdapter tarefaAdapter = new TarefaAdapter(new TarefaAdapter.TarefaDiff());
        recyclerView.setAdapter(tarefaAdapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));

        viewModel = new ViewModelProvider(this, //fábrica
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getActivity().getApplication()))
                .get(TarefaViewModel.class);  //gerenciador do observe

        FloatingActionButton fab = view.findViewById(R.id.floatingActionButton);
        //modo explicito, apontando diretamente para o fragment destino
        //fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.adicionarFragment));

        //modo safe args, passando parametro de forma segura
        fab.setOnClickListener(Navigation.createNavigateOnClickListener
                (ListFragmentDirections.actionListFragmentToAdicionarFragment()
                        .setTexto("Meu texto!")));

        //modo transição, apontando para a ação da navegação
        //fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_listFragment_to_adicionarFragment));

        viewModel.getTarefas().observe(this.getActivity(), tarefas -> { //atualiza a view UI.
            tarefaAdapter.submitList(tarefas);
            //esse cara é avisado toda vez que for submetido alguma coisa, ou alterado a lista.
        });

        return view;
    }
}