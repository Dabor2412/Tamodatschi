package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.Random;

public class BossFight extends Ort{
    private Pane fightPane;
    private ImageView bossBild;
    private ImageView charakterBild;
    private Slider slider;
    private TextArea dialog;
    private Label info1;
    private Label info2;
    private Label spielerLeben;
    private Label spielerAngriff;
    private Button attack_button;
    private Button flee_button;
    private ProgressBar life_indicator;
    private Boss boss = new Boss(20, 1);
    private int scale = 100 / boss.getLeben();
    private Stage stage;

    private String bossImage = getClass().getResource("images/Villain.png").toString();
    private String playerImage = getClass().getResource("images/knight.png").toString();

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

        //Slider
        slider = new Slider(0, 1, 0.5);
        slider.setLayoutX(420);
        slider.setLayoutY(260);
        slider.setPrefHeight(20);
        slider.setPrefWidth(450);
        root.getChildren().add(slider);

        //Dialog
        dialog = new TextArea();
        dialog.setLayoutX(420);
        dialog.setLayoutY(50);
        dialog.setPrefHeight(180);
        dialog.setPrefWidth(300);
        dialog.setEditable(false);
        root.getChildren().add(dialog);

        //Info text
        info1 = new Label("<-- Verteidigung");
        info1.setLayoutX(420);
        info1.setLayoutY(235);
        info1.setPrefHeight(20);
        info1.setPrefWidth(80);
        root.getChildren().add(info1);

        info2 = new Label("Angriff -->");
        info2.setLayoutX(800);
        info2.setLayoutY(235);
        info2.setPrefHeight(20);
        info2.setPrefWidth(80);
        root.getChildren().add(info2);


        //Leben
        spielerLeben = new Label("Leben: " + Main.tdi.getSpieler().getLeben());
        spielerLeben.setLayoutX(750);
        spielerLeben.setLayoutY(50);
        spielerLeben.setPrefHeight(20);
        spielerLeben.setPrefWidth(80);
        root.getChildren().add(spielerLeben);

        //Angriffskraft
        spielerAngriff = new Label("Angriff: " + Main.tdi.getSpieler().getAngriffskraft());
        spielerAngriff.setLayoutX(750);
        spielerAngriff.setLayoutY(70);
        spielerAngriff.setPrefHeight(20);
        spielerAngriff.setPrefWidth(80);
        root.getChildren().add(spielerAngriff);

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
        flee_button.setOnAction(e -> this.stage.close());
        root.getChildren().add(flee_button);

        //Lebensanzeige
        life_indicator = new ProgressBar();
        life_indicator.setLayoutX(420);
        life_indicator.setLayoutY(20);
        life_indicator.setPrefWidth(440);
        life_indicator.setProgress(1);
        life_indicator.setStyle("-fx-accent: green");
        root.getChildren().add(life_indicator);

        //Erstellen von Scene und Stage
        Scene scene = new Scene(root, 884, 462);
        stage = new Stage();
        stage.setAlwaysOnTop(true);
        stage.setScene(scene);
        stage.show();
    }

    private void attack() {
        Random rd = new Random();
        int schaden = (int) Math.ceil(Main.tdi.getSpieler().getAngriffskraft() * slider.getValue());

        if (((1D + rd.nextDouble(100)) / 50D > slider.getValue())) {
            this.boss.setLeben(this.boss.getLeben() - schaden);
            this.dialog.appendText("Du hast mit " + schaden + " Schaden getroffen\n");
        }
        this.life_indicator.setProgress(this.boss.getLeben() / 100D * scale);

        if (rd.nextDouble(1) > (1D - slider.getValue()/2)) {
            Main.tdi.getSpieler().setLeben(Main.tdi.getSpieler().getLeben() - this.boss.getAngriff());
            spielerLeben.setText("Leben: " + Main.tdi.getSpieler().getLeben());
            this.dialog.appendText("Du wurdest mit " + this.boss.getAngriff() + " Schaden getroffen\n");
        }

        if (this.boss.getLeben() <= 0) {
            Spielfeld spf = Main.tdi.getFeld();
            spf.applyTexture(this.getPositionX(), this.getPositionY(), getMatchingTexture(this.getPositionX(), this.getPositionY(), spf));
            spf.applyBounds(this.getPositionX(),this.getPositionY(), false);
            spf.removeOrt(this.getPositionX(), this.getPositionY());
            this.stage.close();
        }
    }

    private Image getMatchingTexture(int positionX, int positionY, Spielfeld feld) {
        return feld.getMapTextures()[positionX-1][positionY].getImage();
    }
}

class Boss {
    private int leben;
    private final int angriff;

    public Boss(int leben, int angriff) {
        this.leben = leben;
        this.angriff = angriff;
    }

    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }

    public int getAngriff() {
        return angriff;
    }
}