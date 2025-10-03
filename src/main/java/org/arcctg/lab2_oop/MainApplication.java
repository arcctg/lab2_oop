package org.arcctg.lab2_oop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);

        ShapeObjectsEditor controller = fxmlLoader.getController();
        controller.setStage(stage);

        stage.setTitle("Графічний редактор - Точка");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
