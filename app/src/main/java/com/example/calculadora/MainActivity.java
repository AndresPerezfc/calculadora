package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numero_uno, numero_dos;
    private TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero_uno = findViewById(R.id.txtNumeroUno);
        numero_dos = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.txtResultado);

    }

    public void sumar(View v){
        int num_uno, num_dos, sumar;
        try{
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            sumar = num_uno + num_dos;
            resultado.setText("" + sumar);
        }catch (Exception e) {
            resultado.setText("Ingrese todos los valores");
        }
    }

    public void restar(View v){
        int num_uno, num_dos, restar;
        try{
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            restar = num_uno - num_dos;
            resultado.setText("" + restar);
        }catch (Exception e){
            resultado.setText("Ingrese todos los valores");
        }
    }

    public void multiplicar(View v){
        int num_uno, num_dos, multiplicar;
        try{
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            multiplicar = num_uno * num_dos;
            resultado.setText("" + multiplicar);
        }catch (Exception e){
            resultado.setText("Ingrese todos los valores");
        }
    }

    public void dividir(View v){
        int num_uno, num_dos, dividir;
        try {
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            dividir = num_uno / num_dos;
            resultado.setText("" + dividir);
        }catch (Exception e){
            resultado.setText("Ingrese todos los valores");
        }

    }

    public void limpiar(View v){
        numero_uno.setText("");
        numero_dos.setText("");
        resultado.setText("");
    }


}
