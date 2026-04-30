package Ficheros;

import java.io.*;

public class Escritor {

    public static void main(String[] args) throws IOException {

        //BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/java/Escritores.txt"));

        //escritor.write("Hola que tal");
        //escritor.newLine();
        //escritor.write("en un lugar de la Mancha");

        //escritor.close();
        mayus();
    }

    public static void mayus() throws IOException {

        BufferedReader lector = new BufferedReader(new FileReader("src/main/java/prueba.txt"));
        BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/java/pruebaTemp.txt"));

        String linea;

        while((linea = lector.readLine()) != null) {

            String[] vector = linea.split(" ");

            for(String s : vector) {

                escritor.write(s.substring(0,1).toUpperCase() + s.substring(1));
            }

            escritor.newLine();

            System.out.println(linea);
        }

        lector.close();
        escritor.close();
    }
}
