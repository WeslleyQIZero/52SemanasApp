package br.com.clubeapp.a52semanas.Activitys.Activitys;

import android.app.Activity;;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import br.com.clubeapp.a52semanas.R;

public class IntroActivity extends Activity {

    private static int TIME_OUT = 1000;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(100);
                progressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(IntroActivity.this, DesafiosActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
}
