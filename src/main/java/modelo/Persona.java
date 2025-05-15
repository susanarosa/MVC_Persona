package modelo;

/**
 * La clase Persona representa a una persona con nombre, edad y poblacion.
 * @author susana.rosa@murciaeduca.es
 * @version 1.0
 */
public class Persona {
    private String nombre; // cada caracter ocupa 2 bytes
    private int edad; // ocupa 4 bytes
    private int poblacion;
    

     /**
     * Constructor que inicializa los atributos con los valores proporcionados.
     * 
     * @param nombre El nombre de la persona.
     * @param edad La edad de la persona.
     * @param activo El estado de actividad de la persona.
     */
    public Persona(String nombre, int edad, int poblacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.poblacion = poblacion;
    }
 /**
     * Constructor que inicializa los atributos con los valores por defecto.
     * 
     */
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.poblacion = 1;
    }

    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece la edad de la persona.
     * 
     * @param edad La nueva edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la edad de la persona.
     * 
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el estado de actividad de la persona.
     * 
     * @return numero asociado a la poblacion de la persona.
     */
    public int getPoblacion() {
        return poblacion;
    }

    /**
     * Establece el estado de actividad de la persona.
     * 
     * @param poblacion La nueva poblacion de la persona.
     */
    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Devuelve una representación en forma de cadena de la persona.
     * 
     * @return Una cadena que contiene el nombre y la edad de la persona.
     */
    @Override
    public String toString() {
        return "\nNombre: " + nombre + 
                "\nEdad: " + edad;
    }   
    
   }
