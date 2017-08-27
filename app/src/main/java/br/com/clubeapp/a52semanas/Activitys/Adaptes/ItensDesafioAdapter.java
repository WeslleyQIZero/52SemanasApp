package br.com.clubeapp.a52semanas.Activitys.Adaptes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.clubeapp.a52semanas.Activitys.Activitys.ItensDesafioActivity;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.R;

/**
 * Created by Denis Souza on 04/08/2017.
 */

public class ItensDesafioAdapter extends RecyclerView.Adapter<ItensDesafioAdapter.ItemDesafio> {

    private ArrayList<Desafio> listDesafios;
    private Context context;

    public ItensDesafioAdapter(ArrayList<Desafio> desafios, Context c) {
        this.listDesafios = desafios;
        this.context = c;
    }

    @Override
    public ItemDesafio onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemDesafio(LayoutInflater.from(parent.getContext()).inflate(R.layout.itens_desafio, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemDesafio holder, int position) {
        holder.objetivo.setText(listDesafios.get(position).getObjetivo());
        holder.valorInicial.setText(String.valueOf(listDesafios.get(position).getValorInicial()));
        holder.semana.setText(String.valueOf(listDesafios.get(position).getSemana()) + "º");

    }


    public class ItemDesafio extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView objetivo;
        public TextView valorInicial;
        public TextView data;
        public TextView semana;
        public ImageView icon;

        public ItemDesafio(View itemView) {
            super(itemView);
            objetivo = (TextView) itemView.findViewById(R.id.tv_objetivo);
            valorInicial = (TextView) itemView.findViewById(R.id.tv_valorinicial);
            semana = (TextView) itemView.findViewById(R.id.tv_semana);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Desafio desafio = listDesafios.get(position);
            Toast.makeText(context, ""+desafio.getVisualizacao(), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public int getItemCount() {
        return listDesafios != null ? listDesafios.size() : 0;
    }
}
