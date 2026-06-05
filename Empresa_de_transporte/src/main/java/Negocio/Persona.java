/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;


public abstract class Persona {
private String nombre;
private String cedula;
private String correo;
private String telefon;

    public Persona(){
    this.cedula=null;
    this.nombre=null;
    this.correo=null;
    this.telefon=null;
    }

    public Persona(String nombre, String cedula, String correo, String telefon) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.telefon = telefon;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nCedula: " + cedula + "\nCorreo: " + correo + "\nTelefono: " + telefon;
    }

    
   
}
