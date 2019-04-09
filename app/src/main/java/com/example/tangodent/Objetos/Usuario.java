package com.example.tangodent.Objetos;

public class Usuario {
    public String nombre;
    public String apellido;
    public String direccion;
    public String fechaNacimiento;
    public String email;
    public String pass;

    public Usuario(String nombre, String apellido, String direccion, String fechaNacimiento, String email, String pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.pass = pass;
    }
}
