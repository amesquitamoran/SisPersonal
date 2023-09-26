package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

// si el trabajador es estable su sueldo es de 30 soles si no, es de 25, si es de lima 50 soles y si no 100 soles
public class MainActivity extends AppCompatActivity {
    EditText txtNombre, txtNum2;
    CheckBox chEstable;
    RadioButton rbLima,rbProvincia;
    Button btnCalcular,btnLimpiar;
    TextView txtResultado;// txtLima,txtProvincia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        chEstable = (CheckBox) findViewById(R.id.chEstable);
        rbLima = (RadioButton) findViewById(R.id.rbLima);
        rbProvincia = (RadioButton) findViewById(R.id.rbProvincia);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        //txtLima = (TextView) findViewById(R.id.txtLima);
        //txtProvincia = (TextView) findViewById(R.id.txtProvincia);
    }
    public void Calcular (View S) {
        int Horas, Sueldo=0, Bono=0;
        String HorasString="" , Nombre="", Zona="";

        boolean MostrarResultado = false;




        try {
            HorasString = txtNum2.getText().toString();
            Nombre = txtNombre.getText().toString();
            Horas = Integer.parseInt(HorasString);

            if (rbLima.isChecked()==false && rbProvincia.isChecked()==false){
                Toast.makeText(getApplicationContext(),"Debe seleccionar Una Opcion",Toast.LENGTH_LONG).show();
            }else {
                if (chEstable.isChecked()==true) {
                    MostrarResultado = true;
                    Toast.makeText(getApplicationContext(),"Trabajador estable",Toast.LENGTH_LONG).show();
                    Sueldo = Horas * 30;
                } else {
                    MostrarResultado = true;
                    Sueldo = Horas * 25;
                    Toast.makeText(getApplicationContext(),"Trabajador no es estable",Toast.LENGTH_LONG).show();
                }
            }



            if (rbLima.isChecked()==true){
                MostrarResultado = true;
                Bono = 50;
                Sueldo = Sueldo + Bono;
                Zona = "Lima";
            } else if (rbProvincia.isChecked()==true) {
                MostrarResultado = true;
                Bono = 100;
                Sueldo = Sueldo + Bono;
                Zona = "Provincia";
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Debe Ingresar Datos",Toast.LENGTH_LONG).show();
        }

        if (MostrarResultado){
            txtResultado.setText(String.valueOf("\n" +
                    "El Empleado " + Nombre + "\n" +
                    "Trabajó " + HorasString + " Horas " + "\n " +
                    "y Como es de " + Zona + "\n " +
                    "Recibe un Bono de " + Bono +
                    " y su Total es \n" +
                    Sueldo + " Soles"));
        }


    }
}