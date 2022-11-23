package com.example.horreomiguel1eva;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {
    SeekBar puntuacionb;
    TextView puntuacion;

    EditText titulo;
    EditText correo;
    EditText asunto;
    EditText contenido;

    Button enviar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        puntuacionb = (SeekBar) findViewById(R.id.seekBar);
        puntuacion = (TextView) findViewById(R.id.textViewProgress);

        puntuacionb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                puntuacion.setText("   " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        titulo = (EditText) findViewById(R.id.tituloEditText);
        correo = (EditText) findViewById(R.id.correoEditText);
        asunto = (EditText) findViewById(R.id.asuntoEditText);
        contenido = (EditText) findViewById(R.id.contenidoEditText);
        enviar = (Button) findViewById(R.id.benviar);


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String errores = "";
                String stitulo = titulo.getText().toString();
                if (stitulo.length() < 1) {
                    errores += "Introduce un título válido para el correo\n";
                    titulo.setText("");
                }

                String scorreo = correo.getText().toString();
                if (scorreo.length()<4 || !scorreo.contains("@")) {
                    errores += "Introduce un dirección de correo válida\n";
                    correo.setText("");
                }

                String sasunto = asunto.getText().toString();

                String scontenido = "Titulo: " + titulo.getText() + "\n" + "Puntuación: " + puntuacion.getText().toString() + "\n" +
                        contenido.getText().toString();

                if (errores.isEmpty()) {
                    if (asunto.length()<1) {
                        AlertDialog.Builder alerta = new AlertDialog.Builder(ContactActivity.this);
                        alerta.setMessage("¿Desea enviar un correo sin asunto?").setCancelable(true).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent1 = new Intent(Intent.ACTION_SEND);
                                intent1.putExtra(Intent.EXTRA_EMAIL, new String[] { scorreo });
                                intent1.putExtra(Intent.EXTRA_SUBJECT, sasunto);
                                intent1.putExtra(Intent.EXTRA_TEXT, scontenido);
                                intent1.setType("message/rfc822");
                                startActivity(Intent.createChooser(intent1, "Elije un cliente de Correo:"));

                                Intent intent = new Intent(ContactActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                        AlertDialog titulo = alerta.create();
                        titulo.setTitle("ASUNTO");
                        titulo.show();
                    } else {
                        Intent intent1 = new Intent(Intent.ACTION_SEND);
                        intent1.putExtra(Intent.EXTRA_EMAIL, new String[] { scorreo });
                        intent1.putExtra(Intent.EXTRA_SUBJECT, sasunto);
                        intent1.putExtra(Intent.EXTRA_TEXT, scontenido);
                        intent1.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent1, "Elije un cliente de Correo:"));


                    }






                } else {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(ContactActivity.this);
                    alertDialog.setMessage(errores + "\n¿Desea corregir los cambios?").setCancelable(true).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(ContactActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog titulo = alertDialog.create();
                    titulo.setTitle("ERROR DE ENVIO");
                    titulo.show();
                }





            }
        });


    }


}