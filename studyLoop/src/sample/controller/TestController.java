package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import sample.model.Questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestController extends HelloViewController {

    @FXML
    private Button answerBtn;

    @FXML
    private ToggleGroup answers;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonCplus;

    @FXML
    private Button buttonCsharp;

    @FXML
    private Button buttonJava;

    @FXML
    private Button buttonPython;

    @FXML
    private Text question_text;

    @FXML
    private RadioButton radio_btn_1;

    @FXML
    private RadioButton radio_btn_2;

    @FXML
    private RadioButton radio_btn_3;

    @FXML
    private RadioButton radio_btn_4;

    private Questions[] questions = new Questions[]{
            new Questions("(1.6)Which of the options is the correct format for displaying information on the screen?", new String[]{"Console.Write()", "console.log()", "print()", "System.out.println()"}),
            new Questions("(2.6)What data type is responsible for integers?", new String[]{"String", "Float", "Boolean", "Integer"}),
            new Questions("(3.6)Where is the new value assigned to the multidimensional array correctly?", new String[]{"a(0)(0) = 1;", "a[0 0] = 1;", "a{0}{0} = 1;", "a[0][0] = 1;"}),
            new Questions("(4.6)Which method allows you to run a Java program?", new String[]{"No main method",
                    "From the class that was written first and from the methods that are inside it", "Any one, it can be set in the project settings", "From the main method in any of the classes"}),
            new Questions("(5.6)Each file must be named...", new String[]{"by the name of the first library in it", "by the name of the package name", "as you wish", "by the name of the class in it"}),
            new Questions("(6.6)How many parameters can a function take?", new String[]{"5", "10", "20", "unlimited quantity"})
    };

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {

        //Тест
        nowCorrectAnswer = questions[nowQuestion].correctAnswer();

        answerBtn.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            if (selectedRadioButton != null) {
                String toogleGroupValue = selectedRadioButton.getText();

                if (toogleGroupValue.equals(nowCorrectAnswer)) {
                    System.out.println("Correct Answer");
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect answer");
                }


                if (nowQuestion + 1 == questions.length) {
                    radio_btn_1.setVisible(false);
                    radio_btn_2.setVisible(false);
                    radio_btn_3.setVisible(false);
                    radio_btn_4.setVisible(false);
                    answerBtn.setVisible(false);

                    question_text.setText("You answered correctly " + correctAnswers + " of " + questions.length + " questions!");
                } else {
                    nowQuestion++;
                    nowCorrectAnswer = questions[nowQuestion].correctAnswer();

                    question_text.setText(questions[nowQuestion].getQuestion());

                    String[] answers = questions[nowQuestion].getAnswers();
                    List<String> intList = Arrays.asList(answers);
                    Collections.shuffle(intList);

                    radio_btn_1.setText(intList.get(0));
                    radio_btn_2.setText(intList.get(1));
                    radio_btn_3.setText(intList.get(2));
                    radio_btn_4.setText(intList.get(3));

                    selectedRadioButton.setSelected(false);
                }

            }
        });


        //Переходы между окнами
        buttonCsharp.setOnAction(event -> {
            buttonCsharp.getScene().getWindow().hide();
            goTo("/sample/fxml/testCsharp.fxml", "Csharp");
        });

        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            goTo("/sample/fxml/helloView.fxml", "helloView");
        });

        buttonCplus.setOnAction(event -> {
            buttonCplus.getScene().getWindow().hide();
            goTo("/sample/fxml/testCplus.fxml", "Cplus");
        });

        buttonPython.setOnAction(event -> {
            buttonPython.getScene().getWindow().hide();
            goTo("/sample/fxml/testPython.fxml", "Python");
        });

    }

}
