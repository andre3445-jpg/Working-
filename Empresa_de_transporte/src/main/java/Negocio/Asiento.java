

package Negocio;

/**
 *
 * @author LENOVO LOQ
 */
public class Asiento {
    private int numAsiento;
    private String estadoAsiento;

    public Asiento() {
        this.numAsiento = 0;
        this.estadoAsiento = null;
    }

    public Asiento(int numAsiento, String tipoAsiento) {
        this.numAsiento = numAsiento;
        this.estadoAsiento = tipoAsiento;
    }

    public int getNumAsiento() {
        return numAsiento;
    }

    public String getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public void setEstadoAsiento(String estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    @Override
    public String toString() {
        return "\nNumero de Asiento= " + numAsiento 
                +"\tEstado de Aiento de Asiento= " + estadoAsiento;
    }
    
    
    
}

