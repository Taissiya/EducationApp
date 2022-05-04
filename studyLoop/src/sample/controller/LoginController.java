package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.db.UserDao;
import sample.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonSighIn;

    @FXML
    private Label logoText;

    @FXML
    private PasswordField password;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button registration;

    @FXML
    void initialize() {
        buttonSighIn.setOnAction(event -> {
            String loginText = phoneNumber.getText().trim();
            String loginPassword = password.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals("")) {
                loginUser(loginText, loginPassword);
            } else
                System.out.println("Error");

        });
        registration.setOnAction(event -> {
            registration.getScene().getWindow().hide();
            //новая часть
            goTo("/sample/fxml/registrationPage.fxml", "reg page");
        });
    }

    public void goTo(String method, String name) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(method));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle(name);
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void loginUser(String phoneText, String loginPassword) {
        UserDao dbUserDao = new UserDao();
        User user = new User();
        user.setPhoneNumber(phoneText);
        user.setPassword(loginPassword);
        Boolean result = UserDao.getUser(user);
        if (result) {
            registration.getScene().getWindow().hide();
            goTo("/sample/fxml/helloView.fxml", "hello");
        }

    }
}



