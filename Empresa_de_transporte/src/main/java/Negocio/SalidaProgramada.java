

package Negocio;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
/**
 *
 * @author LENOVO LOQ
 */

public class SalidaProgramada {
    private String idSalida;
    private GregorianCalendar fechaHora;
    private Bus myBus;
    private Ruta myRuta;
    private String estadoRuta;
    
    public SalidaProgramada(){
       this.idSalida=null;
       this.fechaHora = null;
       this.myBus=null;
       this.myRuta=null;
       this.estadoRuta =null;
    
    }

    public SalidaProgramada(String idSalida, GregorianCalendar fechaHora, Bus myBus, Ruta myRuta, String estadoRuta) {
        this.idSalida = idSalida;
        this.fechaHora = fechaHora;
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

   

    public void setMyBus(Bus myBus) {
        this.myBus = myBus;
    }

    public void setMyRuta(Ruta myRuta) {
        this.myRuta = myRuta;
    }   

    private String cambiarFormato(){
      String formatoSimple="";
      SimpleDateFormat nuevoFormato = new SimpleDateFormat("HH:mm dd/MM/yyyy");
      formatoSimple = nuevoFormato.format(fechaHora.getTime());
      return formatoSimple;
    }
    
    @Override
    public String toString() {
        return "\nidSalida: " + idSalida +
                "\nfechaHora: " + cambiarFormato() +
                "\nBus: " + myBus.getPlaca()+ 
                "\nRuta: " + myRuta.origenDestino()+"\n";
        
    }
    
    
    
    
}


