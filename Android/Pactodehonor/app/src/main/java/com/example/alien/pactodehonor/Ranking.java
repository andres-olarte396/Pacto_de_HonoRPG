package com.example.alien.pactodehonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    Button perfil;
    String user;

    private ArrayList<Heroe> usersList;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;


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

        usersList = new ArrayList<Heroe>();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        myAdapter = new MyAdapter(usersList);
        //Crear un manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        //Asignar el manager al recycler view
        recyclerView.setLayoutManager(mLayoutManager);

        //Asignar el adaptador
        recyclerView.setAdapter(myAdapter);

        myAdapter.notifyDataSetChanged();
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
