package HTTP_Models;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class Cliente {
String busqueda;
static HttpClient cliente;
static HttpRequest solicitud;

//Constructor que recibe la direccion y ejecuta el metodo de hacer recuest
    public Cliente(String busqueda) {
        this.busqueda = busqueda;
        hacerRecuest(busqueda);
    }
//Metodo que crea el cliente y la peticion y la asigna a las variables locales
    public void hacerRecuest(String busqueda) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busqueda.toString()))
                .build();
        this.cliente = client;
        this.solicitud = request;
    }
//Metodos getters de las variables locales
    public static HttpRequest getSolicitud() {
        return solicitud;
    }

    public static HttpClient getCliente() {
        return cliente;
    }
}

