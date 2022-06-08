package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class SchereSteinPapier {

    public void start() {
        GridPane root = new GridPane();
        root.setHgap(20);
        root.setVgap(20);
        root.setAlignment(Pos.CENTER);
        GridPane.setHalignment(root, HPos.CENTER);
        GridPane.setValignment(root, VPos.CENTER);

        Label label = new Label("Wähle eine Aktion aus");
        label.setPrefWidth(180);
        root.add(label, 1, 0);
        label.setAlignment(Pos.CENTER);

        Label symbol1 = new Label();
        symbol1.setScaleX(-1);
        root.add(symbol1, 0, 0);

        Label symbol2 = new Label();
        root.add(symbol2, 2, 0);

        Button button_schere = new Button("Schere");
        button_schere.setPrefWidth(60);
        root.add(button_schere, 0, 1);
        button_schere.setOnAction(e -> {
            if (fight(0, root, symbol1, symbol2) == 1) {
                label.setText("Du hast gewonnen.");
                label.setTextFill(Color.GREEN);
                Main.tdi.spieler.setGeld(Main.tdi.spieler.getGeld() + 3);
            } else if(fight(0, root, symbol1, symbol2) == 2){
                label.setText("Es gibt keinen Sieger");
                label.setTextFill(Color.VIOLET);
                Main.tdi.spieler.setGeld(Main.tdi.spieler.getGeld() + 1);
            } else {
                label.setText("Du hast verloren.");
                label.setTextFill(Color.RED);
            }
        });
        button_schere.setPrefWidth(220);

        Button button_stein = new Button("Stein");
        button_stein.setPrefWidth(60);
        root.add(button_stein, 1, 1);
        button_stein.setOnAction(e -> {
            if (fight(1, root, symbol1, symbol2) == 1) {
                label.setText("Du hast gewonnen.");
                label.setTextFill(Color.GREEN);
            } else if(fight(1, root, symbol1, symbol2) == 2){
                label.setText("Es gibt keinen Sieger");
                label.setTextFill(Color.VIOLET);
            }  else {
                label.setText("Du hast verloren.");
                label.setTextFill(Color.RED);
            }
        });
        button_stein.setPrefWidth(220);

        Button button_papier = new Button("Papier");
        button_papier.setPrefWidth(60);
        root.add(button_papier, 2, 1);
        button_papier.setOnAction(e -> {
            if (fight(2, root, symbol1, symbol2) == 1) {
                label.setText("Du hast gewonnen.");
                label.setTextFill(Color.GREEN);
            } else if(fight(2, root, symbol1, symbol2) == 2){
                label.setText("Es gibt keinen Sieger");
                label.setTextFill(Color.VIOLET);
            } else {
                label.setText("Du hast verloren.");
                label.setTextFill(Color.RED);
            }
        });
        button_papier.setPrefWidth(220);

        Scene scene = new Scene(root, 800, 500);
        Stage stage = new Stage();
        stage.setTitle("Schere Stein Papier");
        stage.setScene(scene);
        stage.show();
    }

    private int fight(int x, GridPane gp, Label symbol2, Label symbol1) {
        Random rd = new Random();
        switch(rd.nextInt(3)) {
            case 0:
                symbol1.setGraphic(new ImageView(new Image(getClass().getResource("images/Schere.jpg").toString())));

                switch(x) {
                    case 0:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Schere.jpg").toString())));
                        return 2;
                    case 1:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Stein.jpg").toString())));
                        return 1;
                    case 2:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Papier.jpg").toString())));
                        return 0;
                    default:
                        return 0;
                }
            case 1:
                symbol1.setGraphic(new ImageView(new Image(getClass().getResource("images/Stein.jpg").toString())));

                switch(x) {
                    case 0:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Schere.jpg").toString())));
                        return 0;
                    case 1:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Stein.jpg").toString())));
                        return 2;
                    case 2:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Papier.jpg").toString())));
                        return 1;
                    default:
                        return 0;
                }
            case 2:
                symbol1.setGraphic(new ImageView(new Image(getClass().getResource("images/Papier.jpg").toString())));

                switch(x) {
                    case 0:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Schere.jpg").toString())));
                        return 1;
                    case 1:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Stein.jpg").toString())));
                        return 0;
                    case 2:
                        symbol2.setGraphic(new ImageView(new Image(getClass().getResource("images/Papier.jpg").toString())));
                        return 2;
                    default:
                        return 0;
                }
        }
        return 0;
    }
}
