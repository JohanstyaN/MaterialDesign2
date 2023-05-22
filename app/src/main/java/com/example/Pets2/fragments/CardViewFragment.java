package com.example.Pets2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Pets2.activity.CincoFavoritosActivity;
import com.example.Pets2.adapter.MascotaAdaptador;
import com.example.Pets2.clases.Mascota;
import com.example.Pets2.presentador.IRecyclerViewPresenter;
import com.example.Pets2.presentador.RecyclerViewPresenter;
import com.tr.Pet2.R;

import java.util.ArrayList;


public class CardViewFragment extends Fragment implements IRecyclerViewFragment {


    private ArrayList<Mascota> mascotas;

    private RecyclerView rvMascotas;

    private MascotaAdaptador adaptador;

    private IRecyclerViewPresenter presenter;

    public CardViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_card_view, container, false);


        rvMascotas = view.findViewById(R.id.rvMascotas);

        presenter = new RecyclerViewPresenter(this, getContext());

        presenter.obtenerContactosBaseDeDatos();

        clickFiveFavorite();

        return view;
    }

    public void clickFiveFavorite(){

        ImageButton ibFav = getActivity().findViewById(R.id.ibFav);

        ibFav.setOnClickListener(view -> {

            Intent intent = new Intent(getActivity(), CincoFavoritosActivity.class);

            startActivity(intent);
        });
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(linearLayoutManager);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        adaptador = new MascotaAdaptador(getActivity(), mascotas, R.layout.cardview_mascota);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}