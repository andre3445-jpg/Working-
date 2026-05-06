/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;


public class Ruta {
    private String codigo;
    private String origen;
    private String destino;
    private float precioBoleto;
    
    public Ruta(){
    this.codigo=null;
    this.origen=null;
    this.destino=null;
    this.precioBoleto=0.0F;
    
    }

    public Ruta(String codigo, String origen, String destino, float precioBoleto) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.precioBoleto = precioBoleto;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public float getPrecioBoleto() {
        return precioBoleto;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setPrecioBoleto(float precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    @Override
    public String toString() {
        return "\ncodigo= " + codigo + 
                "\norigen= " + origen + 
                "\ndestino= " + destino + 
                "\nprecioBoleto= " + precioBoleto+"\n";
    }
    
   
    
    
    
    
    
}

