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



/**
 *
 * @author Susana Rosa susana.rosa@murciaeduca.es
 */
public class PoblacionDAO {
    public List<Poblacion> getAllPoblaciones(){
        ArrayList<Poblacion> poblaciones = null;
        Connection conexion = ConexionBD.conectar();
        String sql = "select * from poblaciones order by id";
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            poblaciones = new ArrayList();
            while(rs.next()){
                Poblacion p = new Poblacion();
                p.setIdPoblacion(rs.getInt("id"));
                p.setNombrePoblacion(rs.getString("nombre"));
                poblaciones.add(p);

            }
            conexion.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
//            ConexionBD.desconectar();
            conexion = null;
        }
        return poblaciones;
    }
}
