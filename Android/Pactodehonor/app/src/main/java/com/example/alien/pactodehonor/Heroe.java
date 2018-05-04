package com.example.alien.pactodehonor;

/**
 * Created by Diego on 02/05/2018.
 */

public class Heroe {
    private static String Nombre;
    private static String  Nivel;
    private static String raza;
    public Heroe(String Nombre , String nivel, String raza){
        this.Nombre=Nombre;
        this.Nivel=nivel;
        this.raza=raza;
    }
    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String nombre) {
        Nombre = nombre;
    }

    public static String getNivel() {
        return Nivel;
    }

    public static void setNivel(String nivel) {
        Nivel = nivel;
    }

    public static String getRaza() {
        return raza;
    }

    public static void setRaza(String raza) {
        Heroe.raza = raza;
    }


}