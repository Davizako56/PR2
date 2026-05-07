package Binario;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.FileOutputStream;

public class Binarios {

    public static void main(String[] args) throws IOException {

        DataOutputStream binario = new DataOutputStream(new FileOutputStream("fichero_binario.bin"));

        binario.writeBoolean(true);
        binario.writeChar('x');
        binario.writeInt(11);
        binario.writeUTF("holaaaaa");

        binario.close();
    }
}
