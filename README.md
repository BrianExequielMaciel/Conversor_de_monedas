# Conversor de Monedas con API de Tipo de Cambio

Este programa en Java permite convertir entre diferentes monedas usando una API pública de tipos de cambio. El usuario ingresa una moneda base y un monto, y el sistema muestra los valores equivalentes en distintas divisas.

## 💡 Descripción

La aplicación permite:
- Ingresar un tipo de moneda base (por ejemplo, USD, ARS, BRL, etc.)
- Ingresar un monto en dicha moneda
- Obtener una conversión de dicho monto a otras monedas, usando datos en tiempo real desde la API de [ExchangeRate-API](https://www.exchangerate-api.com/)

## 🛠️ Tecnologías y Librerías

- **Java 17+**
- **Gson**: para la deserialización del JSON de respuesta de la API
- **ExchangeRate-API**: servicio externo utilizado para obtener los tipos de cambio actualizados

## 📦 Estructura del Proyecto
/src
├── Calculos/
│ └── Calcular.java
├── HTTP_Models/
│ ├── Cliente.java
│ ├── Respuesta.java
│ └── Usuario.java
├── Modelos/
│ ├── Conversor.java
│ └── Modelado.java
├── Main.java

## 🚀 Cómo ejecutar

1. **Clona el repositorio o descarga los archivos fuente.**

2. **Agrega tu clave API:**
   - Abre la clase `Usuario.java`.
   - Modifica el método `getClave()` para que retorne tu clave de [ExchangeRate-API](https://www.exchangerate-api.com/).

3. **Ejecuta el programa:**
   Puedes compilar y ejecutar desde terminal con:

   ```bash
   javac Main.java
   java Main
## EJEMPLO DE USO
  ############################### INICIA PROGRAMA ###############################
##     Escrribla el tipo de moneda que quiere  convertir:
## USD.
...
## Para finalizar escriba: salir.
 #############################################################################

## Ingrese el monto de la moneda que quiere comparar:
100

****************Espere mientras se procesa el calculo******************

#
## Los Calculos del monto 100.0 actual en: USD son: 
  ## En BRL=570.62 Reales
  ## En ARS=113700.0 Pesos argentinos
  ## En COP=418826.75 Pesos colombianos
  ## En USD=100.0 Dolares
  ## En BOB=693.24 Pesos bolivianos
  ## En CLP=94311.26000000001 Pesos chilenos 


👤 Autor
Desarrollado por [Brian E. Maciel]
