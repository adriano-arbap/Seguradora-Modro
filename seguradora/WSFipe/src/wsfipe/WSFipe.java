/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsfipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Usuario
 */
public class WSFipe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WSFipe wsf = new WSFipe();
        System.out.println("1111");
        System.out.println(wsf.executaURLRest("http://fipeapi.appspot.com/api/1/carros/marcas.json"));
    }
    
    public String executaURLRest(String endereco){
        String retorno = "";
        try {

            URL url = new URL(endereco);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                                    + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
     //               System.out.println(output);
                retorno += output;
            }

            conn.disconnect();

            } catch (MalformedURLException e) {
		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }        
        return retorno;
    }
}
