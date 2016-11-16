package ru.deuscode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class JavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        int width = 300;
        int height = 200;
        String city = "Fryazino";
        stage.setTitle("OpenWeatherMap Widget - "+city);
        final Group rootGroup = new Group();
        final Scene scene =
                new Scene(rootGroup, width, height, Color.TRANSPARENT);


        OpenWeatherMapClass owm;
        owm = new OpenWeatherMapClass(city);
        String response = owm.getTemp();
        String hum = owm.getHum();
        String weather = owm.getWeather();

        String resp = "Temp: "+response+" c";

        final Text text1 = new Text(0, 25, city);
        text1.setFill(Color.BLACK);
        text1.setFont(Font.font(java.awt.Font.SERIF, 25));
        text1.setWrappingWidth(width);
        text1.setTextAlignment(TextAlignment.CENTER);
        rootGroup.getChildren().add(text1);

        final Text text2 = new Text(0, 75, resp);
        text2.setFill(Color.BLACK);
        text2.setFont(Font.font(java.awt.Font.SERIF, 25));
        text2.setWrappingWidth(width);
        text2.setTextAlignment(TextAlignment.CENTER);
        rootGroup.getChildren().add(text2);


        final Text text3 = new Text(0, 115, "Humidity: "+hum+"%");
        text3.setFill(Color.BLACK);
        text3.setFont(Font.font(java.awt.Font.SERIF, 25));
        text3.setWrappingWidth(width);
        text3.setTextAlignment(TextAlignment.CENTER);
        rootGroup.getChildren().add(text3);


        final Text text4 = new Text(0, 155, weather);
        text4.setFill(Color.BLACK);
        text4.setFont(Font.font(java.awt.Font.SERIF, 25));
        text4.setWrappingWidth(width);
        text4.setTextAlignment(TextAlignment.CENTER);
        rootGroup.getChildren().add(text4);

        stage.setScene(scene);
        stage.show();

    }
}
