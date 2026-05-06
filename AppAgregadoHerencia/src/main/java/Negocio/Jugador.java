/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author DOCENTE
 */
public class Jugador extends Persona{
    private String posicion;
    private int cantPartidos;
    private int sueldo;
    private boolean disponible;
    private int añosExperiencia;

    public Jugador() {
    }

    public Jugador(String cedula, String nombre, String correo, String telefono, String posicion, int cantP, int sueldo,int experiencia) {
        super(cedula, nombre, correo, telefono);
        this.posicion=posicion;
        this.cantPartidos=cantP;
        this.sueldo=sueldo;
        this.disponible=true;
        this.añosExperiencia=experiencia;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getCantPartidos() {
        return cantPartidos;
    }

    public void setCantPartidos(int cantPartidos) {
        this.cantPartidos = cantPartidos;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }
    
    

    @Override
    public String toString() {
        
        return  super.toString()+  ", posicion=" + posicion + " , cantPartidos=" + cantPartidos + " , sueldo=" + sueldo + " , disponible=" + disponible+"\n";
    }
    
    
    
    
    
    
    
    
    
    
}
