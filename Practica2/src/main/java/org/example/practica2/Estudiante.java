package org.example.practica2;
import java.time.LocalDate;

public class Estudiante {

    private Integer nia;
    private String nombre;
    private LocalDate fecha_de_nacimiento;

    public Estudiante(Integer nia, String nombre, LocalDate fecha_de_nacimiento) {

        this.nia = nia;
        this.nombre = nombre;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public Integer getNia() {
        return nia;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public void setNia(Integer nia) {
        this.nia = nia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_de_nacimiento(LocalDate fecha_de_nacimiento) {
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    @Override

    public String toString() {

        return "[NIA = " + nia  + ", nombre = " + nombre + ", fecha de nacimiento = " + fecha_de_nacimiento + "]";
    }
}
