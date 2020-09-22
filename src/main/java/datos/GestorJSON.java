package datos;

import java.nio.file.Files;
import java.nio.file.Paths;

import lanzador.Principal;
import org.json.JSONArray;
import org.json.JSONObject;
import phonebook.*;
/*Relacion de Dependencia: Gestor JSON usa recursos de las clases GestorArchivo,Agenda,Principal es decir, depende de las funcionalidades de las otras clases
y no de forma inversa,es decir, las otras clases no necesitan de la clase GestorJson*/
public class GestorJSON {

    //// Atributos
    /**
     * Instancia del gestor de archivos
     */
    static GestorArchivo ga = new GestorArchivo();

    //// Métodos
    /**
     * Este método recibe los datos de la agenda principal y los guarda en un archivo
     * @param ruta Ruta donde se guardará el archivo
     */
    public static void guardarJSON(String ruta){

        // JSONArray que representa la agenda con la que se trabaja
        JSONArray agenda_json = new JSONArray();

        // Para cada contacto "c" dentro de la agenda principal
        for(Contacto c: Principal.agenda.getLista_Contactos()){

            // Crea un JSONObject que representa un contacto
            JSONObject contacto_json = new JSONObject();
            // Crea un JSONObject que representa los datos de un contacto
            JSONObject datosContacto_json = new JSONObject();

            //// Obtención de nombre (el cual debe existir sí o sí)

            // Añade el nombre al JSONObject con los datos del contacto
            datosContacto_json.put("nombre", c.getNombre());

            //// Obtención de teléfonos

            // Si el contacto "c" tiene al menos un telefono guardado...
            if(c.getLista_Telefonos().size() != 0) {

                // Crea un JSONArray que representa la lista de teléfonos de la agenda_principal
                JSONArray lista_telefonos_json = new JSONArray();

                // Para cada teléfono "t" dentro del contacto "c"
                for (Telefono t : c.getLista_Telefonos()) {

                    // Crea un JSONObject que representa los datos del teléfono
                    JSONObject datosTelefono_json = new JSONObject(); // Pares ordenados que representan un telefono ("numero", "") ("tipo", "")

                    // Guarda el número y tipo en el JSONObject
                    datosTelefono_json.put("numero", t.getNumero());
                    datosTelefono_json.put("tipo", t.getTipo());

                    // Añade los datos del teléfono a la lista de teléfonos
                    lista_telefonos_json.put(datosTelefono_json);
                }

                // Añade la lista de teléfonos a los datos del contacto
                datosContacto_json.put("telefonos", lista_telefonos_json);
            }

            // Si el contacto "c" tiene una dirección guardada...
            if(c.getDireccion() != null){

                // Crea un JSONObject que representa los datos de la dirección
                JSONObject datosDireccion_json = new JSONObject();

                // Añade los datos de la dirección al JSONObject
                datosDireccion_json.put("ciudad", c.getDireccion().getCiudad());
                datosDireccion_json.put("calle", c.getDireccion().getCalle());
                datosDireccion_json.put("numero", c.getDireccion().getNumero());

                // Añade la dirección a los datos del contacto
                datosContacto_json.put("direccion", datosDireccion_json);
            }

            // Si el contacto "c" tiene una fecha de cumpleaños guardada...
            if(c.getFechaCumple() != null){

                // Crea un JSONObject que representa los datos de la fecha de cumpleaños
                JSONObject datosFechaCumple_json = new JSONObject();

                // Añade los datos de la fecha de cumpleaños al JSONObject
                datosFechaCumple_json.put("dia", c.getFechaCumple().getDia());
                datosFechaCumple_json.put("mes", c.getFechaCumple().getMes());

                // Añade la fecha de cumpleaños a los datos del contacto
                datosContacto_json.put("fechacumple", datosFechaCumple_json);
            }

            // Si el contacto "c" tiene al menos un email guardado...
            if(c.getLista_Emails().size() != 0){

                // Crea un JSONArray que representa la lista de emails (directamente desde el ArrayList de "c")
                JSONArray lista_emails_json = new JSONArray(c.getLista_Emails());

                // Añade la  lista de emails al contacto
                datosContacto_json.put("emails", lista_emails_json);
            }

            // Si el contacto "c" tiene al menos un apodo guardado...
            if(c.getLista_Apodos().size() != 0){

                // Crea un JSONArray que representa la lista de apodos (directamente desde el ArrayList de "c")
                JSONArray lista_apodos_json = new JSONArray(c.getLista_Apodos());

                // Añade la  lista de apodos al contacto
                datosContacto_json.put("apodos", lista_apodos_json);
            }

            // Si el contacto "c" tiene al menos una nota guardada...
            if(c.getLista_Notas().size() != 0){

                // Crea un JSONArray que representa la lista de notas (directamente desde el ArrayList de "c")
                JSONArray lista_notas_json = new JSONArray(c.getLista_Notas());

                // Añade la  lista de notas al contacto
                datosContacto_json.put("notas", lista_notas_json);
            }

            // Si el contacto "c" tiene una ruta de foto guardada...
            if(c.getRutaFoto() != null && !c.getRutaFoto().equals("")){
                // Añade el nombre al JSONObject con los datos del contacto
                datosContacto_json.put("rutafoto", c.getRutaFoto());
            }

            // Añade los datos del contacto a un par ordenado
            contacto_json.put("contacto", datosContacto_json);

            // Añade el contacto a la agenda_json
            agenda_json.put(contacto_json);
        }

        // Después de repetir lo de arriba para cada contacto, se debe guardar el archivo...

        // Guarda el JSON en el archivo de destino, con indentación de 5 espacios
        ga.crearArchivo(ruta, agenda_json.toString(5));

        // ¡Listo!
    }

