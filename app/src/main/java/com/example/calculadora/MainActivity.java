package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numero_uno, numero_dos;
    private TextView resultado;
    private Spinner combo_operaciones;
    private String [] operaciones;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero_uno = findViewById(R.id.txtNumeroUno);
        numero_dos = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.txtResultado);
        combo_operaciones = findViewById(R.id.cmbOperaciones);
        operaciones = getResources().getStringArray(R.array.operaciones);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operaciones);
        combo_operaciones.setAdapter(adapter);

    }

    public void calcular (View v){
        int op;
        double num_uno, num_dos;
        double res = 0;
        if(validar()){
            num_uno = Double.parseDouble(numero_uno.getText().toString());
            num_dos = Double.parseDouble(numero_dos.getText().toString());
            op = combo_operaciones.getSelectedItemPosition();

            switch(op){
                case 0:
                    res = num_uno + num_dos;
                    break;
                case 1:
                    res = num_uno - num_dos;
                    break;
                case 2:
                    res = num_uno * num_dos;
                    break;
                case 3:
                    res = num_uno / num_dos;
                    break;
            }
            resultado.setText("" + res);
        }
    }

    public void sumar(View v){
        int num_uno, num_dos, sumar;
        if(validar()){
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            sumar = num_uno + num_dos;
            resultado.setText("" + sumar);
        }
    }

    public void restar(View v){
        int num_uno, num_dos, restar;
        if(validar()){
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            restar = num_uno - num_dos;
            resultado.setText("" + restar);
        }
    }

    public void multiplicar(View v){
        int num_uno, num_dos, multiplicar;
        if(validar()){
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            multiplicar = num_uno * num_dos;
            resultado.setText("" + multiplicar);
        }
    }

    public void dividir(View v){
        int num_uno, num_dos, dividir;
        String error_division;
        error_division = getResources().getString(R.string.error_division);
        if(Double.parseDouble(numero_dos.getText().toString()) == 0) {
            numero_dos.setError(error_division);
            numero_dos.requestFocus();
        }else if(validar()){
            num_uno = Integer.parseInt(numero_uno.getText().toString());
            num_dos = Integer.parseInt(numero_dos.getText().toString());
            dividir = num_uno / num_dos;
            resultado.setText("" + dividir);
        }
    }

    public void limpiar(View v){
        numero_uno.setText("");
        numero_dos.setText("");
        resultado.setText("");
        numero_uno.requestFocus();
        combo_operaciones.setSelection(0);
    }

    public boolean validar(){
        String error_numero_uno, error_numero_dos, error_division;

        int op;

        error_numero_uno = getResources().getString(R.string.error_numero_uno);
        error_numero_dos = getResources().getString(R.string.error_numero_dos);
        error_division = getResources().getString(R.string.error_division);

        op = combo_operaciones.getSelectedItemPosition();

        if(numero_uno.getText().toString().isEmpty()){
            numero_uno.setError(error_numero_uno);
            numero_uno.requestFocus();
            return false;
        }else if(numero_dos.getText().toString().isEmpty()){
            numero_dos.setError(error_numero_dos);
            numero_dos.requestFocus();
            return false;
        }

        if(op == 3 && Double.parseDouble(numero_dos.getText().toString()) == 0){
            numero_dos.setError(error_division);
            numero_dos.requestFocus();
            return false;
        }

        return true;
    }


}
