package com.example.hola.devfestlp2016.fragmentos;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.hola.devfestlp2016.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hola on 18/10/2016.
 */

public class FragmentTab extends Fragment {
    private ViewPager viewPager;
    private AppBarLayout appBar;
    private TabLayout pestanas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.viewpage,container,false);

        if (savedInstanceState == null) {
            //insertamos los Tabs
            insertarTabs(container);
            // Setear adaptador al viewpager.
            viewPager = (ViewPager) view.findViewById(R.id.pagina);

            //poblamos el ViewPager
           poblarViewPager(viewPager);




           pestanas.setupWithViewPager(viewPager);

            //agregamos los iconos en el los tabs
            pestanas.getTabAt(0).setIcon(R.drawable.ic_charlas);
            pestanas.getTabAt(1).setIcon(R.drawable.ic_codelab);
            pestanas.getTabAt(2).setIcon(R.drawable.ic_feria);
       }

        //devolvemos el view para visualizar el layotu dibujado en este fragmento
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        appBar.removeView(pestanas);
    }

    private void insertarTabs(ViewGroup container) {
        View padre = (View) container.getParent();
        appBar = (AppBarLayout) padre.findViewById(R.id.appbar);
        pestanas = new TabLayout(getActivity());
        pestanas.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(pestanas);
    }
    private void poblarViewPager(ViewPager viewPager) {
        //aquí agregamos los fragmentos a un adaptador
        AdaptadorSecciones adapter = new AdaptadorSecciones(getFragmentManager());
        adapter.addFragment(new ItemTab());
        adapter.addFragment(new ItemTab());
        adapter.addFragment(new ItemTab());
        //seteamos el adaptador donde cargamos los fragmentos
        //en la clase de abajo es donde cargamos y mostramos los fragmentos
        //que se mostrara en cada tab
        viewPager.setAdapter(adapter);
    }

    //creamos una clase para extender los métodos de FragmentStatePagerAdapter
    //así poder usar estos métodos para mostrar los contenidos de los framentos
    public class AdaptadorSecciones extends FragmentStatePagerAdapter {

        //lista para cada fragmento cargado y para mostrar
        private final List<Fragment> fragmentos = new ArrayList<>();

        //método para cada sección de los fragmentos
        public AdaptadorSecciones(FragmentManager fm) {
            super(fm);
        }

        //buscamos los fragmentos en cada posición
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragmentos.get(position);
        }

        //contamos los fragmentos
        @Override
        public int getCount() {
            return fragmentos.size();
        }

        //agregamos los fragmentos
        public void addFragment(android.support.v4.app.Fragment fragment) {
            fragmentos.add(fragment);
        }

    }

}
