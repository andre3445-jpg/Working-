/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;

/**
 *
 * @author DOCENTE
 */
public class Equipo {
    private String nombre;
    private Persona myInversionista;
    private ArrayList<Jugador> myJugadores;
    private Tecnico myTecnico;

    public Equipo(String nombre, Persona myInversionista, ArrayList<Jugador> myJugadores, Tecnico myTecnico) {
        this.nombre = nombre;
        this.myInversionista = myInversionista;
        this.myJugadores = myJugadores;
        this.myTecnico = myTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getMyInversionista() {
        return myInversionista;
    }

    public void setMyInversionista(Persona myInversionista) {
        this.myInversionista = myInversionista;
    }

    public ArrayList<Jugador> getMyJugadores() {
        return myJugadores;
    }

    public void setMyJugadores(ArrayList<Jugador> myJugadores) {
        this.myJugadores = myJugadores;
    }

    public Tecnico getMyTecnico() {
        return myTecnico;
    }

    public void setMyTecnico(Tecnico myTecnico) {
        this.myTecnico = myTecnico;
    }
    
    
    
    
    
    
    
}
  