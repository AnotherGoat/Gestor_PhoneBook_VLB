package datos;

import interfaz_grafica.MensajeError;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class GestorArchivo {
    /**
     * Crea un directorio en la ruta específica, sólo si no existe
     * @param ruta Ruta deonde se va a crear el directorio
     */
    public void crearDirectorio(String ruta){
        Path directorio = Paths.get(ruta);

        if(Files.exists(directorio)){
        }

        else{
            try{
                Files.createDirectories(directorio);
            }catch(IOException e){
                new MensajeError("El directorio no pudo ser creado.");
            }
        }

    }

    /**
     * Crea un archivo vacío en la ruta especificada
     * @param ruta Ruta donde se va a crear el archivo
     */
    public void crearArchivo(String ruta){
        Path archivo = Paths.get(ruta);
        try{
            Files.write(archivo, "".getBytes());
        }catch(IOException e){
            new MensajeError("El archivo no pudo ser creado.");
        }
    }

    /**
     * Crea un archivo en la ruta especificada, y con el contenido ingresado
     * @param ruta Ruta donde se va a crear el archivo
     */
    public void crearArchivo(String ruta, String contenido){
        Path archivo = Paths.get(ruta);
        try{
            Files.write(archivo, contenido.getBytes());
        }catch(IOException e){
            new MensajeError("El archivo no pudo ser copiado.");
        }
    }

    /**
     * Método que retorna un String con el contenido de un archivo, o retorna un String vacío si no existe
     * @param ruta Ruta del archivo a leer
     * @return String con el contenido del archivo
     */
    public String leerArchivo(String ruta){
        Path archivo = Paths.get(ruta);
        String contenido="";

        try{
            contenido = new String(Files.readAllBytes(archivo));
        } catch(IOException e){
            new MensajeError("El archivo no pudo ser leído.");
        }

        return contenido;
    }

    /**
     * Mueve el archivo desde la ruta especificada a su destino (no hace nada si ya existe)
     * @param ruta Ruta del archivo original
     * @param destino Destino al que se quiere mover el archivo
     */
    public void moverArchivo(String ruta, String destino){
        // Inicia los Paths al archivo original y al archivo nuevo
        Path archivoOriginal = Paths.get(ruta);
        Path archivoNuevo = Paths.get(destino);

        try{
            // Mueve el archivo
            Files.move(archivoOriginal, archivoNuevo, StandardCopyOption.COPY_ATTRIBUTES);
        } catch(IOException e){
            new MensajeError("El archivo no pudo ser movido.");
        }
    }

    /**
     * Mueve el archivo desde la ruta especificada a su destino, y lo sobreescribe si es que ya existe
     * @param ruta Ruta del archivo original
     * @param destino Destino al que se quiere mover el archivo
     */
    public void moverArchivoYReemplazar(String ruta, String destino){
        // Inicia los Paths al archivo original y al archivo nuevo
        Path archivoOriginal = Paths.get(ruta);
        Path archivoNuevo = Paths.get(destino);

        try{
            // Mueve el archivo
            Files.move(archivoOriginal, archivoNuevo, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException e){
            new MensajeError("El archivo no pudo ser movido.");
        }
    }

    /**
     * Copia el archivo desde la ruta especificada a su destino (no hace nada si ya existe)
     * @param ruta Ruta del archivo original
     * @param destino Destino al que se quiere copiar el archivo
     */
    public void copiarArchivo(String ruta, String destino){
        // Inicia los Paths al archivo original y al archivo nuevo
        Path archivoOriginal = Paths.get(ruta);
        Path archivoNuevo = Paths.get(destino);

        try{
            // Copia el archivo
            Files.copy(archivoOriginal, archivoNuevo, StandardCopyOption.COPY_ATTRIBUTES);
        } catch(IOException e){
            new MensajeError("El archivo no pudo ser copiado.");
        }
    }

    /**
     * Copia el archivo desde la ruta especificada a su destino, y lo sobreescribe si es que ya existe
     * @param ruta Ruta del archivo original
     * @param destino Destino al que se quiere copiar el archivo
     */
    public void copiarArchivoYReemplazar(String ruta, String destino){
        // Inicia los Paths al archivo original y al archivo nuevo
        Path archivoOriginal = Paths.get(ruta);
        Path archivoNuevo = Paths.get(destino);

        try{
            // Copia el archivo
            Files.copy(archivoOriginal, archivoNuevo, StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException e){
            new MensajeError("El archivo no pudo ser copiado.");
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
        } catch (IOException e){
            new MensajeError("El archivo no pudo ser eliminado.");
        }
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
            new MensajeError("El archivo no pudo ser leído.");
        }

        return new JSONArray(texto);
    }
}
