/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author DOCENTE
 */
public class Asiento {
    private int numero;
    private boolean disponible;
    
    public Asiento(int num){
        this.numero=num;
        this.disponible=true;
   }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    @Override
    public String toString(){
        return "Numero: "+this.numero+ "\t"+ "Disponible: "+this.disponible + "\n";
    }  
    
}
