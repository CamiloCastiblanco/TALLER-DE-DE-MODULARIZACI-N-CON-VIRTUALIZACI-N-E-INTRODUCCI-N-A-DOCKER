# TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER
En este taller profundizamos los conceptos de modulación por medio de virtualización usando Docker y AWS.

### Pre requisitos
- El estudiante conoce Java, Maven
- El estudiante sabe desarrollar aplicaciones web en Java
- Tiene instalado Docker es su máquina

## DESCRIPCIÓN
El taller consiste en crear una aplicación web pequeña usando el micro-framework de Spark java (http://sparkjava.com/). Una vez tengamos esta aplicación procederemos a construir un container para docker para la aplicación y los desplegaremos y configuraremos en nuestra máquina local. Luego, cerremos un repositorio en DockerHub y subiremos la imagen al repositorio. Finalmente, crearemos una máquina virtual de en AWS, instalaremos Docker , y desplegaremos el contenedor que acabamos de crear.

### Primera parte crear la aplicación web
- Cree un proyecto java usando maven.
- Cree la clase principal
```
public class SparkWebServer {
    
    public static void main(String... args){
          port(getPort());
          get("hello", (req,res) -> "Hello Docker!");
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
```
- Importe las dependencias de spark Java en el archivo pom
- Asegúrese que el proyecto esté compilando hacia la versión 17 de Java
- Asegúrese que el proyecto este copiando las dependencias en el directorio target al compilar el proyecto. Esto es necesario para poder construir una imagen de contenedor de docker usando los archivos ya compilados de java. Para hacer esto use el purgan de dependencias de Maven.
### Para la ejecución de este repositorio:
- Primero
```git
git clone https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER.git
```
- Ubicarse en la carpeta Modularizacion_Virtualizacion y borraremos todas las dependencias y modulos que puedan exisitir de los binarios del proyecto.
```maven
mvn clean install
```
- Realizamos la compilación y empaquetamiento del proyecto
```maven
mvn package -U
```
- Ejecutamos el proyecto
  
```maven
java -cp target/Modularizacion_Virtualizacion-1.0-SNAPSHOT.jar co.edu.escuelaing.arep.SparkWebServer
```

### Evidencia 

![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/b406dd47-6e8f-4ca0-b460-1892675323f7)

### Ejecuta la maquina virtual:

![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/4d488f4c-de94-409c-b291-fab371902a40)

### docker build

![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/43dd98eb-1e6b-4219-b8f7-1835c88884a5)

### docker tag, docker images y docker push

![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/eacc11ca-d05c-4c35-b8db-4fcd558754d6)

## Tarea 

Modifique su proyecto publicando servicios REST para calcular:

- Sin

- Cos

- Determinar si una cadena es un palíndromo

- Retorna la magnitud de un vector real de dos dimensiones, es decir recibe dos parámetros reales.

Modifique el Cliente para que se puedan llamar asíncronamente estas funciones, por ejemplo con una formulario para cada función.

### Servicios: 

![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/eb3c73f7-a91a-4c46-b7f5-62166058fdd2)

### Funcionamientos:

- Seno:
  
![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/de5bf036-461c-49ce-b2fa-a2605719377a)

- Coseno:

![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/b85b2497-fa48-4fcd-8845-dc0e0cbbb9ff)

- Palindromo:

![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/810e81f2-b77d-44a3-beaa-a25b4ab6e39c)

- Magnitud de un vector:

![image](https://github.com/CamiloCastiblanco/TALLER-DE-DE-MODULARIZACI-N-CON-VIRTUALIZACI-N-E-INTRODUCCI-N-A-DOCKER/assets/69698380/3a449350-fade-4c2d-9c06-01790be2f2ae)

Imagen en DockerHub:

https://hub.docker.com/repository/docker/camilocastib22/taller_de_modularizacion_spark_docker/general

- Para ver su funcionamiento debe seguir los siguientes pasos:

```
docker pull camilocastib22/taller_de_modularizacion_spark_docker:latest
```
- Luego el siguiente comando
  
```
docker run -d -p 36000:6000 camilocastib22/taller_de_modularizacion_spark_docker:latest
```
- Ya solo queda revisar cada uno de los servicios:
  
```
http://localhost:36000/hello
```
Y allí están cada uno de los servicios.








