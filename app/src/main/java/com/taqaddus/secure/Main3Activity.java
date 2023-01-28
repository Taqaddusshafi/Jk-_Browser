package com.taqaddus.secure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private ProgressBar superprogressbar;
    private WebView superwebview;
    private FrameLayout frameLayout;
    String url;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        superprogressbar = findViewById(R.id.progress_bar25);
        superwebview = findViewById(R.id.webview25);
        frameLayout=findViewById(R.id.framelayout25);
        superprogressbar.setMax(100);

        superprogressbar.setProgress(20);
        superwebview.getSettings().setBuiltInZoomControls(true);
        superwebview.getSettings().setJavaScriptEnabled(true);
        superwebview.setWebViewClient(new WebViewClient());
        url=getIntent().getStringExtra("link2");
        superwebview.loadUrl(url);


        superwebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                frameLayout.setVisibility(View.VISIBLE);
                superprogressbar.setProgress(newProgress);
                if (newProgress==100){
                    frameLayout.setVisibility(View.GONE);
                }
            }






            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }

        });

        superwebview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String s, String s1, String s2, String s3, long l) {
                DownloadManager.Request request= new DownloadManager.Request(Uri.parse(s));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                DownloadManager manager=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
                manager.enqueue(request);
                Toast.makeText(Main3Activity.this,"Your File is  Dowloading...",Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.super_menu, menu);
        MenuItem menuItem=menu.findItem(R.id.app_bar_search);
        final SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                superwebview.loadUrl("https://www.google.com/search?q="+searchView.getQuery());
                return false;

            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()) {
            case R.id.back_button:
                onBackPressed();
                break;
            case R.id.forward:
                onForwardPressed();
                break;
            case R.id.go_home:
                Intent intent=new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
                break;
            case R.id.refresh:
                superwebview.reload();
                break;
        }
        return super.onOptionsItemSelected(item);
    }






    public void onForwardPressed() {
        if (superwebview.canGoForward()) {
            superwebview.goForward();
        } else
        {
            Toast.makeText(this,"Can't go forward",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        if (superwebview.canGoBack()) {
            superwebview.goBack();
        } else {
            finish();
        }
    }


}
