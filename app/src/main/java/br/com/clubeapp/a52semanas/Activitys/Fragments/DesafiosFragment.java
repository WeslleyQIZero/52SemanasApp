package br.com.clubeapp.a52semanas.Activitys.Fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.clubeapp.a52semanas.Activitys.Adaptes.DesafioAdapter;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.Activitys.Utils.DividerItemDecoration;
import br.com.clubeapp.a52semanas.R;

public class DesafiosFragment extends Fragment{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager linearLayoutManager;
    private DesafioAdapter mAdapter;
    private  EditText dataInicial,valorInicial,objetivo;
    private int year,month,day;
    private Date date;
    private Desafio desafio = new Desafio();

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
           NovoDesafio(view);
          }
        });

        //chamada para o metodo que monta a recyclerview
        configRecyclerView(view);

        return view;
    }

    public void NovoDesafio(View v) {

        boolean wrapInScrollView = true;
        MaterialDialog dialog =
        new MaterialDialog.Builder(getContext())
                .title("Novo Desafio")
                .titleGravity(GravityEnum.CENTER)
                .customView(R.layout.form_novo_desafio, wrapInScrollView)
                .positiveText("Salvar")
                .negativeText("Cancelar")
                .cancelable(false)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        //convertendo string para date
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date = format.parse(dataInicial.getText().toString());
                            Toast.makeText(getContext(), ""+date, Toast.LENGTH_SHORT).show();
                        } catch (ParseException e) {
                            e.printStackTrace();
                            Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        desafio.setObjetivo(objetivo.getText().toString());
                        desafio.setValorInicial(Double.parseDouble(valorInicial.getText().toString()));
                        desafio.setDataInicio(date);

                        //mAdapter.updateList(desafio);
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(getContext(), "Clicado Cancelar", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

        //recuperando os componente do xml
        dataInicial = (EditText) dialog.getCustomView().findViewById(R.id.data_inicial);
        valorInicial = (EditText) dialog.getCustomView().findViewById(R.id.valor_inicial);
        objetivo = (EditText) dialog.getCustomView().findViewById(R.id.objetivo);

        dataInicial.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    openDatePicker();
                }
            }
        });

        dataInicial.setInputType(InputType.TYPE_NULL);
        dataInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });
    }

    //configurando o recycler view
    public void configRecyclerView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new DesafioAdapter(new ArrayList<>(0));

        recyclerView.setAdapter(mAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
    }

    //configurando o datepicker
    public void openDatePicker(){
        initDatePicker();
        Calendar mcurrentDate=Calendar.getInstance();
         year=mcurrentDate.get(Calendar.YEAR);
         month=mcurrentDate.get(Calendar.MONTH);
         day=mcurrentDate.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker=new DatePickerDialog(getContext(), new android.app.DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {

                year = selectedyear;
                month = selectedmonth;
                day = selectedday;

                dataInicial.setText((day<10?"0"+day:day)+"/"+
                        (month+1<10?"0"+(month+1):month+1)+"/"+
                        (year<10?"0"+year:year)
                );
            }
        },year, month, day);
        mDatePicker.show();
    }

    private void initDatePicker(){
        if (year == 0){
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month= c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }
    }
}
