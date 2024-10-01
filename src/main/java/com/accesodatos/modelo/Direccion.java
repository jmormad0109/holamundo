package com.accesodatos.modelo;
import java.util.Objects;

public class Direccion {
    private long id;
    private String nombreVia;
    private TipoVia tipoVia;
    private int numero;
    private String detalle;

/* 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)       
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }*/
    
}
