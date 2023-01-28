package com.taqaddus.secure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.SearchView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private SearchView searchView;
    private WebView webView, webView2, webView3, webView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        webView = findViewById(R.id.webView);
        webView2 = findViewById(R.id.web2);
        webView3 = findViewById(R.id.web3);
        webView4 = findViewById(R.id.web4);



        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.setWebChromeClient(new WebChromeClient());
        webView4.setWebViewClient(new WebViewClient());
        webView4.getSettings().setBuiltInZoomControls(true);
        webView4.loadUrl("https://google.com");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("https://google.com");

        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.setWebChromeClient(new WebChromeClient());
        webView3.setWebViewClient(new WebViewClient());
        webView3.getSettings().setBuiltInZoomControls(true);
        webView3.loadUrl("https://google.com");

        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebChromeClient(new WebChromeClient());
        webView2.setWebViewClient(new WebViewClient());
        webView2.getSettings().setBuiltInZoomControls(true);
        webView2.loadUrl("https://google.com");


    }

    @Override
    public void onBackPressed() {
        if (webView4.canGoBack()) {
            webView4.goBack();
        } else {
            finish();
        }
    }

    public void onBackPressed2() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }

    public void onBackPressed3() {
        if (webView2.canGoBack()) {
            webView2.goBack();
        } else {
            finish();
        }
    }

    public void onBackPressed4() {
        if (webView3.canGoBack()) {
            webView3.goBack();
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.multi_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.one:
                onBackPressed2();
                break;
            case R.id.two:
                onBackPressed3();
                break;
            case R.id.three:
                onBackPressed4();
                break;
            case R.id.four:
                onBackPressed();
                break;
            case R.id.fone:
                onForwardPressed();
                break;
            case R.id.ftwo:
                onForwardPressed2();
                break;
            case R.id.fthree:
                onForwardPressed3();
                break;
            case R.id.ffour:
                onForwardPressed4();
                break;
            case R.id.rone:
                webView.reload();
                webView4.reload();
                webView3.reload();
                webView2.reload();
                break;
            case R.id.hone:
                webView2.loadUrl("https://google.com");
                webView.loadUrl("https://google.com");
                webView3.loadUrl("https://google.com");
                webView4.loadUrl("https://google.com");
                break;
            case R.id.home_main1:
                Intent intent= new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    public void onForwardPressed() {
        if (webView.canGoForward()) {
            webView.goForward();
        } else {
            Toast.makeText(this, "Can't go forward for ist page", Toast.LENGTH_SHORT).show();
        }
    }

    public void onForwardPressed2() {
        if (webView2.canGoForward()) {
            webView2.goForward();
        } else {
            Toast.makeText(this, "Can't go forward for 2nd page", Toast.LENGTH_SHORT).show();
        }
    }

    public void onForwardPressed3() {
        if (webView3.canGoForward()) {
            webView3.goForward();
        } else {
            Toast.makeText(this, "Can't go forward for third page", Toast.LENGTH_SHORT).show();
        }
    }

    public void onForwardPressed4() {
        if (webView4.canGoForward()) {
            webView4.goForward();
        } else {
            Toast.makeText(this, "Can't go forward for fourth page", Toast.LENGTH_SHORT).show();
        }
    }


}