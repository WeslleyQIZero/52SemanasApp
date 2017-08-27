package br.com.clubeapp.a52semanas.Activitys.Adaptes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.clubeapp.a52semanas.Activitys.Activitys.ItensDesafioActivity;
import br.com.clubeapp.a52semanas.Activitys.Daos.DesafioDaos;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.R;

/**
 * Created by Denis Souza on 11/07/2017.
 */

public class DesafioAdapter extends RecyclerView.Adapter<DesafioAdapter.DesafioHolder>{
    private ArrayList<Desafio> desafios = new ArrayList<>();
    private  Context context;
    private int position;

    public DesafioAdapter(ArrayList desafio,Context c) {
        this.context =c ;
        this.desafios = desafio;
    }

    @Override
    public DesafioHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.desafio_item, parent, false);
        DesafioHolder dH = new DesafioHolder(v,context,desafios);

        return dH;
    }


    public class DesafioHolder extends RecyclerView.ViewHolder implements  View.OnClickListener,View.OnLongClickListener{

        public TextView objetivo;
        public TextView valorInicial;
        public TextView dataInicial;
        public TextView dataFinal;
        public TextView porcentagem;
        public TextView visualizacao;
        private List<Desafio> desafioList;
        private Context context;

        public DesafioHolder(View itemView,Context c, List<Desafio> desafios) {
            super(itemView);
            this.desafioList = desafios;
            this.context = c;

            objetivo = (TextView) itemView.findViewById(R.id.tv_objetivo);
            valorInicial = (TextView) itemView.findViewById(R.id.tv_valorinicial);
            dataInicial = (TextView) itemView.findViewById(R.id.tv_datainicial);
            dataFinal = (TextView) itemView.findViewById(R.id.tv_datafinal);
            visualizacao = (TextView) itemView.findViewById(R.id.tv_visualizacao);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Desafio desafio = this.desafioList.get(position);
            Intent intent = new Intent(this.context, ItensDesafioActivity.class);

            intent.putExtra("objetivo",desafio.getId().toString());

            this.context.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View view) {
            ((AppCompatActivity)view.getContext()).startSupportActionMode(actionModeCallbacks);
            return  true;
        }
    }

    private ActionMode.Callback actionModeCallbacks = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_acao, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
           return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            switch (item.getItemId()) {

                case R.id.item_delete:
                    Toast.makeText(context,""+item.getItemId(),Toast.LENGTH_LONG).show();
                    removeItem(position);
                    mode.finish();

                case R.id.item_update:
                    Toast.makeText(context,"Update",Toast.LENGTH_LONG).show();
            }

            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            notifyDataSetChanged();
        }
    };

    @Override
    public void onBindViewHolder(DesafioHolder holder, int position) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(desafios.get(position).getDataInicio());

        String dataInicio = formato.format(calendar.getTime());

        holder.objetivo.setText(desafios.get(position).getObjetivo());
        holder.valorInicial.setText(String.valueOf(desafios.get(position).getValorInicial()));
        holder.dataInicial.setText(dataInicio);


        switch (desafios.get(position).getVisualizacao().toString()){
            case "Dia":
                holder.visualizacao.setText("Diariamente");
                break;
            case "Semana":
                holder.visualizacao.setText("Semanalmente");
                break;
            case "Mês":
                holder.visualizacao.setText("Mensalmente");
                break;
            default:
                holder.visualizacao.setText("");
                break;
        }
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

    public void removeItem(int position){
        DesafioDaos desafioDaos = new DesafioDaos(context);
        desafioDaos.deleta(Integer.parseInt(desafios.get(position).getId().toString()));

        desafios.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeRemoved(position,desafios.size());
    }

    public void updateItem(int position){

    }
}