package com.example.myapplication.NavigationDrawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.myapplication.NavigationDrawer.ui.gallery.GalleryFragment;
import com.example.myapplication.NavigationDrawer.ui.home.HomeFragment;
import com.example.myapplication.NavigationDrawer.ui.send.SendFragment;
import com.example.myapplication.NavigationDrawer.ui.share.ShareFragment;
import com.example.myapplication.NavigationDrawer.ui.slideshow.SlideshowFragment;
import com.example.myapplication.NavigationDrawer.ui.tools.ToolsFragment;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class navigation_Activity extends AppCompatActivity {

    DrawerLayout drawer;
    NavigationView navigationView;
    Fragment fragment;
    FragmentManager manager;
    FragmentTransaction transaction;
    private AppBarConfiguration mAppBarConfiguration;



    TextView nam,eml;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        nam = (TextView) headerView.findViewById(R.id.nav_header_name);
        eml = (TextView) headerView.findViewById(R.id.nav_header_email);



        sp=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String s1=sp.getString(Name,"");
        String s2=sp.getString(Email,"");

        nam.setText(s1);
        eml.setText(s2);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Bas bhai kem sadi kare che khoti khoti!!!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this, "Activity is refresh", Toast.LENGTH_SHORT).show();
            fragment = new HomeFragment();


        } else if (id == R.id.nav_gallery) {
            fragment = new GalleryFragment();


        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "Activity is refresh", Toast.LENGTH_SHORT).show();
            fragment = new SlideshowFragment();

        } else if (id == R.id.nav_tools) {
            fragment = new ToolsFragment();

        } else if (id == R.id.nav_share) {
            fragment = new ShareFragment();

        } else if (id == R.id.nav_send) {
            fragment = new SendFragment();


        }
        transaction = manager.beginTransaction();
        transaction.add(R.id.nav_host_fragment, fragment, "A");
        transaction.addToBackStack("addA");
        transaction.commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
