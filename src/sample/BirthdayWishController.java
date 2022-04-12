package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.*;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import sample.QrController;

public class BirthdayWishController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button answer;

    @FXML
    private Label label;

    @FXML
    private Label label2;

    @FXML
    private RadioButton noWish;

    @FXML
    private ToggleGroup wish;

    @FXML
    private RadioButton yesWish;

    @FXML
    void initialize() {
        answer.setOnMouseClicked(mouseEvent -> {
            answer.getScene().getWindow().hide();
            RadioButton selection;
            selection = (RadioButton) wish.getSelectedToggle(); //записываем в переменную выбранный ответ из поля хочет ли отпраздновать ДР

            if (selection == yesWish){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("view/birthday.fxml")); //подгружаем новое окно с выбором какой тест проходить
                    Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                    Stage stage = new Stage();
                    stage.setTitle("Child Center");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e){ //если есть ошибки с открытием, выводим на консоль
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.log(Level.SEVERE, "Failed to create new Window.", e);
                }
            } else {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("view/addQuestionnaire.fxml")); //подгружаем новое окно с выбором какой тест проходить
                    Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                    Stage stage = new Stage();
                    stage.setTitle("Child Center");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e){ //если есть ошибки с открытием, выводим на консоль
                    Logger logger = Logger.getLogger(getClass().getName());
                    logger.log(Level.SEVERE, "Failed to create new Window.", e);
                }


            }
        });
    }

}
