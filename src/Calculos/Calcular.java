package Calculos;


import Modelos.Monedas;

public class Calcular {
    Double monto;
    String monedaActual;

    Double enBRL;
    Double enARS;
    Double enCOP;
    Double enUSD;
    Double enBOB;
    Double enCLP;
    Monedas monedas;

    public Calcular(Double monto, Monedas monedas) {
        this.monto = monto;
       //
        this.monedas = monedas;
        calcularMonedas();
    }

    public void setMonedaActual(String monedaActual) {
        this.monedaActual = monedaActual;
    }

    public void calcularMonedas() {
try {

    if (monto != 0){
        this.enUSD = monto * Double.parseDouble(monedas.USD);
        this.enBRL = monto * Double.parseDouble(monedas.BRL);
        this.enARS = monto * Double.parseDouble(monedas.ARS);
        this.enCOP = monto * Double.parseDouble(monedas.COP);
        this.enBOB = monto * Double.parseDouble(monedas.BOB);
        this.enCLP = monto * Double.parseDouble(monedas.CLP);

    }else System.out.println("Ingrese un numero mayor que 0");;

}catch (NullPointerException e){
    System.out.println(e);
}
    }

    @Override
    public String toString() {
        return "Los Calculos del monto "+monto+" actual en: "+monedaActual+" son: " + "\n"+
                ",  En BRL=" + enBRL +  " Reales"+ "\n"+
                ",  En ARS=" + enARS +  " Pesos argentinos"+ "\n"+
                ",  En COP=" + enCOP +  " Pesos colombianos"+ "\n"+
                ",  En USD=" + enUSD +  " Dolares"+ "\n"+
                ",  En BOB=" + enBOB +  " Pesos bolivianos"+ "\n"+
                ",  En CLP=" + enCLP +  " Pesos chilenos "
                ;
    }
}
