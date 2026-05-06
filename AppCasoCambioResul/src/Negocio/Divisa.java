/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author jhon
 */
public class Divisa {
    
    private String nombreD;
    private int cantDisponVta;   
    private float precVenta;
    private float precCompra;
    

    
   
    public Divisa(){
        
    }
    
    public Divisa(String tipMon, float precVenta, float precCompra, int existencia){
        
        this.nombreD= tipMon;
        this.precVenta= precVenta;
        this.precCompra= precCompra;
        this.cantDisponVta= existencia;
      
        
    }

    /**
     * @return the tipMon
     */
    public String getNombreD() {
        return this.nombreD;
    }

    /**
     * @param tipMon the tipMon to set
     */
    public void setNombreD(String tipMon) {
        this.nombreD = tipMon;
    }

    /**
     * @return the cantDisponVta
     */
    public int getCantDisponVta() {
        return this.cantDisponVta;
    }

    /**
     * @param cantDisponVta the cantDisponVta to set
     */
    public void setCantDisponVta(int cantDisponVta) {
        this.cantDisponVta = cantDisponVta;
    }

    /**
     * @return the precVenta
     */
    public float getPrecVenta() {
        return this.precVenta;
    }

    /**
     * @param precVenta the precVenta to set
     */
    public void setPrecVenta(float precVenta) {
        this.precVenta = precVenta;
    }

    /**
     * @return the precCompra
     */
    public float getPrecCompra() {
        return this.precCompra;
    }

    /**
     * @param precCompra the precCompra to set
     */
    public void setPrecCompra(float precCompra) {
        this.precCompra = precCompra;
    }

    
   /* metodo que concatena la información */
    public String toString(){
        String cad="";
        cad="\n DIVISA: "+this.getNombreD()+"\n PRECIO COMPRA: "+this.getPrecCompra()+
            "\n PRECIO VENTA: "+ this.getPrecVenta()+ "\n CANTIDAD DISPONIBLE: "+this.getCantDisponVta();
        return cad;
    }

 
}

