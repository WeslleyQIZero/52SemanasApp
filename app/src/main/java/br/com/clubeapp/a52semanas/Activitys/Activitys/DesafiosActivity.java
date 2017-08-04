package br.com.clubeapp.a52semanas.Activitys.Activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TextView;

import br.com.clubeapp.a52semanas.Activitys.Adaptes.TabsAdapter;
import br.com.clubeapp.a52semanas.Activitys.Fragments.AjudaFragment;
import br.com.clubeapp.a52semanas.Activitys.Fragments.DesafiosFragment;
import br.com.clubeapp.a52semanas.Activitys.Fragments.SobreFragment;
import br.com.clubeapp.a52semanas.Activitys.Utils.SlidingTabLayout;
import br.com.clubeapp.a52semanas.R;

public class DesafiosActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desafios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mViewPager = (ViewPager) findViewById(R.id.vp_tabs);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.colorPrimary));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("DESAFIOS");
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("AJUDA");
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("SOBRE");
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager(),this);
        adapter.addFrag(new DesafiosFragment(), "DESAFIOS");
        adapter.addFrag(new AjudaFragment(), "AJUDA");
        adapter.addFrag(new SobreFragment(), "SOBRE");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_desafios, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
