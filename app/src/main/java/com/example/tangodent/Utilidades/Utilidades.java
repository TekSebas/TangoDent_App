package com.example.tangodent.Utilidades;

public class Utilidades {

    //Constantes campos tabla cita


    public static final String CREAR_TABLA_CITA="CREATE TABLE citas (idCita INTEGER PRIMARY KEY AUTOINCREMENT,nombreServicio TEXT,fecha DATE,horaInicio DATETIME,horaFin DATETIME, duracion TEXT,nombrePaciente TEXT,dni TEXT,email TEXT,telefono INTEGER,direccion TEXT,ciudad TEXT)";
    public static final String CREAR_TABLA_USUARIO="CREATE TABLE usuarios (idUsuario INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT,apellido TEXT,direccion TEXT, email TEXT, fechaNacimiento DATE, pass TEXT)";



}
