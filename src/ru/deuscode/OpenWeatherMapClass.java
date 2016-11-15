package ru.deuscode;
//import main.java.org.json.simple.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherMapClass {
    public String sendGet() throws Exception {
        String code = "1dbb0e889a89bc1daa841540097190bc";
        String city = "Fryazino,ru";

        String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&lang=ru&units=metric&appid="+code;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");


        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        String json = response.toString();
        JSONParser parser = new JSONParser();

        Object parse = parser.parse(json);
        JSONObject jsonObj = (JSONObject) parse;
        JSONObject main = (JSONObject) jsonObj.get("main");
        String temp = (String) main.get("temp").toString();
        //print result
        return temp;

    }
}
