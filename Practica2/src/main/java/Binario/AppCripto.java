package Binario;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AppCripto {

    public static void main(String[] args) {

        try {

            String apiUrl = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin,ethereum&vs_currencies=usd,eur";

            URL url = new URL(apiUrl);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                json.append(line);
            }
            in.close();

            Gson gson = new Gson();
            Cripto criptomoneda = gson.fromJson(json.toString(), Cripto.class);

            System.out.println("Precios de critpomonedas:");
            System.out.println("Bitcoin: " + criptomoneda.bitcoin.eur + "€");
            System.out.println("Ethereum: " + criptomoneda.ethereum.eur + "€");

        } catch (Exception e) {
            System.out.println("Algo ha ido mal.");
            e.printStackTrace();
        }
    }
}
