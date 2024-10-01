package com.accesodatos.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase general para cargar archivos de nombres y apellidos 
 * y generar aleatoriamente listas de personas.
 */
public class Personas {
    private List<String> listaNombresHombre;
    private List<String> listaNombresMujer;
    private List<String> listaApellidos;
    private Sexo[] sexos;
    private List<Personas> personas;

    public Personas(){
        this.sexos = Sexo.values();
    }

    /**
     * Configuración inicial para indicar dónde están 
     * los archivos que contienen os nombres y apellidos.
     * Un nombre o apellido po línea del fichero.
     * @param archivoNombreMujer El nombre del archivo con los nombres de mujer.
     * @param archivoNombreHombre El nombre del archivo con los nombres de hombre.
     * @param archivoApellido El nombre del archivo con los apellidos.
     */
    public void loadData( 
        String archivoNombreMujer, 
        String archivoNombreHombre, 
        String archivoApellido) {

            try{
                this.listaApellidos = 
                    Files.readAllLines(Paths.get(archivoApellido));
                this.listaNombresHombre = 
                    Files.readAllLines(Paths.get(archivoNombreHombre));
                this.listaNombresMujer = 
                    Files.readAllLines(Paths.get(archivoNombreMujer));
            } catch (IOException ioe){
                System.err.println("Error carga de datos");
                System.err.println(ioe.getLocalizedMessage());
            }
    }

    /**
     * Devuelve un elemento aleatorio de la lista de String
     * que se le pasa como párametro.
     * @param lista una lista de cadena de caracteres.
     * @return un String
     */
    private String getRandomString(List<String> lista){
        return lista.get(generarNumeroRandom(lista.size()));
    }

    /**
     * Genera un número aleatorio entre 0 y max-1
     * @param max el número maximo (excluido)
     * @return un aleatorio 0..max-1
     */
    public static int generarNumeroRandom(int max){
        Random random = new Random();
        return random.nextInt(max);
    }

    /**
     * Generador de sexo random.
     * @return un sexo aleatorio
     */
    private Sexo getRandomSexo(){
        Sexo s = sexos[generarNumeroRandom(sexos.length)];
        return s;
    }

    /*
         * El correo es la primera letra del nombre, 
         * primer apellido sin espacios, 
         * segundo apellido sin espacios, 
         * todo minúscula y quetiamos acentos, letra ñ y letra ç
         */

    private String getEmail(Persona p){
        String email = "@educaand.es";

        return email;
    }

    /**
     * Nos devuelve una persona generada aleatoriamente
     * @return un objeto d tipo persona.
     */

    private Persona getRandomPersona(){
        Persona p = new Persona();

        p.setSexo(getRandomSexo());
        p.setApellido(getRandomString(listaApellidos));
        switch (p.getSexo()) {
            case HOMBRE:
                p.setNombre(getRandomString(listaNombresHombre));
                break;
            case MUJER:
                p.setNombre(getRandomString(listaNombresMujer));
                break;
            default:
                p.setNombre(generarNumeroRandom(2)== 0 ?
                    getRandomString(listaNombresHombre):
                    getRandomString(listaNombresMujer)
                    );
                break;
        }
        p.setEmail(getEmail(p));
        
        return p;
    }

    /**
     * Genera tantas personas como se indica
     * @param numero persoans a generar
     * @return 
     */

    public void generaPersonas(int numero) throws Exception{
        //List<Persona> lista = new ArrayList<Persona>();
        if (this.listaApellidos==null||
        this.listaNombresHombre==null||
        this.listaNombresMujer==null) {

            //System.err.println("Error, no se han cargado los achvos
            // con los nombres y apelidos previamente.");

            throw new Exception("Error, no se han cargado los " + 
            "achvos con los nombres y apelidos previamente.");
        }else{
            for(int i = 0; i < numero; i++){
                this.personas.add(getRandomPersona());
            }
        }
    }

    private LocalDate generaFecha(){
        long startingDate = LocalDate.of(1920, 1, 1).toEpochDay();
        long endingDate = LocalDate.now().toEpochDay();
        
        

        return null;
    }
}
