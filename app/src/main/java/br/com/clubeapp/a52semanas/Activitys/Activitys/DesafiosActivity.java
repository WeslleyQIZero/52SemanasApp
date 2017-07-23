package br.com.clubeapp.a52semanas.Activitys.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.yarolegovich.lovelydialog.LovelyCustomDialog;

import java.util.ArrayList;

import br.com.clubeapp.a52semanas.Activitys.Adaptes.DesafioAdapter;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.Activitys.Utils.DividerItemDecoration;
import br.com.clubeapp.a52semanas.R;

public class DesafiosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager linearLayoutManager;
    private DesafioAdapter mAdapter;
    private Desafio item = new Desafio();

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               NovoDesafio();
            }
        });

        //chamada para o metodo que monta a recyclerview
        configRecyclerView();
    }

    public void NovoDesafio(){
        /*new LovelyTextInputDialog(this, R.style.TintTheme)
                .setTopColorRes(R.color.colorPrimary)
                .setTitle(R.string.novo_desafio)
                .setHint(R.string.action_settings)
                .setInputFilter(R.string.app_name, new LovelyTextInputDialog.TextFilter() {
                    @Override
                    public boolean check(String text) {
                        return text.matches("\\w+");
                    }
                })
                .setIcon(R.drawable.ic_date)
                .setConfirmButton(android.R.string.ok, new LovelyTextInputDialog.OnTextInputConfirmListener() {
                    @Override
                    public void onTextInputConfirmed(String text) {
                        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(android.R.string.no,null)
                .show();*/

       /* new LovelyCustomDialog(this)
                .setView(R.layout.form_novo_desafio)
                .setTopTitle(R.string.novo_desafio)
                .setCancelable(false)
                .setTopTitleColor(R.color.white)
                .setTopColorRes(R.color.colorPrimary)
                .setIcon(R.drawable.ic_add)
                .setListener(R.id.btn_ok, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setListener(R.id.btn_cancel,new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {

                    }
                })
                .show();*/

       Intent intent = new Intent(this,NovoDesafioActivity.class);
        startActivity(intent);

    }

    public void configRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new DesafioAdapter(new ArrayList<>(0));

        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
