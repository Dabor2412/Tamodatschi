package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;


public class Memory {

    int Zaehler = 0;
    private Button buttons[][] = new Button[4][4];

    public void start() {
        Pane root = new Pane();

        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();
        stage.setTitle("Memory");
        stage.setScene(scene);
        stage.show();


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button b = new Button();
                b.setLayoutX(i * 65 + 270);
                b.setLayoutY(j * 65 + 270);
                b.setPrefSize(60, 60);

                root.getChildren().add(b);
                buttons[j][i] = b;
                zuweisung(b);
            }
        }

    }

    public void zuweisung(Button b){
        Random rd = new Random();

        ImageView apfel = new ImageView(new Image(getClass().getResource("images/apple.jpg").toString()));
        apfel.setFitHeight(45);
        apfel.setFitWidth(45);
        int apple = 0;

        ImageView orange = new ImageView(new Image(getClass().getResource("images/Orange.jpg").toString()));
        orange.setFitWidth(45);
        orange.setFitHeight(45);
        int orang = 0;

        ImageView melone = new ImageView(new Image(getClass().getResource("images/Melone.jpg").toString()));
        melone.setFitWidth(45);
        melone.setFitHeight(45);
        int melon = 0;

        ImageView paprika = new ImageView(new Image(getClass().getResource("images/paprika.jpg").toString()));
        paprika.setFitWidth(45);
        paprika.setFitHeight(45);
        int paprik = 0;

        ImageView gurke = new ImageView(new Image(getClass().getResource("images/Gurke.jpg").toString()));
        gurke.setFitWidth(45);
        gurke.setFitHeight(45);
        int cucumber = 0;

        ImageView birne = new ImageView(new Image(getClass().getResource("images/Birne.jpg").toString()));
        birne.setFitWidth(45);
        birne.setFitHeight(45);
        int birn = 0;

        ImageView banane = new ImageView(new Image(getClass().getResource("images/Banane.jpg").toString()));
        banane.setFitWidth(45);
        banane.setFitHeight(45);
        int banana = 0;

        ImageView tomate = new ImageView(new Image(getClass().getResource("images/Tomate.jpg").toString()));
        tomate.setFitWidth(45);
        tomate.setFitHeight(45);
        int tomato = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (rd.nextInt(16) <= 8 && apple < 2){
                   b.setGraphic(apfel);
                    apple ++;
                } else if (rd.nextInt(16) <= 8 && orang < 2){
                    b.setGraphic(orange);
                    orang ++;
                }  else if (rd.nextInt(16) <= 8 && melon < 2){
                    b.setGraphic(melone);
                    melon ++;
                } else if (rd.nextInt(16) <= 8 && paprik < 2){
                    b.setGraphic(paprika);
                    paprik ++;
                }  else if (rd.nextInt(16) >  8 && cucumber < 2){
                    b.setGraphic(gurke);
                    cucumber ++;
                }  else if (rd.nextInt(16) >  8 && birn < 2){
                    b.setGraphic(birne);
                    birn ++;
                }  else if (rd.nextInt(16) >  8 && banana < 2){
                    b.setGraphic(banane);
                    banana ++;
                }  else if (rd.nextInt(16) >  8 && tomato < 2){
                    b.setGraphic(tomate);
                    tomato ++;
                }
                System.out.println(rd.nextInt(16));

            }
        }

       }
    }
