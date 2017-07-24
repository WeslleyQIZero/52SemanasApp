package br.com.clubeapp.a52semanas.Activitys.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.clubeapp.a52semanas.Activitys.Activitys.NovoDesafioActivity;
import br.com.clubeapp.a52semanas.Activitys.Adaptes.DesafioAdapter;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.Activitys.Utils.DividerItemDecoration;
import br.com.clubeapp.a52semanas.R;

public class DesafiosFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager linearLayoutManager;
    private DesafioAdapter mAdapter;
    private Desafio item = new Desafio();

    public DesafiosFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_desafios, container, false);

        //implementaçao floatingActionButton novo desafio
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           NovoDesafio();
          }
        });

        //chamada para o metodo que monta a recyclerview
        configRecyclerView(view);
        return view;
    }

    public void NovoDesafio(){
        Intent intent = new Intent(getContext(),NovoDesafioActivity.class);
        startActivity(intent);
    }

    public void configRecyclerView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new DesafioAdapter(new ArrayList<>(0));

        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
    }
}
