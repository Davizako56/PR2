package Binario;
import java.io.*;

public class AppNasa{

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Nave artemis = new Nave("Artemis II",20000,1000);
        ObjectOutputStream nave = new ObjectOutputStream(new FileOutputStream("artemis_nulo.ser"));

        nave.writeObject(artemis);

        ObjectInputStream deserializo = new ObjectInputStream(new FileInputStream("artemis_nulo.ser"));
        Nave nave_sorpresa = (Nave) deserializo.readObject();

        System.out.println(nave_sorpresa.getNombre() + " " + nave_sorpresa.getPeso() + " " + nave_sorpresa.getVelocidad());

        nave.close();
    }
}
