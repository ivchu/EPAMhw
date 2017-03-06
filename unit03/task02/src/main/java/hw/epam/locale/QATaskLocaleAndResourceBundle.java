package hw.epam.locale;

import java.util.*;

/**
 * Created by MM8 on 05.03.2017.
 */
public class QATaskLocaleAndResourceBundle {
    private final Locale localeRU = new Locale("ru", "RU");
    private final Locale localeEN = new Locale("en", "US");
    private ResourceBundle questions;
    private ResourceBundle answers;

    public static void main(String[] args) {
        new QATaskLocaleAndResourceBundle().findAnswers();
    }

    public void findAnswers() {
        Scanner userInputReader = new Scanner(System.in);
        List<String> keys = new ArrayList<>();
        while (true) {
            System.out.println("Choose lenguage, ru - Russian, en - English\nfor exit use q");
            String userInput = userInputReader.nextLine();
            if (userInput.equals("ru")) {
                while (true) {
                    questions = ResourceBundle.getBundle("Questions_ru_RU", localeRU);
                    keys.addAll(questions.keySet());
                    System.out.println("Напишите номер вопроса на который хотите найти ответ");
                    String answerNumber = userInputReader.nextLine();
                    if (keys.contains(answerNumber)) {
                        answers = ResourceBundle.getBundle("Answers_ru_RU", localeRU);
                        System.out.println(answers.getString(answerNumber));
                        break;
                    } else if (answerNumber.equals("q")) {
                        break;
                    } else {
                        System.out.println("Такого номера вопроса нет, попробуйте снова");
                    }
                }
            } else if (userInput.equals("en")) {
                while (true) {
                    questions = ResourceBundle.getBundle("Questions_en_US", localeEN);
                    keys.addAll(questions.keySet());
                    System.out.println("Choose question, please");
                    String answerNumber = userInputReader.nextLine();
                    if (keys.contains(answerNumber)) {
                        answers = ResourceBundle.getBundle("Answers_en_US", localeRU);
                        System.out.println(answers.getString(answerNumber));
                        break;
                    } else if (answerNumber.equals("q")) {
                        break;
                    } else {
                        System.out.println("We don`t have such question, pls try again");
                    }
                }
            } else if (userInput.equals("q")) {
                break;
            } else {
                System.out.println("Wrong input, u should try again\nНеправильный ввод, попробуйте еще раз");
            }
        }
    }

}
