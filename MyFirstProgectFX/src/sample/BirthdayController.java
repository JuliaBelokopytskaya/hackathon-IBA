package sample;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static sample.CreateExcel.WriterExcel;

public class BirthdayController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton activeGame;

    @FXML
    private ToggleGroup activity;

    @FXML
    private Button answer;

    @FXML
    private RadioButton calmGame;

    @FXML
    private ToggleGroup numberOfPerson;

    @FXML
    private RadioButton person10;

    @FXML
    private RadioButton person1020;

    @FXML
    private RadioButton person20;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
     void initialize() {
        answer.setOnMouseClicked(mouseEvent -> {

            RadioButton selectionPerson;
            selectionPerson = (RadioButton) numberOfPerson.getSelectedToggle();
            String number = selectionPerson.getText();
            CreateExcel.data[9]=number;
            RadioButton selectionActivity;
            selectionActivity = (RadioButton) activity.getSelectedToggle();
            String activity = selectionActivity.getText();
            CreateExcel.data[10]=activity;

            if(selectionPerson == person10 && selectionActivity == activeGame){
                isHidden();
                label3.setText("Большое спасибо за предоставленную информацию! Ваша скидка: " +
                        "30% на проведение дня рождения (до 10 гостей) с услугами аниматора.");
                WriterExcel();
            } else if (selectionPerson == person10 && selectionActivity == calmGame){
                isHidden();
                label3.setText(" Большое спасибо за предоставленную информацию! Ваша скидка: " +
                        "30% на проведение дня рождения (до 10 гостей). Для Вас представлен " +
                        "большой выбор развивающих игр для Ваших малышей. ");
                WriterExcel();
            }else if (selectionPerson == person1020 && selectionActivity == activeGame){
                isHidden();
                label3.setText("Большое спасибо за предоставленную информацию! Ваша скидка: " +
                        "30% на проведение дня рождения (10-20 гостей) с услугами аниматора.");
                WriterExcel();
            } else if (selectionPerson == person1020 && selectionActivity == calmGame){
                isHidden();
                label3.setText("Большое спасибо за предоставленную информацию! Ваша скидка: " +
                        "30% на проведение дня рождения (10-20 гостей). Для Вас представлен " +
                        "большой выбор развивающих игр для Ваших малышей. ");
                WriterExcel();
            } else if (selectionPerson == person20 && selectionActivity == activeGame){
                isHidden();
                label3.setText("Большое спасибо за предоставленную информацию! Ваша скидка: " +
                        "30% на проведение дня рождения (более 20 гостей) с услугами аниматора. ");
                WriterExcel();
            } else if (selectionPerson == person20 && selectionActivity == calmGame){
                isHidden();
                label3.setText("Большое спасибо за предоставленную информацию! Ваша скидка: " +
                        "30% на проведение дня рождения (более 20 гостей). Для Вас представлен " +
                        "большой выбор развивающих игр для Ваших малышей. ");
                WriterExcel();
            }
            Desktop desktop = Desktop.getDesktop();
            File file = new File("./src/Меню для др.pdf");
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }

    private void isHidden() { //скрываем все поля
        answer.setVisible(false);
        activeGame.setVisible(false);
        calmGame.setVisible(false);
        person10.setVisible(false);
        person20.setVisible(false);
        person1020.setVisible(false);
        label1.setVisible(false);
        label2.setVisible(false);


    }
}
