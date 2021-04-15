package com.example.exercise1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class data_activity extends AppCompatActivity {
    TextView tvnama, tvnomor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");


        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah");
                tvnomor.setText("08121122334");
                break;
            case "Ilham":
                tvnama.setText("Ilham");
                tvnomor.setText("08122345234");
                break;
            case "Eris":
                tvnama.setText("Eris");
                tvnomor.setText("08128123941");
                break;
            case "Fikri":
                tvnama.setText("Fikri");
                tvnomor.setText("08128122819");
                break;
            case "Maul":
                tvnama.setText("Maul");
                tvnomor.setText("08122777642");
                break;
            case "Intan":
                tvnama.setText("Intan");
                tvnomor.setText("08122224321");
                break;
            case "Vina":
                tvnama.setText("Vina");
                tvnomor.setText("08122559685");
                break;
            case "Gita":
                tvnama.setText("Gita");
                tvnomor.setText("08199221204");
                break;
            case "Lutfi":
                tvnama.setText("Lutfi");
                tvnomor.setText("08128887345");
                break;
            case "Vian":
                tvnama.setText("Vian");
                tvnomor.setText("08144425678");
                break;





        }

    }
}
