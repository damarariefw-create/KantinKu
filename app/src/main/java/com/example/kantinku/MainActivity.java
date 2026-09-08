package com.example.kantinku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Kunci untuk mengirim data antar halaman
    public static final String EXTRA_NAME = "nama";
    public static final String EXTRA_PHONE = "no_telepon";

    private EditText inputNama;
    private EditText inputNoTelp;
    private Button btnMulaiPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputNama = findViewById(R.id.name);
        inputNoTelp = findViewById(R.id.phone);
        btnMulaiPesan = findViewById(R.id.button);

        btnMulaiPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = inputNama.getText().toString().trim();
                String noTelp = inputNoTelp.getText().toString().trim();

                if (nama.isEmpty() || noTelp.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nama dan nomor telepon wajib diisi", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(EXTRA_NAME, nama);
                intent.putExtra(EXTRA_PHONE, noTelp);
                startActivity(intent);
            }
        });
    }
}