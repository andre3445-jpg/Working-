
package Negocio;

import java.util.Date;



public class Cliente extends Persona {
private Date fechaIngreso;
private float totalCompras;

public Cliente(){
  this.fechaIngreso=null;

}

    public Cliente(Date fechaIngreso, String nombre, String cedula, String correo, String telefon) {
        super(nombre, cedula, correo, telefon);
        this.fechaIngreso = fechaIngreso;
       
    }

    public void actualizarCompra(float compra){
    this.totalCompras+=compra;
    
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

    @Override
    public String toString() {
        return super.toString()+
                "\nCliente{" + "fechaIngreso=" + fechaIngreso + ", totalCompras=" + totalCompras + '}';
    }
    
    
    
}
