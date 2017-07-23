package br.com.clubeapp.a52semanas.Activitys.Activitys;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import br.com.clubeapp.a52semanas.R;

public class NovoDesafioActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener,
                                                                        DialogInterface.OnCancelListener {

    private int year,month,day;
    private  EditText dataInicial;

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
