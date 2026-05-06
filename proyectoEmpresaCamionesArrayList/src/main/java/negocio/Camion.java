
package negocio;

/**
 *ARRAYLIST
 * @author estudiantes
 */
public class Camion {
    private String placa;
    private int carga;
    private float consumo;
//constructor con parametros
    public Camion(String placa, int carga, float consumo) {
        this.placa = placa;
        this.carga = carga;
        this.consumo = consumo;
    }
//cosntructor por default
    public Camion() {
        this.placa = null;
        this.carga = 0;
        this.consumo = 0.0F;
    }
//metodos get y set

    public String getPlaca() {
        return placa;
    }

    public int getCarga() {
        return carga;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
// metodo toString
    @Override
    public String toString() {
        return "\nPlaca: "+this.placa+"\nCarga(Kg): "+this.carga+
                "\nConsumo(Gas/Km): "+this.consumo;
    }
    
    
}
