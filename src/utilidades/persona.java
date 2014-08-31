/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ignacio
 */
public class persona {
    private String nombre;
    private String Apellido;
    private String Edad;
    private String Telefono;

    public persona(String nombre, String Apellido, String Edad, String Telefono) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Telefono = Telefono;
    }

   
   
    public String getNombre() {
        return nombre;
    }
   
    public String getApellido() {
        return Apellido;
    }
    
    public String getEdad() {
        return Edad;
    }
   
    public String getTelefono() {
        return Telefono;
    }
    public String toString()
    {
        return this.nombre;
    }
}
