/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.GregorianCalendar;
/**
 *
 * @author LENOVO LOQ
 */
public class SalidaProgramada {
    private String idSalida;
    private GregorianCalendar fechaHora;
    private Asiento[] myAsientos; //Asientos del bus para esta salida
    private Bus myBus;
    private Ruta myRuta;
    private String estadoRuta;
    
    public SalidaProgramada(){
    this.myAsientos= new Asiento[0];
    this.idSalida=null;
    this.fechaHora = null;
    this.myBus=null;
    this.myRuta=null;
    this.estadoRuta =null;
    
    }

    public SalidaProgramada(String idSalida, GregorianCalendar fechaHora, Bus myBus, Ruta myRuta, String estadoRuta) {
        this.idSalida = idSalida;
        this.fechaHora = fechaHora;
        this.myAsientos = new Asiento[myBus.getCapacidad()];
        this.myBus = myBus;
        this.myRuta = myRuta;
        this.estadoRuta=estadoRuta;
    }

    

    public String getIdSalida() {
        return idSalida;
    }

    public GregorianCalendar getFechaHora() {
        return fechaHora;
    }

    public Asiento[] getMyAsientos() {
        return myAsientos;
    }

    public Bus getMyBus() {
        return myBus;
    }

    public Ruta getMyRuta() {
        return myRuta;
    }

    
    
    
    public void setIdSalida(String idSalida) {
        this.idSalida = idSalida;
    }

    public void setFechaHora(GregorianCalendar fechaHora) {
        this.fechaHora = fechaHora;
    }   

    public void setMyAsientos(Asiento[] myAsientos) {
        this.myAsientos = myAsientos;
    }

    public void setMyBus(Bus myBus) {
        this.myBus = myBus;
    }

    public void setMyRuta(Ruta myRuta) {
        this.myRuta = myRuta;
    }   

    @Override
    public String toString() {
        return "\nidSalida= " + idSalida +
                "\nfechaHora= " + fechaHora + 
                "\nCapacidad= " + myAsientos.length +
                "\nBus= " + myBus.getPlaca() + 
                "\nRuta= " + myRuta+"\n";
        
    }
    
    
    
    
}


