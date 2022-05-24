package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Tamodatschi extends Application {

    public Spieler spieler;
    public Spielfeld feld;

    @FXML
    private Label welcomeText;

    @FXML
    private ImageView imv1;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Tamodatschi!");
        // Test:
            testOrt.applyImage(imv1);
        // End
    }

    // Test variables:
        Ort testOrt = new Ort("Test", 0,0);

    // End


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Tamodatschi.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 576);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void initGame() {
        launch();
    }

    public Tamodatschi() {

    }
}