package HTTP_Models;

import java.io.IOException;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Respuesta {
    private HttpRequest solicitud;
    private HttpClient cliente;
    private String respuesta;

    //Modelados



//Este metodo toma los getters de Cliente y las reasigna a las variables locales y ejecuta el metodo mostrar respuesta
    public void implementarRespuesta() throws IOException, InterruptedException {
        this.cliente = Cliente.getCliente();
        this.solicitud = Cliente.getSolicitud();
        mostrarRespuesta();

    }
//Este metodo obtiene la respuesta de la peticion que manda el cliente la obtiene y la define en una variable local
    public void mostrarRespuesta( ) throws IOException, InterruptedException {
        HttpResponse<String> response = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        this.respuesta = json;
    }



//Este es un getter que pone a disposicion la respuesta,pero antes hace una prueva que desidi incluir para depurar mi codigo ya que en algunos casos no recibia nada y queria saber donde estaba el problema
    public String getRespuesta() {
        //esta es una prueva para determinar si la prueva esta vacia
        if (respuesta==null){System.out.println("Lo siento no encontramos nada. ");
        }
        return respuesta;
    }
}


