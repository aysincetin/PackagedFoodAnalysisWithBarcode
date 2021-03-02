package com.example.barcod;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class IdealKiloActivity extends AppCompatActivity  {

    Spinner spinner;
    TextView text, text2;
    EditText boy, kilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ideal_kilo);

        spinner = findViewById(R.id.spinner);
        text = findViewById(R.id.textView36);
        text2 = findViewById(R.id.textView35);
        boy = findViewById(R.id.boy);
        kilo = findViewById(R.id.kilo);
    }

    public void hesapla(View view){
        int _boy = 100;
        int _kilo = 100;
        String cins = spinner.getSelectedItem().toString();
        if(cins.equals("Kadın")){
            try{
                 _boy = Integer.parseInt(boy.getText().toString());
                 _kilo = Integer.parseInt(kilo.getText().toString());
                double sonuc = _kilo / (Math.pow((float) _boy / 100, 2));
                text.setText(String.format("%.2f", sonuc));
                _hesapla(sonuc);
            }catch (Exception e){
                Toast.makeText(this,"Boş bırakılamaz", Toast.LENGTH_SHORT).show();
            }


        }else if(cins.equals("Erkek")){
            try {
                _boy = Integer.parseInt(boy.getText().toString());
                _kilo = Integer.parseInt(kilo.getText().toString());
                double sonuc = _kilo / (Math.pow((float) _boy / 100, 2));
                text.setText(String.format("%.2f", sonuc));
                _hesapla(sonuc);
            }catch (Exception e){
                Toast.makeText(this,"Boş bırakılamaz", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void _hesapla(double sonuc){
        if(sonuc < 18.49){
            text2.setText("İdeal Kilonun Altı");

        }else if(18.49 < sonuc && sonuc < 24.99){
            text2.setText("İdeal Kilo");

        }else if(24.99 < sonuc && sonuc < 29.99){
            text2.setText("İdeal Kilonun Üzeri");

        }else if(sonuc > 30){
            text2.setText("İdeal Kilonun Çok Üzeri");

        }
    }
}
