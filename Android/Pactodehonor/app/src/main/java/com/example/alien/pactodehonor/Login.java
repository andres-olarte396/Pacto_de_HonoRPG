package com.example.alien.pactodehonor;

import android.content.Context;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.alien.pactodehonor.CargaDatos.cantidad_heroes;

public class Login extends AppCompatActivity {
    private static String S_URL ="http://pactodehonorpg.com/ServiciosMobiles/ControlUsuario.php";
    TextView usuario;
    TextView contraseña;
    public static String Idusuario;
    public static String Usuario;
    public static RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = (TextView) findViewById(R.id.Usuario);
        contraseña = (TextView) findViewById(R.id.Contraseña);
    }

    public void login (View view){
        queue = Volley.newRequestQueue(Login.this);
        String response = null;
        final String finalResponse = response;

        StringRequest postRequest = new StringRequest(Request.Method.POST, S_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {

                        String Validacion = response.substring(2,8);
                        if(Validacion.equals("succes")) {
                            try {

                                JSONObject myJsonjObject = new JSONObject(response);
                                JSONArray jsonArray = myJsonjObject.getJSONArray("succes");
                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String clave = object.getString("Id");
                                    String clave1 = object.getString("Usuario");
                                    Idusuario = clave;
                                    Usuario = clave1;
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            if (Usuario.equals(usuario.getText().toString())) {
                                CargaDatos Cargardatos = new CargaDatos(Idusuario, Usuario, queue);

                                Intent intent = new Intent(Login.this, Noticias.class);
                                startActivity(intent);
                            } else {

                                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();

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


                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);

    }
    public void Registro (View view){
        Intent intent = new Intent(Login.this, Registro.class);
        startActivity(intent);
    }
}