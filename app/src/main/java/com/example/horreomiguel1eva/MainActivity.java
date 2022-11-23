package com.example.horreomiguel1eva;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView animado;
    Animation miAnimacion;

    ImageButton calculadoraboton;
    ImageButton contactboton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animado = (TextView) findViewById(R.id.textView2);
        miAnimacion = AnimationUtils.loadAnimation(this, R.anim.animacion);
        animado.startAnimation(miAnimacion);

        calculadoraboton = (ImageButton) findViewById(R.id.calcuBoton);
        calculadoraboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalcuActivity.class);
                startActivity(intent);
            }
        });

        contactboton = (ImageButton) findViewById(R.id.imageButton2);
        contactboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });


    }
}