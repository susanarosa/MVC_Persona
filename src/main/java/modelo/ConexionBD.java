/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Susana Rosa susana.rosa@murciaeduca.es
 */
public class ConexionBD {
  // Constantes de conexion a BD
    private static final String BD_URL = "jdbc:mysql://localhost/bd_personas?serverTimezone=UTC";
    private static final String BD_USER = "root";
    private static final String BD_PASS = "12345678";

    // Variable de clase
    private static Connection conexion = null;

    // Métodos de clase
    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);
            System.out.println("Conectado a la BD");

        } catch (SQLException ex) {
            System.out.println("Error al conectar a la BD");
            System.out.println(ex.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return conexion;
    }

    public static boolean desconectar() {
        try {
            conexion.close();
            System.out.println("Desconectado de la BD");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al desconectar de la BD");
            ex.getMessage();
            return false;
        }
    }   
}
