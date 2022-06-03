package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;


public class Memory {

    public void start() {
        Pane root = new Pane();

        Scene scene = new Scene(root, 800, 500);
        Stage stage = new Stage();
        stage.setTitle("Memory");
        stage.setScene(scene);
        stage.show();

        for(int i = 0; i < 4;i++ ) {
            for (int j = 0; j < 4; j++) {
                Button b = new Button();
                b.setLayoutX(i * 65 + 270);
                b.setLayoutY(j * 65 + 120);
                b.setPrefSize(60,60);
                root.getChildren().add(b);


            }
        }

    }

    public void ueberpruefung(){

    }
}
