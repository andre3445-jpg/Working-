/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.ArrayList;

/**
 *
 * @author LENOVO LOQ
 */
public class Caja {
    //Atributos
    private float cajaInicial;
    private float totalVentas; 
    private float totalReembolsos;
    private float ingresoNeto;
    private float cajaFinal;
    
    
    //constructor por defecto
    public Caja() {
        this.cajaInicial     =0.0F;
        this.totalVentas = 0.0F;
        this.totalReembolsos = 0.0F;
        this.ingresoNeto = 0.0F;
        this.cajaFinal = 0.0F;
    }

   
    //Getter y Setters
    
    public float getTotalVentas() {
        return totalVentas;
    }

    public double getCajaInicial() {
        return cajaInicial;
    }

    public void setCajaInicial(float cajaInicial) {
        this.cajaInicial = cajaInicial;
    }
 
    public void setTotalVentas(float totalVentas) {
        this.totalVentas = totalVentas;
    }
 
    public float getTotalReembolsos() {
        return totalReembolsos;
    }
 
    public void setTotalReembolsos(float totalReembolsos) {
        this.totalReembolsos = totalReembolsos;
    }
    public void actualizarValorTotal(float totalReembolsos) {
        this.totalVentas += totalReembolsos;
    }
    
    //No se alamacena como atributo, se calcula 
    public float getIngresoNeto() {
        return this.totalVentas - this.totalReembolsos;
    }
    
    public String calcularIngresoNeto(){
    String me="";
    this.ingresoNeto= this.totalVentas-this.totalReembolsos;
    me+=ingresoNeto;
    return me;}
    
    public String calcularCajaFinal(){
    String me="";
    this.calcularIngresoNeto();
    this.cajaFinal = this.ingresoNeto+this.cajaInicial;
    me+=this.cajaFinal;
    return me;}
    
   public void actualizarReembolso(float precioTicket){
   float reembolso= (float) (precioTicket*0.2);
   this.totalReembolsos+=precioTicket+reembolso;
   }
    
    
    //toString
    @Override
    public String toString() {
        return "\nTotal Ventas:     $" + this.totalVentas
             + "\nTotal Reembolsos: $" + this.totalReembolsos
             + "\nIngreso Neto:     $" + this.getIngresoNeto();
    }
    
    
    
    
    
}
