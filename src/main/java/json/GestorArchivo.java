package json;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class GestorArchivo {

    public void crearDirectorio(){
        Scanner teclado = new Scanner(System.in);
        System.out.println();
        String ruta = teclado.nextLine();
        Path directorio = Paths.get(ruta);
        if(Files.exists(directorio)){
            System.out.println("El directorio ya existe");

        }else{
            try{
                Files.createDirectories(directorio);
            }catch(IOException e){
                System.out.println("el directorio no pudo ser creado");
            }
        }

    }

    public void crearArchivo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta completa del archivo");
        String ruta = teclado.nextLine();
        Path archivo = Paths.get(ruta);
        System.out.println("Ingrese el texto a guardar en el archivo");
        String texto = teclado.nextLine();
        try{
            Files.write(archivo,texto.getBytes());
            System.out.println("se ha guardado el archivo");
        }catch(IOException e){
            System.out.println("El archivo no puede ser guardado");
        }
    }

    public void crearArchivo(String texto, String ruta){
        Path archivo = Paths.get(ruta);
        try{
            Files.write(archivo,texto.getBytes());
            System.out.println("El archivo JSON se ha guardado en "+ruta);
        }catch(IOException e){
            System.out.println("El archivo no puede ser guardado.");
        }

    }

    /**
     * Método que retorna un String con el contenido de un archivo de texto, o retorna un String vacío si no existe
     * @param ruta Ruta del archivo a leer
     * @return String con el texto del archivo
     */
    public String convertirArchivoAString(String ruta){
        Path archivo = Paths.get(ruta);

        String texto="";
        try{
            texto = new String(Files.readAllBytes(archivo));
        }catch(IOException e){
            System.out.println("El archivo no pudo ser leído");
        }

        return texto;
    }

    /**
     * Método que retorna un JSONArray construido con un archivo JSON, o retorna un JSONArray nuevo si no existe
     * @param ruta Ruta del archivo JSON
     * @return JSONArray creado con el texto del archivo JSON
     */
    public JSONArray convertirArchivoAJSONArray(String ruta){
        Path archivo = Paths.get(ruta);
        String texto="";

        try{
            texto = new String(Files.readAllBytes(archivo));
        }catch(IOException e){
            System.out.println("El archivo no pudo ser leído");
        }

        return new JSONArray(texto);
    }

    /**
     * Copia el archivo desde la ruta especificada a su destino, y lo sobreescribe si es que ya existe
     * @param ruta Ruta del archivo original
     * @param destino Destino al que se quiere copiar el archivo
     */
    public void copiarArchivo(String ruta, String destino){
        // Inicia los Paths al archivo original y al archivo nuevo
        Path archivoOriginal = Paths.get(ruta);
        Path archivoNuevo = Paths.get(destino);

        try{
            // Copia el archivo
            Files.copy(archivoOriginal, archivoNuevo, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("El archivo fue copiado exitosamente");
        }catch(IOException e){
            System.out.println("El archivo no pudo ser copiado");
        }
    }

    /**
     * Elimina el archivo de la ruta especificada, siempre que no ocurra alguna excepción
     * @param ruta Ruta del archivo que se quiere borrar
     */
    public void eliminarArchivo(String ruta){
        Path archivo = Paths.get(ruta);

        try{
            Files.deleteIfExists(archivo);
            System.out.println("El archivo fue eliminado exitosamente ");
        }catch (IOException e){
            System.out.println("El archivo no pudo ser eliminado");
        }
    }
}
