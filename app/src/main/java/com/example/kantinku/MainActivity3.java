package com.example.kantinku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    public static final String EXTRA_DRINK = "minuman";
    public static final String EXTRA_DRINK_PRICE = "harga_minuman";

    private RadioGroup radioMinuman;
    private Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        radioMinuman = findViewById(R.id.radioMinuman);
        btnLanjut = findViewById(R.id.btnLanjut);

        btnLanjut.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putExtra(MainActivity.EXTRA_NAME, getIntent().getStringExtra(MainActivity.EXTRA_NAME));
            intent.putExtra(MainActivity.EXTRA_PHONE, getIntent().getStringExtra(MainActivity.EXTRA_PHONE));
            intent.putExtra(MainActivity2.EXTRA_FOOD, getIntent().getStringExtra(MainActivity2.EXTRA_FOOD));
            intent.putExtra(MainActivity2.EXTRA_FOOD_PRICE, getIntent().getIntExtra(MainActivity2.EXTRA_FOOD_PRICE, 0));
            intent.putExtra(EXTRA_DRINK, getSelectedName(radioMinuman));
            intent.putExtra(EXTRA_DRINK_PRICE, getSelectedPrice(radioMinuman));
            startActivity(intent);
        });
    }

    // Ambil nama minuman yang dipilih dari teks RadioButton ("Es Teh - Rp3.000")
    private String getSelectedName(RadioGroup group) {
        int checkedId = group.getCheckedRadioButtonId();
        RadioButton rb = findViewById(checkedId);
        return rb.getText().toString().split(" - Rp")[0];
    }

    // Ambil harga minuman yang dipilih ("Rp3.000" -> 3000)
    private int getSelectedPrice(RadioGroup group) {
        int checkedId = group.getCheckedRadioButtonId();
        RadioButton rb = findViewById(checkedId);
        String priceStr = rb.getText().toString().split(" - Rp")[1].replace(".", "");
        return Integer.parseInt(priceStr);
    }
}