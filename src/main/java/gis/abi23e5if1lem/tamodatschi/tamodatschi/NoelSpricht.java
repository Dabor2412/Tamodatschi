package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class NoelSpricht {
    private int[] reihenfolge = new int[5];
    private Button[] buttonArr = new Button[4];

    public void start() {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        Label label = new Label("Hallo Welt");
        root.getChildren().add(label);

        GridPane gp = new GridPane();
        gp.setHgap(20);
        gp.setVgap(20);
        gp.setPadding(new Insets(20));
        root.getChildren().add(gp);

        for (int i = 0; i < 4; i++) {
            Button button = new Button();
            button.setPrefWidth(40);
            button.setPrefHeight(40);
            button.setOnAction(e -> {

            });
            this.buttonArr[i] = button;
            gp.add(button, i, 0);
        }

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        for (int i = 0; i < 5; i++) {
            Random rd = new Random();
            this.reihenfolge[i] = rd.nextInt(4);
        }

        for (int i = 0; i < 5; i++) {
            runde(i);
        }
    }

    private void runde(int runde) {
        for (int i = 0; i < runde; i++) {
            this.buttonArr[this.reihenfolge[i]].setStyle("-fx-background-color: lightblue");
        }
    }

    public NoelSpricht(){

    }
}
