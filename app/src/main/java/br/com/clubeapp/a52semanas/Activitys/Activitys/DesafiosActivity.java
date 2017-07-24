package br.com.clubeapp.a52semanas.Activitys.Activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import br.com.clubeapp.a52semanas.Activitys.Adaptes.TabsAdapter;
import br.com.clubeapp.a52semanas.Activitys.Fragments.AjudaFragment;
import br.com.clubeapp.a52semanas.Activitys.Fragments.DesafiosFragment;
import br.com.clubeapp.a52semanas.R;

public class DesafiosActivity extends AppCompatActivity {
    private SlidingTabLayout mSlidingTabLayout;
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
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_view_list, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("AJUDA");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_help, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager(),this);
        adapter.addFrag(new DesafiosFragment(), "DESAFIOS");
        adapter.addFrag(new AjudaFragment(), "AJUDA");
        viewPager.setAdapter(adapter);
    }
}
