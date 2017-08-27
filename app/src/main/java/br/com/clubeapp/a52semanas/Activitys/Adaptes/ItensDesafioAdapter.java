package br.com.clubeapp.a52semanas.Activitys.Adaptes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.clubeapp.a52semanas.Activitys.Activitys.ItensDesafioActivity;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.R;

/**
 * Created by Denis Souza on 04/08/2017.
 */

public class ItensDesafioAdapter extends RecyclerView.Adapter<ItensDesafioAdapter.ItemDesafio> {

    private ArrayList<Desafio> listDesafios;
    private Context context;

    public ItensDesafioAdapter(ArrayList<Desafio> listDesafios, Context c) {
        this.listDesafios = listDesafios;
        this.context = c;
    }

    @Override
    public ItemDesafio onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemDesafio(LayoutInflater.from(parent.getContext()).inflate(R.layout.itens_desafio, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemDesafio holder, int position) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        holder.objetivo.setText(listDesafios.get(position).getObjetivo());
        holder.valorInicial.setText(String.valueOf(listDesafios.get(position).getValorInicial()));
        holder.semana.setText(String.valueOf(listDesafios.get(position).getSemana()) + "º");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(listDesafios.get(position).getDataFim());

        String dataInicio = formato.format(calendar.getTime());


        holder.dataInicial.setText(dataInicio);



    }


    public class ItemDesafio extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView data;
        public TextView semana;
        public ImageView icon;
        public TextView objetivo;
        public TextView valorInicial;
        public TextView dataInicial;
        public TextView dataFinal;
        public TextView porcentagem;
        public TextView visualizacao;
        private List<Desafio> desafioList;

        RadioGroup radioGroup;
        RadioButton radioButton;

        public ItemDesafio(View itemView) {
            super(itemView);
            objetivo = (TextView) itemView.findViewById(R.id.tv_objetivo);
            valorInicial = (TextView) itemView.findViewById(R.id.tv_valorinicial);
            semana = (TextView) itemView.findViewById(R.id.tv_semana);
            objetivo = (TextView) itemView.findViewById(R.id.tv_objetivo);
            valorInicial = (TextView) itemView.findViewById(R.id.tv_valorinicial);
            dataInicial = (TextView) itemView.findViewById(R.id.tv_datainicial);
            dataFinal = (TextView) itemView.findViewById(R.id.tv_datafinal);
            visualizacao = (TextView) itemView.findViewById(R.id.tv_visualizacao);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.radio);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Desafio desafio = listDesafios.get(position);
            Toast.makeText(context, "" + desafio.getVisualizacao(), Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public int getItemCount() {
        return listDesafios != null ? listDesafios.size() : 0;
    }
}
