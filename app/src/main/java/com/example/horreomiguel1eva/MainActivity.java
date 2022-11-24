package com.example.horreomiguel1eva;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    TextView menuC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuC = (TextView) findViewById(R.id.menuTextView);
        registerForContextMenu(menuC);

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menu1, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.calcu:
                Intent intent = new Intent(MainActivity.this, CalcuActivity.class);
                startActivity(intent);
            return true;
            case R.id.contact:
                Intent intent1 = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent1);
            return true;

            default: return super.onOptionsItemSelected(item);
        }
    }

}