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
            this.inicializarAsientos(tipoServicio);
            
        }

        private void inicializarAsientos(String tipo) {
            int cantidad;
            if(tipo.equalsIgnoreCase("Ejecutivo")){
             cantidad = 30;
            }else if(tipo.equalsIgnoreCase("Normal")){
             cantidad = 40;
            }else{
                cantidad = 0;
            }
            
            this.asientos = new Asiento[cantidad];
            
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
             inicializarAsientos(tipoServicio);
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public void setAsientos(Asiento[] asientos) {
            this.asientos = asientos;
        }

        @Override
        public String toString() {
            return "\nplaca= " + placa + 
                    "\ntipoServicio= " + tipoServicio + 
                    "\nestado= " + estado + 
                    "\ncapacidad= " + getCapacidad()+"\n";
        }



//Comentaario de prueba





    }

