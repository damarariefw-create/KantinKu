package com.example.kantinku;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String nama = getIntent().getStringExtra(MainActivity.EXTRA_NAME);
        String noTelp = getIntent().getStringExtra(MainActivity.EXTRA_PHONE);
        String makanan = getIntent().getStringExtra(MainActivity2.EXTRA_FOOD);
        String minuman = getIntent().getStringExtra(MainActivity3.EXTRA_DRINK);
        int hargaMakanan = getIntent().getIntExtra(MainActivity2.EXTRA_FOOD_PRICE, 0);
        int hargaMinuman = getIntent().getIntExtra(MainActivity3.EXTRA_DRINK_PRICE, 0);

        ((TextView) findViewById(R.id.textView)).setText("Nama: " + nama);
        ((TextView) findViewById(R.id.textView2)).setText("Nomor Telepon: " + noTelp);
        ((TextView) findViewById(R.id.textView10)).setText("Makanan: " + makanan);
        ((TextView) findViewById(R.id.textView8)).setText("Minuman: " + minuman);
        ((TextView) findViewById(R.id.textView4)).setText("Harga Makanan: " + formatRupiah(hargaMakanan));
        ((TextView) findViewById(R.id.textView6)).setText("Harga Minuman: " + formatRupiah(hargaMinuman));
        ((TextView) findViewById(R.id.textView7)).setText("Total Harga: " + formatRupiah(hargaMakanan + hargaMinuman));
    }

    // Format angka ke format rupiah ("15000" -> "Rp15.000")
    private String formatRupiah(int harga) {
        return "Rp" + String.format(Locale.getDefault(), "%,d", harga).replace(',', '.');
    }
}