    /**
     * Método que carga un el archivo "agenda.json" (si este existe), y carga sus datos en en JSONArray agenda_json
     * @param ruta Ruta del archivo que se va a cargar
     */
    public static void cargarJSON(String ruta){

        // Si el archivo de la ruta indicada existe...
        if (Files.exists(Paths.get(ruta))) {

            // Carga los datos de la ruta al JSONArray agenda_json
            Principal.agenda_json = ga.convertirArchivoAJSONArray(ruta);

            // Para cada contacto dentro del JSONArray...
            for(int i=0; i<Principal.agenda_json.length(); i++){

                // Crea un JSONObject que representa a un contacto
                JSONObject contacto_json = Principal.agenda_json.getJSONObject(i).getJSONObject("contacto");

                // Verifica que el contacto tiene un nombre guardado
                if(contacto_json.has("nombre")) {

                    // Crea un contacto nuevo con el nombre del JSONArray
                    Contacto contactoNuevo = new Contacto(contacto_json.getString("nombre"));

                    // Si el JSON tiene teléfonos guardados...
                    if(contacto_json.has("telefonos")) {

                        // Crea un JSONArray que representa la lista de teléfonos
                        JSONArray lista_telefonos_json = contacto_json.getJSONArray("telefonos");

                        // Para cada teléfono dentro de la lista...
                        for (int j = 0; j < lista_telefonos_json.length(); j++) {

                            // Obtiene el JSONObject que representa un teléfono
                            JSONObject telefono_json = lista_telefonos_json.getJSONObject(j);

                            // Crea un objeto de tipo Telefono obteniendo los datos del JSON
                            Telefono telefonoNuevo = new Telefono(telefono_json.getInt("numero"), telefono_json.getString("tipo"));

                            // Añade el Telefono nuevo al contacto nuevo
                            contactoNuevo.getLista_Telefonos().add(telefonoNuevo);
                        }
                    }

                    // Si el JSON tiene una dirección guardada...
                    if(contacto_json.has("direccion")){

                        // Crea un JSONObject que representa la dirección
                        JSONObject direccion = contacto_json.getJSONObject("direccion");

                        // Crea una dirección nueva con los datos del JSON
                        Direccion direccionNueva = new Direccion(direccion.getString("ciudad"), direccion.getString("calle"), direccion.getInt("numero"));

                        // Añade la dirección al contacto nuevo
                        contactoNuevo.setDireccion(direccionNueva);
                    }

                    // Si el JSON tiene una fecha de cumpleaños guardada...
                    if(contacto_json.has("fechacumple")){

                        // Crea un JSONObject que representa la fecha de cumpleaños
                        JSONObject fechaCumple = contacto_json.getJSONObject("fechacumple");

                        // Crea una fecha de cumpleaños nueva con los datos del JSON
                        FechaCumple fechaCumpleNueva = new FechaCumple(fechaCumple.getInt("dia"), fechaCumple.getString("mes"));

                        // Añade la fecha de cumpleaños al contacto nuevo
                        contactoNuevo.setFechaCumple(fechaCumpleNueva);
                    }

                    // Si el JSON tiene emails guardados...
                    if(contacto_json.has("emails")){

                        // Crea un JSONArray que representa la lista de emails
                        JSONArray lista_emails_json = contacto_json.getJSONArray("emails");

                        // Para cada email dentro del JSONArray...
                        for(int j=0; j<lista_emails_json.length(); j++){
                            // Se añade el email al contacto nuevo
                            contactoNuevo.getLista_Emails().add(lista_emails_json.getString(j));
                        }
                    }

                    // Si el JSON tiene apodos guardados...
                    if(contacto_json.has("apodos")){

                        // Crea un JSONArray que representa la lista de apodos
                        JSONArray listaApodos = contacto_json.getJSONArray("apodos");

                        // Para cada apodo dentro del JSONArray...
                        for(int j=0; j<listaApodos.length(); j++){
                            // Se añade el apodo al contacto nuevo
                            contactoNuevo.getLista_Apodos().add(listaApodos.getString(j));
                        }
                    }

                    // Si el JSON tiene notas guardadas...
                    if(contacto_json.has("notas")){

                        // Crea un JSONArray que representa la lista de notas
                        JSONArray listaNotas = contacto_json.getJSONArray("notas");

                        // Para cada nota dentro del JSONArray...
                        for(int j=0; j<listaNotas.length(); j++){
                            // Se añade la nota al contacto nuevo
                            contactoNuevo.getLista_Notas().add(listaNotas.getString(j));
                        }
                    }

                    // Si el JSON tiene una ruta de foto establecida...
                    if(contacto_json.has("rutafoto")){
                        contactoNuevo.setRutaFoto(contacto_json.getString("rutafoto"));
                    }

                    // Añade el contacto a la agenda principal
                    Principal.agenda.getLista_Contactos().add(contactoNuevo);
                }

                // En caso de que el contacto del JSON no tenga un nombre...
                else{
                    // Muestra un mensaje de error
                    System.out.println("Error: Contacto en el JSON no tiene nombre guardado");
                }
            }

            // Muestra un mensaje de éxito
            System.out.println("Datos de \""+ruta+"\" cargados correctamente");

            // Cuando llega a esta sección, significa que la agenda principal cargó los datos correctamente

            // Para terminar, se ordenan alfabéticamente los contactos para la ejecución del programa
            Principal.agenda.ordenarContactos();
        }

        // Si el archivo de la ruta no existe, no hace nada
    }

