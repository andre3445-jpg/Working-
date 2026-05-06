/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author DOCENTE
 * CLASE PADRE..
 */
public  class  Persona {
    private String cedula;
    private String nombre;
    private String correo;
    private String telefono;
    
    //constructor por default
    public Persona(){
        
    }

    //constructor con parametros, recibe los datos de la persona
    public Persona(String cedula, String nombre, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return  "cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono;
    }
    
    
    
    
    
    
}
