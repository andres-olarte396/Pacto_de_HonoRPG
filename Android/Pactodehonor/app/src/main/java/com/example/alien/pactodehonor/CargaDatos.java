package com.example.alien.pactodehonor;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Diego on 13/04/2018.
 */

public class CargaDatos {

    private static String S_URL ="http://pactodehonorpg.com/ServiciosMobiles/ObtenerDatosId.php";
    private static String S1_URL ="http://pactodehonorpg.com/ServiciosMobiles/CambiarContrasena.php";
    private static String S2_URL ="http://pactodehonorpg.com/ServiciosMobiles/ObtenerTodosHeroes.php";
    public static String nombre_perfil;
    public static String ContraseñaV ;
    public static String ContraseñaN ;
    public static RequestQueue queue;
    public static String idPerfil ;
    public static int cantidad_heroes=0;
    public static String [] Heroe1 = new String [3];
    public static String [] Heroe2 = new String [3];;
    public static String [] Heroe3 = new String [3];;
    public static String [] Heroe4 = new String [3];;
    public static LinkedList<Heroe>heroes= new LinkedList<Heroe>();

    public static int cantidad_total_heroes;
    public CargaDatos(String idPerfil , String nombreperfil,RequestQueue applogin){

        this.idPerfil=idPerfil;
        this.nombre_perfil=nombreperfil;
        this.queue=applogin;
        CargaPostjson();

    }


    public void CargaPostjson(){

        String response = null;
        final String finalResponse = response;


        StringRequest postRequest = new StringRequest(Request.Method.POST, S_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {

                        String Validacion = response.substring(8,13);

                        if(Validacion.equals("array")) {
                            Cargatodosheroes();
                            try {
                                JSONObject myJsonjObject = new JSONObject(response);

                                JSONArray jsonArray = myJsonjObject.getJSONArray("array");
                                cantidad_heroes=jsonArray.length();
                                for (int i = 0; i < jsonArray.length(); i++){
                                    if(i==0 ){
                                        JSONObject object = jsonArray.getJSONObject(i);
                                        String NombreJ = object.getString("Nombre_heroe");
                                        String SexoJ = object.getString("Sexo");
                                        String RazaJ = object.getString("Raza");
                                        Heroe1[0]=NombreJ;
                                        Heroe1[1]=SexoJ;
                                        Heroe1[2]=RazaJ;

                                    }
                                    else if(i==1 ){
                                        JSONObject object = jsonArray.getJSONObject(i);
                                        String NombreJ = object.getString("Nombre_heroe");
                                        String SexoJ = object.getString("Sexo");
                                        String RazaJ = object.getString("Raza");
                                        Heroe2[0]=NombreJ;
                                        Heroe2[1]=SexoJ;
                                        Heroe2[2]=RazaJ;

                                    }
                                    else if(i==2 ){
                                        JSONObject object = jsonArray.getJSONObject(i);
                                        String NombreJ = object.getString("Nombre_heroe");
                                        String SexoJ = object.getString("Sexo");
                                        String RazaJ = object.getString("Raza");
                                        Heroe3[0]=NombreJ;
                                        Heroe3[1]=SexoJ;
                                        Heroe3[2]=RazaJ;

                                    }
                                    else if(i==3) {
                                        JSONObject object = jsonArray.getJSONObject(i);
                                        String NombreJ = object.getString("Nombre_heroe");
                                        String SexoJ = object.getString("Sexo");
                                        String RazaJ = object.getString("Raza");
                                        Heroe4[0]=NombreJ;
                                        Heroe4[1]=SexoJ;
                                        Heroe4[2]=RazaJ;

                                    }


                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


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

                params.put("Idusuario", idPerfil);



                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);

    }

    public void CambiarContraseña(final String ContraseñaV, final String ContraseñaN){

        this.ContraseñaV=ContraseñaV;
        this.ContraseñaN=ContraseñaN;

        String response = null;
        final String finalResponse = response;


        StringRequest postRequest = new StringRequest(Request.Method.POST, S1_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {

                        String Validacion = response.substring(17,25);
                        if(Validacion.equals("cambiada")){
                            //se cambio


                        }
                        else {


                            //no se cambio
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

                params.put("Idusuario", nombre_perfil);
                params.put("ContraseñaV", ContraseñaV);
                params.put("ContraseñaN", ContraseñaN);



                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);






    }

    public void Cargatodosheroes(){

        String response = null;
        final String finalResponse = response;


        StringRequest postRequest = new StringRequest(Request.Method.POST, S2_URL,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                       String Validacion = response.substring(8,13);

                        if(Validacion.equals("array")) {

                            try {
                                JSONObject myJsonjObject = new JSONObject(response);
                                JSONArray jsonArray = myJsonjObject.getJSONArray("array");
                                cantidad_total_heroes=jsonArray.length();
                                for (int i = 0; i < jsonArray.length(); i++){
                                    Heroe nuevo ;
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String NombreJ = object.getString("Nombre_heroe");
                                    String Nivel_heroe = object.getString("Nivel_heroe");
                                    String RazaJ = object.getString("Raza");
                                    nuevo = new Heroe(NombreJ,Nivel_heroe,RazaJ);

                                    heroes.addLast(nuevo);

                                }




                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


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

                params.put("Idusuario","1");




                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);





    }
}

