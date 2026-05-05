package Ficheros;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Escritor {

    public static void main(String[] args) throws IOException {

        //BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/java/Escritores.txt"));

        //escritor.write("Hola que tal");
        //escritor.newLine();
        //escritor.write("en un lugar de la Mancha");

        //escritor.close();
        combinar();
    }

    public static void mayus() throws IOException {

        BufferedReader lector = new BufferedReader(new FileReader("src/main/java/prueba.txt"));
        BufferedWriter escritor = new BufferedWriter(new FileWriter("src/main/java/pruebaTemp.txt"));

        String linea;

        while((linea = lector.readLine()) != null) {

            String[] vector = linea.split(" ");

            for(String s : vector) {

                escritor.write(s.substring(0,1).toUpperCase() + s.substring(1) + " ");
            }

            escritor.newLine();

            System.out.println(linea);
        }

        lector.close();
        escritor.close();
    }

    public static void combinar() throws IOException{

        BufferedReader archivo1 = new BufferedReader(new FileReader("src/main/java/Archivo1.txt"));
        BufferedReader archivo2 = new BufferedReader(new FileReader("src/main/java/Archivo2.txt"));
        BufferedWriter resultado = new BufferedWriter(new FileWriter("src/main/java/Resultado.txt"));

        String linea;

        Queue<String> cola1 = new LinkedList<>();
        Queue<String> cola2 = new LinkedList<>();

        while((linea = archivo1.readLine()) != null) {

            String[] vector = linea.split(" ");

            for(String s : vector) {

                cola1.offer(s);
            }
        }

        while((linea = archivo2.readLine()) != null) {

            String[] vector = linea.split(" ");

            for(String s : vector) {

                cola2.offer(s);
            }
        }

        int cola;

        if(cola1.size() >= cola2.size()) {
            cola = cola1.size();
        }else{
            cola = cola2.size();
        }

        for(int i = 0; i < cola; i++) {

            if(!cola1.isEmpty()) {
                resultado.write(cola1.poll() + " ");
            }

            if(!cola2.isEmpty()) {
                resultado.write(cola2.poll() + " ");
            }
        }

        archivo1.close();
        archivo2.close();
        resultado.close();
    }
}
