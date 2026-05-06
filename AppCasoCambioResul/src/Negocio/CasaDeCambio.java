

package Negocio;


/**
 *
 * @author 
 *  
 */
public class CasaDeCambio {

    private  final Divisa myDiv1;
    private  final Divisa myDiv2;
    private  final Divisa myDiv3;
    private  final Divisa myDiv4;
    private float  dineroCaja;
    private float  ganancias;
    
    
    /*
     * RF1:  crear los cuatro tipos de Divisa con valores por default e iniciar caja: El sistema debe permitir al crear la Casa de Cambio, 
    la creación de cuatro divisas con valores predeterminados. Asimismo, se puede aprovechar para
      solicitar por una ventana el valor con que inicia la caja de la casa de cambio.
     */
    
    public CasaDeCambio(int totalCaja){
        this.dineroCaja=totalCaja;
        this.myDiv1=new Divisa("Dolar",4088.33F,3968.57F,8600);
        this.myDiv2=new Divisa("Euro", 4684F,4597.38F,5000);
        this.myDiv3=new Divisa("Franco Suizo", 4974.7F,4780F,4000);
        this.myDiv4=new Divisa("Libra Esterlina", 5520F,5400F,5000);
        this.ganancias=0F;
    }
    
   
/* RF2:  registrar compra de divisa: El sistema debe permitir el ingreso de la cantidad a comprar 
  de la divisa por parte de la casa de cambio. El sistema debe actualizar la cantidad disponible de la 
divisa  y las utilidades respectivas.*/
   public String comprarDivisa(String tipoDivisa, int cantidad){
       	 String cad;
         Divisa obj1;
         obj1=this.buscarDivisa(tipoDivisa);
         if(this.dineroCaja>=obj1.getPrecCompra()*cantidad){
           obj1.setCantDisponVta(obj1.getCantDisponVta()+cantidad);
           this.dineroCaja=this.dineroCaja-obj1.getPrecCompra()*cantidad;
           return "\n LOS "+ cantidad+ "  "+tipoDivisa+ " SE COMPRO A " + 
                   obj1.getPrecCompra()+ "\nEL CUAL REPRESENTA UNA SALIDA DE CAJA DE COP: $ "+ obj1.getPrecCompra()*cantidad;
         }
        return "NO HAY SUFICIENTE DINERO EN CAJA PARA COMPRAR: " +this.dineroCaja;
         
     }

 
   /*RF3:  registrar venta de divisa: El sistema debe permitir el ingreso de la cantidad a vender de la divisa
por parte de la casa de cambio. El sistema debe actualizar la cantidad disponible de la divisa y
las utilidades respectivas.*/
   
  public String venderDivisa(String tipoDivisa, int cantidad){
       	 String cad="";
         Divisa obj1=null;
         obj1=this.buscarDivisa(tipoDivisa);
         if(obj1.getCantDisponVta()>=cantidad){
            obj1.setCantDisponVta(obj1.getCantDisponVta()-cantidad);
            this.dineroCaja=this.dineroCaja+obj1.getPrecVenta()*cantidad;
            this.ganancias=this.ganancias+ this.calcularGanancias(obj1, cantidad); 
            return "\n LOS "+ cantidad+ "  "+tipoDivisa+ " SE VENDIÓ A " + 
                   obj1.getPrecVenta()+ "\nEL CUAL REPRESENTA UN INGRESO A CAJA EN COP: $ "+ obj1.getPrecVenta()*cantidad;
         }  
         return "NO HAY SUFICIENTE DIVISA PARA LA VENTA: "+obj1.getCantDisponVta();
         
          
    }

  private float calcularGanancias(Divisa obj, int cantidad){
      return  (obj.getPrecVenta()-obj.getPrecCompra())*cantidad;
  }
  
/* RF4:   consolidado del estado financiero : El sistema debe permitir mostrar el estado financiero de la casa 
de cambio, como son las utilidades y el valor total que se tiene actualmente en la caja.*/

public String  listarConsolidadoFinanciero ( ){
        String cad;
        cad="ACTUALMENTE DINERO EN CAJA EN COP: $" + this.dineroCaja+
            "\n SE CUENTA CON UNA UTILIDAD EN COP: $"+ this.ganancias;
        
         return cad;
    
}

/* RF5:   listar Divisas: El sistema debe permitir mostrar el estado actual de cada divisa.*/

public String  listarDivisas ( ){
          
    return this.myDiv1.toString()+"\n"+this.myDiv2.toString()+"\n"+this.myDiv3+"\n"+this.myDiv4.toString();
}


private Divisa buscarDivisa(String nomD){
    Divisa obj=null;
    if(this.myDiv1.getNombreD().equalsIgnoreCase(nomD)){
        obj=this.myDiv1;
    }else if(this.myDiv2.getNombreD().equalsIgnoreCase(nomD)){
        obj=this.myDiv2;
    }else if(this.myDiv3.getNombreD().equalsIgnoreCase(nomD)){
        obj=this.myDiv3;
    }else if(this.myDiv4.getNombreD().equalsIgnoreCase(nomD)){
        obj=this.myDiv4;
    }
    return obj;
}

}