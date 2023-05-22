package com.example.Pets2.presentador;

import android.content.Context;

import com.example.Pets2.clases.Mascota;
import com.example.Pets2.database.ConstructorMascotas;
import com.example.Pets2.fragments.IRecyclerViewFragment;

import java.util.ArrayList;

public class RecyclerViewPresenter implements IRecyclerViewPresenter{

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewPresenter(IRecyclerViewFragment iRecyclerViewFragment, Context context) {
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
    }

    @Override
    public void obtenerContactosBaseDeDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarLinearLayoutVertical();
    }
}
