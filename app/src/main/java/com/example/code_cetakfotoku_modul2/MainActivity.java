package com.example.code_cetakfotoku_modul2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements KeranjangBelanjaListener {

    private RecyclerView rvKatalogFoto;
    private KatalogFotoListAdapter adapter;
    private Button btnKeranjangBelanja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KatalogFotoUtil.init();
        OrderFotoUtil.init();

        rvKatalogFoto = findViewById(R.id.rv_katalog_foto);
        adapter = new KatalogFotoListAdapter(this);

        rvKatalogFoto.setAdapter(adapter);
        rvKatalogFoto.setLayoutManager(new LinearLayoutManager(this));

        btnKeranjangBelanja = findViewById(R.id.btn_keranjang_belanja);
        orderChanged();
        btnKeranjangBelanja.setOnClickListener(view -> {
            Intent intent = new Intent(this, KeranjangBelanjaActivity.class);
            startActivity(intent);
        });
        OrderFotoUtil.addkbListener(this);
    }

    @Override
    public void orderChanged() {
        String kbCountStr = "Keranjang Belanja: " + OrderFotoUtil.getOrderCount();
        btnKeranjangBelanja.setText(kbCountStr);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "App telah diresume", Toast.LENGTH_SHORT).show();
    }
}