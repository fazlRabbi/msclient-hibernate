/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.hib.msapp.RESTClient;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import no.hib.msapp.entities.Symptom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;



/**
 *
 * @author Leif Arne
 */
public class SymptomFacade {
    private final String ALL_SYMPTOMS = "http://localhost:9030/api/settings/symptoms";

    public SymptomFacade() {
    }

       public List<Symptom> findAll() {
        List<Symptom> symptoms;
        try {
        	System.out.println("Inside findAll symptoms..");
            URL obj = new URL(ALL_SYMPTOMS);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            //add reuqest header
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(),"UTF-8"));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Type type = new TypeToken<List<Symptom>>() {}.getType();
            String resp = response.toString();
            System.out.println(resp);
            symptoms = new Gson().fromJson(resp, type);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Exception getting all symptoms: ", ex);
        }


        return symptoms;
    }
}
