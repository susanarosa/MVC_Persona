/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.PersonaDAO;
import modelo.Poblacion;
import modelo.PoblacionDAO;
import vista.VentanaPrincipal;

/**
 *
 * @author Susana Rosa susana.rosa@murciaeduca.es
 */
public class Controlador {

    private Persona persona;
    private PersonaDAO personaDAO;
    private VentanaPrincipal ventana;
    private Poblacion poblacion;
    private PoblacionDAO poblacionDAO;

    public Controlador() {
        
        this.personaDAO = new PersonaDAO();
        this.ventana = new VentanaPrincipal();
        this.poblacionDAO = new PoblacionDAO();
        //la ventana registra un evento para que al cargarse se carguen las poblaciones
        this.ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                cargarPoblaciones();
            }

        });
        this.ventana.setVisible(true);
        this.ventana.btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String poblacion = (String) ventana.poblaciones.getSelectedItem();            
                int idPoblacion = ventana.poblaciones.getSelectedIndex();              
                String nombre = ventana.txtNombre.getText();              
                int edad = Integer.parseInt(ventana.txtEdad.getText());            
                int res = personaDAO.insertPersona(new Persona(nombre,edad,(idPoblacion + 1)));
                if(res > 0) JOptionPane.showMessageDialog(ventana, "Registro insertado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(ventana, "Registro No insertado", "Error", JOptionPane.ERROR_MESSAGE);
                ventana.txtNombre.setText(""); 
                ventana.txtEdad.setText("");
                cargarPoblaciones();
            }
        
        });
        
        this.ventana.btnSearch.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             String nombreABuscar = ventana.txtBusqueda.getText();
             Persona persona = personaDAO.buscar(nombreABuscar);
             if(persona!=null){
                 JOptionPane.showMessageDialog(ventana, "Registro encontrado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 ventana.txtNombre.setText(persona.getNombre());
                 ventana.txtEdad.setText(String.valueOf(persona.getEdad()));
                 cargarPoblaciones();
                 ventana.poblaciones.setSelectedIndex(persona.getPoblacion()-1);
             }else{
                 JOptionPane.showMessageDialog(ventana, "Registro NO encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                 ventana.txtBusqueda.setText("");
             }
         }
        
        });
        
         this.ventana.btnEliminar.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             String nombreABuscar = ventana.txtEliminar.getText();
             int res = personaDAO.eliminar(nombreABuscar);
             if(res > 0) JOptionPane.showMessageDialog(ventana, "Registro eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
             else   JOptionPane.showMessageDialog(ventana, "Registro no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
             ventana.txtBusqueda.setText("");
             ventana.txtEliminar.setText("");

         }
        
        });
    }

    private void cargarPoblaciones() {
        this.ventana.poblaciones.removeAllItems();
        System.out.println("");
        List<Poblacion> poblaciones = poblacionDAO.getAllPoblaciones();
        for (Poblacion p : poblaciones) {
            ventana.poblaciones.addItem(p.getNombrePoblacion());
        }        
    }

}
