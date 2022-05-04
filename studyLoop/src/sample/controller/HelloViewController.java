package sample.controller;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloViewController extends LoginController {

    @FXML
    private Button addButton;

    @FXML
    private Button buttonLogOut;

    @FXML
    private Button buttonMyCourse;

    @FXML
    private Button buttonTests;

    @FXML
    private TextField fieldFinder;

    @FXML
    private AnchorPane leftWindow;

    @FXML
    private ImageView logoPicture;

    @FXML
    private Label logoText;

    @FXML
    private AnchorPane mainWindow;

    @FXML
    private Button pauseButton;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    @FXML
    private ScrollBar scroll;

    @FXML
    private MediaView videoFirst;

    @FXML
    void addMedia(ActionEvent event) {

    }

    @FXML
    void pauseMedia(ActionEvent event) {

    }

    @FXML
    void playMedia(ActionEvent event) {

    }

    @FXML
    void resetMedia(ActionEvent event) {

    }

    @Override
    public void initialize() {
        //Переходы между окнами
        buttonMyCourse.setOnAction(event -> {
            buttonMyCourse.getScene().getWindow().hide();
            goTo("/sample/fxml/yourCourses.fxml", "Courses");
        });

        buttonTests.setOnAction(event -> {
            buttonTests.getScene().getWindow().hide();
            goTo("/sample/fxml/testPage.fxml", "Tests");
        });

        buttonLogOut.setOnAction(event -> {
            buttonLogOut.getScene().getWindow().hide();
            goTo("/sample/fxml/loginPage.fxml", "Log in page");
        });
        OpenFileMethod(new javafx.event.ActionEvent());
        pauseVideo(new javafx.event.ActionEvent());
    }

    // все что ниже тоже к видосику
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // инициализатор видосика
//
//        // TODO
//    }

    private String path;

    private MediaPlayer mediaPlayer;

    @FXML
    private MediaView mediaView;

    @FXML
    private Button openFile;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider progressBar;

    @FXML
    private Label label;

    @FXML
    private StackPane pane;

    @FXML
    private void OpenFileMethod(javafx.event.ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
//        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a .mp4 file", ".mp4");
//        fileChooser.getExtensionFilters().add(filter);
//        File file = fileChooser.showOpenDialog(null);
        File file = new File("C:/Users/77478/IdeaProjects/AAAAAAAAA/studyLoop2/studyLoop/src/sample/video/java.mp4");
        path = file.toURI().toString();

        if (path != null) {
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaView.setMediaPlayer(mediaPlayer);

            //creating bindings
            DoubleProperty widthProp = mediaView.fitWidthProperty();
            DoubleProperty heightProp = mediaView.fitHeightProperty();

            //widthProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
            //heightProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

            volumeSlider.setValue(mediaPlayer.getVolume() * 100);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeSlider.getValue() / 100);
                }
            });

            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observable, javafx.util.Duration oldValue, javafx.util.Duration newValue) {
                    progressBar.setValue(newValue.toSeconds());
                }
            });

            progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });

            progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });

            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    javafx.util.Duration total = media.getDuration();
                    progressBar.setMax(total.toSeconds());
                }
            });

            mediaPlayer.play();
        }
    }

    public void pauseVideo(javafx.event.ActionEvent event) {
        mediaPlayer.pause();
    }

    public void stopVideo(javafx.event.ActionEvent event) {
        mediaPlayer.stop();
    }

    public void playVideo(javafx.event.ActionEvent event) {
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }

    public void skip5(javafx.event.ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }

    public void furtherSpeedUpVideo(javafx.event.ActionEvent event) {
        mediaPlayer.setRate(2);
    }

    public void back5(javafx.event.ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    public void furtherSlowDownVideo(javafx.event.ActionEvent event) {
        mediaPlayer.setRate(0.5);

    }
}

