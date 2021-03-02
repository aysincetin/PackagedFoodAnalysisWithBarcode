package com.example.barcod;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;




public class MainActivity extends AppCompatActivity {
    public static TextView box1;
    public static EditText search;
    public static String barkodd ;
    public TextView barkod;
    public Button button, btn,btnkod,btnbilgi,btnapp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barkod = findViewById(R.id.textView);
        box1 = findViewById(R.id.textView2);
        search = findViewById(R.id.simpleSearchView);

        buttons();
    }
    public void buttons(){
        button = (Button) findViewById(R.id.search);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        btn=(Button) findViewById(R.id.btnkilo);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIdealKiloActivity();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openIdealKiloActivity();
            }
        });

        btnkod=(Button) findViewById(R.id.btnkod);
        btnkod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEKodActivity();
            }
        });
        btnkod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEKodActivity();
            }
        });

        btnbilgi=(Button) findViewById(R.id.btnbilgi);
        btnbilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYararliBilgiActivity();
            }
        });
        btnbilgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYararliBilgiActivity();
            }
        });


        btnapp=(Button) findViewById(R.id.btnapp);
        btnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHakkindaActivity();
            }
        });
        btnapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHakkindaActivity();
            }
        });
    }
    public void openNewActivity(){
        MainActivity.fetchData fetchData = new MainActivity.fetchData();
        fetchData.execute();
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);

    }
    public void openIdealKiloActivity(){
        Intent intent = new Intent(this, IdealKiloActivity.class);
        startActivity(intent);
    }
    public void openEKodActivity(){
        Intent intent = new Intent(this, EKodActivity.class);
        startActivity(intent);
    }
    public void openYararliBilgiActivity(){
        Intent intent = new Intent(this, YararliBilgiActivity.class);
        startActivity(intent);
    }
    public void openHakkindaActivity(){
        Intent intent = new Intent(this, HakkindaActivity.class);
        startActivity(intent);
    }
    public void onClick(View view){
        barkodd = barkod.getText().toString();
        new fetchData().execute();
    }

    public void scan(View view){
        startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
    }

    public static class fetchData extends AsyncTask<Void,Void,Void> {

        public Document doc ;
        public String Name ;
        public String Img ;
        public String Health ;
        public String Kal ;
        public String TYag ;
        public String DYag ;
        public String Seker ;
        public String Tuz ;
        public String Kalo ;
        String[] Analiz = new String[50];
        String[] sAnaliz = new String[50];
        String AlerjenTemp;
        String[] arrOfStr;
        float kiloHesap;
        String temp;
        String temp2;
        int i, k = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            MainActivity.barkodd = search.getText().toString();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            NewActivity.kalori.setText(Kal);
            NewActivity.tYag.setText(TYag);
            NewActivity.dYag.setText(DYag);
            NewActivity.seker.setText(Seker);
            NewActivity.tuz.setText(Tuz);
            NewActivity.ad.setText(Name);
            NewActivity.kilo.setText("Bu üründen " + String.format("%.2f", kiloHesap) + " adet yerseniz 1 kilo alırsınız.");
            if(!Img.equals("")){Picasso.get().load(Img).into(NewActivity.imageView);}

            for (int j = 1; j < k - 1; j++){
                if(sAnaliz[j] != null && !sAnaliz[j].equals("")) {
                    NewActivity.sAnaliz.append(sAnaliz[j] + "\n");
                }

            }

            for (int a = 0; a < i; a++){
                if(Analiz[a] != null && !Analiz[a].equals("")){
                    NewActivity.kAnaliz.append(Analiz[a] + "\n");
                }
            }
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String url = "http://kliktag.com/products/product.php?gtin=0" + barkodd;
            try {
                doc = Jsoup.connect(url).get();
                Elements name = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(0)>div:eq(1)>div:eq(1)>div:eq(0)");
                Name = name.text();
                Elements img = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(0)>div:eq(1)>div:eq(0)>figure>a");
                Img = img.attr("href");
                Elements heal = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(2)");
                Health = heal.text();
                Elements kal = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(4)>div:eq(1)>div:eq(0)>div");
                Kal = kal.text();
                Elements tyag = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(4)>div:eq(1)>div:eq(1)>div");
                TYag = tyag.text();
                Elements dyag = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(4)>div:eq(1)>div:eq(2)>div");
                DYag = dyag.text();
                Elements seker = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(4)>div:eq(1)>div:eq(3)>div");
                Seker = seker.text();
                Elements tuz = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(4)>div:eq(1)>div:eq(4)>div");
                Tuz = tuz.text();
                Elements alej = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(5)>div:eq(1)");
                AlerjenTemp = alej.text();
                Elements kalo = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(0)>div:eq(2)>div:eq(1)>div");
                Kalo = kalo.text();
                Elements tem = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(2)>div:eq(0)");
                temp2 = tem.text();


                while (!tem.text().equals("E-KOD ANALİZİ")) {
                    tem = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(2)>div:eq(" + k + ")");
                    Elements tem2 = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(2)>div:eq(" + k + ")>a>div>span");
                    if (tem.text() != null){
                        if (tem2.text() != null)
                            sAnaliz[k] = tem2.text();
                        k++;
                    }
                    if(k >= 20){break;}
                }

                Elements analiz = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(2)>div:eq("+k+")>div:eq(0)>a>div>span");
                temp = analiz.text();

                while (!analiz.text().equals("")){
                    analiz = doc.select("html>body>div:eq(0)>div:eq(2)>div:eq(1)>div:eq(2)>div:eq("+k+")>div:eq("+i+")>a>div>span");
                    if (!analiz.text().equals("")){
                        Analiz[i] = analiz.text();
                        i++;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            arrOfStr  = Kal.split(" ", 2);
            kiloHesap = (float) (7000.0 / Integer.parseInt(arrOfStr[0]));
            return null;
        }

    }



}



