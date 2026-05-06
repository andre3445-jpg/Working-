/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
/**
 *
 * @author DOCENTE
 * esta es una aplicación que implementa el concepto de todo parte físico
 * La empresa Copetran cuenta con una flota de buses para la prestación de servicios de los usuarios.
 * En la actualidad cuenta con unos tipos de buses, del cual depende la cantidad de asientos.  Se indica 
 * que según el tipo: 1. SERVICIO PREMIUM (44 asientos).  2.  NORMAL  (30 puestos)   3. AEROVANS (18 puestos).
 * 
 * Este programa es para aplicar el concepto de todo parte físico, entendiendo que es la clase todo (Bus), la que debe
 * administrar las partes: Crear, consultar, listar, actualizar, eliminar.. Por lo tanto, siempre se recomienda, en la clase Todo
 * eliminar el set y get de objetos parte.
 * 
 * Se presenta un programa sencillo que permita registrar los buses (Validados por  placa).  Listar buses y asientos y consultar
 * asientos de un bus por placa.
 * 
 */
public class EmpresaCopetran {
    
    private ArrayList<Bus> myBuses;
    
    
    public EmpresaCopetran(){
        this.myBuses=new ArrayList<>();
           
    }
    
    /*  RF1: registrar bus en la empresa, no pueden existir dos buses con la misma placa*/
    
    public String registrarBuses(String placa, String modelo, int tipo){
        if(this.validarPlaca(placa)){
            return "Placa ya fue registrada en el sistema...";
        }
        this.myBuses.add(new Bus(placa, modelo, tipo));
        return "Registro exitoso...";
    }
    
    /* metodo privado de la clase para validar si existe una placa */
    private boolean validarPlaca(String placa){
        boolean enc=false;
        for(Bus b: this.myBuses){
            if(b.getPlaca().equalsIgnoreCase(placa)){
                enc=true;
            }
        }
        return enc;
    }
 
    /* RF2: listar los buses guardados en la empresa con su respectiva información 
        y todos los asientos y sus respectivo estados*/
    
    public String listarBusesAsientos(){
        String cad="";
        for(Bus myB:this.myBuses){
            cad=cad+myB.toString()+"\n"+myB.mostrarTodosAsientosBus();
        }
        return cad;
    }
 
   /* Buscar un Bus de acuerdo a una placa */
    private Bus buscarPlaca(String placa){
        Bus myB=null;
        for(Bus b: this.myBuses){
            if(b.getPlaca().equalsIgnoreCase(placa)){
                myB=b;
                break;
            }
        }
        return myB;
     }
    
    /* Listar los puestos disponibles de un Bus SEGUN PLACA*/
    
   public String listarAsientosBus(String placa){
        String cad="";
        Bus myB=this.buscarPlaca(placa);
        if(myB!=null) {
           cad=cad+myB.toString()+"\n"+myB.mostrarAsientosDisponibles();
           return cad;
        }
        return "PLACA NO EXISTE..";
    } 
    
    
}
