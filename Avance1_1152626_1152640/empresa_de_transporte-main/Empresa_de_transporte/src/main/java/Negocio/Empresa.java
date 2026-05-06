
package Negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empresa {
 private  ArrayList<Bus> myBuses;
 private  ArrayList<Ruta> myRutas;
 private ArrayList<Pasajero> myPasajeros; 
 private ArrayList<SalidaProgramada> mySalidas; 
 
 
 public Empresa(){
     this.myBuses = new ArrayList();
     this.myRutas = new ArrayList();
     this.myPasajeros = new ArrayList();
     this.mySalidas = new ArrayList();
     
     this.inicializarBus();
    this.inicializarRuta();
    this.inicializarSalidas();
 
 
 }
 
 private void inicializarBus(){
     this.myBuses.add(new Bus("KAA-101","NORMAL","DISPONIBLE"));
     this.myBuses.add(new Bus("KBB-202","EJECUTIVO","DISPONIBLE"));
     this.myBuses.add(new Bus("KCC-303","NORMAL","DISPONIBLE"));
     this.myBuses.add(new Bus("KDD-404","EJECUTIVO","DISPONIBLE"));
     this.myBuses.add(new Bus("KEE-505","NORMAL","MANTENIMIENTO"));
     this.myBuses.add(new Bus("KFF-606","EJECUTIVO","DISPONIBLE"));
 }

 private void inicializarRuta(){
     this.myRutas.add(new Ruta("R01","Cucuta","Bucaramanga",80000.0f));
     this.myRutas.add(new Ruta("R02","Cucuta","Bogotá",160000.0f));
     this.myRutas.add(new Ruta("R03","Cucuta","Medellin",180000.0f));
     this.myRutas.add(new Ruta("R04","Cucuta","Cartagena",220000.0f));
 }

 private void inicializarSalidas(){
     this.mySalidas.add(new SalidaProgramada("S001",new GregorianCalendar(2026,03,15,06,00,00),
             this.myBuses.stream().filter(b -> b.getPlaca().equals("KAA-101")).findFirst().orElse(null),
             this.myRutas.stream().filter(b -> b.getCodigo().equals("R01")).findFirst().orElse(null),"PROGRAMADO"));
     
     this.mySalidas.add(new SalidaProgramada("S002",new GregorianCalendar(2026,03,15,14,00,00),
             this.myBuses.stream().filter(b -> b.getPlaca().equals("KBB-202")).findFirst().orElse(null),
             this.myRutas.stream().filter(b -> b.getCodigo().equals("R01")).findFirst().orElse(null),"PROGRAMADO"));
     
     this.mySalidas.add(new SalidaProgramada("S003",new GregorianCalendar(2026,03,16,07,00,00),
             this.myBuses.stream().filter(b -> b.getPlaca().equals("KCC-303")).findFirst().orElse(null),
             this.myRutas.stream().filter(b -> b.getCodigo().equals("R02")).findFirst().orElse(null),"PROGRAMADO"));
     
     this.mySalidas.add(new SalidaProgramada("S004",new GregorianCalendar(2026,03,16,20,00,00),
             this.myBuses.stream().filter(b -> b.getPlaca().equals("KDD-404")).findFirst().orElse(null),
             this.myRutas.stream().filter(b -> b.getCodigo().equals("R02")).findFirst().orElse(null),"PROGRAMADO"));
     
     this.mySalidas.add(new SalidaProgramada("S005",new GregorianCalendar(2026,03,17,05,30,00),
             this.myBuses.stream().filter(b -> b.getPlaca().equals("KFF-606")).findFirst().orElse(null),
             this.myRutas.stream().filter(b -> b.getCodigo().equals("R03")).findFirst().orElse(null),"PROGRAMADO"));
     
     this.mySalidas.add(new SalidaProgramada("S006",new GregorianCalendar(2026,03,17,18,00,00),
             this.myBuses.stream().filter(b -> b.getPlaca().equals("KAA-101")).findFirst().orElse(null),
             this.myRutas.stream().filter(b -> b.getCodigo().equals("R03")).findFirst().orElse(null),"PROGRAMADO"));
     
     this.mySalidas.add(new SalidaProgramada("S007",new GregorianCalendar(2026,03,18,06,30,00),
             this.myBuses.stream().filter(b -> b.getPlaca().equals("KCC-303")).findFirst().orElse(null),
             this.myRutas.stream().filter(b -> b.getCodigo().equals("R04")).findFirst().orElse(null),"PROGRAMADO"));

     this.mySalidas.add(new SalidaProgramada("S008",new GregorianCalendar(2026,03,18,19,30,00),
             this.myBuses.stream().filter(b -> b.getPlaca().equals("KBB-202")).findFirst().orElse(null),
             this.myRutas.stream().filter(b -> b.getCodigo().equals("R04")).findFirst().orElse(null),"PROGRAMADO"));

}
 
 /* RF1 Parametrizar el sistema: gestionar rutas, buses y salidas (crear/listar).
Validar unicidad (placa, codigoRuta, idSalida) y estados.*/
 
 public String registrarRuta(String codigo, String origen, String destino, float precioBoleto){
 String me="";
 if(this.validarRuta(codigo)){
   me="LA RUTA YA EXISTE";
 }else{
   this.myRutas.add(new Ruta(codigo,origen,destino,precioBoleto));
   me ="LA RUTA:\n"+myRutas.getFirst().toString()+"\n HA SIDO CREADA CON EXITO";
   }
 return me;}
 
 
 public boolean validarRuta(String codigoRuta){
 boolean existe=false;
 for(Ruta r: myRutas){
     if(r.getCodigo().equalsIgnoreCase(codigoRuta)){
       existe=true;
       break;
     }
 }
 return existe;}
 
 
 
 public String listarRuta(){
 String me="LISTA DE RUTAS ACTUALES:\n";
 
 for(Ruta r: myRutas){
     me+=r.toString();
 }
 return me;}
 
 
  public String registrarBus(String placa, String tipoServicio, String estado){
 String me="";
 if(this.validarBus(placa)){
   me="LA PLACA YA ESTA REGISTRADA";
 }else{
   this.myBuses.add(new Bus(placa,tipoServicio,estado));
   me ="EL BUS:\n"+myBuses.getFirst().toString()+"\n HA SIDO REGISTRADO CON EXITO";
   }
 return me;}
 
 
 public boolean validarBus(String placa){
 boolean existe=false;
 for(Bus b: myBuses){
     if(b.getPlaca().equalsIgnoreCase(placa)){
       existe=true;
       break;
     }
 }
 return existe;}
 
 
 public String listarBus(){
 String me="LISTA DE BUCES ACTUALES:\n";
 
 for(Bus b: myBuses){
     me+=b.toString();
 }
 return me;}
 
 
  public String registrarSalida(String idSalida, GregorianCalendar fechaHora, Bus myBus, Ruta myRuta, String estadoRuta){
 String me="";
 if(this.validarBus(idSalida)){
   me="LA SALIDA YA SE ENCUENTRA PROGRAMADA";
 }else{
   this.mySalidas.add(new SalidaProgramada(idSalida,fechaHora, myBus, myRuta, estadoRuta));
   me ="LA SALIDA:\n"+mySalidas.getFirst().toString()+"\n HA SIDO PROGRAMADA CON EXITO";
   }
 return me;}
 
 
 public boolean validarSalida(String idSalida){
 boolean existe=false;
 for(SalidaProgramada s: mySalidas){
     if(s.getIdSalida().equalsIgnoreCase(idSalida)){
       existe=true;
       break;
     }
 }
 return existe;}
 
 
 
  public String listarSalida(){
 String me="LISTA DE SALIDAS PROGRAMADAS:\n";
 
 for(SalidaProgramada s: mySalidas){
     me+=s.toString();
 }
 return me;}
 
 
  
  /*RF2 Venta de pasaje (1 tiquete): seleccionar salida, mostrar sillas disponibles,
  registrar pasajero y silla, calcular valor y generar tiquete. Actualizar caja y ocupacion.*/
  
  public String venderPasaje(){
  String me="";
  
  
  return me;}
  
  /*RF3 Venta ida y vuelta (2 tiquetes en una transacción): seleccionar salida ida y
  salida regreso, validar misma ruta, sillas disponibles y aplicar descuento del 10%.*/
  
  
  /*RF4 Cancelación de salida: cambiar estado a CANCELADA y gestionar tiquetes VIGENTES 
  (reprogramar automáticamente a otra salida PROGRAMADA de la misma ruta con cupo, o marcar REEMBOLSADO)
  . Generar reporte del proceso.*/
  
  
  /*RF5 Reportes del día: (a) ventas por ruta, (b) total vendido, reembolsado e
  ingreso neto, (c) ventas por mes o un rango de fechas.*/
  
}

