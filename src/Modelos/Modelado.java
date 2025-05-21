package Modelos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Modelado {
  public   String ultimaActualizacion;
  public   String monedaActual;
    Monedas monedas;
    public String resultado;

    public Modelado(Conversor conversor) {
        this.resultado = conversor.result();
        this.ultimaActualizacion = conversor.time_last_update_utc();
        this.monedaActual = conversor.base_code();
        this.monedas = conversor.monedas();
    }


    @Override
    public String toString() {
        return "Modelado{" + ", Resultado: "+resultado+
                ", ultimaActualizacion: " + ultimaActualizacion + '\'' +
                ", monedaActual: " + monedaActual + '\'' +
                ", Moneda: "+ monedas+
                '}';
    }
}
