package com.example.barcod;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EKodActivity extends AppCompatActivity{
    TextView ekod;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_kodlar);
        ekod = findViewById(R.id.ekod);
        s = getTermsString();
        ekod.setText(s);
    }

    private String getTermsString() {
        StringBuilder termsString = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("ekods.txt")));

            String str;
            while ((str = reader.readLine()) != null) {
                termsString.append(str);
                termsString.append("\n------------------------------------------------------------\n");

            }

            reader.close();
            return termsString.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