    /**
     * Reinstancia la agenda principal y borra el archivo de la ruta indicada
     * @param ruta Ruta del archivo JSON que se va a borrar
     */
    public static void borrarJSON(String ruta){
        // Vuelve a instanciar la agenda en principal
        Principal.agenda_json = new JSONArray();
        // Borra el archivo
        ga.eliminarArchivo(ruta);
    }

    /**
     * Importa un archivo JSON externo al programa, y carga todos sus datos
     * @param ruta Ruta del archivo original
     * @param destino Ruta de destino
     */
    public static void importarJSON(String ruta, String destino){
        // Vuelve a instanciar la agenda_json en Principal
        Principal.agenda_json = new JSONArray();
        // Borra el archivo
        ga.eliminarArchivo(destino);
        // Copia el archivo
        ga.copiarArchivo(ruta, destino);
        // Vuelve a cargar el archivo JSON
        cargarJSON(destino);
    }

    /**
     * Exporta un archivo JSON con los datos actuales de la agenda a la ruta especificada
     * @param ruta Ruta del archivo original
     * @param destino Ruta de destino a donde se copiará el archivo
     */
    public static void exportarJSON(String ruta, String destino){
        // Copia el archivo usando el gestor de archivos
        ga.copiarArchivo(ruta, destino);
    }
}
