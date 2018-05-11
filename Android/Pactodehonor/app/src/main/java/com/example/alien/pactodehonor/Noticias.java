package com.example.alien.pactodehonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.alien.pactodehonor.CargaDatos.nombre_perfil;

public class Noticias extends AppCompatActivity {

    TextView txtnoticias,txtnotas;
    Button perfil;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        txtnoticias = (TextView) findViewById(R.id.Texto_noticias);
       // txtnotas = (TextView) findViewById(R.id.Texto_notas);
        perfil = (Button) findViewById(R.id.Perfil);
        getUser();
    }

    public void getUser(){
       // Bundle dato =getIntent().getExtras();
        //user=dato.getString("Usuario");
        perfil.setText(""+nombre_perfil);
    }

    public void noticias (View view){
        Intent intent = new Intent(Noticias.this, Noticias.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void ranking (View view){
        Intent intent = new Intent(Noticias.this, Ranking.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void perfil (View view){
        Intent intent = new Intent(Noticias.this, Perfil.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }

    public void notas (View view){
        Intent intent = new Intent(Noticias.this, Noticias.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }

}
