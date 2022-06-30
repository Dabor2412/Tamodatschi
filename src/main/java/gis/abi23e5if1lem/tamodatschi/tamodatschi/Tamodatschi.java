package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Tamodatschi extends Application {
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
    public Label labelLive;
    @FXML
    public ImageView logo;
    private static Spieler spieler;
    private static Spielfeld feld;

    @FXML
    protected void onStartGameButtonClick(Event e) {
        ((Button) e.getSource()).setVisible(false);
        logo.setVisible(false);

        labelHunger.setVisible(true);
        labelPlayer.setVisible(true);
        labelMoney.setVisible(true);
        labelFood.setVisible(true);
        labelLive.setVisible(true);
        rectangleleft.setVisible(false);

        pane.getScene().addEventHandler(KeyEvent.KEY_PRESSED, event -> onKeyDown(event));

        getFeld().initDrawMap(pane);
    }

    @FXML
    protected void onClickFood(Event evt) {
        try {
            spieler.konsumiereEssen();

            //Extra Essen wird zu Leben
            if (spieler.getHunger() > 100) {
                int saturated = spieler.getHunger() - 100;
                spieler.setLeben(spieler.getLeben() + (saturated / 5));
                spieler.setHunger(100);
            }

            labelLive.setText("Leben: " + spieler.getLeben());
            labelHunger.setText("Hunger: " + spieler.getHunger());
            labelFood.setText("Essen:");
            for (Essen es : spieler.getEssen()
            ) {
                labelFood.setText(labelFood.getText() + "\n" + es.getName());
            }
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void onKeyDown(KeyEvent kev){
        labelMoney.setText("Geld: " + spieler.getGeld());
        labelHunger.setText("Hunger: " + spieler.getHunger());
        labelLive.setText("Leben: " + spieler.getLeben());
        labelPlayer.setAlignment(Pos.TOP_LEFT);
        labelPlayer.setText("Spieler Inventar:");
        for (String s: spieler.getItems()
             ) {
            labelPlayer.setText(labelPlayer.getText() + "\n" + s);
        }
        labelFood.setAlignment(Pos.TOP_LEFT);
        labelFood.setText("Essen:");
        for (Essen es: spieler.getEssen()
        ) {
            labelFood.setText(labelFood.getText() + "\n" + es.getName());
        }
        switch (kev.getText()) {
            case "w" :
            case "W":
                getFeld().movePlayer(0,-1);
                break;
            case "a" :
            case "A":
                getSpieler().setRotated(true);
                getFeld().movePlayer(-1,0);
                break;
            case "s" :
            case "S":
                getFeld().movePlayer(0,1);
                break;
            case "d" :
            case "D":
                getSpieler().setRotated(false);
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