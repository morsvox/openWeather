package ru.deuscode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("OpenWeatherMap");
        final Group rootGroup = new Group();
        final Scene scene =
                new Scene(rootGroup, 300, 200, Color.TRANSPARENT);


        OpenWeatherMapClass owm = new OpenWeatherMapClass();
        String response = owm.sendGet();
        response = "Temp: "+response+" c";

        final Text text1 = new Text(25, 25, response);
        text1.setFill(Color.BLACK);
        text1.setFont(Font.font(java.awt.Font.SERIF, 25));
        rootGroup.getChildren().add(text1);

        stage.setScene(scene);
        stage.show();

    }
}
