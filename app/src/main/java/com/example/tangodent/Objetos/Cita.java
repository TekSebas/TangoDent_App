package com.example.tangodent.Objetos;

import java.sql.Timestamp;
import java.util.Date;

public class Cita {
    public String nombreServicio;
    public Date fechaYhora;
    public String nombre;
    public String email;
    public String teléfono;
    public String telefono;
    public String direccion;
    public String ciudad;

    public Cita() {
    }

    public Cita(String nombreServicio, Date fechaYhora, String nombre, String email, String teléfono, String telefono, String direccion, String ciudad) {
        this.nombreServicio = nombreServicio;
        this.fechaYhora = fechaYhora;
        this.nombre = nombre;
        this.email = email;
        this.teléfono = teléfono;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
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

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
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

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Date getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(Date fechaYhora) {
        this.fechaYhora = fechaYhora;
    }
}
