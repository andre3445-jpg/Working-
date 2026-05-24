/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author LENOVO LOQ
 */
public class Caja {
    //Atributos
    private float totalVentas; 
    private float totalReembolsos;
    
    
    //constructor por defecto
    public Caja() {
        this.totalVentas     = 0.0F;
        this.totalReembolsos = 0.0F;
    }
    
    //Constructor con parametros(iniciar caja)
    public Caja(float totalVentas, float totalReembolsos) {
        this.totalVentas     = totalVentas;
        this.totalReembolsos = totalReembolsos;
    }
    
    //Getter y Setters
    
    public float getTotalVentas() {
        return totalVentas;
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
    
    //No se alamacena como atributo, se calcula 
    public float getIngresoNeto() {
        return this.totalVentas - this.totalReembolsos;
    }
    
    //toString
    @Override
    public String toString() {
        return "\nTotal Ventas:     $" + this.totalVentas
             + "\nTotal Reembolsos: $" + this.totalReembolsos
             + "\nIngreso Neto:     $" + this.getIngresoNeto();
    }
    
    
    
}
