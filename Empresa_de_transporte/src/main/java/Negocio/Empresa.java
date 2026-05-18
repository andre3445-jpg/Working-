
package Negocio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empresa {
 private  ArrayList<Bus> myBuses;
 private  ArrayList<Ruta> myRutas;
 private ArrayList<Pasajero> myPasajeros; 
 private ArrayList<SalidaProgramada> mySalidas; 
 private ArrayList<Ticket> myTickets; 
 // PROFESORA:   AQUI DEBE IR EL MONTO INICIAL DE LA CAJA, TOTAL VENDIDO.... IRIAN ACA
 // O EN LA CLASE CAJA
 
 
 
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
     this.myBuses.add(new Bus("KAA-101","NORMAL"));
     this.myBuses.add(new Bus("KBB-202","EJECUTIVO"));
     this.myBuses.add(new Bus("KCC-303","NORMAL"));
     this.myBuses.add(new Bus("KDD-404","EJECUTIVO"));
     this.myBuses.add(new Bus("KEE-505","NORMAL"));
     this.myBuses.getLast().setEstado("MANTENIMIENTO");
     this.myBuses.add(new Bus("KFF-606","EJECUTIVO"));
 }

 private void inicializarRuta(){
     this.myRutas.add(new Ruta("R01","Cucuta","Bucaramanga",80000.0f));
     this.myRutas.add(new Ruta("R02","Cucuta","Bogotá",160000.0f));
     this.myRutas.add(new Ruta("R03","Cucuta","Medellin",180000.0f));
     this.myRutas.add(new Ruta("R04","Cucuta","Cartagena",220000.0f));
 }

 
 
 private void inicializarSalidas() {
        this.mySalidas.add(new SalidaProgramada("S001",new GregorianCalendar(2026, 2, 15, 6, 0, 0),
        this.myBuses.get(0),this.myRutas.get(0),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S002",new GregorianCalendar(2026, 2, 15, 14, 0, 0),
        this.myBuses.get(1),this.myRutas.get(0),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S003",new GregorianCalendar(2026, 2, 16, 7, 0, 0),
        this.myBuses.get(2),this.myRutas.get(1),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S004",new GregorianCalendar(2026, 2, 16, 20, 0, 0),
        this.myBuses.get(3),this.myRutas.get(1),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S005",new GregorianCalendar(2026, 2, 17, 5, 30, 0),
        this.myBuses.get(5),this.myRutas.get(2),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S006",new GregorianCalendar(2026, 2, 17, 18, 0, 0),
        this.myBuses.get(0),this.myRutas.get(2),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S007",new GregorianCalendar(2026, 2, 18, 6, 30, 0),
        this.myBuses.get(2),this.myRutas.get(3),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S008",new GregorianCalendar(2026, 2, 18, 19, 30, 0),
        this.myBuses.get(1),this.myRutas.get(3),"PROGRAMADA"));
    }
 
 
 
 /* RF1 Parametrizar el sistema: gestionar rutas, buses y salidas (crear/listar).
Validar unicidad (placa, codigoRuta, idSalida) y estados.*/
 
 public String registrarRuta(String codigo, String origen, String destino, float precioBoleto) {
        String validar ="";
        validar = this.validarRuta(codigo, destino, origen);
     if (!validar.equalsIgnoreCase("CONTINUAR")){
            return validar;
        }
        Ruta nueva = new Ruta(codigo, origen, destino, precioBoleto);
        this.myRutas.add(nueva);
        return "LA RUTA:\n" + nueva.toString() + "\nHA SIDO CREADA CON EXITO";
    }

   /* private boolean validarRuta(String codigoRuta) {
        for (Ruta r : myRutas) {
            if (r.getCodigo().equalsIgnoreCase(codigoRuta)) {
                return true;
            }
        }
        return false;
    }*/
    


    public String listarRuta() {
        String me = "LISTA DE RUTAS ACTUALES:\n";
        for (Ruta r : myRutas) {
            me += r.toString();
        }
        return me;
    }

   
    public String registrarBus(String placa, String tipoServicio) {
        if (this.validarBus(placa)) {
            return "LA PLACA YA ESTA REGISTRADA";
        }
        
        Bus nuevo = new Bus(placa, tipoServicio);
        this.myBuses.add(nuevo);
        return "EL BUS:\n" + nuevo.toString() + "\nHA SIDO REGISTRADO CON EXITO";
    }

    private boolean validarBus(String placa) {
        for (Bus b : myBuses) {
            if (b.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

    public String listarBus() {
        String me = "LISTA DE BUSES ACTUALES:\n";
        for (Bus b : myBuses) {
            me += b.toString()+"\n";
          
        }
        return me;
    }

    //un requerimiento funcional no puede recibir objetos
    public String registrarSalida(String idSalida, GregorianCalendar fechaHora,
            String placa, String codRuta, String estadoRuta) {
        if (this.validarSalida(idSalida)) {
            return "LA SALIDA YA SE ENCUENTRA PROGRAMADA";
        }
        Bus b= this.buscarBus(placa);
        Ruta r= this.buscarRuta(codRuta);
        SalidaProgramada nueva = new SalidaProgramada(idSalida, fechaHora, b, r, estadoRuta);
        this.mySalidas.add(nueva);
        return "LA SALIDA:\n" + nueva.toString() + "\nHA SIDO PROGRAMADA CON EXITO";
    }

    private boolean validarSalida(String idSalida) {
        for (SalidaProgramada s : mySalidas) {
            if (s.getIdSalida().equalsIgnoreCase(idSalida)) {
                return true;
            }
        }
        return false;
    }
    
    private String validarRuta(String codigoRuta, String destinoExterno, String origenExterno){   
        for (Ruta s : this.myRutas){
            if (s.getCodigo().equalsIgnoreCase(codigoRuta)) {
                return "Este ID ya esta registrado para la salida:\n"+s.toString();
            }
          if(destinoExterno.equalsIgnoreCase(s.getDestino()) && origenExterno.equalsIgnoreCase(s.getOrigen())){
            return "Esta ruta ya esta registrada para el ID:\n"+s.toString();
            }
          }
      return "CONTINUAR";
    }
    
    private Bus buscarBus(String placa){
        Bus b=null;
        for (Bus c: this.myBuses){
         if(c.getPlaca().equalsIgnoreCase(placa))
             b=c;
        }
    return b;
    }
    
    private Ruta buscarRuta(String codigoRuta){
        Ruta b=null;
        for (Ruta c: this.myRutas){
         if(c.getCodigo().equalsIgnoreCase(codigoRuta))
             b=c;
        }
    
    return b;
    }

    public String listarSalida() {
        String me = "LISTA DE SALIDAS PROGRAMADAS:\n";
        for (SalidaProgramada s : mySalidas) {
            me += s.toString();
        }
        return me;
    }

    public String venderPasaje() {
        String me = "";
        return me;
    }
    
    
    
    /*RF2: Venta de pasaje (1 tiquete): seleccionar salida, mostrar sillas disponibles, 
    registrar pasajero y silla, calcular valor y generar tiquete. Actualizar caja y ocupacion.*/
    public String comprarTicket(String codSalida, String asiento, String nombre, String cedula){
    String me ="";
    me=this.registrarPasajero(nombre, cedula);
    if(!me.equalsIgnoreCase("EXITO")){
        return me;
    }
    float precio=this.buscarSalidaProgramada(codSalida).getMyRuta().getPrecioBoleto();
    this.myTickets.add(new Ticket(this.crearIdTicket(), "VIGENTE", precio, this.buscarSalidaProgramada(codSalida)));
    String placa=this.buscarBusDeSalida(codSalida);
    int asient= Integer.parseInt(asiento);
    this.buscarBus(placa).ocuparAsiento(asient);
    
    me ="VENTA EXITOS: \n"+
            "TICKET: "+this.myTickets.getLast().getIdTicket();
            
    return me;
    }
    
    /*Metodo para crear el id del Ticket*/
    private String crearIdTicket(){
    String id="";
    id = "TQ -0 "+(this.myTickets.size());
    return id;}
    
    
    
    /*Metodo para registrar pasajeros*/
    private String registrarPasajero(String nombre, String cedula){
        if(this.validarPasajero(cedula)){
          return "La cedula ya se encuentra registrada, digite una cedula diferente";
        }
        this.myPasajeros.add(new Pasajero(nombre, cedula));
    return "EXITO";
    }
    
    /*Metodo para validar si la cedula del pasajero ya existe*/
    private boolean validarPasajero(String ced){
        for(Pasajero p: this.myPasajeros){
          if(p.getCedula().equalsIgnoreCase(ced)){
          return true;
          }
        }
    return false;}
    
    /*FUNCIONALIDADES DE MOSTRADO PARA LOS COMBOBOX*/
    
    
    /*Este metodo nos da un arreglo de String listo para mostrar en el combobox*/
    public String[] asientosBusSeleccionado(String Placa){
        String[] asientos;
        asientos= new String[this.buscarBus(Placa).capacidad()];
        asientos=this.buscarBus(Placa).estadoAsientos();
    return asientos;
    }
    
    /*Este metodo nos da un arreglo de String listo para mostrar en el combobox*/
      public ArrayList listarSalidaPrograma() {
        ArrayList<String> salida;
        salida = new ArrayList<String>();
        for(SalidaProgramada s: this.mySalidas){
          salida.add(s.getIdSalida()+" "+s.getMyRuta().getOrigen()+"-"+s.getMyRuta().getDestino()+"   "+s.getMyBus().getTipoServicio());
        }
        return salida;
    }
      
      private SalidaProgramada buscarSalidaProgramada(String codigoSalida){
          for(SalidaProgramada s: this.mySalidas){
           if(s.getIdSalida().equalsIgnoreCase(codigoSalida)){
             return s;
           }
          }
          return null;
      }
      
      /*Metodo que permite buscar la hora fecha de la salida*/
      public String buscarHorayFechaSalida(String codigoSalida){
      String me="";
      SalidaProgramada s=this.buscarSalidaProgramada(codigoSalida);
      if(s!=null){
          s.getFechaHora();
           SimpleDateFormat nuevoFormato = new SimpleDateFormat("HH:mm dd/MM/yyyy");
           me = nuevoFormato.format(s.getFechaHora().getTime());
          return me;
      }
      me="Si ves esto tienes un error con la busqueda de la salida";
      return me;
      }
      
       /*Metodo nos retorna la placa del bus recibiendo el codigo de la salida programada*/
      public String buscarBusDeSalida(String codigoSalida){
      String placa="";
      SalidaProgramada s=this.buscarSalidaProgramada(codigoSalida);
      placa=s.getMyBus().getPlaca();
      return placa;}
      
      
       /*Metodo nos retorna un arreglo con los numeros de los asientos disponibles*/
         public ArrayList mostrarAsientoDisponible(String placa){
          ArrayList<String> me =new ArrayList<>();
          me=this.buscarBus(placa).mostrarAsientoDisponible();
          return me;
        }
        
}

