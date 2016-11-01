package com.example.hola.devfestlp2016.fragmentos;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hola.devfestlp2016.InformacionActivity;
import com.example.hola.devfestlp2016.R;


/**
 * Created by hola on 18/10/2016.
 */

public class ItemTab extends Fragment {
    RecyclerView recyclerView;
    ViewGroup viewGroup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView=(RecyclerView)inflater.inflate(R.layout.recycleview,container,false);
        viewGroup=container;
        View view=new View(getActivity());
        //agregamos contenido al adaptador
        ContentAdapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));


        return recyclerView;
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    //clase para poblar el recyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        //método para el contenido y poder usar el evento click
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_tab, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(v.getContext(), InformacionActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }


    // clase para visualizar el contenido del fragmento_layout creado en una lista
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // cantidad a visualizar en la lista
        private static final int LENGTH = 18;

        public ContentAdapter() {
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // no-op
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
