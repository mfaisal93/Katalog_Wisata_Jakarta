package com.faisal.katalogwisatajakarta.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.faisal.katalogwisatajakarta.R;
import com.faisal.katalogwisatajakarta.adapter.WisataAdapter;
import com.faisal.katalogwisatajakarta.model.Wisata;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataJudul;
    private TypedArray dataPoster;
    private String[] dataDeskripsi;
    private WisataAdapter adapter;
    private ArrayList<Wisata> wisataArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new WisataAdapter(this);
        RecyclerView list = findViewById(R.id.rv);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Prepare();
        addItem();
    }

    private void Prepare(){
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
    }

    private void addItem(){
        wisataArrayList = new ArrayList<>();

        for (int i = 0; i<dataJudul.length; i++){
            Wisata wisata = new Wisata();
            wisata.setJudul(dataJudul[i]);
            wisata.setPoster(dataPoster.getResourceId(i,-1));
            wisata.setDeskripsi(dataDeskripsi[i]);
            wisataArrayList.add(wisata);
        }
        adapter.setWisatas(wisataArrayList);
    }
}
