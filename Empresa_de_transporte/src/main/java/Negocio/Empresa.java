package Negocio;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Empresa {

    private ArrayList<Bus> myBuses;
    private ArrayList<Ruta> myRutas;
    private ArrayList<Cliente> myClientes;
    private ArrayList<SalidaProgramada> mySalidas;
    private ArrayList<Ticket> myTickets;

    private Caja myCaja;//Agregado como atributo
    // PROFESORA:   AQUI DEBE IR EL MONTO INICIAL DE LA CAJA, TOTAL VENDIDO.... IRIAN ACA
    // O EN LA CLASE CAJA

    public Empresa() {
        this.myBuses = new ArrayList();
        this.myRutas = new ArrayList();
        this.myClientes = new ArrayList();
        this.mySalidas = new ArrayList();
        this.myTickets = new ArrayList();// abriendo memoria en ticket 

        this.inicializarBus();
        this.inicializarRuta();
        this.inicializarSalidas();

    }

    private void inicializarBus() {
        this.myBuses.add(new Bus("KAA-101", "NORMAL"));
        this.myBuses.add(new Bus("KBB-202", "EJECUTIVO"));
        this.myBuses.add(new Bus("KCC-303", "NORMAL"));
        this.myBuses.add(new Bus("KDD-404", "EJECUTIVO"));
        this.myBuses.add(new Bus("KEE-505", "NORMAL"));
        this.myBuses.getLast().setEstado("MANTENIMIENTO");
        this.myBuses.add(new Bus("KFF-606", "EJECUTIVO"));
    }

    private void inicializarRuta() {
        this.myRutas.add(new Ruta("R01", "Cucuta", "Bucaramanga", 4, 80000.0f));
        this.myRutas.add(new Ruta("R02", "Cucuta", "Bogotá", 14, 160000.0f));
        this.myRutas.add(new Ruta("R03", "Cucuta", "Medellin", 16, 180000.0f));
        this.myRutas.add(new Ruta("R04", "Cucuta", "Cartagena", 18, 220000.0f));
    }

    private void inicializarSalidas() {
        this.mySalidas.add(new SalidaProgramada("S001", new GregorianCalendar(2026, 2, 15, 6, 0, 0),
                this.myBuses.get(0), this.myRutas.get(0)));

        this.mySalidas.add(new SalidaProgramada("S002", new GregorianCalendar(2026, 2, 15, 14, 0, 0),
                this.myBuses.get(1), this.myRutas.get(0)));

        this.mySalidas.add(new SalidaProgramada("S003", new GregorianCalendar(2026, 2, 16, 7, 0, 0),
                this.myBuses.get(2), this.myRutas.get(1)));

        this.mySalidas.add(new SalidaProgramada("S004", new GregorianCalendar(2026, 2, 16, 20, 0, 0),
                this.myBuses.get(3), this.myRutas.get(1)));

        this.mySalidas.add(new SalidaProgramada("S005", new GregorianCalendar(2026, 2, 17, 5, 30, 0),
                this.myBuses.get(5), this.myRutas.get(2)));

        this.mySalidas.add(new SalidaProgramada("S006", new GregorianCalendar(2026, 2, 17, 18, 0, 0),
                this.myBuses.get(0), this.myRutas.get(2)));

        this.mySalidas.add(new SalidaProgramada("S007", new GregorianCalendar(2026, 2, 18, 6, 30, 0),
                this.myBuses.get(2), this.myRutas.get(3)));

        this.mySalidas.add(new SalidaProgramada("S008", new GregorianCalendar(2026, 2, 18, 19, 30, 0),
                this.myBuses.get(1), this.myRutas.get(3)));
    }

    /* RF1 GESTIÓN DE RUTAS*/
    public String registrarRuta(String codigo, String origen, String destino, int hora, float precioBoleto) {
        String validar = "";
        validar = this.validarRuta(codigo, destino, origen);
        if (!validar.equalsIgnoreCase("CONTINUAR")) {
            return validar;
        }
        Ruta nueva = new Ruta(codigo, origen, destino, hora, precioBoleto);
        this.myRutas.add(nueva);
        return "LA RUTA:\n" + nueva.toString() + "\nHA SIDO CREADA CON EXITO";
    }

    public String listarRuta() {
        String me = "LISTA DE RUTAS ACTUALES:\n";
        for (Ruta r : myRutas) {
            me += r.toString();
        }
        return me;
    }

    private String validarRuta(String codigoRuta, String destinoExterno, String origenExterno) {
        for (Ruta s : this.myRutas) {
            if (s.getCodigo().equalsIgnoreCase(codigoRuta)) {
                return "Este ID ya esta registrado para la salida:\n" + s.toString();
            }
            if (destinoExterno.equalsIgnoreCase(s.getDestino()) && origenExterno.equalsIgnoreCase(s.getOrigen())) {
                return "Esta ruta ya esta registrada para el ID:\n" + s.toString();
            }
        }
        return "CONTINUAR";
    }

    /* RF1 Gestion de buses*/
    public String registrarBus(String placa, String tipoServicio) {
        if (this.validarBus(placa)) {
            return "LA PLACA YA ESTA REGISTRADA";
        }

        Bus nuevo = new Bus(placa, tipoServicio);
        this.myBuses.add(nuevo);
        return "EL BUS:\n" + nuevo.toString() + "\nHA SIDO REGISTRADO CON EXITO";
    }

    public String listarBus() {
        String me = "LISTA DE BUSES ACTUALES:\n";
        for (Bus b : myBuses) {
            me += b.toString() + "\n";

        }
        return me;
    }

    private boolean validarBus(String placa) {
        for (Bus b : myBuses) {
            if (b.getPlaca().equalsIgnoreCase(placa)) {
                return true;
            }
        }
        return false;
    }

    /* RF1 Gestion de Salidas*/
    public String registrarSalida(String idSalida, GregorianCalendar fechaHora,
            String placa, String codRuta) {
        if (this.validarSalida(idSalida)) {
            return "LA SALIDA YA SE ENCUENTRA PROGRAMADA";
        }
        Bus b = this.buscarBus(placa);
        Ruta r = this.buscarRuta(codRuta);
        SalidaProgramada nueva = new SalidaProgramada(idSalida, fechaHora, b, r);
        this.mySalidas.add(nueva);
        return "LA SALIDA:\n" + nueva.toString() + "\nHA SIDO PROGRAMADA CON EXITO";
    }

    public String listarSalida() {
        String me = "LISTA DE SALIDAS PROGRAMADAS:\n";
        for (SalidaProgramada s : mySalidas) {
            me += s.toString();
        }
        return me;
    }

    private boolean validarSalida(String idSalida) {
        for (SalidaProgramada s : mySalidas) {
            if (s.getIdSalida().equalsIgnoreCase(idSalida)) {
                return true;
            }
        }
        return false;
    }

    /* RF2 VENTA DE PASAJE*/
    public String comprarTicket(String codSalida, int asiento, String nombre, String cedula, String correo, String tele, ArrayList<Integer> sillas, boolean idaVuelta) {
        String me = "";

        me = this.registrarPasajero(nombre, cedula, correo, tele);
        if (!me.equalsIgnoreCase("EXISTE")) {
            return me;
        }
        SalidaProgramada s = this.buscarSalidaProgramada(codSalida);
        Cliente c = this.buscarCliente(cedula);
        float precio = this.valorParcialApagar(s, c, idaVuelta);
        float valorTotal = 0.0F;
        for (Integer i : sillas) {
            String silla = "" + i;
            this.myTickets.add(new Ticket(this.crearIdTicket(), "VIGENTE", precio, this.buscarSalidaProgramada(codSalida), c, silla));
            this.actualizarPasajero(1, c);
            valorTotal += precio;
        }
        String placa = this.buscarBusDeSalida(codSalida);
        //int asient = Integer.parseInt(asiento);
        //this.buscarBus(placa).ocuparAsiento(asiento);

        me = this.ticketsImprimir(sillas) + "\n Total a pagar: "+ valorTotal;

//VAMOS ACA
        return me;
    }

    //Metodo para determinar los tickets a imprimir (1 o 2)
    private String ticketsImprimir(ArrayList sillas) {
        String me = "";
        if (sillas.size() == 2) {
            me = "VENTA EXITOS: \n"
                    + this.myTickets.get(myTickets.size() - 2).toString()
                    + this.myTickets.getLast().toString() + "\n\n";
        } else {
            me = "VENTA EXITOS: \n"
                    + this.myTickets.getLast().toString() + "\n\n";
        }
        return me;
    }

    //Metodo para actualizar el estado del pasajero (PREFERENCIAL, NO PREFERENCIAL)
    private void actualizarPasajero(int i, Cliente c) {
        c.actualizarCompraRealizada(i);
        c.actualizarTipoPasajero();

    }

    //Metodo para calcular el valor por puesto en una compra R2
    public float valorParcialApagar(SalidaProgramada s, Cliente c, boolean idaVuelta) {
        float descuentoCleiente = (float) (s.getMyRuta().getPrecioBoleto() * 0.15);
        float descuentoIdaVuelta = (float) (s.getMyRuta().getPrecioBoleto() * 0.10);
        float recargoBus = (float) ((s.getMyRuta().getPrecioBoleto()) * 0.2);
        float total = 0.0F;

        total = s.getMyRuta().getPrecioBoleto();
        if (idaVuelta) {
            total = (float) (total-descuentoIdaVuelta);
        }
        if (c.getTipoPasajero().equalsIgnoreCase("PREFERENCIAL")) {
            total = total - descuentoCleiente;
        }
        if (s.getMyBus().getTipoServicio().equalsIgnoreCase("EJECUTIVO")) {
            total = total + recargoBus;
        }
        return total;
    }

    /*Metodo para registrar pasajeros r2*/
    private String registrarPasajero(String nombre, String cedula, String correo, String tele) {
        Cliente c = this.buscarCliente(cedula);
        String me = "REVISA EL CODIGO";
        boolean clienteRegistrado = false;
        if (c == null) {
            Date horaFecha = new Date();
            this.myClientes.add(new Cliente(horaFecha, nombre, cedula, correo, tele));
            me = "EXISTE";
        } else if (c.getCedula().equalsIgnoreCase(cedula) && !c.getNombre().equalsIgnoreCase(nombre)) {
            me = "El cliente de Cedula: " + cedula + " ya se encuentra registrado bajo el nombre de: " + c.getNombre() + " Rectifique los datos";
        } else {
            return "EXISTE";
        }
        return me;
    }

    //metodo para enviar sillas ocupadas a la vista
    public ArrayList<String> sillasOcupadasTicket(String codSalida) {
        ArrayList<String> sillasOcupadas = new ArrayList<>();
        for (Ticket t : this.myTickets) {
            if (t.getMySalida().getIdSalida().equalsIgnoreCase(codSalida) && (t.getEstadoTicket().equalsIgnoreCase("VIGENTE") || t.getEstadoTicket().equalsIgnoreCase("REPROGRAMADO"))) {
                sillasOcupadas.add(t.getSilla());
            }
        }
        return sillasOcupadas;
    }

    private Cliente buscarCliente(String Cedula) {
        for (Cliente c : this.myClientes) {
            if (c.getCedula().equalsIgnoreCase(Cedula)) {
                return c;
            }
        }

        return null;
    }

    /*Metodo para crear el id del Ticket r2*/
    private String crearIdTicket() {
        String id = "";
        id = "TQ -0 " + (this.myTickets.size() + 1);
        return id;
    }

    /*Metodos de apoyo para combobox de la vista r2*/
    public ArrayList listarSalidaPrograma() {
        ArrayList<String> salida;
        salida = new ArrayList<String>();
        for (SalidaProgramada s : this.mySalidas) {
            salida.add(s.getIdSalida() + " " + s.getMyRuta().getOrigen() + "-" + s.getMyRuta().getDestino() + "   " + s.getMyBus().getTipoServicio());
        }
        return salida;
    }

    /*Metodo que permite buscar la hora fecha de la salida r2*/
    public String buscarHorayFechaSalida(String codigoSalida) {
        String me = "";
        SalidaProgramada s = this.buscarSalidaProgramada(codigoSalida);
        if (s != null) {
            s.getFechaHora();
            SimpleDateFormat nuevoFormato = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            me = nuevoFormato.format(s.getFechaHora().getTime());
            return me;
        }
        me = "Si ves esto tienes un error con la busqueda de la salida";
        return me;
    }

    /*Metodo nos retorna la placa del bus recibiendo el codigo de la salida programada r2*/
    public String buscarBusDeSalida(String codigoSalida) {
        String placa = "";
        SalidaProgramada s = this.buscarSalidaProgramada(codigoSalida);
        placa = s.getMyBus().getPlaca();
        return placa;
    }

    public float totalCompra(String codSalida, int puestosCompra, boolean idaVuelta) {
        this.buscarBusDeSalida(codSalida);
        float total = 0.0f;
        float precio = this.buscarSalidaProgramada(codSalida).getMyRuta().getPrecioBoleto();
        total = precio * puestosCompra;

        if (idaVuelta) {
            total = total * 2;
            total -= total * 0.1;
        }
        return total;
    }

//Metodo para contar los puestos ocupados r2
    private int contarPuestosVenta(String[] puestosOcupados) {
        int total = 0;
        for (String m : puestosOcupados) {
            if (m.equalsIgnoreCase("OCUPADO")) {
                total++;
            }
        }

        return total;
    }

    private Bus buscarBus(String placa) {
        Bus b = null;
        for (Bus c : this.myBuses) {
            if (c.getPlaca().equalsIgnoreCase(placa)) {
                b = c;
            }
        }
        return b;
    }

    private Ruta buscarRuta(String codigoRuta) {
        Ruta b = null;
        for (Ruta c : this.myRutas) {
            if (c.getCodigo().equalsIgnoreCase(codigoRuta)) {
                b = c;
            }
        }

        return b;
    }

    //METODOS PARA EL FORM GESTIONAR SALIDAS
    public ArrayList<String> mostrarRutaComboBox() {
        ArrayList<String> myRutas = new ArrayList<>();
        for (Ruta r : this.myRutas) {
            myRutas.add(r.origenDestino());
        }
        return myRutas;
    }

    public String generarIdSalida() {
        String id = "S00";
        id += this.mySalidas.size() + 1;
        return id;
    }

    public ArrayList<String> busDisponibleComboBox(GregorianCalendar fechaHora) {
        ArrayList<String> bucesDisponibles = new ArrayList<>();

        for (Bus b : this.myBuses) {
            // Excluir buses en mantenimiento
            if (b.getEstado().equalsIgnoreCase("MANTENIMIENTO")) {
                continue;
            }

            boolean ocupado = false;
            for (SalidaProgramada s : this.mySalidas) {
                if (s.getMyBus().getPlaca().equalsIgnoreCase(b.getPlaca())) {
                    boolean enViaje
                            = fechaHora.compareTo(s.getFechaHora()) >= 0
                            && fechaHora.compareTo(s.getFechaHoraRetorno()) <= 0;

                    if (enViaje) {
                        ocupado = true;
                        break;
                    }
                }
            }

            if (!ocupado) {
                bucesDisponibles.add(b.getPlaca());
            }
        }

        return bucesDisponibles;
    }


    /*FUNCIONALIDADES DE MOSTRADO PARA LOS COMBOBOX*/
    private SalidaProgramada buscarSalidaProgramada(String codigoSalida) {
        for (SalidaProgramada s : this.mySalidas) {
            if (s.getIdSalida().equalsIgnoreCase(codigoSalida)) {
                return s;
            }
        }
        return null;
    }

    //Metodo para buscar la cantidad de asientos del bus
    public int asientosPanel(String placa) {
        return this.buscarBus(placa).getCapacidad();
    }

    //Metodo para traer el estado de cada asiento del bus
    public String[] estadoAsientosBotones(String codSalida) {
        String[] estado;
        estado = this.buscarSalidaProgramada(codSalida).getMyBus().estadoAsientos();

        return estado;
    }

    public String listarTickets() {
        String me = "";
        for (Ticket t : this.myTickets) {
            me += t.toString() + "\n";
        }
        return me;
    }
    
    /*REQUERIMIENTO FUNCIONAL 4 Cancelación de salida: cambiar estado a CANCELADA 
    y gestionar tiquetes VIGENTES (reprogramar automáticamente a otra salida PROGRAMADA
    de la misma ruta con cupo, o marcar REEMBOLSADO). Generar reporte del proceso.
    */

    public String cancelarReprogramarSalida(String codSalida){
        SalidaProgramada s= this.buscarSalidaProgramada(codSalida);
        Bus b= this.buscarBusReprogramar(s, codSalida).getFirst();
        SalidaProgramada s2;
    String me="Si ves esto, ve a CancelarReprogramarSalida";
    
    if(b!=null){
    Bus c=s.getMyBus();
    s.setMyBus(b);
    c.setEstado("MANTENIMIENTO");
    me="BUS REASIGNADO "+s.getMyBus().getPlaca()+ "A LA SALIDA "+s.getIdSalida()+" ("+s.getMyRuta().origenDestino()+") "+s.getFechaHora();
    }else{
    
        
    }
    
    
    return me;
    }
    
    //Metodo para buscar un bus disponible en la brecha de tiempo que necesitamos para reprogramar r4
    private ArrayList<Bus> buscarBusReprogramar(SalidaProgramada s, String placa){
        ArrayList <Bus> posiblesBuses=new ArrayList<>();
        
        for(Bus b: this.myBuses){
            boolean disponible = true;
            if(!b.getPlaca().equals(placa)){
                for(SalidaProgramada sp: this.mySalidas){
                    boolean cruce = false;
                    if(b.getPlaca().equalsIgnoreCase(sp.getMyBus().getPlaca())){
                      cruce=this.hayCruce(s.getFechaHora(), s.getFechaHoraRetorno(), sp.getFechaHora(),sp.getFechaHoraRetorno());
                    }
                    if(cruce){
                       break;
                    }
                    
                }
               if(disponible){
                posiblesBuses.add(b);
                } 
            }
        }
    
    return posiblesBuses;}
    
    //metodo para buscar las salidas en una brecha de un dia para reprogramar los puestos disponibles r4
    private String reprogramarSalida(SalidaProgramada c){
    String me="INREPROGRAMABLE";
    ArrayList<SalidaProgramada> posiblesSalidas= this.opcionesParaReprogramarSalida(c);
    if(posiblesSalidas.size()!=0){
        for(SalidaProgramada sa: posiblesSalidas){
        
        }
    }
    
    return me;
    }
    
    //Metodo para buscar posibles salidas disponibles para la reprogramacion
    private ArrayList<SalidaProgramada> opcionesParaReprogramarSalida(SalidaProgramada s){
        ArrayList<SalidaProgramada> salidas= new ArrayList<>();
        for(SalidaProgramada sc: this.mySalidas){
           if(this.esReprogramable(s, sc)){
               salidas.add(sc);
           }
        }
        
    
    return salidas;
    }
    
    
    //metodo para buscar los tickets de una salida especifica r4
    private ArrayList<Ticket> buscarTickets(SalidaProgramada s){
    ArrayList<Ticket> tickets= new ArrayList<>();
        for(Ticket t : this.myTickets){
            if(t.getMySalida().getIdSalida().equals(s.getIdSalida())){
            tickets.add(t);
            }
        }
        
    return tickets;}
    
    //Metodo para verificar si hay cruce de horarios entre los buses para reprogramar la salida r4
    private boolean hayCruce(GregorianCalendar salida1, GregorianCalendar retorno1, GregorianCalendar salida2, GregorianCalendar retorno2){
    return salida1.before(retorno2) && retorno1.after(salida2);
}
    //metodo para comparar con otra salida, teniendo en cuenta que la diferencia maxima es de un dia para poder ser reprogramada
    public boolean esReprogramable( SalidaProgramada salidaCancelada,
        SalidaProgramada salidaRepro) {

    // Verificar mismo destino
    if (!salidaCancelada.getMyRuta().getDestino().equals(salidaRepro.getMyRuta().getDestino())) {
        return false;
    }

    // Obtener diferencia en milisegundos
    long tiempo1 = salidaCancelada.getFechaHora().getTimeInMillis();
    long tiempo2 = salidaRepro.getFechaHora().getTimeInMillis();

    long diferencia = Math.abs(tiempo1 - tiempo2);

    // 24 horas en milisegundos
    long unDia = 24L * 60 * 60 * 1000;

    return diferencia <= unDia;
}
    //metodo para recorrer los buses y buscar los que se pueden usar para reprogramar r4
    
    
    /*requerimiento 5*/

}
