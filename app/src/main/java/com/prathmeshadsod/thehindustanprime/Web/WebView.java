package com.prathmeshadsod.thehindustanprime.Web;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebViewClient;


import com.prathmeshadsod.thehindustanprime.R;

public class WebView extends AppCompatActivity {

    Toolbar toolbar;
    android.webkit.WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(null);

        /* For Backpress */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        /* Code for WebView */

        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");  // Link is we provided while giving intent to cardview in RecyclerAdapter in intent putExtra method

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(link);





    }



    // For Backpress Button

    /* I dont know why but its working for all categories without giving in switch statements properly */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}