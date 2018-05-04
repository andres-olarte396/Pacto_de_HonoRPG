package com.example.alien.pactodehonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ranking extends AppCompatActivity {

    Button perfil;
    String user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        perfil = (Button) findViewById(R.id.Perfil);
    }

    public void getUser(){
        Bundle dato =getIntent().getExtras();
        user=dato.getString("Usuario");
        perfil.setText(""+user);
    }

    public void noticias (View view){
        Intent intent = new Intent(Ranking.this, Noticias.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void ranking (View view){
        Intent intent = new Intent(Ranking.this, Ranking.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void perfil (View view){
        Intent intent = new Intent(Ranking.this, Perfil.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }

    public void notas (View view){
        Intent intent = new Intent(Ranking.this, Noticias.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
}
