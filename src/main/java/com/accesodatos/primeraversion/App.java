package com.accesodatos.primeraversion;

import com.accesodatos.modelo.Personas;

public class App {
    public static void main(String[] args) {
        Personas gp = new Personas();
        gp.loadData(
                "datos\\nombres-mujeres.txt",
                "datos\\nombres-hombres.txt",
                "datos\\apellidos.txt"
        );
        try {
            System.out.println(gp.generaPersonas(10).toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}