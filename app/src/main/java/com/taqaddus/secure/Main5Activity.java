package com.taqaddus.secure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

public class Main5Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TabsAccessorAdapter tabsAccessorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        toolbar=findViewById(R.id.main_tol_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Secure");
        viewPager=findViewById(R.id.mai_tab_pager);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabsAccessorAdapter=new TabsAccessorAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsAccessorAdapter);
        tabLayout=findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        {
            Intent intent=new Intent(Main5Activity.this,Main4Activity.class);
            startActivity(intent);
            return true;
        }
    }

}

