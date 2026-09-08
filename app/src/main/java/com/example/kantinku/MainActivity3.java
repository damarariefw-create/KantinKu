package com.example.kantinku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        btnLanjut = findViewById(R.id.btnLanjut);

        btnLanjut.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity3.this,
                    MainActivity4.class
            );

            startActivity(intent);

        });
    }
}