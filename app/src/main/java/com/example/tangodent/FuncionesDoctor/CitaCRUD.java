package com.example.tangodent.FuncionesDoctor;

import com.example.tangodent.Objetos.Cita;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CitaCRUD {

    private Connection conexion = null;
    private Statement sentencia = null;
    private ResultSet registros = null;

    public void crearCita(Cita cita, Connection cn){

        try {
        String consulta="INSERT INTO citas (nombreServicio,fecha,hora, nombrePaciente, email, telefono,direccion,ciudad) VALUES " +
                "('" + cita.getNombreServicio() + "','" + cita.getFecha() +"','" + cita.getHora() + "','"+cita.getNombre() + "','"+cita.getEmail() + "','"+cita.getTelefono() + "','"+
                cita.getDireccion() + "','"+cita.getCiudad() + "')";
            sentencia= cn.createStatement();
            sentencia.executeUpdate(consulta);
            System.out.println("DONE!");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
