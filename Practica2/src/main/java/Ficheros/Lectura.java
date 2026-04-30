package Ficheros;
import java.io.*;
import java.util.Scanner;

public class Lectura {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/main/java/prueba.txt"));

            String linea;

            while((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            lector.close();
            System.out.println();

            System.out.println("Que palabra quieres contar en este fichero?");
            String palabra = entrada.next();

            System.out.println("Apariciones de " + palabra + ": " + actividad6(palabra));
            System.out.println();

            Scanner leer = new Scanner(new File("src/main/java/prueba.txt"));

            while(leer.hasNextLine()) {
                linea = leer.nextLine();
                System.out.println(linea);
            }

            leer.close();

        }catch(IOException e) {
            throw new RuntimeException();
        }
    }

    public static int actividad6(String palabra) throws FileNotFoundException {

        int contador = 0;

        try {
            BufferedReader lector = new BufferedReader(new FileReader("src/main/java/prueba.txt"));

            String linea;

            while((linea = lector.readLine()) != null) {

                String hola = linea.replace(".", "");
                String qtal = hola.replace(",", "");

                String[] vector = qtal.split(" ");

                for(String s : vector) {

                    if(s.equalsIgnoreCase(palabra)) {
                        contador++;
                    }
                }
            }

            lector.close();

        }catch(IOException e) {
            throw new RuntimeException();
        }

        return contador;
    }
}
