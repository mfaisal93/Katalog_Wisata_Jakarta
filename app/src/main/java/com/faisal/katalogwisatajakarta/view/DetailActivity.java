package com.faisal.katalogwisatajakarta.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.faisal.katalogwisatajakarta.R;
import com.faisal.katalogwisatajakarta.model.Wisata;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Wisata data;
    Button lokasi,jadwal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        data = getIntent().getParcelableExtra("wisata");

        TextView deskripsi = findViewById(R.id.description);
        ImageView imageView = findViewById(R.id.expandedImage);
        lokasi = findViewById(R.id.btn_lokasi);
        jadwal = findViewById(R.id.btn_jadwal);

        deskripsi.setText(data.getDeskripsi());
        imageView.setImageResource(data.getPoster());

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(data.getJudul());

        lokasi.setOnClickListener(this);
        jadwal.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_lokasi:
                Uri uri = Uri.parse("geo:0,0?q="+data.getJudul());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getPackageManager())!= null){
                    startActivity(intent);
                }
                break;
            case R.id.btn_jadwal:
                Intent intetJadwal = new Intent(Intent.ACTION_EDIT);
                intetJadwal.setType("vnd.android.cursor.item/event");
                intetJadwal.putExtra(CalendarContract.Events.TITLE,data.getJudul());
                intetJadwal.putExtra(CalendarContract.Events.DESCRIPTION, "Ayo jalan - jalan");
                intetJadwal.putExtra(CalendarContract.Events.EVENT_LOCATION,data.getJudul());

                startActivity(intetJadwal);
                break;
        }
    }
}
