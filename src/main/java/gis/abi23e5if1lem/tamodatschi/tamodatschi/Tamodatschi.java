package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Tamodatschi extends Application {

    public Scene scene;
    @FXML
    public Pane pane;
    @FXML
    public Label labelMoney;

    @FXML

    public Rectangle rectangleleft;
    @FXML
    public Label labelFood;
    @FXML
    public Label labelHunger;
    @FXML
    public Label labelPlayer;
    @FXML
    public ImageView logo;
    private static Spieler spieler;
    private static Spielfeld feld;
    @FXML
    protected void onDisplayClick(Event e) {
        System.out.println(e.getTarget().toString());
    }

    // Test variables:
    Ort testOrt = new Ort( 7,16, getClass().getResource("images/banan.png").toString());
    Minigame testMin = new Minigame(2, 5, getClass().getResource("images/lootbox.png").toString(), 1);

    // End
    @FXML
    protected void onStartGameButtonClick(Event e) {
    // Test:
        ((Button) e.getSource()).setVisible(false);
        labelHunger.setVisible(true);
        labelPlayer.setVisible(true);
        labelHunger.setVisible(true);
        labelFood.setVisible(true);
        rectangleleft.setVisible(false);

        getFeld().initDrawMap(pane);
    // End
    }
    @FXML
    protected void onTest2ButtonClick(Event e) {
    // Test:
        getFeld().applyBounds(testOrt.getPositionX(), testOrt.getPositionY(), true);
        getFeld().applyOrt(testOrt);
        getFeld().applyOrt(testMin);
        getFeld().drawMap(pane);
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
        getFeld().drawMap(pane);
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
        //Shop sp = new Shop(3,9, getClass().getResource("images/japanese_door.png").toString());
        //getFeld().applyOrt(sp);
        System.out.println(spieler.equals(Main.tdi.getSpieler()));
        System.out.println(Main.tdi.getSpieler().equals(spieler));
        System.out.println(feld.equals(Main.tdi.getFeld()));
        System.out.println(Main.tdi.getFeld().equals(feld));
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
                getFeld().movePlayer(0,-1);
                break;
            case "a" :
                getFeld().movePlayer(-1,0);
                break;
            case "s" :
                getFeld().movePlayer(0,1);
                break;
            case "d" :
                getFeld().movePlayer(1,0);
                break;
            case "y":
                onTestImageBoundaries();
                break;
        }

        if(pane != null) {
            getFeld().drawMap(pane);
        }
    }


    public Tamodatschi() {
        spieler = new Spieler();
        feld = new Spielfeld(false, pane);
    }

    public Spieler getSpieler() {
        return spieler;
    }

    public Spielfeld getFeld() {
        return feld;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Tamodatschi.class.getResource("tamodatschi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1152, 624);
        this.scene = scene;
        stage.setMinWidth(1152);
        stage.setMinHeight(624);
        stage.setResizable(false);
        stage.setTitle("Tamodatschi");
        stage.setScene(scene);
        stage.show();
    }

    public void initGame() {
        launch();
    }

}