package com.taqaddus.secure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Screach extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private EditText text;
    private ImageButton button2;
    private AdView adView;
    private Toolbar toolbar;
    private SearchView searchView;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screach);
        toolbar=findViewById(R.id.main_tol_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Secure");
        button = findViewById(R.id.search_button_home);
        adView=findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        text = findViewById(R.id.search_url_home);

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view==button){
            openwebsite();
        }
    }

    private void openwebsite() {
        String url_address=text.getText().toString();
        if(TextUtils.isEmpty(url_address)){
            Toast empty=Toast.makeText(Screach.this,"please enter url or web address",Toast.LENGTH_LONG);
            empty.show();

        }else {
        String url="https://www.google.com/search?q="+text.getText();



        Intent screach=new Intent(Screach.this,urlscreach.class);
        screach.putExtra("link1",url);
        startActivity(screach);
    }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.super_menu3, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.shome:
                Intent intent=new Intent(Screach.this,Main4Activity.class);
                startActivity(intent);

                break;

        }
        return super.onOptionsItemSelected(item);
    }



}

