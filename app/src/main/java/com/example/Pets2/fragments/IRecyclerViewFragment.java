package com.example.Pets2.fragments;

import com.example.Pets2.adapter.MascotaAdaptador;
import com.example.Pets2.clases.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragment {

    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> contactos);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
