
package Negocio;

/**
 *
 * @author geral
 */
public class Ticket {
  
    private String idTicket;
    private String estadoTicket;
    private float valorPagar;
    private SalidaProgramada mySalida;
    private Pasajero myPasajero;
    
    public Ticket(){
    
    this.idTicket=null;
    this.estadoTicket=null;
    this.mySalida=null;
    this.valorPagar=0.0F;
    }

    public Ticket(String idTicket, String estadoTicket, float valorPagar, SalidaProgramada mySalida) {
        this.idTicket = idTicket;
        this.estadoTicket = estadoTicket;
        this.valorPagar = valorPagar;
        this.mySalida = mySalida;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public String getEstadoTicket() {
        return estadoTicket;
    }

    public float getValorPagar() {
        return valorPagar;
    }

    public SalidaProgramada getMySalida() {
        return mySalida;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public void setValorPagar(float valorPagar) {
        this.valorPagar = valorPagar;
    }

    public void setMySalida(SalidaProgramada mySalida) {
        this.mySalida = mySalida;
    }

    
    
}
