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
    List<String> list = new ArrayList<>();



    public void start() {
        Pane root = new Pane();

        Scene scene = new Scene(root, 800, 800);
        Stage stage = new Stage();
        stage.setTitle("Memory");
        stage.setScene(scene);
        stage.show();



        list.add("Apfel");
        list.add("Apfel");
        list.add("Orange");
        list.add("Orange");
        list.add("Melone");
        list.add("Melone");
        list.add("Paprika");
        list.add("Paprika");
        list.add("Gurke");
        list.add("Gurke");
        list.add("Birne");
        list.add("Birne");
        list.add("Banane");
        list.add("Banane");
        list.add("Tomate");
        list.add("Tomate");
        System.out.println(list);

        Collections.shuffle(list);

        System.out.println(list);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button b = new Button();
                b.setLayoutX(i * 65 + 270);
                b.setLayoutY(j * 65 + 270);
                b.setPrefSize(60, 60);

                root.getChildren().add(b);
                buttons[j][i] = b;
                b.setOnAction( e ->
                zuweisung(b)
                );
            }

        }

    }

    public void zuweisung(Button b){

        ImageView apfel = new ImageView(new Image(getClass().getResource("images/apple.jpg").toString()));
        apfel.setFitHeight(45);
        apfel.setFitWidth(45);
        ImageView orange = new ImageView(new Image(getClass().getResource("images/Orange.jpg").toString()));
        orange.setFitWidth(45);
        orange.setFitHeight(45);
        ImageView melone = new ImageView(new Image(getClass().getResource("images/Melone.jpg").toString()));
        melone.setFitWidth(45);
        melone.setFitHeight(45);
        ImageView paprika = new ImageView(new Image(getClass().getResource("images/paprika.jpg").toString()));
        paprika.setFitWidth(45);
        paprika.setFitHeight(45);
        ImageView gurke = new ImageView(new Image(getClass().getResource("images/Gurke.jpg").toString()));
        gurke.setFitWidth(45);
        gurke.setFitHeight(45);
        ImageView birne = new ImageView(new Image(getClass().getResource("images/Birne.jpg").toString()));
        birne.setFitWidth(45);
        birne.setFitHeight(45);
        ImageView banane = new ImageView(new Image(getClass().getResource("images/Banane.jpg").toString()));
        banane.setFitWidth(45);
        banane.setFitHeight(45);
        ImageView tomate = new ImageView(new Image(getClass().getResource("images/Tomate.jpg").toString()));
        tomate.setFitWidth(45);
        tomate.setFitHeight(45);

        for (int k = 0; k < 1; k++) {
            if (list.get(k).equals("Apfel")) {
                b.setGraphic(apfel);
                b.setDisable(true);
                list.remove("Apfel");
            } else if (list.get(k).equals("Orange")) {
                b.setGraphic(orange);
                b.setDisable(true);
                list.remove("Orange");
            } else if (list.get(k).equals("Melone")) {
                b.setGraphic(melone);
                b.setDisable(true);
                list.remove("Melone");
            } else if (list.get(k).equals("Paprika")) {
                b.setGraphic(paprika);
                b.setDisable(true);
                list.remove("Paprika");
            } else if (list.get(k).equals("Gurke")) {
                b.setGraphic(gurke);
                list.remove("Gurke");
            } else if (list.get(k).equals("Birne")) {
                b.setGraphic(birne);
                b.setDisable(true);
                list.remove("Birne");
            } else if (list.get(k).equals("Banane")) {
                b.setGraphic(banane);
                b.setDisable(true);
                list.remove("Banane");
            } else if (list.get(k).equals("Tomate")) {
                b.setGraphic(tomate);
                b.setDisable(true);
                list.remove("Tomate");
            }
        }
       }

       public void ueberpruefung(Button b){

       }
    }
