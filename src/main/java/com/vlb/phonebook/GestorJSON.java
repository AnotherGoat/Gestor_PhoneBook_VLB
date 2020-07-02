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
        ctest.getEmails().add("A@gmail.com");
        ctest.getEmails().add("B@hotmail.com");
        ctest.getEmails().add("C@ufromail.cl");
        ctest.getApodos().add("Juancho");
        ctest.getApodos().add("Flaco");
        ctest.setFechaCumple(new FechaCumple(12, 2));
        ctest.getNotas().add("Me cae bien");
        test.getContactos().add(ctest);

        Contacto dtest = new Contacto();
        test.getContactos().add(dtest);
        ////

        JSONArray agenda = new JSONArray();
        int contador = 0;

        for(Contacto c: test.getContactos()){
            contador++;
            agenda.put("Contacto #"+contador+":");

            JSONArray contacto = new JSONArray();

            if(c.getNombre() == null){
                contacto.put("null");
            }
            else{
                // Crea un objeto con el nombre
                JSONObject nombre = new JSONObject();
                nombre.put("nombre", c.getNombre());

                // Añade el nombre al JSONArray del contacto
                contacto.put(nombre);
            }

            contacto.put("listaTelefonos");
            if(c.getTelefonos().size() == 0){
                contacto.put("null");
            }
            else{
                JSONArray listaTelefonos = new JSONArray();
                for(Telefono t: c.getTelefonos()) {
                    JSONObject telefono = new JSONObject();

                    // Guarda el número y tipo en un JSONObject
                    telefono.put("numero", t.getNumero());
                    telefono.put("tipo", t.getTipo());

                    // Añade el teléfono a la lista de teléfonos
                    listaTelefonos.put(telefono);
                }

                // Añade el arreglo con los teléfonos al contacto
                contacto.put(listaTelefonos);
            }

            contacto.put("direccion");
            if(c.getDireccion() == null){
                contacto.put("null");
            }
            else{
                JSONObject direccion = new JSONObject();
                direccion.put("ciudad", c.getDireccion().getCiudad());
                direccion.put("calle", c.getDireccion().getCalle());
                direccion.put("numero", c.getDireccion().getNumero());

                // Añade la dirección
                contacto.put(direccion);
            }

            contacto.put("listaEmails:");
            if(c.getEmails().size() == 0){
                contacto.put("null");
            }
            else{
                // Crea la lista de e-mails usando el ArrayList
                JSONArray listaEmails = new JSONArray(c.getEmails());

                // Añade la  lista de e-mails al contacto
                contacto.put(listaEmails);
            }

            contacto.put("listaApodos:");
            if(c.getApodos().size() == 0){
                contacto.put("null");
            }
            else{
                // Crea la lista de apodos usando el ArrayList
                JSONArray listaApodos = new JSONArray(c.getApodos());

                // Añade la  lista de apodos al contacto
                contacto.put(listaApodos);
            }

            contacto.put("fechaCumple:");
            if(c.getFechaCumple() == null){
                contacto.put("null");
            }
            else{
                JSONObject fechacumple = new JSONObject();
                fechacumple.put("dia", c.getFechaCumple().getDia());
                fechacumple.put("numeroMes", c.getFechaCumple().getNumeroMes());
                fechacumple.put("mes", c.getFechaCumple().getMes());

                // Añade el mes
                contacto.put(fechacumple);
            }

            contacto.put("listaNotas:");
            if(c.getNotas().size() == 0){
                contacto.put("null");
            }
            else{
                // Crea la lista de notas usando el ArrayList
                JSONArray listaNotas = new JSONArray(c.getNotas());

                // Añade la  lista de notas al contacto
                contacto.put(listaNotas);
            }

            // Añade el contacto a la agenda
            agenda.put(contacto);
        }

        // Muestra el JSON
        System.out.println(agenda);
    }
}
