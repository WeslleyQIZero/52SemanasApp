package br.com.clubeapp.a52semanas.Activitys.Adaptes;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.clubeapp.a52semanas.Activitys.Fragments.AjudaFragment;
import br.com.clubeapp.a52semanas.Activitys.Fragments.DesafiosFragment;
import br.com.clubeapp.a52semanas.Activitys.Fragments.SobreFragment;

/**
 * Created by Denis Souza on 23/07/2017.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] titles = {"DESAFIOS","AJUDA","SOBRE"};

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public TabsAdapter(FragmentManager fm,Context c) {
        super(fm);
        this.mContext = c;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        if (position==0){//DESAFIOS
            f = new DesafiosFragment();
        }
        else if(position == 1){
            f = new AjudaFragment();
        }
        else if(position == 2){
            f = new SobreFragment();
        }
        return f;
    }

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (titles[position]);
    }
}