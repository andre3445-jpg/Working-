
package Negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empresa {
 private  ArrayList<Bus> myBuses;
 private  ArrayList<Ruta> myRutas;
 private ArrayList<Pasajero> myPasajeros; 
 private ArrayList<SalidaProgramada> mySalidas; 
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

 private void inicializarSalidas() {
        this.mySalidas.add(new SalidaProgramada("S001",new GregorianCalendar(2026, 2, 15, 6, 0, 0),this.myBuses.get(0),this.myRutas.get(0),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S002",new GregorianCalendar(2026, 2, 15, 14, 0, 0),this.myBuses.get(1),this.myRutas.get(0),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S003",new GregorianCalendar(2026, 2, 16, 7, 0, 0),this.myBuses.get(2),this.myRutas.get(1),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S004",new GregorianCalendar(2026, 2, 16, 20, 0, 0),this.myBuses.get(3),this.myRutas.get(1),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S005",new GregorianCalendar(2026, 2, 17, 5, 30, 0),this.myBuses.get(5),this.myRutas.get(2),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S006",new GregorianCalendar(2026, 2, 17, 18, 0, 0),this.myBuses.get(0),this.myRutas.get(2),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S007",new GregorianCalendar(2026, 2, 18, 6, 30, 0),this.myBuses.get(2),this.myRutas.get(3),"PROGRAMADA"));

        this.mySalidas.add(new SalidaProgramada("S008",new GregorianCalendar(2026, 2, 18, 19, 30, 0),this.myBuses.get(1),this.myRutas.get(3),"PROGRAMADA"));
    }
 
 /* RF1 Parametrizar el sistema: gestionar rutas, buses y salidas (crear/listar).
Validar unicidad (placa, codigoRuta, idSalida) y estados.*/
 
 public String registrarRuta(String codigo, String origen, String destino, float precioBoleto) {
        if (this.validarRuta(codigo)) {
            return "LA RUTA YA EXISTE";
        }
        Ruta nueva = new Ruta(codigo, origen, destino, precioBoleto);
        this.myRutas.add(nueva);
        return "LA RUTA:\n" + nueva.toString() + "\nHA SIDO CREADA CON EXITO";
    }

    private boolean validarRuta(String codigoRuta) {
        for (Ruta r : myRutas) {
            if (r.getCodigo().equalsIgnoreCase(codigoRuta)) {
                return true;
            }
        }
        return false;
    }

    public String listarRuta() {
        String me = "LISTA DE RUTAS ACTUALES:\n";
        for (Ruta r : myRutas) {
            me += r.toString();
        }
        return me;
    }

    public String registrarBus(String placa, String tipoServicio, String estado) {
        if (this.validarBus(placa)) {
            return "LA PLACA YA ESTA REGISTRADA";
        }
        Bus nuevo = new Bus(placa, tipoServicio, estado);
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
            me += b.toString();
        }
        return me;
    }

    public String registrarSalida(String idSalida, GregorianCalendar fechaHora,
            Bus myBus, Ruta myRuta, String estadoRuta) {
        if (this.validarSalida(idSalida)) {
            return "LA SALIDA YA SE ENCUENTRA PROGRAMADA";
        }
        SalidaProgramada nueva = new SalidaProgramada(idSalida, fechaHora, myBus, myRuta, estadoRuta);
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
}

