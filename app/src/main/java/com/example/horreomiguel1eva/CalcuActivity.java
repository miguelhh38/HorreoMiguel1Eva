package com.example.horreomiguel1eva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcuActivity extends AppCompatActivity {
    TextView pantalla;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button bpunto;
    Button bborrar;
    Button binv;

    Button bsuma;
    Button bresta;
    Button bigual;
    Button bmulti;
    Button bbarra;


    Double numero1, numero2, resultado;

    int operadorActual = 0;

    boolean pulsado = false;
    boolean punto = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);

        pantalla = (TextView) findViewById(R.id.textView3);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);
        bpunto = (Button) findViewById(R.id.bpunto);

        bborrar = (Button) findViewById(R.id.bborrar);
        binv = (Button) findViewById(R.id.binv);

        bsuma = (Button) findViewById(R.id.bmas);
        bresta = (Button) findViewById(R.id.bmenos);
        bigual = (Button) findViewById(R.id.bigual);
        bmulti = (Button) findViewById(R.id.bmulti);
        bbarra = (Button) findViewById(R.id.bbarra);



        bigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (operadorActual) {

                    case 0:
                        if (pantalla.getText().equals(0))
                            pantalla.setText("0");
                        break;
                    case 1:
                        numero2 = Double.parseDouble(pantalla.getText().toString());
                        resultado = numero1 + numero2;
                        break;
                    case 2:
                        numero2 = Double.parseDouble(pantalla.getText().toString());
                        resultado = numero1 - numero2;
                        break;
                    case 3:
                        numero2 = Double.parseDouble(pantalla.getText().toString());
                        resultado = numero1 * numero2;
                        break;
                    case 4:
                        numero2 = Double.parseDouble(pantalla.getText().toString());
                        resultado = numero1 / numero2;
                        break;

                }
                if (operadorActual != 0) {
                    if (resultado - Math.floor(resultado) == 0) {
                        pantalla.setText(String.valueOf(Math.round(resultado)));
                    } else {
                        pantalla.setText(String.valueOf(resultado));
                    }
                }

            }
        });
        bbarra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operadorActual = 4;
                numero1 = Double.parseDouble(pantalla.getText().toString());
                pulsado = true;

            }
        });

        bmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operadorActual = 3;
                numero1 = Double.parseDouble(pantalla.getText().toString());
                pulsado = true;

            }
        });
        bresta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operadorActual = 2;
                numero1 = Double.parseDouble(pantalla.getText().toString());
                pulsado = true;

            }
        });


        bsuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operadorActual = 1;
                numero1 = Double.parseDouble(pantalla.getText().toString());
                pulsado = true;

            }
        });

        binv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String invertir = "";
                for (int i = pantalla.length() - 1; i >= 0; i--) {
                    invertir += pantalla.getText().charAt(i);
                }
                pantalla.setText(invertir);
            }
        });

        bborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operadorActual = 0;
                numero1 = null;
                numero2 = null;
                pantalla.setText("0");
                punto = false;
            }
        });

        bpunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (punto == false) {
                    if (pulsado == true) {
                        pantalla.setText("0.");
                        pulsado = false;
                    } else {
                        pantalla.setText(pantalla.getText() + ".");
                    }
                    punto = true;
                }

            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    pantalla.setText("0");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("0");
                    } else
                        pantalla.setText(pantalla.getText() + "0");
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("1");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("1");
                    } else {
                        pantalla.setText(pantalla.getText() + "1");
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("2");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("2");
                    } else {
                        pantalla.setText(pantalla.getText() + "2");
                    }
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("3");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("3");
                    } else {
                        pantalla.setText(pantalla.getText() + "3");
                    }
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("4");
                    pulsado = false;
                } else {

                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("4");
                    } else {
                        pantalla.setText(pantalla.getText() + "4");
                    }
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("5");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("5");
                    } else {
                        pantalla.setText(pantalla.getText() + "5");
                    }
                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("6");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("6");
                    } else {
                        pantalla.setText(pantalla.getText() + "6");
                    }
                }
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("7");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("7");
                    } else {
                        pantalla.setText(pantalla.getText() + "7");
                    }
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("8");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("8");
                    } else {
                        pantalla.setText(pantalla.getText() + "8");
                    }
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pulsado == true) {
                    punto = false;
                    pantalla.setText("9");
                    pulsado = false;
                } else {
                    if (pantalla.getText().equals("0")) {
                        pantalla.setText("9");
                    } else {
                        pantalla.setText(pantalla.getText() + "9");
                    }
                }
            }
        });
    }
}