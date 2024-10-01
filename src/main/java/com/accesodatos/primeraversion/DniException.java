package com.accesodatos.primeraversion;

public class DniException extends Exception {
    public DniException(String mensaje){
        super(mensaje);
    }

    public DniException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
}
