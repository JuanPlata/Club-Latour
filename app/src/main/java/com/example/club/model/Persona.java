package com.example.club.model;

public class Persona {
    private String uid;
    private String Nombre;
    private String Apellido;
    private String Altura;
    private String Edad;
    private String Actividad;

    public Persona() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getAltura() {
        return Altura;
    }

    public void setAltura(String altura) {
        Altura = altura;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String actividad) {
        Actividad = actividad;
    }

    public Persona(String uid, String nombre, String apellido, String altura, String edad, String actividad) {
        this.uid = uid;
        Nombre = nombre;
        Apellido = apellido;
        Altura = altura;
        Edad = edad;
        Actividad = actividad;
    }

    @Override
    public String toString() {
        return Nombre;

    }


}
