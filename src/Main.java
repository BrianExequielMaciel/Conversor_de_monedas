import HTTP_Models.Cliente;
import HTTP_Models.Respuesta;
import HTTP_Models.Usuario;
import Modelos.Conversor;
import Modelos.Modelado;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        //Scanner lectura = new Scanner(System.in);
        String clave;
        Usuario usuario1 = new Usuario();
        clave = usuario1.getClave();
        String direccion;
//Libreria para formatear JSON, lo veremos mas adelante
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create()
                ;

        direccion = "https://v6.exchangerate-api.com/v6/" + clave + "/latest/USD";


        try {
            //instancio un nuevo cliente
            Cliente nuevaSolicitud = new Cliente(direccion);
            System.out.println("""
                    ##################
                    ### #### ### ####
                    """);

            //instancio una nueva respuesta
            Respuesta solicitudRespuesta = new Respuesta();
            //implemento el metodo
            solicitudRespuesta.implementarRespuesta();
            //OBTENGO LA RESPUESTA
            String respuesta = solicitudRespuesta.getRespuesta();
            System.out.println("Respuesta: "+ respuesta);
            Conversor conversor = gson.fromJson(respuesta, Conversor.class);
            Modelado modelo = new Modelado(conversor);
            System.out.println(modelo.toString());





        } catch (RuntimeException | IOException  e){
            System.out.println(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            System.out.println("ocurrio un error: "+e);
        }


    }
}
