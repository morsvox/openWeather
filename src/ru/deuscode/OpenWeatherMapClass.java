package ru.deuscode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class OpenWeatherMapClass {
    String sendGet() throws Exception {
        String code = "1dbb0e889a89bc1daa841540097190bc";
        String city = "Fryazino,ru";

        String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&lang=ru&units=metric&appid="+code;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuilder response;
        response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        String json;
        json = response.toString();
        JSONParser parser = new JSONParser();

        Object parse = parser.parse(json);
        JSONObject jsonObj = (JSONObject) parse;
        JSONObject main = (JSONObject) jsonObj.get("main");
        return main.get("temp").toString();
    }
}
