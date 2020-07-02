package com.vlb.phonebook;

import org.json.JSONArray;
import org.json.JSONObject;

public class GestorJSON {

    static Agenda test = new Agenda();

    //// Métodos
    public static void main(String[] args){

        ////
        Contacto ctest = new Contacto("Juan");
        ctest.getTelefonos().add(new Telefono(33333333, "Celular"));
        ctest.getTelefonos().add(new Telefono(123123, "Fijo"));
        ctest.setDireccion(new Direccion("Temuco", "Francisco Salazar", 111));
        test.getContactos().add(ctest);

        Contacto dtest = new Contacto("Diego");
        dtest.setDireccion(new Direccion("Pitrufquen", "Avenida 12 de Febrero", 1042));
        test.getContactos().add(dtest);
        ////

        JSONArray agendaJSON = new JSONArray();

        for(Contacto c: test.getContactos()){
            JSONArray contactoJSON = new JSONArray();

            // Si el nombre no es nulo, ponerlo en contactoJSON
            if(c.getNombre() != null){
                // Crea un objeto con el nombre
                JSONObject nombreJSON = new JSONObject();
                nombreJSON.put("nombre", c.getNombre());

                // Añade el nombre al JSONArray del contacto
                contactoJSON.put(nombreJSON);
            }

            // Si hay telefonos guardados
            if(c.getTelefonos().size() != 0){
                JSONArray telefonosJSON = new JSONArray();
                for(Telefono t: c.getTelefonos()) {
                    JSONObject numeroJSON = new JSONObject();

                    // Guarda el número y tipo en un JSONObject
                    numeroJSON.put("numero", t.getNumero());
                    numeroJSON.put("tipo", t.getTipo());

                    // Añade el teléfono al JSONArray
                    telefonosJSON.put(numeroJSON);
                }

                // Añade el arreglo con los teléfonos al contacto
                contactoJSON.put(telefonosJSON);
            }

            if(c.getDireccion() != null){
                JSONObject direccionJSON = new JSONObject();
                direccionJSON.put("ciudad", c.getDireccion().getCiudad());
                direccionJSON.put("calle", c.getDireccion().getCalle());
                direccionJSON.put("numero", c.getDireccion().getNumero());

                // Añade la dirección
                contactoJSON.put(direccionJSON);
            }

            // Añade el contacto a la agenda
            agendaJSON.put(contactoJSON);
        }

        System.out.println(agendaJSON);

    }

}
