package sample.Reader;

import sample.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Kristina Horbachova
 * Класс для работы с файлами и случайными вопросами
 */

public class FileHandlers {//класс чтения файлов

    //ДОБАВЛЕНО
    private static final String FILE_SOVETSKIE_MULTIKI = "Советские мультики.txt";//константа где хранится название файлов
    private static final String FILE_SOVREMENNYE_MULTIKI = "Современные мультики.txt";
    private static final Integer COUNT_QUESTION = 3;//сколько вопросов


    private static Question[] questions = null;//наши вопросы, которые запрашивали


    /**
     * Метод возвращает массив вопросов
     * вызывается в классе QuizController
     * @return Question[] массив вопросов (Вопрос+Ответ+правильный ответ)
     */
    public static Question[] getQuestions() {
        return questions;
    }

    /**
     * Метода для обработки файлов и генерации случайных вопросов
     * вызывается в классе APPController
     * записывает Question[] (массив вопросов) в private static Question[] questions
     * @param type  Тип вопросов из класса FileTypes
     *
     */
    public static void getQuestionFromFile(FileTypes type) {
        switch (type) {
            case SOVETSKIE_MULTIKI:
                questions = getRandomQuestion(COUNT_QUESTION, new File(FILE_SOVETSKIE_MULTIKI));
                break;
            case SOVREMENNYE_MULTIKI:
                questions = getRandomQuestion(COUNT_QUESTION, new File(FILE_SOVREMENNYE_MULTIKI));
                break;
            default:
                questions = getRandomQuestion(COUNT_QUESTION, new File(FILE_SOVETSKIE_MULTIKI), new File(FILE_SOVREMENNYE_MULTIKI));
                break;
        }
    }

    /**
     * Метод для считывания вопросов из массива файлов
     * использует метод ArrayList<Question> parcerTxt(File file)
     * @param files массив файлов для обработки
     * @return Question[] массив вопросов (Вопрос+Ответ+правильный ответ)
     */
    public static Question[] parcerTxt(File... files) {//считываем файлы
        ArrayList<Question> returnAL = new ArrayList<>();//коллекция вопросов
        for (File file : files) {//читаем все файлы
            returnAL.addAll(parcerTxt(file));//добавляем результат выполнения метода
        }
        return returnAL.toArray(new Question[0]);//преобразуем в массив типа Q(как у Ксении)
    }

    /**
     * Метод для считывания вопросов из одного файла
     * @param file файл для обработки
     * @return Question[] массив вопросов (Вопрос+Ответ+правильный ответ)
     */
    public static ArrayList<Question> parcerTxt(File file) {//возвращаем тему
        ArrayList<Question> questions = new ArrayList<>();//создаем пустую коллекцию
        try {
            //создаем объект FileReader(посимвольное чтение) для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);

            String line;
            while ((line = reader.readLine()) != null) {//берем первую строку
                String question_name = line.trim();//удаление пробелов в конце файла

                String[] answers = null;//создаем масссив строк
                String correctAnswer = null;//создаем строку
                if ((line = reader.readLine()) != null) {//читаем след строчку,после вопроса
                    line = line.trim();
                    String[] answersFromLine = line.split(";");//разбиваем строку по ;
                    correctAnswer = answersFromLine[answersFromLine.length - 1];//правильный ответ,как у Ксении
                    answers = Arrays.copyOf(answersFromLine, answersFromLine.length - 1);//копируем все ответы без последнего ответа
                } else {
                    break;
                }
                questions.add(new Question(question_name, answers, correctAnswer));//колеекция/создаем новый вопрос,для передачи Ксении
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    /**
     * Метод для выбора случайных вопросов из массива файлов
     * использует метод Question[] parcerTxt(File... files)
     * использует метод getRandomQuestion(Integer count_question, Question... questions)
     * @param count_question нужное количество случайных вопросов
     * @param files массив файлов для обработки
     * @return Question[] массив вопросов (Вопрос+Ответ+правильный ответ)
     */
    public static Question[] getRandomQuestion(Integer count_question, File... files) {
        return getRandomQuestion(count_question, FileHandlers.parcerTxt(files));
    }

    /**
     * Метод для выбора случайных вопросов из массива вопросов
     * @param count_question нужное количество случайных вопросов
     * @param questions массив всех вопросов (Вопрос+Ответ+правильный ответ)
     * @@return Question[] массив вопросов (Вопрос+Ответ+правильный ответ)
     */
    public static Question[] getRandomQuestion(Integer count_question, Question... questions) {//метод массив вопросов(кол возвращаемых вопросов, масиив всех вопрсов)
        Question[] returnAL = new Question[count_question];//массив вопросов для ксении
        int size = questions.length;//кол всех вопросов
        if (size > count_question) {
            Random random = new Random();//объект для работы со случайными числами
            ArrayList<Integer> randomUniqNumbersAL = new ArrayList<>();//коллекция хранения значения, хранит только уникальные значения
            while (randomUniqNumbersAL.size() < count_question) {
                int randomValue = (int) ((size - 1) * random.nextDouble());//получаю случаное целое число от 0 до size-1
                if (!randomUniqNumbersAL.contains(randomValue)) {//если список не содержит RV.тогда добавляем его дальше
                    randomUniqNumbersAL.add(randomValue);
                }
            }
            for (int i = 0; i < count_question; i++) {
                returnAL[i] = questions[randomUniqNumbersAL.get(i)];
            }
            return returnAL;
        } else {
            return questions;
        }
    }
}
