package com.example.myapplication.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.fragment.first_Fragment;
import com.example.myapplication.fragment.second_Fragment;
import com.google.android.material.tabs.TabLayout;

public class tab_Activity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_);
        viewPager=(ViewPager) findViewById(R.id.tablayout_viewpager);
        tabLayout=(TabLayout) findViewById(R.id.tablayout_tl);

        manager=getSupportFragmentManager();

        viewPager.setAdapter(new tab_Activity.adapter(manager));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public class adapter extends FragmentPagerAdapter{
        public adapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            if (position==0){
                fragment=new first_Fragment();
            }
            if (position==1){
                fragment=new second_Fragment();
            }
            if (position==2){
                fragment=new first_Fragment();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
