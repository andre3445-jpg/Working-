
package Negocio;

/**
 *
 * @author geral
 */
public class Ticket {
  
    private String idTicket;
    private String estadoTicket;
    private float valorPagar;
    private SalidaProgramada mySalida;
    private Pasajero myPasajero;
    
    public Ticket(){
    
    this.idTicket=null;
    this.estadoTicket=null;
    this.mySalida=null;
    this.valorPagar=0.0F;
    }

    public Ticket(String idTicket, String estadoTicket, float valorPagar, SalidaProgramada mySalida) {
        this.idTicket = idTicket;
        this.estadoTicket = estadoTicket;
        this.valorPagar = valorPagar;
        this.mySalida = mySalida;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public String getEstadoTicket() {
        return estadoTicket;
    }

    public float getValorPagar() {
        return valorPagar;
    }

    public SalidaProgramada getMySalida() {
        return mySalida;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public void setValorPagar(float valorPagar) {
        this.valorPagar = valorPagar;
    }

    public void setMySalida(SalidaProgramada mySalida) {
        this.mySalida = mySalida;
    }
    
     // =====================================================
    // LO QUE SE CORRIGIO EN BUS.java
    // =====================================================
    
    /*
     * CORRECCION 1 - Se elimino el atributo cantidadPuestos
     * porque es innecesario. La capacidad ya la da asientos.length
     * a traves del metodo getCapacidad().
     * 
     * CORRECCION 2 - Se reemplazo inicializarAsientos por dos metodos privados:
     * 
     *      determinarCapacidad(String tipo):
     *      - retorna int, no es void
     *      - recibe el tipo y retorna 30 si es Ejecutivo, 40 si es Normal
     *      - no tiene else porque con return el metodo sale inmediatamente
     *      - el constructor lo llama para saber el tamanio del arreglo
     * 
     *      crearAsientos():
     *      - es void porque no retorna nada, solo llena el arreglo
     *      - recorre el arreglo con un for y en cada posicion mete un new Asiento
     *      - los asientos arrancan desde i+1 porque en la vida real
     *        los puestos de un bus arrancan desde el numero 1, no desde 0
     *      - sin este metodo el arreglo tendria puras nulls
     * 
     * CORRECCION 3 - El constructor ahora hace esto en orden:
     *      1. Asigna placa, tipoServicio y estado
     *      2. Abre el arreglo: new Asiento[determinarCapacidad(tipoServicio)]
     *      3. Llena el arreglo: crearAsientos()
     * 
     * CORRECCION 4 - setTipoServicio tambien llama a los dos metodos
     * porque si cambia el tipo de servicio, el arreglo debe recalcularse.
     */
    
    
    // =====================================================
    // LO QUE SE CORRIGIO EN Empresa.java
    // =====================================================
    
    /*
     * CORRECCION 1 - inicializarSalidas usaba streams innecesariamente.
     * La profesora dijo que los objetos ya estan en el ArrayList
     * desde posicion 0, entonces se usa get(posicion) directo.
     * Recordar el orden:
     *      myBuses:  get(0)=KAA-101  get(1)=KBB-202  get(2)=KCC-303
     *                get(3)=KDD-404  get(4)=KEE-505  get(5)=KFF-606
     *      myRutas:  get(0)=R01  get(1)=R02  get(2)=R03  get(3)=R04
     * 
     * CORRECCION 2 - GregorianCalendar cuenta meses desde 0.
     *      Enero=0  Febrero=1  MARZO=2  Abril=3  Mayo=4...
     *      El enunciado dice marzo entonces el mes va como 2, no 3.
     * 
     * CORRECCION 3 - registrarBus y registrarRuta tenian else innecesario.
     *      Con return directo el metodo sale inmediatamente si ya existe.
     *      Ademas usaban getFirst() que retornaba el primer elemento,
     *      no el recien agregado. Se corrigio guardando el objeto nuevo
     *      en una variable y usando esa variable en el mensaje.
     * 
     * CORRECCION 4 - registrarSalida llamaba validarBus en vez de validarSalida.
     *      Era un error de logica grave porque validaba la placa del bus
     *      en vez del id de la salida.
     * 
     * CORRECCION 5 - validarBus, validarRuta y validarSalida cambiaron
     *      de public a private porque son metodos internos de apoyo.
     *      Nadie fuera de Empresa debe llamarlos directamente.
     *      La vista solo llama a registrarBus y este internamente valida.
     *      Eso se llama encapsulamiento.
     */
    
    
    // =====================================================
    // CONCEPTOS QUE LA PROFESORA PUEDE PREGUNTAR
    // =====================================================
    
    /*
     * CONCEPTO - void vs tipo de retorno
     *      void: el metodo ejecuta acciones pero no retorna nada
     *      int: el metodo calcula algo y retorna un numero entero
     *      String: el metodo produce un texto y lo retorna
     *      boolean: el metodo evalua algo y retorna true o false
     *      Regla: si alguien necesita el resultado del metodo, retorna ese tipo.
     *             si solo ejecuta acciones sin que nadie necesite resultado, es void.
     * 
     * CONCEPTO - private vs public
     *      public: cualquier clase puede llamar ese metodo
     *      private: solo la misma clase puede usarlo internamente
     *      Los metodos de validacion van private porque son de apoyo interno.
     *      Los metodos que llama la vista van public.
     * 
     * CONCEPTO - this
     *      this hace referencia al objeto actual de la clase.
     *      Se usa para diferenciar atributos de parametros cuando tienen el mismo nombre.
     *      Ejemplo: this.placa = placa
     *               this.placa es el atributo de la clase
     *               placa es el parametro que llego al metodo
     * 
     * CONCEPTO - por que los formularios reciben FormPrincipal como parametro
     *      FormPrincipal tiene la referencia a Empresa donde vive la logica.
     *      Los formularios hijos necesitan acceder a Empresa para llamar sus metodos.
     *      Sin esa referencia los formularios no podrian hacer nada util.
     *      Se accede asi: myFormPrincipal.getMyEmpresa().registrarBus(...)
     * 
     * CONCEPTO - encapsulamiento
     *      Atributos siempre private.
     *      Acceso a ellos solo por getters y setters publicos.
     *      La logica interna se protege con metodos private.
     */
    
    
    // =====================================================
    // POSIBLES EXTENSIONES QUE PUEDEN PEDIR EN EL QUIZ
    // =====================================================
    
    /*
     * SI PIDEN: buscar un bus por placa
     *      Recorrer myBuses con for each.
     *      Comparar b.getPlaca().equalsIgnoreCase(placa).
     *      Si encuentra, retornar el objeto Bus.
     *      Si no encuentra, retornar null.
     * 
     * SI PIDEN: cambiar el estado de un bus
     *      Buscar el bus por placa con el metodo anterior.
     *      Si no es null, llamar bus.setEstado(nuevoEstado).
     *      Retornar mensaje de exito o error.
     * 
     * SI PIDEN: buscar una salida por id
     *      Recorrer mySalidas con for each.
     *      Comparar s.getIdSalida().equalsIgnoreCase(id).
     *      Si encuentra, retornar el objeto SalidaProgramada.
     *      Si no encuentra, retornar null.
     * 
     * SI PIDEN: listar salidas de una ruta especifica
     *      Recorrer mySalidas con for each.
     *      Comparar s.getMyRuta().getCodigo().equalsIgnoreCase(codigoRuta).
     *      Si coincide, agregar al String resultado.
     * 
     * SI PIDEN: contar asientos disponibles de una salida
     *      Acceder a salida.getMyAsientos().
     *      Recorrer el arreglo con for.
     *      Contar las posiciones que sean null (no vendidas aun).
     * 
     * SI PIDEN: vender un pasaje (RF2)
     *      Recibir: idSalida, numeroAsiento, nombre, cedula del pasajero.
     *      Buscar la salida por id.
     *      Verificar que el asiento no este ocupado.
     *      Calcular valor: tarifa base de la ruta.
     *      Si el bus es EJECUTIVO sumar 20%: valor = valor * 1.20f
     *      Crear Pasajero y Ticket.
     *      Marcar el asiento como ocupado en la salida.
     *      Sumar el valor al totalVendido de la caja.
     * 
     * SI PIDEN: venta ida y vuelta (RF3)
     *      Vender dos pasajes, uno de ida y uno de regreso.
     *      Validar que ambas salidas sean de la misma ruta.
     *      Calcular descuento del 10% sobre el total de los dos.
     *      valorFinal = (valorIda + valorRegreso) * 0.90f
     * 
     * SI PIDEN: cancelar una salida (RF4)
     *      Buscar la salida por id.
     *      Cambiar su estado a CANCELADA.
     *      Recorrer sus tiquetes vigentes.
     *      Para cada tiquete buscar otra salida PROGRAMADA de la misma ruta con cupo.
     *      Si hay cupo: cambiar estado del tiquete a REPROGRAMADO.
     *      Si no hay cupo: cambiar estado del tiquete a REEMBOLSADO.
     *      Sumar reembolsados al totalReembolsado de la caja.
     * 
     * SI PIDEN: reporte de caja (RF5)
     *      totalVendido: suma de todos los tiquetes vendidos.
     *      totalReembolsado: suma de todos los tiquetes reembolsados.
     *      ingresoNeto: totalVendido - totalReembolsado.
     *      Esos tres valores se muestran en el FormCaja.
     */
    
    
    // =====================================================
    // ESTRUCTURA DE CONEXION ENTRE FORMULARIOS
    // =====================================================
    
    /*
     * FormPrincipal crea y abre los formularios hijos pasandose asi mismo:
     *      this.myFormBus = new FormRegistrarBus(this)
     *      this.myFormBus.setVisible(true)
     * 
     * Cada formulario hijo guarda esa referencia:
     *      private FormPrincipal myFormPrincipal
     * 
     * Y la usa para acceder a Empresa:
     *      myFormPrincipal.getMyEmpresa().registrarBus(...)
     *      myFormPrincipal.getMyEmpresa().listarBus()
     * 
     * Los resultados de esos metodos se muestran en:
     *      JTextArea: txtMensaje.setText(resultado)
     *      JOptionPane: JOptionPane.showMessageDialog(this, resultado)
     */

    
    
}
