package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Random;

public class BossFight extends Ort{
    private Pane fightPane;
    private ImageView bossBild;
    private ImageView charakterBild;
    private Slider slider;
    private TextArea dialog;
    private Button attack_button;
    private Button flee_button;
    private Boss boss = new Boss(100, 5, 10);
    private Stage stage;

    private String bossImage = getClass().getResource("images/Villain.png").toString();
    private String playerImage = getClass().getResource("images/iGoSleep.jpg").toString();

    public BossFight(int x, int y) {
        super(x, y);
    }
    public BossFight(int x, int y, String bossGrafik) {
        super(x, y);
        bossImage = bossGrafik;
    }
    public BossFight(int x, int y, String bossGrafik, String spielerGrafik) {
        super(x, y);
        bossImage = bossGrafik;
        playerImage = spielerGrafik;
    }

    public void start() {
        Pane root = new Pane();

        //KampfPane
        fightPane = new Pane();
        fightPane.setLayoutX(10);
        fightPane.setLayoutY(10);
        fightPane.setPrefHeight(440);
        fightPane.setPrefWidth(390);
        fightPane.setBackground(Background.fill(Paint.valueOf("333333")));
        root.getChildren().add(fightPane);

        //Boss

        //BossBld
        bossBild = new ImageView(new Image(bossImage));
        bossBild.setLayoutX(160);
        bossBild.setLayoutY(30);
        bossBild.setFitHeight(200);
        bossBild.setFitWidth(200);
        fightPane.getChildren().add(bossBild);

        //CharakterBild
        charakterBild = new ImageView(new Image(playerImage));
        charakterBild.setLayoutX(30);
        charakterBild.setLayoutY(210);
        charakterBild.setFitHeight(200);
        charakterBild.setFitWidth(200);
        fightPane.getChildren().add(charakterBild);

        //Slieder
        slider = new Slider(0, 1, 0.5);
        slider.setLayoutX(420);
        slider.setLayoutY(260);
        slider.setPrefHeight(20);
        slider.setPrefWidth(450);
        root.getChildren().add(slider);

        //Dialog
        dialog = new TextArea();
        dialog.setLayoutX(420);
        dialog.setLayoutY(20);
        dialog.setPrefHeight(200);
        dialog.setPrefWidth(440);
        dialog.setEditable(false);
        root.getChildren().add(dialog);

        //Attack
        attack_button = new Button("Angreifen");
        attack_button.setLayoutX(420);
        attack_button.setLayoutY(300);
        attack_button.setPrefHeight(120);
        attack_button.setPrefWidth(220);
        attack_button.setOnAction(e -> attack());
        root.getChildren().add(attack_button);

        //Flee
        flee_button = new Button("Fliehen");
        flee_button.setLayoutX(650);
        flee_button.setLayoutY(300);
        flee_button.setPrefHeight(120);
        flee_button.setPrefWidth(220);
        flee_button.setOnAction(e -> this.stage.hide());
        root.getChildren().add(flee_button);

        //Erstellen von Scene und Stage
        Scene scene = new Scene(root, 884, 462);
        stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }

    private void attack() {
        dialog.appendText("Angriff mit " + slider.getValue() + "\n");
        Random rd = new Random();
        double a = rd.nextDouble(141) / 100D;
        int schaden = (int) Math.round(
                (Math.log(
                        Main.tdi.getSpieler().getAngriffskraft() /
                Math.pow(slider.getValue(), 0.05)
                ) * Math.pow(
                        Math.pow(slider.getValue() - 1, 2) + 1, 5
                ) * Math.pow(
                        slider.getValue() / 2, a
                    )
                ) *5);
        this.boss.setLeben(this.boss.getLeben() - schaden - this.boss.getVerteidigung());
        this.dialog.appendText(String.valueOf(this.boss.getLeben()));
        if (this.boss.getLeben() <= 0) {
            Spielfeld spf = Main.tdi.getFeld();
            int textureID = getMatchingTexture(this.getPositionX(), this.getPositionY());
            spf.applyTexture(this.getPositionX(), this.getPositionY(), spf.getTextures()[textureID]);
            spf.applyBounds(this.getPositionX(),this.getPositionY(), false);
            spf.removeOrt(this.getPositionX(), this.getPositionY());
        }
    }

    private int getMatchingTexture(int positionX, int positionY) {

        return 255;

    }
}

class Boss {
    private int leben;
    private final int verteidigung;
    private final int angriff;

    public Boss(int leben, int verteidigung, int angriff) {
        this.leben = leben;
        this.verteidigung = verteidigung;
        this.angriff = angriff;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public int getVerteidigung() {
        return verteidigung;
    }

    public int getAngriff() {
        return angriff;
    }
}