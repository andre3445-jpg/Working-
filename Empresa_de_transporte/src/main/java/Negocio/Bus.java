/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.ArrayList;

/**
 *
 * @author LENOVO LOQ
 */
    public class Bus {
        private String placa;
        private String tipoServicio;
        private String estado;
        private Asiento[] asientos;


        public Bus(){

        this.placa=null;
        this.tipoServicio=null;
        this.estado=null;
        this.asientos=new Asiento[0];
        }
 //AQUI ESTA ABRIENDO ESPACIO DE MEMORIA AL ARREGLO ASIENTO SEGUN
            //TIPO DE SERVICIO (Corregido creo )

        public Bus(String placa, String tipoServicio) {
            this.placa = placa;
            this.tipoServicio = tipoServicio;
            this.estado = "DISPONIBLE";
            this.asientos = new Asiento[this.determinarCapacidad(tipoServicio)];
            this.crearAsientos();
        }
        // PROFESORA: AQUI FALTA OBLIGATORIAMENTE EL LLAMADO DEL METODO PRIVADO DE ACTUALIZAR LOS 
        //PUESTOS CREADO...


        private int determinarCapacidad(String tipo) {
            if (tipo.equalsIgnoreCase("Ejecutivo")) {
              return 30;
            }
            if (tipo.equalsIgnoreCase("Normal")) {
              return 40;
            }
              return 0;
            }
        private void crearAsientos(){
            for(int i=0; i < this.asientos.length; i++){
                this.asientos[i] = new Asiento(i + 1, "Disponible");
            }
        }
        
        private int getCapacidad(){
            return asientos.length;
        }
        public int capacidad(){
          int cap= this.getCapacidad();
            return cap;
        }

        public String getPlaca() {
            return placa;
        }

        public String getTipoServicio() {
            return tipoServicio;
        }

        public String getEstado() {
            return estado;
        }

        public Asiento[] getAsientos() {
            return asientos;
        }

        public void setPlaca(String placa) {
            this.placa = placa;
        }

        public void setTipoServicio(String tipoServicio) {
            this.tipoServicio = tipoServicio;
            
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public void setAsientos(Asiento[] asientos) {
            this.asientos = asientos;
        }
       
       /**PROFESORA:  OJOO QUE BUS DEBE MANIPULAR LAS PARTES..**/

        public String mostrarAsiento(){
          String me="";
            for (Asiento a : this.asientos){
              me += a.toString();
            }
          return me;
        }
        
        /*Metodo para mostrar solo los asientos disponibles*/
            public ArrayList mostrarAsientoDisponible(){
          ArrayList<String> me =new ArrayList<>();
          String numeroPuesto="";
            for (Asiento a : this.asientos){
             if(a.getEstadoAsiento().equalsIgnoreCase("Disponible")){
                me.add(numeroPuesto+=a.getNumAsiento());
                numeroPuesto="";
             }
            }
          return me;
        }
        
        
        /*Este metodo carga en un vector tipo string la informacion del estado de los asientos en orden, el numero del asiento
        equivale al indice del vector +1 (i+1) 
        */
        public String[] estadoAsientos(){
         String[] asientos;
        asientos= new String[this.asientos.length];
        for(int i=0; i< asientos.length; i++){
          asientos[i]=this.asientos[i].getEstadoAsiento();
        }
        
        return asientos;}
        
        /*Metodo para cambiar el estado del asiento a "OCUPADO"*/
        public void ocuparAsiento(int numeroAsiento){
            this.asientos[numeroAsiento-1].setEstadoAsiento("OCUPADO");
        }
        
        
        @Override
        public String toString() {
            return "\nplaca: " + placa + 
                    "\nipoServicio: " + tipoServicio + 
                    "\nEstado: " + estado + 
                    "\nCapacidad: " + getCapacidad()+"\n";
        }



//Comentaario de prueba
        
        private String listarAsientosInversos(){
            String me="";
            
            for(int i= this.asientos.length-1; i>=0; i--){
                me+= this.asientos[i].toString();
            }
            
            
            
            
            return me; 
        }
        

        public String listarIntercalado(){
            return "Placa : "+this.placa +"\t Tipo Servicio: "+this.tipoServicio +"\t estado : "+this.estado+"\t capacidad : "+this.asientos.length+
                    "\n********************* PUESTOS O SILLAS **************************\n"+
                    this.listarAsientosInversos();
        }



    }

