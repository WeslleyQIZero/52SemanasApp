package br.com.clubeapp.a52semanas.Activitys.Activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import br.com.clubeapp.a52semanas.Activitys.Adaptes.DesafioAdapter;
import br.com.clubeapp.a52semanas.Activitys.Adaptes.ItensDesafioAdapter;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.Activitys.Utils.DividerItemDecoration;
import br.com.clubeapp.a52semanas.R;

public class ItensDesafioActivity extends AppCompatActivity {

    private ItensDesafioAdapter mAdapter;
    private ArrayList<Desafio> desafiosList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_desafio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        preencherLista();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new ItensDesafioAdapter(desafiosList,this);

        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    public  ArrayList<Desafio> preencherLista(){

        for(int i=1;i<52;i++) {
            Desafio d = new Desafio();
            d.setObjetivo(getIntent().getStringExtra("objetivo"));
            d.setValorInicial(100.0);
            d.setSemana(i);
            desafiosList.add(d);
        }
        return desafiosList;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        if(item.getItemId()==R.id.menu_item_progress){
            progressDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_desafio_item, menu);
        return true;
    }

    public void progressDialog(){
        boolean showMinMax = true;
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title("Meu Progresso")
                .titleGravity(GravityEnum.CENTER)
                .content("Mensagem aqui")
                .progress(false, 52, showMinMax)
                .show();
    }
}
