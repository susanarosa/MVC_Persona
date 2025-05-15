/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Susana Rosa susana.rosa@murciaeduca.es
 */
public class PersonaDAO {

    public int insertPersona(Persona p) {
        int res = 0;
        Connection conexion = ConexionBD.conectar();
        String sql = "insert into personas values (?,?,?)";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setInt(2, p.getEdad());
            pst.setInt(3, p.getPoblacion());
            res = pst.executeUpdate();
            System.out.println(res);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }

    public Persona buscar(String nombre) {
        Connection conexion = ConexionBD.conectar();
        String sql = "select * from personas where LOWER(nombre) = LOWER(?);";
        ResultSet rs = null;
        Persona persona = null;
        PreparedStatement pst = null;
        try {
            
            pst = conexion.prepareStatement(sql);
            pst.setString(1, nombre);
            rs = pst.executeQuery();
            if (rs.next()) {
                persona = new Persona();
                persona.setEdad(rs.getInt("edad"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPoblacion(rs.getInt("idPoblacion"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return persona;
    }

    public int eliminar(String nombre) {
        Connection conexion = ConexionBD.conectar();
        String sql = "DELETE FROM personas WHERE LOWER(nombre) = LOWER(?);";
        PreparedStatement pst = null;
        int rs = 0;
        try {
            pst = conexion.prepareStatement(sql);
            pst.setString(1, nombre);
            rs = pst.executeUpdate();
            System.out.println("resultado al eliminar");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
}
