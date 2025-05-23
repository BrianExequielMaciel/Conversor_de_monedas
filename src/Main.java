import Calculos.Calcular;
import HTTP_Models.Cliente;
import HTTP_Models.Respuesta;
import HTTP_Models.Usuario;
import Modelos.Conversor;
import Modelos.Modelado;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        String clave;
        Usuario usuario1 = new Usuario();
        clave = usuario1.getClave();
        String direccion;
        String tipoCambio;
        Double monto;
//Libreria para formatear JSON, lo veremos mas adelante
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create()
                ;
//Ingresar tipos de cambio
        while (true) {
            System.out.println("""
                      ############################### INICIA PROGRAMA ###############################
                       Escrribla el tipo de moneda que quiere  convertir:
                       USD.
                       ARS.
                       BRL.
                       COP.
                       BOB.
                       CPL.
                       Para finalizar escriba: salir.
                       #############################################################################
                    """);

            try {
                tipoCambio = lectura.next();
                if (tipoCambio.equalsIgnoreCase("Salir")){
                    break;
                }
                System.out.println("Ingrese el monto de la moneda que quiere comparar: \n");
                monto = lectura.nextDouble();

                System.out.println("****************Espere mientras se procesa el calculo******************");

                direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/" + tipoCambio;

                //instancio un nuevo cliente
                Cliente nuevaSolicitud = new Cliente(direccion);


                //instancio una nueva respuesta
                Respuesta solicitudRespuesta = new Respuesta();
                //implemento el metodo
                solicitudRespuesta.implementarRespuesta();
                //OBTENGO LA RESPUESTA
                String respuesta = solicitudRespuesta.getRespuesta();
                //Intancio el nuevo objeto, es el que convierte el JSON
                Conversor conversor = gson.fromJson(respuesta, Conversor.class);
                //instancio modelado y le paso el record
                Modelado modelo = new Modelado(conversor);
                //Muestra algunos datos importantes del modelado
                System.out.println(modelo.toString());
                //Instancio calculos, es el que va a calcular los tipos de cambio, le paso el monto que ingresa el usuario y los valores de tipos de cambio
                Calcular calculos = new Calcular(monto, modelo.getMonedas());
                //Le paso el tipo de cambio elegido por el usuario
                calculos.setMonedaActual(tipoCambio);
                //Muestro el toString de los calculos
                System.out.println(calculos.toString());



            } catch (RuntimeException | IOException e) {
                System.out.println("Ocurrio un error verifique los datos ingresados, error: "+e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                System.out.println("Ocurrio un error inesperado: " + e);
            }
        }
        lectura.close();
        System.out.println("######################## FIN PROGRAMA ##############################");
    }
}
