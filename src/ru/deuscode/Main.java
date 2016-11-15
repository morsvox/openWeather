package ru.deuscode;


public class Main {


    public static void main(String[] args) throws Exception {

        OpenWeatherMapClass owm = new OpenWeatherMapClass();
        String response = owm.sendGet();

        System.out.println(response+" по цельсию");

    }

}
