package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Tamodatschi extends Application {
    public static Spieler spieler = new Spieler();
    public Spielfeld feld;
    public Scene scene;
    @FXML
    public Pane pane;

    @FXML
    protected void onDisplayClick(Event e) {
        System.out.println(e.getTarget().toString());
    }

    // Test variables:
    Ort testOrt = new Ort("Test", 16,16, getClass().getResource("images/banan.png").toString());

    // End
    @FXML
    protected void onTestButtonClick(Event e) {
    // Test:
        feld = new Spielfeld(true);
        feld.initDrawMap(pane);
        ((Button) e.getSource()).setDisable(true);
        // End
    }
    @FXML
    protected void onTest2ButtonClick(Event e) {
    // Test:
        feld.applyOrt(testOrt);
        feld.drawMap(pane);
        ((Button) e.getSource()).setDisable(true);
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
    protected void onTestMinigameButtonClick() {
        // Test:
        //SchereSteinPapier ssp = new SchereSteinPapier();
        //ssp.start();
        Memory mem = new Memory();
        mem.start();
        //NoelSpricht nsp = new NoelSpricht();
        //nsp.start();
        // End
    }
    @FXML
    protected void onTestShopButtonClick() {
        // Test:
        Shop sp = new Shop();
        sp.start();
        // End
    }
    @FXML
    protected void onDisplayText(KeyEvent kev){
        switch (kev.getCharacter()) {
            case "w" :
                if(spieler.getPosY() > 0){
                    spieler.setPosY(spieler.getPosY() - 1);
                }
                break;
            case "a" :
                if(spieler.getPosX() > 0){
                    spieler.setPosX(spieler.getPosX() - 1);
                }
                break;
            case "s" :
                if(spieler.getPosY() < feld.getMap()[0].length-1){
                    spieler.setPosY(spieler.getPosY() + 1);
                }
                break;
            case "d" :
                if(spieler.getPosX() < feld.getMap().length-1){
                    spieler.setPosX(spieler.getPosX() + 1);
                }
                break;
        }

        feld.drawMap(pane);
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Tamodatschi.class.getResource("tamodatschi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1152, 700);
        this.scene = scene;
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