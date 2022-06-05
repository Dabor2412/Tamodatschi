package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;


public class Memory {

    private static final int pairs = 8;
    private static final int rows = 4;


    private Card selected = null;
    private int zaehler = 2;

    public void start(){

        Pane root = new Pane();

        Scene scene = new Scene(root, 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Memory");
        stage.setScene(scene);
        stage.show();

        char c = 'A';
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < pairs; i++) {
            cards.add(new Card(String.valueOf(c)));
            cards.add(new Card(String.valueOf(c)));
            c++;
        }

        Collections.shuffle(cards);

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            card.setTranslateX(50 * (i % rows));
            card.setTranslateY(50 *(i / rows));
            root.getChildren().add(card);
        }
    }

    private class Card extends StackPane {
        private Text text = new Text();

        public Card(String image) {
            Rectangle border = new Rectangle(50, 50);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            text.setText(image);
            text.setFont(Font.font(30));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(this::Logik);
            close();
        }
        public void Logik(MouseEvent event){
            if (isOpen() || zaehler == 0) {
                zaehler --;
                return;
            }

            if (selected == null) {
                selected = this;
                open(() -> {});
            } else {
                open(() -> {
                    if(!gleichesBild(selected)) {
                        selected.close();
                        this.close();
                    }

                    selected = null;
                    zaehler = 2;
                });
            }
        }

        public boolean isOpen(){
            return text.getOpacity() == 1;
        }


        public void open(Runnable action){
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(1);
            ft.setOnFinished(e -> action.run());
            ft.play();
        }

        public void close(){
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(0);
            ft.play();
        }

        public boolean gleichesBild(Card other){
            return text.getText().equals(other.text.getText());
        }
    }
}