package Binario;

import java.util.ArrayList;
import java.util.List;

public class Pais {

    private String nombre;
    private String continente;
    private int habitantes;
    private ArrayList<String> idiomas;

    public Pais(String nombre, String continente, int habitantes, List<String> idiomas) {

        this.nombre = nombre;
        this.continente = continente;
        this.habitantes = habitantes;
        this.idiomas = new ArrayList<>(idiomas);
    }

    public Pais() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<String> idiomas) {
        this.idiomas = idiomas;
    }

    @Override

    public String toString() {

        return "[Nombre = " + nombre + ", continente = " + continente + ", habitantes = " + habitantes + ", idiomas = " + idiomas + "]";
    }
}
