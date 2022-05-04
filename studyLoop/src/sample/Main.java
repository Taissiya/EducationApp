package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/loginPage.fxml"));
        primaryStage.setTitle("StudyLoop");
        primaryStage.getIcons().add(new Image("https://avatars.mds.yandex.net/i?id=2a00000179ebb86de9a77bf2a2a9212049a7-4244759-images-thumbs&n=13"));
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
