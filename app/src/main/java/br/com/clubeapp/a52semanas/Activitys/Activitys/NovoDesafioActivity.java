package br.com.clubeapp.a52semanas.Activitys.Activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.clubeapp.a52semanas.Activitys.Adaptes.DesafioAdapter;
import br.com.clubeapp.a52semanas.Activitys.Models.Desafio;
import br.com.clubeapp.a52semanas.R;

public class NovoDesafioActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
                                                                        DialogInterface.OnCancelListener {

    private int year,month,day;
    private  EditText dataInicial;
    private Button btn_salvar;

    private DesafioAdapter mAdapter = new DesafioAdapter(new ArrayList<>(0));;
    private Desafio desafio;

    private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_novo_desafio);

        dataInicial= (EditText)findViewById(R.id.data_inicial);
        dataInicial.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    openDatePicker(v);
                }
            }
        });

        dataInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker(v);
            }
        });
        getSupportActionBar().setTitle("Novo Desafio");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_salvar = (Button) findViewById(R.id.btn_ok);

        btn_salvar.setOnClickListener(new View.OnClickListener() {

            Calendar c = Calendar.getInstance();

            @Override
            public void onClick(View view) {
                desafio = new Desafio();
                desafio.setValorInicial(100.00);
                desafio.setObjetivo("Carro Novo");
                desafio.setDataInicio(c);
                desafio.setDataFinal(c);

                finish();
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDatePicker(View view){
        initDatePicker();
        Calendar cDefault = Calendar.getInstance();


        cDefault.set(year,month,day);
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                this,
                cDefault.get(Calendar.YEAR),
                cDefault.get(Calendar.MONTH),
                cDefault.get(Calendar.DAY_OF_MONTH)
        );

        Calendar dataMin = Calendar.getInstance();
        datePickerDialog.setMinDate(dataMin);
        datePickerDialog.setOnCancelListener(this);
        datePickerDialog.show(getFragmentManager(),"DatePickerDialog");
    }

    private void initDatePicker(){
        if (year == 0){
            Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month= c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Calendar tDefault = Calendar.getInstance();
        tDefault.set(this.year,this.month,this.day);

        this.year = year;
        this.month = monthOfYear;
        this.day = dayOfMonth;

        dataInicial.setText((day<10?"0"+day:day)+"/"+
                            (month+1<10?"0"+(month+1):month+1)+"/"+
                            (year<10?"0"+year:year)
                            );
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        year = month=day=0;
        dataInicial.setText("");
    }
}
