package org.example.practica2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Datos {

    public static void main(String[] args) {

        Connection bd = conexion();
        consulta(bd);
    }

    public static Connection conexion() {
        Connection conexion;
        String host = "jdbc:mariadb://localhost:3310/";
        String user = "root";
        String psw = "";
        String bd = "instituto";
        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host + bd, user, psw);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void desconectar(Connection conexion) {

        System.out.println("Desconectando...");

        try {
            conexion.close();
            System.out.println("Conexión finalizada.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<Estudiante> consulta(Connection conexion) {

        ObservableList<Estudiante> listaEstudiantes = FXCollections.observableArrayList();

        String query = "SELECT * FROM estudiantes";

        //necesitamos dos variables de tipo Statement y ResultSet para realizar la consulta y guardar la respuesta
        Statement stmt;
        ResultSet respuesta;

        try {
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()) { //recorremos todas las filas existentes en la tabla y las imprimimos
                int nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                LocalDate fecha_nacimiento = respuesta.getDate("fecha_nacimiento").toLocalDate();
                //System.out.println("NIA: " + nia + " - Nombre: " + nombre + " - Fecha de nacimiento: " + fecha_nacimiento);
                listaEstudiantes.add(new Estudiante(nia, nombre, fecha_nacimiento));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return listaEstudiantes;
    }

    public static void insertar(Connection conexion, Estudiante estudiante){

        System.out.println("Insertando...");

        String query = "INSERT INTO estudiantes (nia, nombre, fecha_nacimiento) VALUES (" + estudiante.getNia() + ", '" + estudiante.getNombre() + "', '" + estudiante.getFecha_de_nacimiento() + "');";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }

    public static void eliminar(Connection conexion, Estudiante estudiante){

        System.out.println("Eliminando...");

        String query = "DELETE FROM estudiantes WHERE nia = '" + estudiante.getNia() + "'";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void modificar(Connection conexion, Estudiante estudiante){

        System.out.println("Modificando...");

        String query = "UPDATE estudiantes SET nia = '" + estudiante.getNia() + "', nombre = '" + estudiante.getNombre() + "', fecha_nacimiento = '" + estudiante.getFecha_de_nacimiento() + "' WHERE nia = '" + estudiante.getNia() + "'";

        Statement stmt;

        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void consulta_a_lista (Connection conexion){

        String query = "SELECT * FROM estudiantes";

        //necesitamos el dos variables de tipo Statement y ResultSet para realizar la consulta y guardar la respuesta
        Statement stmt;
        ResultSet respuesta;
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        try {
            stmt = conexion.createStatement();
            respuesta = stmt.executeQuery(query);

            while (respuesta.next()){ //recorremos todas las filas existentes en la tabla
                Integer nia = respuesta.getInt("nia");
                String nombre = respuesta.getString("nombre");
                Date fecha_nacimiento = respuesta.getDate("fecha_nacimiento");
                listaEstudiantes.add(new Estudiante(nia,nombre, fecha_nacimiento.toLocalDate()));
            }

            System.out.println(listaEstudiantes);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
