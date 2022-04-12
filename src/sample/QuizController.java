package sample;
//квиз

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Reader.*;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuizController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup answers;

    @FXML
    private RadioButton btnAnswer1;

    @FXML
    private RadioButton btnAnswer2;

    @FXML
    private RadioButton btnAnswer3;

    @FXML
    private Text textQuestion;

    @FXML
    private Button btnGetAnswer;

    @FXML
    private Button btnWantSale;

    private Question[] questions;
//    private Question[] questions = new Question[] {
//            new Question("В каком из вариантов представлен корректный формат вывода информации на экран?", new String[] {"Console.Write()", "console.log()", "print()", "System.out.println()"}),
//            new Question("Какой тип данных отвечает за целые числа?", new String[] {"String", "Float", "Boolean", "Integer"}),
//            new Question("Где правильно присвоено новое значение к многомерному массиву?", new String[] {"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
//            new Question("Какой метод позволяет запустить программу на Java?", new String[] {"Основного метода нет", "С класса, что был написан первым и с методов что есть внутри него", "Любой, его можно задавать в настройках проекта", "С метода main в любом из классов"}),
//            new Question("Каждый файл должен называется...", new String[] {"по имени первой библиотеки в нём", "по имени названия пакета", "как вам захочется", "по имени класса в нём"}),
//            new Question("Сколько параметров может принимать функция?", new String[] {"5", "10", "20", "неограниченное количество"})
//    };

    // Переменные для установки текущего номера вопроса и для подсчета количества верных ответов
    private int nowQuestion = 0, correctAnswers;
    // В эту переменную будет устанавливаться корректный ответ текущего вопроса
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {

        questions = FileHandlers.getQuestions();//ДОБАВЛЕНО
        nextQuestion();//ДОБАВЛЕНО

        // Отслеживание нажатия на кнопку "Ответить"
        btnGetAnswer.setOnAction(e -> {
            // Получаем выбранную кнопку пользователем
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            // Код будет выполняться только если пользователь выбрал ответ
            if (selectedRadioButton != null) {
                // Получаем текст ответа
                String toogleGroupValue = selectedRadioButton.getText();

                // Сверяем ответ с корректным
                if (toogleGroupValue.equals(nowCorrectAnswer)) {
                    // Выводим информацию и увеличиваем количество верных ответов
                    System.out.println("Верный ответ");
                    correctAnswers++;
                } else
                    System.out.println("Не верный ответ");

                // Если сейчас был последний вопрос, то скрываем все поля
                if (nowQuestion == questions.length) {
                    btnAnswer1.setVisible(false); // Скрываем все поля для выбора
                    btnAnswer2.setVisible(false);
                    btnAnswer3.setVisible(false);
                    btnGetAnswer.setVisible(false); // Скрываем кнопку ответа

                    // Показываем текст в конце
                    textQuestion.setText("Вы ответили корректно на " + correctAnswers + " из " + questions.length + " вопросов!");

                    //btnGetAnswer.setVisible(true);
                    btnWantSale.setText("Хочу скидку!");

                    btnWantSale.setOnMouseClicked(mouseEvent -> {//если нажимает кнопку Хочу скидку, следующее окно
                        btnWantSale.getScene().getWindow().hide(); //скрываем предыдущее окно
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("view/questionnaire.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                            Stage stage = new Stage();
                            stage.setTitle("Child Center");
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException exp) {
                            Logger logger = Logger.getLogger(getClass().getName());
                            logger.log(Level.SEVERE, "Failed to create new Window.", exp);
                        }
                    });


                } else { // Если еще есть вопросы...
                    nextQuestion();
                    // Снимаем выделение, что указал пользователь ранее
                    selectedRadioButton.setSelected(false);
                }
            }

        });


    }
    /**
     * метод заполняет компоненты формы значениями из массива вопросов
     */

    private void nextQuestion() {//ДОБАВЛЕНО

        // Указываем новый текст верного ответа
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        // Меняем текст вопроса в программе
        textQuestion.setText(questions[nowQuestion].getQuestion());
        // Получаем массив ответов
        String[] answers = questions[nowQuestion].getAnswers();

        // Преобразовываем в список (так удобнее сортировать элементы)
        List<String> intList = Arrays.asList(answers);

        // Сортируем в случайном порядке
        Collections.shuffle(intList);

        // Подставляем ответы в радио кнопки
        btnAnswer1.setText(intList.get(0));
        btnAnswer2.setText(intList.get(1));
        btnAnswer3.setText(intList.get(2));

        // Увеличиваем номер текущего вопроса
        nowQuestion++;

    }
}





