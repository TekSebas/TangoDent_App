package com.example.tangodent.Objetos;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Cita {
    public String nombreServicio;
    public java.sql.Date fecha;
    public Time hora;
    public String nombre;
    public String email;
    public String telefono;
    public String direccion;
    public String ciudad;

    public Cita() {
    }

    public Cita(String nombreServicio, Date fecha, Time hora, String nombre, String email, String telefono, String direccion, String ciudad) {
        this.nombreServicio = nombreServicio;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
