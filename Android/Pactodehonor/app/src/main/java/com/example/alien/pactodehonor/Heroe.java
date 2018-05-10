package com.example.alien.pactodehonor;

public class Heroe {
    private String Nombre;
    private String Nivel;
    private String Raza;

    public Heroe(String nombre , String nivel, String raza){
        this.Nombre=nombre;
        this.Nivel=nivel;
        this.Raza=raza;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = Nombre;
    }

    public String getNivel() {
        return Nivel;
    }

    public void setNivel(String nivel) { this.Nivel = Nivel;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String raza) {
        this.Raza = Raza;
    }


}