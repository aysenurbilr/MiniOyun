package com.example.yakalamaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView kalan;
    TextView skor;
    ImageView []images;

    int sayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kalan = findViewById(R.id.kalan);
        skor = findViewById(R.id.skor);

        images = new ImageView[]{findViewById(R.id.g1),
                findViewById(R.id.g2),findViewById(R.id.g3),findViewById(R.id.g4)};

        hideImages();

        new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                hideImages();

                Random random = new Random();
                int uretilen = random.nextInt(4);
                images [uretilen].setVisibility(View.VISIBLE);

                kalan.setText("kalan süre:"+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                hideImages();

            }
        }.start();
    }
    public void baslaOyun(View view) {

        sayi = 0; // Oyun skorunu sıfırladık

        // Yeni bir CountDownTimer oluşturarak oyunu yeniden başlattık
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                hideImages(); // Resimleri gizler
                Random random = new Random();
                int uretilen = random.nextInt(4);
                images[uretilen].setVisibility(View.VISIBLE); // Rastgele bir resmi görünür yapar
                kalan.setText("kalan: " + millisUntilFinished / 1000); // Geri sayım metnini günceller
            }

            @Override
            public void onFinish() {
                hideImages();
            }
        }.start(); // CountDownTimer'ı başlattık
    }
    public void hideImages(){
        for (ImageView gezici : images){
            gezici.setVisibility(View.INVISIBLE);
        }
    }
    public void catchAgent(View view ){
        sayi++;
        skor.setText("Skor : "+sayi);

    }
}