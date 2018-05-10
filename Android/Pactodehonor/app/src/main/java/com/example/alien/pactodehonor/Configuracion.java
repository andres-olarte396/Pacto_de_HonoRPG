package com.example.alien.pactodehonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.alien.pactodehonor.CargaDatos.CambiarContraseña;

public class Configuracion extends AppCompatActivity {

    Button perfil;
    String user;
    TextView contraseña,contraseña_nueva,contraseña_nueva2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        perfil = (Button) findViewById(R.id.Perfil);
        contraseña = (TextView) findViewById(R.id.Contraseña_actual);
        contraseña_nueva = (TextView) findViewById(R.id.Contraseña_nueva);
        contraseña_nueva2 = (TextView) findViewById(R.id.Contraseña_nueva2);

    }

    public void getUser() {
        Bundle dato = getIntent().getExtras();
        user = dato.getString("Usuario");
        perfil.setText("" + user);
    }

    //MAIN
    public void noticias (View view){
        Intent intent = new Intent(Configuracion.this, Noticias.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void ranking (View view){
        Intent intent = new Intent(Configuracion.this, Ranking.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void perfil (View view){
        Intent intent = new Intent(Configuracion.this, Perfil.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }


    public void aceptar (View view){
        String pass=contraseña.getText().toString();
        String pass_new=contraseña_nueva.getText().toString();
        String pass_new2=contraseña_nueva2.getText().toString();


        if (pass_new.equals(pass_new2)){
            //Remplazar la contraseña en la BD
            CambiarContraseña(pass,pass_new);

            Intent intent = new Intent(Configuracion.this, Perfil.class);
            intent.putExtra("Usuario",user);
            startActivity(intent);
        }
        else{
            Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }
    }

    //Botones
    public void config (View view){
        Intent intent = new Intent(Configuracion.this, Configuracion.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void salir (View view){
        Intent intent = new Intent(Configuracion.this, Login.class);

        startActivity(intent);
    }
}
