package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NoelSpricht {
    public void start() {
        HBox root = new HBox();

        Label label = new Label("Hallo Welt");
        root.getChildren().add(label);

        GridPane gp = new GridPane();
        root.getChildren().add(gp);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public NoelSpricht(){

    }
}
