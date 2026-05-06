/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;


/**
 *
 * @author USUARIO
 * En el caso de los productos se van almacenar en Empresa en una colección
 * TreeSet, para que queden de manera ordenada por nombre y sean únicos
 * En este caso la clase Producto debe implementar la interface Comparable
 * y se debe sobreescribir el metodo CompareTo por el atributo o atributos
 * que quiere que sea único y ordenado.
 * 
 * La interfaz comparable declara un método que se usa para determinar el orden natural de 
 * instancias de una clase.  La cual se define como:
		int compareTo (T obj)

Donde compara el objeto que realiza la llamada  con obj.  Devuelve:
	Cero:  si los valores son iguales
	Negativo:  si el objeto que realiza la llamada tiene un valor menor
	Positivo: si el  objeto que realiza la llamada tiene un valor mayor
        * 
 */
public class Producto implements Comparable<Producto>{
    private String nombre;
    private int cantidadExist;
    private float precioUnit;

    public Producto(String nombre, float precioUnit) {
        this.nombre = nombre;
        this.precioUnit = precioUnit;
    }

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadExist() {
        return cantidadExist;
    }

    public void setCantidadExist(int cantidadExist) {
        this.cantidadExist = cantidadExist;
    }

    public float getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(float precioUnit) {
        this.precioUnit = precioUnit;
    }
    
    public String toString(){
        return "Nombre: "+this.nombre+"\tCantidad Existencia: "+this.cantidadExist+
                "\tPrecio Unitario: "+this.precioUnit;
        
    }
    
    /*** ESTE MEDOTO compareTo se sobreescribe para indicar
     que se va a guardar sus objetos en una colección TreeSet
     de manera ordenada y no repetida por nombre.   ***/
    
    public int compareTo(Producto p){
        return this.nombre.compareToIgnoreCase(p.getNombre());
    }
    
    
}
