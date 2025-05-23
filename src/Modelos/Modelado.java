package Modelos;




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

    public Monedas getMonedas() {
        return monedas;
    }

    @Override
    public String toString() {
        return "La fechas de actualizacion y los tipos de cambio estan listos" + ", Resultado: "+resultado+
                ", ultimaActualizacion: " + ultimaActualizacion + '\n' +
                ", monedaActual: " + monedaActual + '\n' +
                ", Cotizaciones actuales: "+ monedas.toString()+
                "\n";
    }
}
