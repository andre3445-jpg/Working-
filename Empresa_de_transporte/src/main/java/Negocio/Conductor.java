
package Negocio;


public class Conductor extends Persona{
    private int anoIngreso;
    private float sueldo;
    
    public Conductor(){
    this.anoIngreso=0;
    this.sueldo=0.0F;
    }

    public Conductor(int anoIngreso, float sueldo, String nombre, String cedula, String correo, String telefon) {
        super(nombre, cedula, correo, telefon);
        this.anoIngreso = anoIngreso;
        this.sueldo = sueldo;
    }

    public int getAnoIngreso() {
        return anoIngreso;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setAnoIngreso(int anoIngreso) {
        this.anoIngreso = anoIngreso;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nConductor{" + "anoIngreso=" + anoIngreso + ", sueldo=" + sueldo + '}';
    }
    
    
    
   
    
}
