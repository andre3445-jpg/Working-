

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
    private GregorianCalendar fechaHoraRetorno;
    private Bus myBus;
    private Ruta myRuta;
    private String estadoSalida;
    
    public SalidaProgramada(){
       this.idSalida=null;
       this.fechaHora = null;
       this.myBus=null;
       this.myRuta=null;
       this.estadoSalida =null;
    
    }

    public SalidaProgramada(String idSalida, GregorianCalendar fechaHora, Bus myBus, Ruta myRuta) {
        this.idSalida = idSalida;
        this.fechaHora = fechaHora;
        this.myBus = myBus;
        this.myRuta = myRuta;
        this.estadoSalida="PROGRAMADA";
        this.calcularTiempoRetorno();
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

    public GregorianCalendar getFechaHoraRetorno() {
        return fechaHoraRetorno;
    }

    public String getEstadoRuta() {
        return estadoSalida;
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
    public String mostrarHoraFechaSalida(){
    String formatoSimple="";
      SimpleDateFormat nuevoFormato = new SimpleDateFormat("HH:mm dd/MM/yyyy");
      formatoSimple = nuevoFormato.format(fechaHora.getTime());
      return formatoSimple;
    
    }
    private String cambiarFormato(){
      String formatoSimple="";
      SimpleDateFormat nuevoFormato = new SimpleDateFormat("HH:mm dd/MM/yyyy");
      formatoSimple = nuevoFormato.format(fechaHora.getTime());
      return formatoSimple;
    }
    private void calcularTiempoRetorno(){
        int horaFechaRuta=(this.myRuta.getHoraViaje()*2)+3;
    this.fechaHoraRetorno=(GregorianCalendar)this.fechaHora.clone();
              this.fechaHoraRetorno.add(GregorianCalendar.HOUR_OF_DAY, horaFechaRuta);
    }

   
    @Override
    public String toString() {
        return "\nidSalida: " + idSalida +
                "\nfechaHora: " + cambiarFormato() +
                "\nBus: " + myBus.getPlaca()+ 
                "\nRuta: " + myRuta.origenDestino()+"\n";
        
    }
    
    
    
    
}





