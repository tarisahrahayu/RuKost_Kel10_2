package com.example.rukost_kel10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText Pilihtanggal;
    private ImageButton btn_tgl;

    private int tahun,bulan,tanggal;
    private int tahun2,bulan2,tanggal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kalender);
        Pilihtanggal = findViewById(R.id.Pilihtanggal);
        btn_tgl = findViewById(R.id.btn_tgl);



        btn_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                tahun = calendar.get(Calendar.YEAR);
                bulan = calendar.get(Calendar.MONTH);
                tanggal = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tahun = year;
                        bulan = month;
                        tanggal = dayOfMonth;

                        Pilihtanggal.setText(tanggal + " - " + bulan + " - " + tahun);
                    }
                },tahun,bulan,tanggal);
                dialog.show();
            }
        });

        Pilihtanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                tahun2 = calendar.get(Calendar.YEAR);
                bulan2 = calendar.get(Calendar.MONTH);
                tanggal2 = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tahun2 = year;
                        bulan2 = month;
                        tanggal2 = dayOfMonth;

                        Pilihtanggal.setText(tanggal2 + " - " + bulan2 + " - " + tahun2);
                    }
                },tahun2,bulan2,tanggal2);
                dialog.show();
            }
        });
    }
}