package Modelos;



public class Monedas {

   public String USD;
    public String ARS;
    public  String BRL;
    public   String COP;
    public   String BOB;
    public  String CLP;


    public Monedas(String USD, String ARS, String BRL, String COP, String BOB, String CLP) {
        this.USD = USD;
        this.ARS = ARS;
        this.BRL = BRL;
        this.COP = COP;
        this.BOB = BOB;
        this.CLP = CLP;
    }


    @Override
    public String toString() {
        return "Monedas{" +
                "USD='" + USD + '\'' +
                ", ARS='" + ARS + '\'' +
                ", BRL='" + BRL + '\'' +
                ", COP='" + COP + '\'' +
                ", BOB='" + BOB + '\'' +
                ", CLP='" + CLP + '\'' +
                "\n";
    }
}
