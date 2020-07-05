package com.vlb.phonebook;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GestorJSON {

    //// Atributos
    static Agenda test = Principal.agenda;
    static GestorArchivo ga = new GestorArchivo();

    //// Métodos
    public static void guardarJSON(){

        JSONArray agenda = new JSONArray();

        for(Contacto c: test.getContactos()){
            JSONObject contacto = new JSONObject(); // Par ordenado "contacto":datosContacto
            JSONObject datosContacto = new JSONObject();

            //// NOMBRE
            // Añade el nombre al JSONArray del contacto
            datosContacto.put("nombre", c.getNombre());

            //// TELEFONO
            if(c.getTelefonos().size() != 0) {
                JSONObject listaTelefonos = new JSONObject();

                // Procesa todos los teléfonos y
                for (Telefono t : c.getTelefonos()) {
                    JSONObject datosTelefono = new JSONObject(); // Pares ordenados que representan un telefono ("numero", "") ("tipo", "")

                    // Guarda el número y tipo en un JSONObject
                    datosTelefono.put("numero", t.getNumero());
                    datosTelefono.put("tipo", t.getTipo());

                    // Añade los pares ordenados a la lista de teléfonos
                    listaTelefonos.put("telefono", datosTelefono);
                }

                // Añade el par ordenado a
                datosContacto.put("telefonos", listaTelefonos);
            }

            if(c.getDireccion() != null){
                JSONObject datosDireccion = new JSONObject(); // Objeto con los datos de la dirección

                datosDireccion.put("ciudad", c.getDireccion().getCiudad());
                datosDireccion.put("calle", c.getDireccion().getCalle());
                datosDireccion.put("numero", c.getDireccion().getNumero());

                // Añade la dirección
                datosContacto.put("direccion", datosDireccion);
            }

            if(c.getEmails().size() != 0){
                // Crea la lista de emails usando el ArrayList
                JSONArray listaEmails = new JSONArray(c.getEmails());

                // Añade la  lista de emails al contacto
                datosContacto.put("emails", listaEmails);
            }

            if(c.getApodos().size() != 0){
                // Crea la lista de apodos usando el ArrayList
                JSONArray listaApodos = new JSONArray(c.getApodos());

                // Añade la  lista de apodos al contacto
                datosContacto.put("apodos", listaApodos);
            }

            if(c.getFechaCumple() != null){
                JSONObject datosFechaCumple = new JSONObject();
                datosFechaCumple.put("dia", c.getFechaCumple().getDia());
                datosFechaCumple.put("numeroMes", c.getFechaCumple().getNumeroMes());
                datosFechaCumple.put("mes", c.getFechaCumple().getMes());

                // Añade el mes
                datosContacto.put("fechacumple", datosFechaCumple);
            }

            if(c.getNotas().size() != 0){
                // Crea la lista de notas usando el ArrayList
                JSONArray listaNotas = new JSONArray(c.getNotas());

                // Añade la  lista de notas al contacto
                datosContacto.put("notas", listaNotas);
            }

            contacto.put("contacto", datosContacto);

            // Añade el contacto a la agenda
            agenda.put(contacto);
        }

        // Muestra el JSON
        System.out.println(agenda.toString(8));

        // Guarda el JSON en un archivo "agenda.json"
        ga.crearArchivo(agenda.toString(8), "agenda.json");
    }

    /**
     * Método que carga un el archivo agenda.json (si este existe), y carga sus datos en en JSONArray Principal.agendaJSON
     */
    public static void cargarJSON(){
        // Si el archivo "agenda.json" existe, cargarlo
        if (Files.exists(Paths.get("agenda.json"))) {
            // Carga los datos de "agenda.json" al JSONArray agendaJSON
            Principal.agendaJSON = ga.convertirArchivoAJSONArray("agenda.json");

            System.out.println("Datos de \"agenda.json\" cargados");

            // Muestra el JSON en pantalla, para verificar que funcionó bien
            System.out.println(Principal.agendaJSON.toString());
        }
    }
}
