package com.androidfizz.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.androidfizz.main.adpater.PagerAdapter;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private PagerAdapter mPagerAdapter;
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        if (actionBar == null)
            return;

        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        setUpViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        setUpTabLayout(viewPager, tabLayout);
    }


    //icons as per no. of tabs
    private int[] icons = new int[]{
            R.drawable.tab_home,
            R.drawable.tab_favorite,
            R.drawable.tab_profile};

    private void setUpViewPager(ViewPager viewPager) {
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPagerAdapter.addFragment(new HomeFragment(), "Home");
        mPagerAdapter.addFragment(new FavoritesFragment(), "Favorite");
        mPagerAdapter.addFragment(new ProfileFragment(), "Profile");
        /*
        mPagerAdapter.addFragment(new PageFragment(), "Page 1");
        mPagerAdapter.addFragment(new PageFragment(), "Page 2");
        mPagerAdapter.addFragment(new PageFragment(), "Page 3");
        mPagerAdapter.addFragment(new PageFragment(), "Page 4");
        mPagerAdapter.addFragment(new PageFragment(), "Page 5");
        mPagerAdapter.addFragment(new PageFragment(), "Page 6");
        mPagerAdapter.addFragment(new PageFragment(), "Page 7");
        mPagerAdapter.addFragment(new PageFragment(), "Page 8");
        mPagerAdapter.addFragment(new PageFragment(), "Page 9");
        mPagerAdapter.addFragment(new PageFragment(), "Page 10");*/
        viewPager.setAdapter(mPagerAdapter);
        setActionBarTitle(0);
    }


    private void setUpTabLayout(ViewPager viewPager, TabLayout tabLayout) {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);
        for(int i=0; i<tabLayout.getTabCount(); i++){
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }
    }

    private void setActionBarTitle(int position) {
        if (actionBar != null) {
            actionBar.setTitle(mPagerAdapter.getPageTitle(position));
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        setActionBarTitle(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
