package com.example.kantinku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
            int checkedId = radioMinuman.getCheckedRadioButtonId();
            if (checkedId == -1) {
                Toast.makeText(MainActivity3.this, "Silakan pilih minuman terlebih dahulu", Toast.LENGTH_SHORT).show();
                return;
            }
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
        if (checkedId == -1) {
            return "";
        }
        RadioButton rb = findViewById(checkedId);
        if (rb == null) {
            return "";
        }
        String text = rb.getText().toString();
        if (text.contains(" - Rp")) {
            return text.split(" - Rp")[0];
        }
        return text;
    }

    // Ambil harga minuman yang dipilih ("Rp3.000" -> 3000)
    private int getSelectedPrice(RadioGroup group) {
        int checkedId = group.getCheckedRadioButtonId();
        if (checkedId == -1) {
            return 0;
        }
        RadioButton rb = findViewById(checkedId);
        if (rb == null) {
            return 0;
        }
        String text = rb.getText().toString();
        if (text.contains(" - Rp")) {
            try {
                String priceStr = text.split(" - Rp")[1].replace(".", "").trim();
                return Integer.parseInt(priceStr);
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }
}