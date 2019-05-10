package com.example.tangodent.FuncionesDoctor;

import android.os.StrictMode;

import com.example.tangodent.Objetos.Cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CitaCRUD {

    private Connection conexion = null;
    private Statement sentencia = null;
    private ResultSet registros = null;

    public void crearCitas(Cita cita, Connection cn) {

        try {
            String consulta = "INSERT INTO citas (nombreServicio,fecha,hora,duracion, nombrePaciente, email, telefono,direccion,ciudad) VALUES " +
                    "('" + cita.getNombreServicio() + "','" + cita.getFecha() + "','" + cita.getHora() + "','" + cita.getDuracion() + "','" + cita.getNombre() + "','" + cita.getEmail() + "','" + cita.getTelefono() + "','" +
                    cita.getDireccion() + "','" + cita.getCiudad() + "')";

            sentencia = cn.createStatement();

            sentencia.executeUpdate(consulta);

            System.out.println("DONE!");
        } catch (SQLException e) {
            e.getMessage();
        }


    }

    public ResultSet comprobarNombre(Cita cita, Connection cn) {

        try {

            String consulta = "SELECT * FROM alumnos WHERE nombre='" + cita.getNombre() + "'";
            sentencia = cn.createStatement();
            registros = sentencia.executeQuery(consulta);
            while (registros.next()) {
                System.out.println("id" + registros.getInt(1));
                System.out.println("nombre" + registros.getString(2));
                System.out.println("telefono" + registros.getString(3));
            }
            System.out.println("DONE!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return registros;
    }

    public void Actualizar(Cita cita, Connection cn) {
        try {

            PreparedStatement consulta = cn.prepareStatement("UPDATE alumnos SET nombre=?,telefono=? WHERE id=?");
            consulta.setString(1, cita.getNombre());
            consulta.setString(2, cita.getTelefono());
            //consulta.setInt(3, cita.getId());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public ArrayList<Cita> listar(Connection cn) {
        ArrayList<Cita> citas = new ArrayList<>();
        try {


            String consulta = "SELECT * FROM alumnos";
            sentencia = cn.createStatement();
            registros = sentencia.executeQuery(consulta);
            while (registros.next()) {

                String nombre = registros.getString(2);
                String telef = registros.getString(3);
                // Cita alumn=new Cita(/**/);
                // citas.add(/**/);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CitaCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return citas;

    }


}
