package br.com.clubeapp.a52semanas.Activitys.Adaptes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.R;

/**
 * Created by Denis Souza on 11/07/2017.
 */

public class DesafioAdapter extends RecyclerView.Adapter<DesafioAdapter.DesafioHolder> {
    private ArrayList<Desafio> desafios;

    public DesafioAdapter(ArrayList desafio) {
        desafios = desafio;
    }

    @Override
    public DesafioHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DesafioHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.desafio_item, parent, false));
    }


    public class DesafioHolder extends RecyclerView.ViewHolder {

        public TextView produto;
        public TextView valor;
        public TextView quant;
        public TextView sigla;

        public DesafioHolder(View itemView) {
            super(itemView);
        }

    }


    @Override
    public void onBindViewHolder(DesafioHolder holder, int position) {
        holder.produto.setText(desafios.get(position).getObjetivo());
        holder.valor.setText(String.valueOf(desafios.get(position).getValorInicial()));
        holder.quant.setText(String.valueOf(desafios.get(position).getDataInicio()));
        holder.sigla.setText(String.valueOf(desafios.get(position).getVisualizacao()));
    }

    @Override
    public int getItemCount() {
        return desafios != null ? desafios.size() : 0;
    }

    public void updateList(Desafio item) {
        insertItem(item);
    }

    private void insertItem(Desafio item) {
        desafios.add(item);
        notifyItemInserted(getItemCount());
    }
}
