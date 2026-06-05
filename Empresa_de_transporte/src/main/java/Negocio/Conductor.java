
package Negocio;


public class Conductor extends Persona{
    
    private float sueldo;
    private boolean asignado;
    
    public Conductor(){
 
    this.sueldo=0.0F;
    this.asignado=false;
    }

    public Conductor(float sueldo, String nombre, String cedula, String correo, String telefon) {
        super(nombre, cedula, correo, telefon);
        this.sueldo = sueldo;
        this.asignado=false;
    }
    
    
    public float getSueldo() {
        return sueldo;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isAsignado() {
        return asignado;
    }

    @Override
    public String toString() {
        return "Conductor\n"+super.toString()+"\n Sueldo: "+this.sueldo;
    }

    
    
    
    
   
    
}
