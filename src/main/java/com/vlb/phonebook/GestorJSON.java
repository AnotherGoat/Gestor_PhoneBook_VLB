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
        ////

        JSONArray agenda = new JSONArray();

        for(Contacto c: test.getContactos()){
            JSONArray contacto = new JSONArray();

            if(c.getNombre() != null){
                // Crea un objeto con el nombre
                JSONObject nombre = new JSONObject();
                nombre.put("nombre", c.getNombre());

                // Añade el nombre al JSONArray del contacto
                contacto.put(nombre);
            }

            if(c.getTelefonos().size() != 0){
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

            if(c.getDireccion() != null){
                JSONObject direccion = new JSONObject();
                direccion.put("ciudad", c.getDireccion().getCiudad());
                direccion.put("calle", c.getDireccion().getCalle());
                direccion.put("numero", c.getDireccion().getNumero());

                // Añade la dirección
                contacto.put(direccion);
            }

            if(c.getEmails().size() != 0){
                JSONArray listaEmails = new JSONArray();
                for(String e: c.getEmails()){
                    JSONObject email = new JSONObject();
                    email.put("email", e);

                    // Añade el e-mail a la lista
                    listaEmails.put(email);
                }

                // Añade la  lista de e-mails al contacto
                contacto.put(listaEmails);
            }

            if(c.getApodos().size() != 0){
                JSONArray listaApodos = new JSONArray();
                for(String a: c.getApodos()){
                    JSONObject apodo = new JSONObject();
                    apodo.put("apodo", a);

                    // Añade el apodo a la lista
                    listaApodos.put(apodo);
                }

                // Añade la  lista de apodos al contacto
                contacto.put(listaApodos);
            }

            if(c.getFechaCumple() != null){
                JSONObject fechacumple = new JSONObject();
                fechacumple.put("dia", c.getFechaCumple().getDia());
                fechacumple.put("numeroMes", c.getFechaCumple().getNumeroMes());
                fechacumple.put("mes", c.getFechaCumple().getMes());

                // Añade el mes
                contacto.put(fechacumple);
            }

            if(c.getNotas().size() != 0){
                JSONArray listaNotas = new JSONArray();
                for(String n: c.getNotas()){
                    JSONObject nota = new JSONObject();
                    nota.put("nota", n);

                    // Añade la nota a la lista
                    listaNotas.put(nota);
                }

                // Añade la  lista de notas al contacto
                contacto.put(listaNotas);
            }

            // Añade el contacto a la agenda
            agenda.put(contacto);
        }

        System.out.println(agenda);

    }
}
