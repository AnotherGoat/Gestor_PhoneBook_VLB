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
        System.out.println("");
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

    public void copiarArchivo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo original");
        String ruta = teclado.nextLine();
        Path archivo =Paths.get(ruta);
        System.out.println("Ingrese la ruta de destino de la copia");
        String newRuta = teclado.nextLine();
        Path newArchivo = Paths.get(newRuta);
        try{
            Files.copy(archivo, newArchivo, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("El archivo fue copiado exitosamente");
        }catch(IOException e){
            System.out.println("El archivo no pudo ser copiado");
        }
    }

    public void eliminarArchivo(){
        Scanner teclado= new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo");
        String ruta =teclado.nextLine();
        Path archivo = Paths.get(ruta);
        try{
            Files.deleteIfExists(archivo);
            System.out.println("El archivo fue eliminado exitosamente ");
        }catch (IOException e){
            System.out.println("El archivo no pudo ser eliminado");
        }
    }
}
