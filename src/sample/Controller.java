package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.*;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button goToTest;

    @FXML
    private ImageView image;

    @FXML
    void initialize() {
        goToTest.setOnMouseClicked(mouseEvent -> { //ждем нажатия мыши на копку "Пройти тест"
            goToTest.getScene().getWindow().hide(); //скрываем первое окно
            System.out.println("Вы нажали на пройти тест");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("view/app.fxml")); //подгружаем новое окно с выбором какой тест проходить
            Scene scene = new Scene(fxmlLoader.load(), 700, 400);
            Stage stage = new Stage();
            stage.setTitle("Child Center");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){ //если есть ошибки с открытием, выводим на консоль
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
               }
        });
    }

};



