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

        ImageView apfel = new ImageView(new Image(getClass().getResource("images/apple.jpg").toString()));
        apfel.setFitHeight(45);
        apfel.setFitWidth(45);

        ImageView orange = new ImageView(new Image(getClass().getResource("images/Orange.jpg").toString()));
        orange.setFitWidth(45);
        orange.setFitHeight(45);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button b = new Button();
                b.setLayoutX(i * 65 + 270);
                b.setLayoutY(j * 65 + 270);
                b.setPrefSize(60, 60);

                root.getChildren().add(b);
                buttons[j][i] = b;

                b.setOnAction(e -> {
                    Random rd = new Random();
                    if (rd.nextInt(100) >= 50) {
                        b.setGraphic(apfel);
                    } else {
                        b.setGraphic(orange);
                    }
                });
            }
        }
    }
}