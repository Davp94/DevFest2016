package com.example.hola.devfestlp2016;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Map;

public class InformacionActivity extends AppCompatActivity {
    String keyEvento;
    TextView textView;

    CollapsingToolbarLayout collapsingToolbar;
    //TRANSICION BACK
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.right_in,R.anim.right_out);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbarInformacion));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
       collapsingToolbar =(CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page


        keyEvento = getIntent().getStringExtra("key");
        //TRANSICION
        overridePendingTransition(R.anim.left_in,R.anim.left_out);
        //Toast.makeText(getApplicationContext(),keyEvento,Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
