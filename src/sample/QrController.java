package sample;
//класс для итогового опросника (имя, фамилия, дата рождения и т.д)
import java.io.*;
import java.net.URL;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.logging.*;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import static sample.CreateExcel.WriterExcel;

public class QrController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button answer;

    @FXML
    private RadioButton constantInterest;

    @FXML
    private DatePicker dateOfBirthday;

    @FXML
    private TextField firstName;

    @FXML
    private ToggleGroup interest;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private TextField lastName;

    @FXML
    private RadioButton noRecentVisit;

    @FXML
    private RadioButton oneTimeInterest;

    @FXML
    private ToggleGroup recentVisit;

    @FXML
    private TextField telephoneNumber;

    @FXML
    private RadioButton yesRecentVisit;

    @FXML
    private Label msgResult;

    @FXML
    private TextField review;

    @FXML
    private Label reviewText;

    @FXML
    void initialize() {
        answer.setOnAction(event -> {//ждем, когда пользователь нажмет на кнопку Ответить
            String firstNameStr = firstName.getText(); //записываем в переменную то, что ввел пользователь (имя)
            CreateExcel.data[0]=firstNameStr;
            if (firstNameStr == null || firstName.getText().length() == 0)
                System.out.println("Ошибка"); //если Поле пустое, выводим на консоль ошибку
            String lastNameStr = lastName.getText();//записываем в переменную то, что ввел пользователь (фамилия)
            CreateExcel.data[1]=lastNameStr;
            if (lastName.getText() == null || lastName.getText().length() == 0) System.out.println("Ошибка");
            String telephoneNumberStr = telephoneNumber.getText();
            CreateExcel.data[2]=telephoneNumberStr;

            try { //для полей дата рождения, и радиокнопок для обработки ошибок
                String dateOfBirthdayStr = dateOfBirthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                CreateExcel.data[3]=dateOfBirthdayStr;
                RadioButton selection = (RadioButton) recentVisit.getSelectedToggle();
                String recentVisitStr = selection.getText();
                CreateExcel.data[4]=recentVisitStr;
                selection = (RadioButton) interest.getSelectedToggle();
                String interestStr = selection.getText();
                CreateExcel.data[5]=interestStr;
                System.out.println(firstNameStr + lastNameStr + dateOfBirthdayStr + telephoneNumberStr +
                        recentVisitStr + interestStr);
            } catch (Exception e) {
                System.out.println("Сделайте выбор");
            }

            RadioButton selection;
            selection = (RadioButton) interest.getSelectedToggle(); //записываем в переменную выбранный ответ из поля Вас интересует

            RadioButton selectionVisit;
            selectionVisit = (RadioButton) recentVisit.getSelectedToggle();


            //блок по анализу даты
            String dateOfBirthdayStr = dateOfBirthday.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate date = LocalDate.parse(dateOfBirthdayStr);
            LocalDate d2 = LocalDate.now();
            System.out.println(date.getDayOfYear());
            int d;

            if(date.getDayOfYear()>=1 && date.getDayOfYear()<60 && d2.getDayOfYear()>=305 && d2.getDayOfYear()<=365){
                d=365+date.getDayOfYear()-d2.getDayOfYear();
            }
            else{
                d=date.getDayOfYear()-d2.getDayOfYear();
            }
            System.out.println(d);

            if(d<=61 && d>=0){
                answer.getScene().getWindow().hide();//скрываем предыдущее окно
                System.out.println("Скоро ДР");
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("view/birthdayWish.fxml")); //подгружаем новое окно с выбором какой тест проходить
                        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                        Stage stage = new Stage();
                        stage.setTitle("Child Center");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException e){ //если есть ошибки с открытием, выводим на консоль
                        Logger logger = Logger.getLogger(getClass().getName());
                        logger.log(Level.SEVERE, "Failed to create new Window.", e);
                    }
                }else
                    if (selectionVisit == yesRecentVisit) { //если выбрали Бывали ранее
                        answer.getScene().getWindow().hide();
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("view/review.fxml")); //подгружаем новое окно с выбором какой тест проходить
                            Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                            Stage stage = new Stage();
                            stage.setTitle("Child Center");
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e){ //если есть ошибки с открытием, выводим на консоль
                            Logger logger = Logger.getLogger(getClass().getName());
                            logger.log(Level.SEVERE, "Failed to create new Window.", e);
                        }

                    } else
                    if (selectionVisit == noRecentVisit) {
                        answer.getScene().getWindow().hide();
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
    private void isHidden(){ //скрываем все поля
        answer.setVisible(false);
        constantInterest.setVisible(false);
        dateOfBirthday.setVisible(false);
        lastName.setVisible(false);
        firstName.setVisible(false);
        noRecentVisit.setVisible(false);
        oneTimeInterest.setVisible(false);
        telephoneNumber.setVisible(false);
        yesRecentVisit.setVisible(false);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
    }

}










