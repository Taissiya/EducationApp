package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.db.UserDao;
import sample.model.User;

public class RegistrationPageController extends LoginController {

    @FXML
    private Button buttonSignUp;

    @FXML
    private AnchorPane dateOfBirth;

    @FXML
    private TextField fieldMail;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldPhoneNumber;

    @FXML
    private TextField fieldCountry;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private ImageView logoPicture;

    @FXML
    private Label logoText;

    @FXML
    private RadioButton radioButtonFemale;

    @FXML
    private RadioButton radioButtonMale;

    @FXML
    void initialize() {
        buttonSignUp.setOnAction(event -> {
            System.out.println("123");
            signUpNewUser();
        });
    }

    private void signUpNewUser() {

        String gender;
        if (radioButtonMale.isSelected())
            gender = "Male";
        else
            gender = "Female";

        User user = new User(fieldName.getText(),
                fieldPhoneNumber.getText(),
                fieldMail.getText(),
                fieldCountry.getText(),
                fieldPassword.getText(),
                gender,
                "01.02.2000");
        if (UserDao.insNewUser(user)) {
            buttonSignUp.getScene().getWindow().hide();
            goTo("/sample/fxml/helloView.fxml", "hello");
        }

    }

//    private void signUpNewUser() {
//        DataBaseHandler dbHandler = new DataBaseHandler();
//
//
//        String name = fieldName.getText();
//        String phonenumber = fieldPhoneNumber.getText();
//        String mail = fieldMail.getText();
//        String country = fieldcountry.getText();
//        String password = fieldpassword.getText();
//        String gender = "";
//        String dateofbirth = "01.01.01";
//        if (radioButtonMale.isSelected())
//            gender = "Male";
//        else
//            gender = "Female";
//
//        User user = new User(name, phonenumber, mail, country, password, gender, dateofbirth);
//        try {
//            dbHandler.signUpUser(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        buttonSignUp.getScene().getWindow().hide();
//        goTo("..//fxml//helloView.fxml", "helloView");
//
//
//    }
}


