package Binario;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Serializacion {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ejercicio5();
    }

    public static void ejercicio1y2y3() throws IOException, ClassNotFoundException{

        try {
            ArrayList<Pokemon> listaPokemon = new ArrayList<>();

            Pokemon squirtle = new Pokemon("Squirtle","Agua",15,35);
            Pokemon charmander = new Pokemon("Charmander","Fuego",6,20);
            Pokemon bulbasur = new Pokemon("Bulbasur","Planta",10,30);
            Pokemon pikachu = new Pokemon("Pikachu","Eléctrico",30,40);

            listaPokemon.add(squirtle);
            listaPokemon.add(charmander);
            listaPokemon.add(bulbasur);
            listaPokemon.add(pikachu);

            ObjectOutputStream pokemon = new ObjectOutputStream(new FileOutputStream("pokemons_nulo.ser"));

            pokemon.writeObject(listaPokemon);

            ObjectInputStream deserializar = new ObjectInputStream(new FileInputStream("pokemons_nulo.ser"));
            ArrayList<Pokemon> pokemon_sorpresa = (ArrayList<Pokemon>) deserializar.readObject();

            for(Pokemon p : pokemon_sorpresa) {

                System.out.println(p.getNombre()  + " " + p.getTipo() + " " + p.getNivel() + " " + p.getPs());
            }

            pokemon.close();
        }catch(FileNotFoundException e) {

            ArrayList<Pokemon> listaPokemon = new ArrayList<>();

            Pokemon squirtle = new Pokemon();
            Pokemon charmander = new Pokemon();
            Pokemon bulbasur = new Pokemon();
            Pokemon pikachu = new Pokemon();

            listaPokemon.add(squirtle);
            listaPokemon.add(charmander);
            listaPokemon.add(bulbasur);
            listaPokemon.add(pikachu);

            ObjectOutputStream pokemon = new ObjectOutputStream(new FileOutputStream("pokemons_defecto.ser"));

            pokemon.writeObject(listaPokemon);

            ObjectInputStream deserializar = new ObjectInputStream(new FileInputStream("pokemons_defecto.ser"));
            ArrayList<Pokemon> pokemon_sorpresa = (ArrayList<Pokemon>) deserializar.readObject();

            for(Pokemon p : pokemon_sorpresa) {

                System.out.println(p.getNombre()  + " " + p.getTipo() + " " + p.getNivel() + " " + p.getPs());
            }
        }
    }

    public static void ejercicio4() throws IOException, ClassNotFoundException{

        Map<String, Pokemon> mapaPokemons = new HashMap<>();

        Pokemon squirtle = new Pokemon("Squirtle","Agua",15,35);
        Pokemon charmander = new Pokemon("Charmander","Fuego",6,20);
        Pokemon bulbasur = new Pokemon("Bulbasur","Planta",10,30);
        Pokemon pikachu = new Pokemon("Pikachu","Eléctrico",30,40);

        mapaPokemons.put("pokemon1",squirtle);
        mapaPokemons.put("pokemon2",charmander);
        mapaPokemons.put("pokemon3",bulbasur);
        mapaPokemons.put("pokemon4",pikachu);

        ObjectOutputStream pokemon = new ObjectOutputStream(new FileOutputStream("mapa.ser"));

        pokemon.writeObject(mapaPokemons);

        ObjectInputStream deserializar = new ObjectInputStream(new FileInputStream("mapa.ser"));
        HashMap<String, Pokemon> mapa_sorpresa = (HashMap<String, Pokemon>) deserializar.readObject();

        for(Map.Entry<String,Pokemon> mapita : mapa_sorpresa.entrySet()) {

            System.out.println(mapita.getValue().getNombre() + " " + mapita.getValue().getTipo() + " " + mapita.getValue().getNivel() + " " + mapita.getValue().getPs());
        }
    }

    public static void ejercicio5() throws IOException, ClassNotFoundException{

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        Empleado carlos = new Empleado("Carlos", 2000);
        Empleado cristian = new Empleado("Cristian", 1300);
        Empleado jorge = new Empleado("Jorge", 4000);
        Empleado manzanita = new Jefe("Adrian",4300,"Informática");

        listaEmpleados.add(carlos);
        listaEmpleados.add(cristian);
        listaEmpleados.add(jorge);
        listaEmpleados.add(manzanita);

        ObjectOutputStream empleado = new ObjectOutputStream(new FileOutputStream("empleados.ser"));

        empleado.writeObject(listaEmpleados);

        ObjectInputStream deserializar = new ObjectInputStream(new FileInputStream("empleados.ser"));
        ArrayList<Empleado> empleado_sorpresa = (ArrayList<Empleado>) deserializar.readObject();

        for(Empleado emp : empleado_sorpresa) {

            System.out.println(emp.getNombre() + " " + emp.getSalario());
        }
    }
}
