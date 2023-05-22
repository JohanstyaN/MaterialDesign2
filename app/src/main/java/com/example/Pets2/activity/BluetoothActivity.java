package com.example.Pets2.activity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tr.Pet2.R;

public class BluetoothActivity extends AppCompatActivity {

    private static final int CODIGO_HABILITAR_BLUETOOTH = 0;

    private Context context;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        context = getApplicationContext();
        activity = this;
    }


    public void habilitarBluetooth(View v) {


        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null)
            Toast.makeText(BluetoothActivity.this, "Su dipositivo no tiene bluetooth", Toast.LENGTH_SHORT);

        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, CODIGO_HABILITAR_BLUETOOTH);
        }


    }


}