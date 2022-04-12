package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.logging.Level;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.*;
import sample.Reader.FileTypes;
import sample.Reader.FileHandlers;


public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActual;

    @FXML
    private Button btnMix;

    @FXML
    private Button btnSoviet;

    @FXML
    void initialize() {
        btnSoviet.setOnMouseClicked(mouseEvent -> {
            System.out.println("Soviet");
            FileHandlers.getQuestionFromFile(FileTypes.SOVETSKIE_MULTIKI);//ДОБАВЛЕНО

            URL url = getClass().getResource("view/quizSoviet.fxml");
            showQuestion(url);
            btnSoviet.getScene().getWindow().hide();
        });
        btnActual.setOnMouseClicked(mouseEvent -> {
            System.out.println("Actual");
           FileHandlers.getQuestionFromFile(FileTypes.SOVREMENNYE_MULTIKI);//ДОБАВЛЕНО

            URL url = getClass().getResource("view/quizActual.fxml");
            showQuestion(url);
            btnActual.getScene().getWindow().hide();
        });
        btnMix.setOnMouseClicked(mouseEvent -> {
            System.out.println("Mix");
            FileHandlers.getQuestionFromFile(FileTypes.SMESHANNA_VIKTORINA);//ДОБАВЛЕНО

            URL url = getClass().getResource("view/quizMix.fxml");
            showQuestion(url);
            btnMix.getScene().getWindow().hide();
        });
    }

    public void showQuestion(URL url){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            Scene scene = new Scene(fxmlLoader.load(), 700, 400);
            Stage stage = new Stage();
            stage.setTitle("Child Center");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

}

