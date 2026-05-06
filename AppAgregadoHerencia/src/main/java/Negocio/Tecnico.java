/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author DOCENTE
 * Para el calculo del sueldo de los técnico, se estima como:
 * años de experiencia entre 1 - 3 años recibe de base de sueldo de 5 mill
 * años de experiencia entre 4 - 7 años recibe de base de sueldo de 8 mill
 * años de experiencia mayor a 7 años recibe base de sueldo de  11 mill
 * Ahora, si cuenta con una cantidad de premios entre 1-3 recibe un excedente de 2 millones
 * si cuenta con 4-7 premios recibe un excedente de 4 millones y más de 7 premios recibe 6 millones
 * Tenga en cuenta que no se recibe hojas de vida con cero experiencia.
 * 
 */
public class Tecnico extends Persona{
    private String nombreUltEqu;
    private boolean disponible;
    private int añosExperiencia;
    private int cantPremiosGanados;
    private int sueldo;

    public Tecnico() {
        
    }

    public Tecnico(String cedula, String nombre, String correo, String telefono, String nombreUltEqu, int añosExperiencia, int cantPremiosGanados) {
        super(cedula, nombre, correo, telefono);
        this.nombreUltEqu = nombreUltEqu;
        this.añosExperiencia = añosExperiencia;
        this.cantPremiosGanados = cantPremiosGanados;
        this.disponible=true;
        this.calcularSueldo();
    }
    
    
    private void calcularSueldo(){
        int excedente=this.calcularExcedentePremio();
        if(this.añosExperiencia>=1&&this.añosExperiencia<=3){
            this.sueldo=5000000+excedente;
        } else if(this.añosExperiencia>=4&&this.añosExperiencia<=7){
            this.sueldo=8000000+excedente;
        } else this.sueldo=11000000+excedente;
    }
    
    
    private int calcularExcedentePremio(){
        int exced=0;
        switch(this.cantPremiosGanados){
            case 0: { exced=0; break; }
            case 1: case 2: case 3: { exced=2000000;break; }
            case 4: case 5: case 6: case 7: { exced=4000000;break; }
            default: { exced=6000000;break; }
         }
        return exced;
   }

    public String getNombreUltEqu() {
        return nombreUltEqu;
    }

    public void setNombreUltEqu(String nombreUltEqu) {
        this.nombreUltEqu = nombreUltEqu;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public int getCantPremiosGanados() {
        return cantPremiosGanados;
    }

    public void setCantPremiosGanados(int cantPremiosGanados) {
        this.cantPremiosGanados = cantPremiosGanados;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return  super.toString() + "nombreUltEqu=" + nombreUltEqu + ", disponible=" + disponible + ", a\u00f1osExperiencia=" + añosExperiencia + ", cantPremiosGanados=" + cantPremiosGanados + ", sueldo=" + sueldo + '\n';
    }
    
    
    
    
    
}
