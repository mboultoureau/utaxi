package fr.iutlannion;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public void start(Stage primaryStage) {
        primaryStage = new Window();
        primaryStage.show();
    }

    public static void main(final String[] args) {
        Application.launch();
    }
}
