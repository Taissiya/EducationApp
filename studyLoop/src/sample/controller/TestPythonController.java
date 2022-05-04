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

public class TestPythonController extends HelloViewController {

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
            new Questions("(1.6)Which of the options is the correct format for displaying information on the screen?", new String[]{"Console.Write()", "console.log()", "cout << \"Hello World!\"", "print()"}),
            new Questions("(2.6)Without what the code will not work?", new String[]{";", "class main", "Boolean", "efforts"}),
            new Questions("(3.6)Which of these is the correct variable declaration?", new String[]{"int age; int age;", "int main", "int A", "int age = 20"}),
            new Questions("(4.6)It can take one of two values true (true) and false (false)...", new String[]{"int",
                    "char", "short", "boolean"}),
            new Questions("(5.6)Do programs use ;?", new String[]{"in the beginning", "in classes", "sometimes", "no"}),
            new Questions("(6.6)How many parameters can a function take?", new String[]{"5", "10", "20", "unlimited quantity"})
    };

    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

    @FXML
    public void initialize() {
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

        buttonJava.setOnAction(event -> {
            buttonJava.getScene().getWindow().hide();
            goTo("/sample/fxml/testPage.fxml", "testPage");
        });
    }

}
