/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

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

        public Bus(String placa, String tipoServicio, String estado) {
            this.placa = placa;
            this.tipoServicio = tipoServicio;
            this.estado = estado;
            this.asientos = new Asiento[this.determinarCapacidad(tipoServicio)];
            this.crearAsientos();
        }

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
                this.asientos[i] = new Asiento(i + 1, this.tipoServicio);
            }
        }
        
        public int getCapacidad(){
            return asientos.length;
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
            this.asientos = new Asiento[this.determinarCapacidad(tipoServicio)];
            this.crearAsientos();
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public void setAsientos(Asiento[] asientos) {
            this.asientos = asientos;
        }
       
       /**PROFESORA:  OJOO QUE BUS DEBE MANIPULAR LAS PARTES..**/

        @Override
        public String toString() {
            return "\nplaca= " + placa + 
                    "\ntipoServicio= " + tipoServicio + 
                    "\nestado= " + estado + 
                    "\ncapacidad= " + getCapacidad()+"\n";
        }



//Comentaario de prueba





    }

