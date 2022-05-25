package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Tamodatschi extends Application {
    public static Spieler spieler = new Spieler();
    public Spielfeld feld;
    @FXML
    public Pane pane;

    @FXML
    protected void onDisplayClick(Event e) {
        System.out.println(e.getTarget().toString());
    }

    // Test variables:
    Ort testOrt = new Ort("Test", 16,16);

    // End
    @FXML
    protected void onTestButtonClick() {
    // Test:
        feld = new Spielfeld(true);
        feld.initDrawMap(pane);
    // End
    }
    @FXML
    protected void onTest2ButtonClick() {
    // Test:
        feld.applyOrt(testOrt);
        feld.drawMap(pane);
    // End
    }
    @FXML
    protected void onTestPlayerButtonClick() {
    // Test:
        Random r = new Random();
        int x = r.nextInt(42);
        int y = r.nextInt(26);
        spieler.setPosX(x);
        spieler.setPosY(y);
        feld.drawMap(pane);
    // End
    }
    @FXML
    protected void onDisplayText(KeyEvent kev){
        System.out.println(kev.getCharacter());
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Tamodatschi.class.getResource("tamodatschi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1152, 700);
        stage.setTitle("Tamodatschi");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    public void initGame() {
        launch();
    }

    public Tamodatschi() {

    }
}