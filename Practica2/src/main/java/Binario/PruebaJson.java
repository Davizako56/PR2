package Binario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PruebaJson {

    public static void main(String[] args) throws IOException{

        Gson json = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<Pais> listaPaises = new ArrayList<>(Arrays.asList(

                new Pais("Nueva Zelanda","Oceanía",1500000, Arrays.asList("Nuevozelandés","Inglés","Español")),
                new Pais("Mongolia","Asia",3550000, Arrays.asList("Mongol","Inglés","Español"))

        ));

        Pais españa = new Pais("España", "Europa", 50000000, Arrays.asList("Vasco","Catalán","Castellano","Valenciano","Marroquí"));

        System.out.println(españa);

        String pais_json = json.toJson(españa);
        System.out.println(pais_json);

        FileWriter escribir_esp = new FileWriter("src/main/java/españa.json");

        json.toJson(españa,escribir_esp);

        escribir_esp.close();

        FileReader leer = new FileReader("src/main/java/españa.json");
        Pais pais = json.fromJson(leer,Pais.class);
        leer.close();
        System.out.println(pais.getNombre());

        FileReader leer_lista = new FileReader("src/main/java/paises.json");
        Pais paises[] = json.fromJson(leer_lista,Pais[].class);
        ArrayList<Pais> lista = new ArrayList<>(Arrays.asList(paises));
        leer_lista.close();

        for(Pais paisito : lista) {
            System.out.println(paisito.getNombre());
        }
    }
}
