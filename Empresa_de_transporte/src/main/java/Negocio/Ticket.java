
package Negocio;

/**
 *
 * @author geral
 */
public class Ticket {
  
    private String idTicket;
    private String estadoTicket;
    private String silla;
    private float valorPagar;
    private SalidaProgramada mySalida;
    private Cliente myCliente;
    
    public Ticket(){
    
    this.idTicket=null;
    this.estadoTicket=null;
    this.mySalida=null;
    this.valorPagar=0.0F;
    }

    public Ticket(String idTicket, String estadoTicket, float valorPagar, SalidaProgramada mySalida, Cliente myCliente, String silla) {
        this.idTicket = idTicket;
        this.estadoTicket = estadoTicket;
        this.valorPagar = valorPagar;
        this.mySalida = mySalida;
        this.myCliente = myCliente;
        this.silla= silla;
    }

    public String getSilla() {
        return silla;
    }

    public Cliente getMyCliente() {
        return myCliente;
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

    @Override
    public String toString() {
        return   "TICKET: " + this.idTicket+
                "\nPasajero: "+ this.myCliente.getCedula()+" - "+this.myCliente.getNombre()+
                "\nSalida: "+this.mySalida.getIdSalida()+" (Cucuta -> "+this.mySalida.getMyRuta().origenDestino()+")"+this.mySalida.mostrarHoraFechaSalida()+
                "\nBus: "+this.mySalida.getMyBus().getPlaca()+" ("+this.mySalida.getMyBus().getTipoServicio()+") "+this.mySalida.getMyBus().getCapacidad()+
                "\nSilla: "+this.silla+
                "\nValor pagado: "+this.valorPagar+
                "\nEstado Tiquete: "+this.estadoTicket
                ;
    }

    
    
}
