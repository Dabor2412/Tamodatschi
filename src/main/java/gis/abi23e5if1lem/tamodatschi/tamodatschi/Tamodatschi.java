package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Tamodatschi extends Application {

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
    public ImageView logo;
    private static Spieler spieler;
    private static Spielfeld feld;

    // Test variables:
    Ort testOrt = new Ort( 7,16, getClass().getResource("images/banan.png").toString());
    Minigame testMin = new Minigame(2, 5, getClass().getResource("images/lootbox.png").toString(), 1);
    // End
    @FXML
    protected void onStartGameButtonClick(Event e) {
        ((Button) e.getSource()).setVisible(false);
        getFeld().initDrawMap(pane);
    }

    private void onKeyDown(KeyEvent kev){
       labelMoney.setText("Geld: " + spieler.getGeld());
       labelHunger.setText("Hunger: " + spieler.getHunger());
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
        }

        if(pane != null) {
            getFeld().drawMap(pane);
        }
    }


    public Tamodatschi() {
        spieler = new Spieler();
        feld = new Spielfeld(false, pane);
    }

    public static Spieler getSpieler() {
        return spieler;
    }

    public static Spielfeld getFeld() {
        return feld;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Tamodatschi.class.getResource("tamodatschi.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1152, 624);
        this.scene = scene;
        scene.setOnKeyPressed(this::onKeyDown);
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