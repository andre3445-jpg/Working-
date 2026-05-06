/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author USUARIO
 */
public class Empresa {

    private  Camion myCamion1;
    private  Camion myCamion2;
    private Camion myCamion3;

    public Empresa() {
    }
    
    /* RF1:  registrar camión: El sistema debe permitir registrar un camión, teniendo en cuenta 
               que no pueden existir dos camiones con una misma placa.*/
    
    public String registarCamion(String placa,int carga,float consumo){
        String cad;
       if(this.validarPlaca(placa)){
           return "placa ya registrada";
       }
        if(this.myCamion1==null){
            this.myCamion1=new Camion(placa,carga,consumo);
            cad="camion ha sido registrado";
        }else if(this.myCamion2==null){
            this.myCamion2=new Camion(placa,carga,consumo);
            cad="camion 2 ha sido registrado";
        } else if(this.myCamion3==null){
            this.myCamion3=new Camion(placa,carga,consumo);
            cad="camion 3 ha sido registrado";
        }else     
           cad="NO HAY MAS ESPACIO PARA REGISTRAR";
       
        return cad;
                
      }
    
     /* RF2:  validar camión por placa: El sistema debe permitir el ingreso de una placa y validar entre los camiones que existan. 
        Debe retornar el resultado de existencia.*/
    
    public boolean validarPlaca(String placa){
        boolean enc=false;
        if(this.myCamion1!=null&&this.myCamion1.getPlaca().equalsIgnoreCase(placa)){
            enc=true;
        }else if(this.myCamion2!=null&&this.myCamion2.getPlaca().equalsIgnoreCase(placa)){
                enc=true;
        }else if(this.myCamion3!=null&&this.myCamion3.getPlaca().equalsIgnoreCase(placa)){
                enc=true;
         }
         return enc;
    
    
     }
    
     /*RF3:  buscar camión carga solicitada: El sistema deber permitir la búsqueda de un
 camión capaz de transportar una carga solicitada, en caso contrario informar el 
      resultado.*/
        
    public String buscarCamionCarga(int peso){
        String cad="";
        if(this.myCamion1!=null&&this.myCamion1.getCarga()>=peso){
            cad="El siguiente camion puede transportar la carga: \n"+this.myCamion1.toString();
        }
        if (this.myCamion2!=null&&this.myCamion2.getCarga()>=peso){
            cad=cad+ "\n" + "El siguiente camion puede transportar la carga: \n"+this.myCamion2.toString();
        }
         if (this.myCamion3!=null&&this.myCamion3.getCarga()>=peso){
            cad=cad+ "\n" + "El siguiente camion puede transportar la carga: \n"+this.myCamion3.toString();
        }   
        if(cad.equals("")){
            cad="NO HAY CAMION DISPONIBLE PARA ESA CARGA";
        }
        return cad;
    }
    
    /*RF4:   camión menor consumo de gasolina: El sistema debe buscar cual es el camión con menor consumo de gasolina, 
puede existir la posibilidad de dos o tres camiones con igual consumo.*/
    
    public String mostrarCamionMenorConsumo ( ) {
      float menor=100.0F;
      String cad="";
      
      if(this.myCamion1!=null&&this.myCamion1.getConsumo()<=menor){
          cad="El siguiente camion tiene consumo de gasolina menor: \n"+this.myCamion1.toString();
          menor=this.myCamion1.getConsumo();
      }
      if(this.myCamion2!=null&&this.myCamion2.getConsumo()<=menor){
          cad=cad+ "\nEl siguiente camion tiene consumo de gasolina menor: \n"+this.myCamion2.toString();
          menor=this.myCamion2.getConsumo();
      }
      if(this.myCamion3!=null&&this.myCamion3.getConsumo()<=menor){
          cad=cad+ "\nEl siguiente camion tiene consumo de gasolina menor: \n"+this.myCamion3.toString();
          menor=this.myCamion3.getConsumo();
      }
      return cad;
      
    }
/*RF5:   calcular el promedio de capacidad de carga: El sistema debe permitir 
mostrar cual es el promedio de la capacidad de carga entre los camiones que existen 
en la empresa.*/

 public  String  calcularPromedioCarga ( ){
     String cad="";
     int cont=0;
     float prom=0.0F;
     
     if(this.myCamion1!=null){
         cont++;
         prom=prom+this.myCamion1.getCarga();
     }
     if(this.myCamion2!=null){
         cont++;
         prom=prom+this.myCamion2.getCarga();
     }
     if(this.myCamion3!=null){
         cont++;
         prom=prom+this.myCamion3.getCarga();
     }
     if(cont!=0){
         prom=prom/cont;
         cad="promedio de carga: "+prom;
         return cad;
     }
     
    return "NO HAY CAMIONES EN LA EMPRESA..";
     
 } 

 /*  RF6:   Listar camiones: El sistema debe permitir mostrar la información de 
cada uno de los camiones que existen en la empresa.*/

public  String  listarCamiones( ){
    String cad="";
    if(this.myCamion1!=null){
         cad=cad + this.myCamion1.toString();
     }
     if(this.myCamion2!=null){
         cad =cad+this.myCamion2.toString();
     }
     if(this.myCamion3!=null){
         cad=cad+this.myCamion3.toString();
     }
    
     if(cad.isEmpty()){
         return "NO HAY CAMIONES REGISTRADOS";
     }
     return cad;
}
            
  
}
        
    

