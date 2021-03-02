package com.example.barcod;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    public static TextView kalori, tYag, dYag, seker, tuz, sAnaliz, kAnaliz, ad, kilo;
    public static ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_content);
        kalori = findViewById(R.id.kalori);
        tYag = findViewById(R.id.TYag);
        dYag = findViewById(R.id.DYag);
        seker = findViewById(R.id.seker);
        tuz = findViewById(R.id.tuz);
        sAnaliz = findViewById(R.id.sAnaliz);
        kAnaliz = findViewById(R.id.kAnaliz);
        ad = findViewById(R.id.ad);
        imageView = findViewById(R.id.imageView);
        kilo = findViewById(R.id.kilo);
    }
}