package com.accesodatos.primeraversion;

import com.accesodatos.modelo.Personas;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Personas gp = new Personas();
        gp.loadData(
            "datos\\nombres-mujeres.txt",
           "datos\\nombres-hombres.txt",
               "datos\\apellidos.txt"
        );
        try {
            gp.generaPersonas(100);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
