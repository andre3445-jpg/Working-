/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.ArrayList;
/**
 *
 * @author DOCENTE
 * Se quiere desarrollar un sistema para la Empresa "DeportExport", que brinda el servicio de recepción de hojas de vida
 * de jugadores, para que sean reclutados por equipos. Actualmente, la empresa DeportExport  se encarga de inversionistas
 * interesados en crear un equipo, buscarle el mejor recurso humano a nivel de jugadores y técnicos. La empresa por ahora, 
 * se ha especializado en equipos para futbol. Este es un sistema que irá creciendo.  Por ahora, se va a recepcionar
 * la hoja de vida del jugador: cedula, nombre, correo, telefono, años de experiencia, posicion en que juega, cantidad de partidos
 * en que ha participado, sueldo al que aspira. Igualmente, se va a recepcionar las horas de vida 
 * de los técnicos, se registra: cedula,nombre, correo, telefono, años de experiencia, cantidad de premios ganados,  
 * sueldo (tiene un valor de acuerdo al número de años de experiencia y cantidad de premidos ganados), nombre del último equipo que entrenó. 
 *Igualmente, se debe guardar la información de los inversionistas interesados en que les ayude a crear los equipos y reclutar
 * jugadores, mínimo para que se pueda crear un equipo en el sistema, debe tener un técnico, y dos jugadores
 * Ahora, la idea es que el equipo cuando salga al mercado, se tengan al menos 11 jugadores y hasta un máximo de 20 jugadores. Ahora,
 * en estos momentos, un jugador no puede estar en más de un equipo. Asimismo, los técnicos, no pueden dirigir más de un equipo al tiempo.
 * De los inversionistas, se guarda cedula, nombre, correo, telefono. Los inversionistas si pueden ser dueños de varios equipos.
 * El sistema debe hacer las validaciones respectivas y no puede existir personas con una misma cedula.
 */
public class Empresa {
    private ArrayList<Jugador> myJugadores;
    private ArrayList<Equipo> myEquipos;
    private ArrayList<Tecnico> myTecnicos;
    private ArrayList<Persona> myPersonas;
    
    
    // en el constructor de Toreno se abre espacio en la memoria a los arreglos de objetos.
    public Empresa(){
        this.myEquipos=new ArrayList();
        this.myJugadores=new ArrayList();
        this.myTecnicos=new ArrayList();
        this.myPersonas=new ArrayList();
     }
    
    //RF: Registrar hoja de vida de jugador en el sistema, validar que la cedula no exista.
    public String recepcionarHojasVidaJugador(String cedula, String nombre, String correo, String telefono,String posicion,int exper, int cantP, int sueldo){
        if(this.buscarJugador(cedula)==null){
            this.myJugadores.add(new Jugador(cedula,nombre,correo,telefono,posicion,cantP,sueldo,exper));
            return "REGISTRADA HOJA DE VIDA DE JUGADOR ...";
        }
        return "HOJA DE VIDA YA EXISTE EN EL SISTEMA... ";   
    }
    
    //RF: Registrar hoja de vida de los técnicos en el sistema, validar que la cedula no exista.

    public String recepcionarHojasVidaTecnico(String cedula, String nombre, String correo, String telefono, int añosE, int cantPG, String nombreE){
        
        if(añosE==0){
            return "LA HOJA DE VIDA NO SE RECIBE, POR NO CONTAR CON EXPERIENCIA..";
        }
        
        if(this.buscarTecnico(cedula)==null){
            this.myTecnicos.add(new Tecnico(cedula,nombre,correo,telefono,nombreE,añosE,cantPG));
            return "REGISTRADA HOJA DE VIDA DE TECNICO ...";
        }
        return "HOJA DE VIDA YA EXISTE EN EL SISTEMA... ";   
    }
    
    
    //metodo privado para validar si la cedula del jugador existe en el sistema.
    private Jugador buscarJugador(String cedula){
        Jugador j=null;        
        for(Jugador jug:this.myJugadores){
            if(jug.getCedula().equalsIgnoreCase(cedula)){
                j=jug; break;
            }
        }
        return j;
    }
    
     //metodo privado para validar si la cedula del tecnico existe en el sistema.
    private Tecnico buscarTecnico(String cedula){
        Tecnico t=null;        
        for(Tecnico tec:this.myTecnicos){
            if(tec.getCedula().equalsIgnoreCase(cedula)){
                t=tec; break;
            }
        }
        return t;
    }
  
    //RF Mostrar todos los jugadores sin excepción
    public String mostrarTodosJugadores(){
        String cad="";
        for(Jugador j:this.myJugadores){
            cad=cad+j.toString()+"\n";
        }
        if(cad.isEmpty()){
            return "NO HAY JUGADORES REGISTRADOS..";
        }
        return cad;
    }
    
    public int retornarCantidadJugadores(){
        return this.myJugadores.size();
    }
   
    
    //RF: registrar tecnicos  
    
    
    //RF: Registrar equipos en el sistema
    
    
    
    
    
}
