
package negocio;

import java.util.ArrayList;
import java.util.TreeSet;


/**
 * PROYECTO CAMIONES CON ARRAYLIST
 * @author estudiantes
 */
public class Empresa {

    private ArrayList<Camion> myCamiones;
    private TreeSet<Producto> myProductos;
    

    // constructor por default
    public Empresa() {
        this.myCamiones = new ArrayList<>();
        this.myProductos=new TreeSet<>();
    }

    // requerimiento uno
    // registrar camión: El sistema debe permitir registrar un camión
    public String registrarCamion(String placa, int carga, float consumo) {
        if (this.validarPlaca(placa)) {
            return "Placa ya EXISTE...";
        }

        Camion nuevo = new Camion(placa, carga, consumo);
        this.myCamiones.add(nuevo);
        return "Camión registrado " + nuevo.toString();
    }

    // requerimiento doss
    // validar camión por placa: Retorna si existe o no
    public boolean validarPlaca(String placa) {
        boolean existe = false;
         for (Camion c : this.myCamiones) {
            if(c.getPlaca().equalsIgnoreCase(placa)){
                existe = true;
                break;
            }
                      
        }
        return existe;
    }

    // requerimiento tres
    // buscar camión carga solicitada
    public String buscarCamionCarga(int carga) {
        String cad = "";
        if(this.myCamiones.isEmpty()){
        return "camiones no registrados, registre uno";
    }
        for (Camion c :this.myCamiones) {
            if(c.getCarga() >= carga){
                cad = cad +"Placa: "+c.getPlaca()+" \t carga: "+c.getCarga()+"\n ";
            }
        }
        return cad;
    }

    // requerimiento cuatro
    // camión menor consumo de gasolina
    public String mostrarCamionMenorConsumo(){ 
           
        String cad= "NO HAY CAMIONES REGISTRADOS";
        float menor = Float.MAX_VALUE;
        
     if (this.myCamiones.isEmpty()){
              return cad;
     }
     for (Camion c:this.myCamiones){
           if (c.getConsumo()<=menor){
               if (c.getConsumo()==menor){
                      cad=cad+"\n" +c.toString();        
                  }else {
                     cad=c.toString(); 
                  }
                  menor=c.getConsumo();

           }
        }
       return cad;
     }  
        
    

    // requerimiento cinco
    // calcular el promedio de capacidad de carga
    public String calcularPromedioCarga() {
        if (this.myCamiones.isEmpty()) {
            return "Promedio de carga: 0 (No hay camiones)";
        }

        float suma = 0;
        for (int i = 0; i < this.myCamiones.size(); i++) {
            suma = suma + this.myCamiones.get(i).getCarga();
        }

        float promedio = suma / this.myCamiones.size();
        return "El promedio de capacidad de carga es: " + promedio + " kg.";
    }

    // requerimiento seis
    // Listar camiones
    public String listarCamiones() {
        if (this.myCamiones.isEmpty()) {
            return "No hay camiones para listar.";
        }

        String cad = "LISTADO DE CAMIONES EN LA EMPRESA:\n";
        for(Camion c : this.myCamiones){
            cad = cad+c.toString()+"\n";
        }
        return cad;
    }
}