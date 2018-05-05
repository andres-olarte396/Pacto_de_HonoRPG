package com.example.alien.pactodehonor;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;
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

public class Registro extends AppCompatActivity {
    private static String S_URL ="http://pactodehonorpg.com/ServiciosMobiles/Registro.php";
    TextView usuario,getcorreo,contraseña,contraseña2;
    String userBd,passBd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario = (TextView) findViewById(R.id.Usuario);
        getcorreo = (TextView) findViewById(R.id.editText2);
        contraseña = (TextView) findViewById(R.id.Contraseña);
        contraseña2 = (TextView) findViewById(R.id.Repetir_contraseña);
    }

    public void registrarse (View view){
        String user=usuario.getText().toString();
        final String correo=getcorreo.getText().toString();
        String pass=contraseña.getText().toString();
        String pass2=contraseña2.getText().toString();
        if (!pass.equals(pass2)){
            Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }
        else if (user.isEmpty()||correo.isEmpty()||pass.isEmpty()||pass2.isEmpty()){
            Toast.makeText(this,"Ingrese todos los campos", Toast.LENGTH_LONG).show();
        }
        else if (user.isEmpty()==false && correo.isEmpty()==false && pass.isEmpty()==false && pass2.isEmpty()==false && pass.equals(pass2)){

            RequestQueue queue = Volley.newRequestQueue(Registro.this);
            String response = null;
            final String finalResponse = response;

            StringRequest postRequest = new StringRequest(Request.Method.POST, S_URL,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {

                            String Validacion = response.substring(2,9);


                            if(Validacion.equals("success")) {


                                Intent intent = new Intent(Registro.this, Login.class);
                                startActivity(intent);


                            }

                            else {

                                //CAMILO ACA PONGA UN MENSAJE QUE USUARIO YA EXISTE QUE SE VEA REFLEJADO EN LA INTERFAZ
                            }

                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.d("ErrorResponse", finalResponse);


                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String>  params = new HashMap<String, String>();

                    params.put("Usuario", usuario.getText().toString());
                    params.put("Password", contraseña.getText().toString());
                    params.put("Correo", getcorreo.getText().toString());

                    return params;
                }
            };
            postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            queue.add(postRequest);
            }
    }
}
