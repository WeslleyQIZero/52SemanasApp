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

        public TextView objetivo;
        public TextView valorInicial;
        public TextView dataInicial;
        public TextView dataFinal;
        public TextView porcentagem;

        public DesafioHolder(View itemView) {
            super(itemView);
            objetivo = (TextView) itemView.findViewById(R.id.lbobjetivo);
            valorInicial = (TextView) itemView.findViewById(R.id.lbvalor);
            dataInicial = (TextView) itemView.findViewById(R.id.lb_datainicial);
            dataFinal = (TextView) itemView.findViewById(R.id.lb_datafinal);
        }
    }


    @Override
    public void onBindViewHolder(DesafioHolder holder, int position) {
        holder.objetivo.setText(desafios.get(position).getObjetivo());
        holder.valorInicial.setText(String.valueOf(desafios.get(position).getValorInicial()));
        holder.dataInicial.setText(String.valueOf(desafios.get(position).getDataInicio()));
        holder.dataFinal.setText(String.valueOf(desafios.get(position).getDataFim()));
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
