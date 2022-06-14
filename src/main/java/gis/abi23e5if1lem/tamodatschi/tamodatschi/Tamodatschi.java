package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Tamodatschi extends Application {
    public Spieler spieler = new Spieler();
    public Spielfeld feld;
    public Scene scene;
    @FXML
    public Pane pane;
    @FXML
    public Label labelMoney;
    @FXML
    public TextField textFieldEssen;
    @FXML
    public Label labelHunger;
    @FXML
    public Label labelPlayer;
    @FXML
    protected void onDisplayClick(Event e) {
        System.out.println(e.getTarget().toString());
    }

    // Test variables:
    Ort testOrt = new Ort( 7,16, getClass().getResource("images/banan.png").toString());
    Minigame testMin = new Minigame(2, 5, getClass().getResource("images/lootbox.png").toString(), 1);

    // End
    @FXML
    protected void onTestButtonClick(Event e) {
    // Test:
        feld = new Spielfeld(true, pane);
        feld.initDrawMap();
        ((Button) e.getSource()).setDisable(true);
        labelPlayer.setBorder(Border.stroke(Color.BLACK));
        labelMoney.setBorder(Border.stroke(Color.BLACK));
        labelHunger.setBorder(Border.stroke(Color.BLACK));
        labelHunger.setBackground(Background.fill(Color.LIGHTGRAY));
        labelMoney.setBackground(Background.fill(Color.LIGHTGRAY));
        labelPlayer.setBackground(Background.fill(Color.LIGHTGRAY));
        textFieldEssen.setBackground(Background.fill(Color.LIGHTGRAY));
        textFieldEssen.setBorder(Border.stroke(Color.BLACK));
        pane.setBackground(Background.fill(Color.DARKOLIVEGREEN));



        // End
    }
    @FXML
    protected void onTest2ButtonClick(Event e) {
    // Test:
        feld.applyBounds(testOrt.getPositionX(), testOrt.getPositionY(), true);
        feld.applyOrt(testOrt);
        feld.applyOrt(testMin);
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
        Main.tdi.spieler.setPosX(x);
        Main.tdi.spieler.setPosY(y);
        feld.drawMap(pane);
    // End
    }
    @FXML
    protected void onTestMinigameButtonClick() {
        // Test:
        //SchereSteinPapier ssp = new SchereSteinPapier();
        //ssp.start();
        Memory mem = new Memory();
        mem.start(1);
        //NoelSpricht nsp = new NoelSpricht();
        //nsp.start();
        // End
    }
    @FXML
    protected void onTestShopButtonClick() {
        // Test:
        Shop sp = new Shop(3,9, getClass().getResource("images/japanese_door.png").toString());
        feld.applyOrt(sp);
        // End
    }
    @FXML
    protected void onTestImageBoundaries(){

        int black = 0;
        for (int i = 0; i < feld.getSizeX(); i++) {
            for (int j = 0; j < feld.getSizeY(); j++) {

            }
        }
        System.out.println(black);
    }
    @FXML
    protected void onDisplayText(KeyEvent kev){
       labelMoney.setText("Geld: " + Main.tdi.spieler.getGeld());
       labelHunger.setText("Hunger: " + Main.tdi.spieler.getHunger());
        switch (kev.getCharacter()) {
            case "w" :
                feld.movePlayer(0,-1);
                break;
            case "a" :
                feld.movePlayer(-1,0);
                break;
            case "s" :
                feld.movePlayer(0,1);
                break;
            case "d" :
                feld.movePlayer(1,0);
                break;
            case "y":
                onTestImageBoundaries();
                break;
        }

        if(pane != null) {
            feld.drawMap(pane);
        }
    }


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Tamodatschi.class.getResource("tamodatschi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1152, 624);
        this.scene = scene;
        stage.setMinWidth(1152);
        stage.setMinHeight(624);
        stage.setTitle("Tamodatschi");
        stage.setScene(scene);
        stage.show();
    }

    public void initGame() {
        launch();
    }

    public Tamodatschi() {

    }
}