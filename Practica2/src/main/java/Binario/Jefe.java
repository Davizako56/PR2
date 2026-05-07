package Binario;

public class Jefe extends Empleado{

    private String departamento;

    public Jefe(String nombre, double salario, String departamento) {

        super(nombre, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {

        return "[Nombre = " + getNombre() + ", salario = " + getSalario() + ", departamento = " + departamento + "]";
    }
}
