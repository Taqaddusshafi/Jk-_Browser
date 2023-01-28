package com.taqaddus.secure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class Main4Activity extends AppCompatActivity {
    EditText searchView;
    private Button button,button2,button3,button4,button203,button5,button6,button7,button8,button9,button10,button11,button12,button13,button91;
   private ImageButton imageButton;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    BottomNavigationView naveView;
    AdView adView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.multi:
                    Intent intent=new Intent(Main4Activity.this,multiwebpage.class);
                    startActivity(intent);
                    break;
                case R.id.multi2:
                    Intent intent1=new Intent(Main4Activity.this,Main2Activity.class);
                    startActivity(intent1);
                 break;
                case R.id.browse:
                    Intent intent2=new Intent(Main4Activity.this,Screach.class);
                    startActivity(intent2);
                    break;
            }
            return false;
        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        drawerLayout = findViewById(R.id.drawable_layout);
        searchView=findViewById(R.id.s123);
        naveView=findViewById(R.id.same_nav);

        naveView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url_address=searchView.getText().toString();
                if(TextUtils.isEmpty(url_address)){
                    Toast empty=Toast.makeText(Main4Activity.this,"please enter url or web address",Toast.LENGTH_LONG);
                    empty.show();

                }else {
                    String url="https://www.google.com/search?q="+searchView.getText();



                    Intent screach=new Intent(Main4Activity.this,Main3Activity.class);
                    screach.putExtra("link2",url);
                    startActivity(screach);
                }

            }
        });




        button203=findViewById(R.id.buttongo);
        adView=findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        button203.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url_address=searchView.getText().toString();
                if(TextUtils.isEmpty(url_address)){
                    Toast empty=Toast.makeText(Main4Activity.this,"please enter url or web address",Toast.LENGTH_LONG);
                    empty.show();

                }else {
                    String url="https://www.google.com/search?q="+searchView.getText();



                    Intent screach=new Intent(Main4Activity.this,Main3Activity.class);
                    screach.putExtra("link2",url);
                    startActivity(screach);
                }
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(Main4Activity.this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView = findViewById(R.id.navigation_view);
        final View inflateHeaderView= navigationView.inflateHeaderView(R.layout.navigation_header);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.multi:
                        Intent intent=new Intent(Main4Activity.this,multiwebpage.class);
                        startActivity(intent);

                        break;
                    case R.id.multi2:
                        Intent intent1=new Intent(Main4Activity.this,Main2Activity.class);
                        startActivity(intent1);
                        break;
                    case R.id.browse:
                        Intent intent2=new Intent(Main4Activity.this,Screach.class);
                        startActivity(intent2);
                        break;




            }


                return false;
            }
        });
        searchView=findViewById(R.id.s123);
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable charSequence) {





            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");



        }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
