package com.example.hola.devfestlp2016;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hola.devfestlp2016.fragmentos.FragmentHorario;
import com.example.hola.devfestlp2016.fragmentos.FragmentInicio;
import com.example.hola.devfestlp2016.fragmentos.FragmentTab;
import com.example.hola.devfestlp2016.fragmentos.ItemSpeaker;
import com.example.hola.devfestlp2016.fragmentos.MensajeFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            setTitle("INICIO");
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            FragmentInicio inicio = new FragmentInicio();
            //<TzRANSICION>
            fragmentTransaction.setCustomAnimations(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
            //<\TzRANSICION>
            fragmentTransaction.replace(R.id.contenedor_principal,inicio);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_gallery) {
// Handle the camera action
            setTitle("TAB");
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            FragmentTab evento = new FragmentTab();
            //TRANSICION
            fragmentTransaction.setCustomAnimations(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
            fragmentTransaction.replace(R.id.contenedor_principal, evento);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_horario) {
            setTitle("Horarios");
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            FragmentHorario evento = new FragmentHorario();
            //TRANSICION
            fragmentTransaction.setCustomAnimations(R.anim.zoom_forward_in, R.anim.zoom_forward_out);

            fragmentTransaction.replace(R.id.contenedor_principal, evento);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_speaker) {
            setTitle("SPEAKER");
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            ItemSpeaker evento = new ItemSpeaker();
            fragmentTransaction.setCustomAnimations(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
            fragmentTransaction.replace(R.id.contenedor_principal, evento);
            fragmentTransaction.commit();
        }else if (id == R.id.nav_ubicacion) {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=1600 Fundacion UNIFRANZ,  Landaeta, La Paz");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        } else if (id == R.id.nav_registro) {


        }else if (id == R.id.nav_mensaje) {
            setTitle("MENSAJE");
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            MensajeFragment evento = new MensajeFragment();
            fragmentTransaction.setCustomAnimations(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
            fragmentTransaction.replace(R.id.contenedor_principal, evento);
            fragmentTransaction.commit();
        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
