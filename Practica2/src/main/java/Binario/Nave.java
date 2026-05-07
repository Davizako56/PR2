package Binario;
import java.io.Serializable;

public class Nave implements Serializable {

    private String nombre;
    private transient double peso;
    private double velocidad;

    public Nave(String nombre, double peso, double velocidad) {

        this.nombre = nombre;
        this.peso = peso;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public double getVelocidad() {
        return velocidad;
    }

    @Override
    public String toString() {

        return "[Nombre = " + nombre + ", peso = " + peso + ", velocidad = " + velocidad + "]";
    }
}
