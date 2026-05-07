package Binario;
import java.io.Serializable;

public class Pokemon implements Serializable {

    private String nombre;
    private transient String tipo;
    private int nivel;
    private int ps;

    public Pokemon(String nombre, String tipo, int nivel, int ps){

        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.ps = ps;
    }

    public Pokemon() {

        this(null, null, 0, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPs() {
        return ps;
    }

    @Override
    public String toString() {

        return "[Nombre = " + nombre + ", tipo = " + tipo + ", nivel = " + nivel + ", ps = " + ps + "]";
    }
}
