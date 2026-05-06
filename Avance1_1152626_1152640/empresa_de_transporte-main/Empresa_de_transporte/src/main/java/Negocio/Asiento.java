/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author LENOVO LOQ
 */
public class Asiento {
    private int numAsiento;
    private String tipoAsiento;

    public Asiento() {
        this.numAsiento = 0;
        this.tipoAsiento = null;
    }

    public Asiento(int numAsiento, String tipoAsiento) {
        this.numAsiento = numAsiento;
        this.tipoAsiento = tipoAsiento;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public void setTipoAsiento(String tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    @Override
    public String toString() {
        return "\nNumero de Asiento= " + numAsiento 
                +"\nTipo de Asiento= " + tipoAsiento;
    }
    
    
    
}

