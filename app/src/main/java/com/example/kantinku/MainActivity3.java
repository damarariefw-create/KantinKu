package com.example.kantinku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatActivity;

public class PilihMakananActivity extends AppCompatActivity {

    Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pilih_makanan);

        btnLanjut = findViewById(R.id.btnLanjut);

        btnLanjut.setOnClickListener(v -> {

            Intent intent = new Intent(
                    PilihMakananActivity.this,
                    PilihMinumanActivity.class
            );

            startActivity(intent);

        });
    }
}