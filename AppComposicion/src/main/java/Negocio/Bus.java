/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
/**
 *
 * @author DOCENTE
 * 
 * 
 * 
 */
public class Bus {
    private String placa;
    private String modelo;
    private int tipo; //1. SERVICIO PREMIUM (44 asientos).  2.  NORMAL  (30 puestos)   3. AEROVANS (18 puestos)
    private Asiento[] myAsientos;
    private boolean disponible;
    private boolean gasesRenovado;
    
    

    public Bus(String placa, String modelo, int tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.disponible=true;
        this.gasesRenovado=true;
        this.abrirMemoriaAsientos();
     }
    
  /* METODOS PRIVADOS PARA MANIPULAR LOS OBJETOS PARTE**/
    
    /*  Metodo para crear espacios en memoria y crear asientos */
    private void abrirMemoriaAsientos(){
        switch(this.tipo){
            case 1: {this.myAsientos=new Asiento[44]; this.crearAsientos(44); break;}
            case 2: {this.myAsientos=new Asiento[30]; this.crearAsientos(30); break;}
            case 3: {this.myAsientos=new Asiento[18]; this.crearAsientos(18); break;}
        }
   }
    
    /* metodo para crear los asientos según el tipo de bus.*/
    private void crearAsientos(int numA){
        for (int i=0;i<numA;i++){
            this.myAsientos[i]=new Asiento(i+1);
        }
   }
    
    /*-metodo para entregar información de las partes */
    public String mostrarTodosAsientosBus(){
        String cad="LISTADO DE ASIENTOS DEL AUTOBUS"+"\n";
        for(Asiento myA: this.myAsientos){
            cad=cad+myA.toString();
        }
        return cad;
    }
    
    public String mostrarAsientosDisponibles(){
        String cad="LISTADO ASIENTOS DISPONIBLES DEL AUTOBUS"+"\n";
        for(Asiento myA: this.myAsientos){
            if(myA.isDisponible()){
                    cad=cad+myA.toString();
              }
        }
        return cad;
    }
    
    /*tipo de Bus */
    private String retornarTipo(){
        String cad="";
        switch(this.tipo){
            case 1: {cad= "SERVICIO PREMIUM"; break;}
            case 2: {cad="NORMAL"; break;}
            case 3: {cad="AEROVANS"; break;}
        }
        return cad;
    }
    
    
    public String toString(){
        return "Placa: "+this.getPlaca()+"\nModelo: "+ this.getModelo()+
                "\nTipo: "+ this.retornarTipo()+"\n Bus Disponible: "+this.isDisponible()+
                "\nGases renovado: "+this.isGasesRenovado()+"\n";
    }
    

    
    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public boolean isGasesRenovado() {
        return gasesRenovado;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setGasesRenovado(boolean gasesRenovado) {
        this.gasesRenovado = gasesRenovado;
    }
    
    
    
}
