
package Negocio;

import java.util.Date;



public class Cliente extends Persona {
private Date fechaIngreso;
private float totalCompras;
private int compraRealizada;
private String tipoPasajero;

public Cliente(){
  this.fechaIngreso=null;

}

    public Cliente(Date fechaIngreso, String nombre, String cedula, String correo, String telefon) {
        super(nombre, cedula, correo, telefon);
        this.fechaIngreso = fechaIngreso;
       this.tipoPasajero="NO PREFERENCIAL";
    }

    public void actualizarCompra(float compra){
    this.totalCompras+=compra;
    
    }

    public void actualizarCompraRealzada(){
    this.totalCompras++;
    
    }

    public void setCompraRealizada(int compraRealizada) {
        this.compraRealizada = compraRealizada;
    }

    public void setTipoPasajero(String tipoPasajero) {
        this.tipoPasajero = tipoPasajero;
    }

    public int getCompraRealizada() {
        return compraRealizada;
    }

    public String getTipoPasajero() {
        return tipoPasajero;
    }
    
    public void actualizarTipoPasajero(){
    if(this.compraRealizada>=5){
    this.tipoPasajero="PREFERENCIAL";
    }
    
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public float getTotalCompras() {
        return totalCompras;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setTotalCompras(float totalCompras) {
        this.totalCompras = totalCompras;
    }
    public void actualizarCompraRealizada(int i){
    this.compraRealizada+=i;
    }
    @Override
    public String toString() {
        return super.toString()+
                "\nCliente{" + "fechaIngreso=" + fechaIngreso + ", totalCompras=" + totalCompras + '}';
    }
    
    
    
}
