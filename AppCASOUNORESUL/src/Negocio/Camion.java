/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author USUARIO
 */
public class Camion {
    private String placa;
    private int carga;
    private float consumo;
    
    public Camion(){
        this.placa="";
        this.carga=0;
        this.consumo=0.0F;
    }
    public Camion(String placa,int carga,float consumo){
            this.placa=placa;
            this.carga=carga;
            this.consumo=consumo;
                
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCarga() {
        return this.carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
    public String toString(){
        return  "\n"+ "Placa:" +this.getPlaca()+"\n"+"Carga:"+this.getCarga()+ "\n" +"consumo:" +this.getConsumo()+"\n";

    }
    
    
    
    
    
    
}
