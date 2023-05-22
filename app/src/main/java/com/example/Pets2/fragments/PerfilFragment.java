package com.example.Pets2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Pets2.adapter.MascotaAdaptador;
import com.example.Pets2.clases.Mascota;
import com.tr.Pet2.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    private ArrayList<Mascota> mascotas;

    private View view;

    private RecyclerView rvPerfilFotos;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfilFotos   = view.findViewById(R.id.rvPerfilFotos);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);

        rvPerfilFotos.setLayoutManager(gridLayoutManager);

        inicializarPerfil();
        inicializarAdaptador();

        return view;
    }

    public void inicializarPerfil(){

        CircularImageView   civPerfil       = view.findViewById(R.id.civPerfil);
        TextView            tvNombrePerfil  = view.findViewById(R.id.tvNombrePerfil);

        civPerfil.setBackgroundResource(R.drawable.ic_dog);
        tvNombrePerfil.setText("Fabri");

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 1));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 5));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 4));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 2));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 1));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 1));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 1));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 0));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 2));
        mascotas.add(new Mascota(R.drawable.ic_dog, "Fabri", 1));


    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(getActivity(), mascotas, R.layout.cardview_perfil_fotos);
        rvPerfilFotos.setAdapter(adaptador);
    }
}