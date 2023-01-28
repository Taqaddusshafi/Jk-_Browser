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
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

public class multiwebpage extends AppCompatActivity {
    WebView webView;
    WebView webView2;
    FrameLayout frameLayout;
    ProgressBar superprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiwebpage);
        webView = findViewById(R.id.webView1);
        webView2 = findViewById(R.id.webView2);
        webView2.setWebViewClient(new WebViewClient());
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.loadUrl("https://google.com");
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://google.com");
    }


    @Override
    public void onBackPressed() {
        if (webView2.canGoBack()) {
            webView2.goBack();
        } else {
            finish();

        }
    }

    public void onForwardPressed() {
        if (webView2.canGoForward()) {
            webView2.goForward();
        } else {
            Toast.makeText(this, "Can't go forward for firstwebpage", Toast.LENGTH_SHORT).show();
        }

    }

    public void onForwardPressed2() {
        if (webView.canGoForward()) {
            webView.goForward();
        } else {
            Toast.makeText(this, "Can't go forward for webpage2", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.multi_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.first:
                onBackPressed();
                break;
            case R.id.for1:
                onForwardPressed();
                break;
            case R.id.sec:
                onBackPressed2();
                break;
            case R.id.for2:
                onForwardPressed2();
                break;
            case R.id.ref1:
                webView2.reload();
                break;
            case R.id.ref2:
                webView.reload();
                break;
            case R.id.go1:
                webView2.loadUrl("https://google.com");
                break;
            case R.id.go2:
                webView.loadUrl("https://google.com");
                break;
            case R.id.main_home:
                Intent intent=new Intent(multiwebpage.this,Main4Activity.class);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed2() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();

        }
    }

}


