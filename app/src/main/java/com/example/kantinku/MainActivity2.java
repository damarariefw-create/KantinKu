package com.example.kantinku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_FOOD = "makanan";
    public static final String EXTRA_FOOD_PRICE = "harga_makanan";

    private RadioGroup radioMakanan;
    private Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioMakanan = findViewById(R.id.radioMakanan);
        btnLanjut = findViewById(R.id.btnLanjut);

        btnLanjut.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra(MainActivity.EXTRA_NAME, getIntent().getStringExtra(MainActivity.EXTRA_NAME));
            intent.putExtra(MainActivity.EXTRA_PHONE, getIntent().getStringExtra(MainActivity.EXTRA_PHONE));
            intent.putExtra(EXTRA_FOOD, getSelectedName(radioMakanan));
            intent.putExtra(EXTRA_FOOD_PRICE, getSelectedPrice(radioMakanan));
            startActivity(intent);
        });
    }

    // Ambil nama item yang dipilih dari teks RadioButton ("Nasi Goreng - Rp15.000")
    private String getSelectedName(RadioGroup group) {
        int checkedId = group.getCheckedRadioButtonId();
        RadioButton rb = findViewById(checkedId);
        return rb.getText().toString().split(" - Rp")[0];
    }

    // Ambil harga item yang dipilih ("Rp15.000" -> 15000)
    private int getSelectedPrice(RadioGroup group) {
        int checkedId = group.getCheckedRadioButtonId();
        RadioButton rb = findViewById(checkedId);
        String priceStr = rb.getText().toString().split(" - Rp")[1].replace(".", "");
        return Integer.parseInt(priceStr);
    }
}