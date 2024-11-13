package com.example.zadanie4rzutkoscmi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button rzutkoscia;
    private Button reset;

    private TextView kosc1;
    private TextView kosc2;
    private TextView kosc3;
    private TextView kosc4;
    private TextView kosc5;

    private TextView wynikrzutu;
    private TextView wynikgry;
    private TextView liczbarzutow;
    private int liczba_rzut = 0;
    private int sum = 0;
    private int sum_gry = 0;
    private ArrayList<Integer> wyn_los;

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rzutkoscia = findViewById(R.id.rzutkoscia);
        reset = findViewById(R.id.reset);

        kosc1 = findViewById(R.id.kosc1);
        kosc2 = findViewById(R.id.kosc2);
        kosc3 = findViewById(R.id.kosc3);
        kosc4 = findViewById(R.id.kosc4);
        kosc5 = findViewById(R.id.kosc5);

        wynikrzutu = findViewById(R.id.wynikrzutu);
        wynikgry = findViewById(R.id.wynikgry);
        liczbarzutow= findViewById(R.id.liczbarzutow);
        wyn_los = new ArrayList<>();

        rzutkoscia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liczba_rzut++;
                liczbarzutow.setText("Liczba rzutów: " + liczba_rzut);

                int[] wyniki = new int[5];
                for (int i = 0; i < 5; i++) {
                    wyniki[i] = random.nextInt(6) + 1;
                    sum += wyniki[i];
                }

                kosc1.setText(String.valueOf(wyniki[0]));
                kosc2.setText(String.valueOf(wyniki[1]));
                kosc3.setText(String.valueOf(wyniki[2]));
                kosc4.setText(String.valueOf(wyniki[3]));
                kosc5.setText(String.valueOf(wyniki[4]));

                wynikrzutu.setText("Wynik tego losowania: " + sum);
                sum_gry += sum;
                wynikgry.setText("Wynik gry: " + sum_gry);
                sum = 0;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kosc1.setText("?");
                kosc2.setText("?");
                kosc3.setText("?");
                kosc4.setText("?");
                kosc5.setText("?");
                liczba_rzut = 0;
                liczbarzutow.setText("Liczba rzutów: " + liczba_rzut);
                sum = 0;
                wynikrzutu.setText("Wynik tego losowania: " + sum);
                sum_gry = 0;
                wynikgry.setText("Wynik gry: " + sum_gry);
            }
        });
    }
}