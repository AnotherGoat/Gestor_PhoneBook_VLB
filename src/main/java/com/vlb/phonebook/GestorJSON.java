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
                JSONArray listaTelefonos = new JSONArray();

                // Procesa todos los teléfonos y
                for (Telefono t : c.getTelefonos()) {
                    JSONObject datosTelefono = new JSONObject(); // Pares ordenados que representan un telefono ("numero", "") ("tipo", "")

                    // Guarda el número y tipo en un JSONObject
                    datosTelefono.put("numero", t.getNumero());
                    datosTelefono.put("tipo", t.getTipo());

                    // Añade los pares ordenados a la lista de teléfonos
                    listaTelefonos.put(datosTelefono);
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

            if(c.getFechaCumple() != null){
                JSONObject datosFechaCumple = new JSONObject();
                datosFechaCumple.put("dia", c.getFechaCumple().getDia());
                datosFechaCumple.put("numeroMes", c.getFechaCumple().getNumeroMes());
                datosFechaCumple.put("mes", c.getFechaCumple().getMes());

                // Añade el mes
                datosContacto.put("fechacumple", datosFechaCumple);
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
        System.out.println(agenda.toString(6));

        // Guarda el JSON en un archivo "agenda.json"
        ga.crearArchivo(agenda.toString(6), "agenda.json");
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
            // System.out.println(Principal.agendaJSON.toString());

            // Para cada contacto
            for(int i=0; i<Principal.agendaJSON.length(); i++){
                JSONObject contacto = Principal.agendaJSON.getJSONObject(i).getJSONObject("contacto");

                // El contacto solo se puede crear si se tiene un nombre guardado
                if(contacto.has("nombre")) {
                    // Crea un contacto nuevo con el nombre del key
                    Contacto contactoNuevo = new Contacto(contacto.getString("nombre"));

                    // Si tiene telefonos guardados
                    if(contacto.has("telefonos")) {
                        // Nombramos la lista de telefonos
                        JSONArray listaTelefonos = contacto.getJSONArray("telefonos");

                        // Para cada telefono dentro de la lista
                        for (int j = 0; j < listaTelefonos.length(); j++) {
                            // Obtiene el JSONObject que representa un telefono
                            JSONObject telefono = listaTelefonos.getJSONObject(j);

                            // Crea un objeto de tipo Telefono con el numero y el tipo del JSON
                            Telefono telefonoNuevo = new Telefono(telefono.getInt("numero"), telefono.getString("tipo"));

                            // Añade el Telefono nuevo al contacto nuevo
                            contactoNuevo.getTelefonos().add(telefonoNuevo);
                        }
                    }

                    if(contacto.has("direccion")){
                        // Nombramos al JSONObject que contiene la dirección
                        JSONObject direccion = contacto.getJSONObject("direccion");

                        // Crea una dirección nueva con los datos del JSON
                        Direccion direccionNueva = new Direccion(direccion.getString("ciudad"), direccion.getString("calle"), direccion.getInt("numero"));

                        // Cambia la dirección del contacto nuevo
                        contactoNuevo.setDireccion(direccionNueva);
                    }

                    if(contacto.has("fechacumple")){
                        // Nombramos la fecha de cumpleaños
                        JSONObject fechaCumple = contacto.getJSONObject("fechacumple");

                        // Crea una fecha de cumpleaños nueva con los datos del JSON
                        FechaCumple fechaCumpleNueva = new FechaCumple(fechaCumple.getInt("dia"), fechaCumple.getInt("numeroMes"));

                        // Añade la fecha de cumpleaños
                        contactoNuevo.setFechaCumple(fechaCumpleNueva);
                    }

                    if(contacto.has("emails")){
                        // Nombramos al JSONArray que contiene los correos
                        JSONArray listaEmails = contacto.getJSONArray("emails");

                        // Para cada email dentro de la lista
                        for(int j=0; j<listaEmails.length(); j++){
                            contactoNuevo.getEmails().add(listaEmails.getString(j));
                        }
                    }

                    if(contacto.has("apodos")){
                        // Nombramos al JSONArray que contiene los apodos
                        JSONArray listaApodos = contacto.getJSONArray("apodos");

                        // Para cada apodo dentro de la lista
                        for(int j=0; j<listaApodos.length(); j++){
                            contactoNuevo.getApodos().add(listaApodos.getString(j));
                        }
                    }

                    if(contacto.has("notas")){
                        // Nombramos al JSONArray que contiene las notas
                        JSONArray listaNotas = contacto.getJSONArray("notas");

                        // Para cada nota dentro de la lista
                        for(int j=0; j<listaNotas.length(); j++){
                            contactoNuevo.getNotas().add(listaNotas.getString(j));
                        }
                    }

                    // Añade el contacto a la agenda
                    Principal.agenda.getContactos().add(contactoNuevo);
                }

                else{
                    System.out.println("Error: Contacto en el JSON no tiene nombre registrado");
                }
            }

            // Actualiza la lista de nombres
            Principal.agenda.actualizarListaNombres();
        }
    }
}
