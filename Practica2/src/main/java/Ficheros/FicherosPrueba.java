package Ficheros;
import java.io.File;

public class FicherosPrueba {

    public static void main(String[] args) {

        File fichero = new File("src/main/java/ejemplo1.txt");

        if(fichero.exists()) {
            System.out.println("El fichero + " + fichero.getName() + " existe.");
        }else{

        }

    }
}
