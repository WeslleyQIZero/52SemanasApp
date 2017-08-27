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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.clubeapp.a52semanas.Activitys.Adaptes.DesafioAdapter;
import br.com.clubeapp.a52semanas.Activitys.Adaptes.ItensDesafioAdapter;
import br.com.clubeapp.a52semanas.Activitys.Daos.DesafioDaos;
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

        mAdapter = new ItensDesafioAdapter(desafiosList, this);

        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    public ArrayList<Desafio> preencherLista() {

        DesafioDaos daos = new DesafioDaos(this);

        Desafio d = daos.Buscar(getIntent().getStringExtra("objetivo"));
        Double valor = d.getValorInicial();
        Calendar c = new GregorianCalendar(d.getDataInicio().getYear(), d.getDataInicio().getMonth(), d.getDataInicio().getDay());
        for (int i = 1; i <= 52; i++) {
            Desafio desafio = new Desafio();
            desafio.setSemana(i);
            desafio.setValorInicial(valor);
            c.add(Calendar.DAY_OF_MONTH, +(i * 7));
            desafio.setObjetivo(d.getObjetivo());
            desafio.setDataFim(c.getTime());

            Double total = valor + (desafiosList.size() > 0 ? (Double.parseDouble(desafiosList.get(desafiosList.size() - 1).getVisualizacao())) : 0.0);
            desafio.setVisualizacao(total + "");
            valor = valor + d.getValorInicial();
            desafiosList.add(desafio);

        }
        return desafiosList;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        if (item.getItemId() == R.id.menu_item_progress) {
            progressDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_desafio_item, menu);
        return true;
    }

    public void progressDialog() {
        boolean showMinMax = true;
        MaterialDialog dialog = new MaterialDialog.Builder(this)
                .title("Meu Progresso")
                .titleGravity(GravityEnum.CENTER)
                .content("Mensagem aqui")
                .progress(false, 52, showMinMax)
                .show();
    }
}
