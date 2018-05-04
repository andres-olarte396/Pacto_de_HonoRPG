package com.example.alien.pactodehonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;

import static com.example.alien.pactodehonor.CargaDatos.Heroe1;
import static com.example.alien.pactodehonor.CargaDatos.Heroe2;
import static com.example.alien.pactodehonor.CargaDatos.Heroe3;
import static com.example.alien.pactodehonor.CargaDatos.nombre_perfil;
import static com.example.alien.pactodehonor.CargaDatos.cantidad_heroes;

public class Perfil extends AppCompatActivity {
    private static String S_URL ="http://pactodehonorpg.com/ServiciosMobiles/Perfil.php";
    String user;
    Button perfil,pj1,pj2,pj3,pj4;
    ImageView heroe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        perfil = (Button) findViewById(R.id.Perfil);
        pj1 = (Button) findViewById(R.id.pj1);
        pj2 = (Button) findViewById(R.id.pj2);
        pj3 = (Button) findViewById(R.id.pj3);
        pj4 = (Button) findViewById(R.id.pj4);
        heroe = (ImageView) findViewById(R.id.Heroe);
        getUser();
    }

    public void getUser(){
        perfil.setText(""+nombre_perfil);

        if(cantidad_heroes>=1){
            pj1.setText(Heroe1[0]);
            heroe.setImageResource(R.drawable.tigre);}
        else{
            pj1.setVisibility(View.INVISIBLE);
        }
        if(cantidad_heroes>=2)
            pj2.setText(Heroe2[0]);
        else{
            pj2.setVisibility(View.INVISIBLE);
        }
        if(cantidad_heroes>=3)
            pj3.setText(Heroe3[0]);
        else{
            pj3.setVisibility(View.INVISIBLE);
        }
        if(cantidad_heroes==4)
            pj4.setText(Heroe3[0]);
        else{
            pj4.setVisibility(View.INVISIBLE);
        }
    }


    //MAIN
    public void noticias (View view){
        Intent intent = new Intent(Perfil.this, Noticias.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void ranking (View view){
        Intent intent = new Intent(Perfil.this, Ranking.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void perfil (View view){
        Intent intent = new Intent(Perfil.this, Perfil.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }


    //Personajes
    public void pj1 (View view){
        heroe.setImageResource(R.drawable.tigre);
    }
    public void pj2 (View view){
        heroe.setImageResource(R.drawable.prueba);
    }
    public void pj3 (View view){
        heroe.setImageResource(R.drawable.tigre);
    }
    public void pj4 (View view){
        heroe.setImageResource(R.drawable.prueba);
    }



    //Botones
    public void config (View view){
        Intent intent = new Intent(Perfil.this, Configuracion.class);
        intent.putExtra("Usuario",user);
        startActivity(intent);
    }
    public void salir (View view){
        Intent intent = new Intent(Perfil.this, Login.class);

        startActivity(intent);
    }
}










