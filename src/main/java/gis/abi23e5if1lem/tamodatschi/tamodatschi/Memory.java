package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Memory {
    //Deklaration der Anzahl an Paaren und Reihen bei Memory!
    private static final int pairs = 8;
    private static final int rows = 4;

    private Label label = new Label();

    private Card selected = null;
    private int zaehler = 2;
    private int paarzaehler = 0;
    private int area;

    public void start(int area){
        //Erstellung des Feldes und der Szene wo Memory läuft
        this.area = area;
        Pane root = new Pane();

        Scene scene = new Scene(root, 600, 600);
        Stage stage = new Stage();
        stage.setTitle("Memory");
        stage.setScene(scene);
        stage.show();

        label.setPrefWidth(180);
        label.setLayoutX(300);
        label.setLayoutY(100);
        root.getChildren().add(label);
        label.setAlignment(Pos.CENTER);
        label.setText("Du hast Memory betreten!");
        //Die Karten kriegen eine Char als Text zugewiesen geht von A bis H hoch
        char c = 'A';
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < pairs; i++) {
            cards.add(new Card(String.valueOf(c)));
            cards.add(new Card(String.valueOf(c)));
            c++;
        }
        // Karten werden gemischt
        Collections.shuffle(cards);

        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            card.setTranslateX(50 * (i % rows));
            card.setTranslateY(50 *(i / rows));
            root.getChildren().add(card);
        }
    }
    //Klasse Karten um die Objekte zu erstellen
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
        //Abfrage in welchem Status des Spiels wir uns befinden
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
        // Falls eine Karte geöffnet wird, wird der Text Sichtbar gemacht!
        public boolean isOpen(){
            return text.getOpacity() == 1;
        }


        public void open(Runnable action){
            // Text wird mit einer Animation geöffnet
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(1);
            ft.setOnFinished(e -> action.run());
            ft.play();
        }

        public void close(){
            //Text wird unsichtbar gemacht!
            text.setOpacity(0);
        }

        public boolean gleichesBild(Card other){
            // Die If Abfrage läuft wenn sich zwei Inhalte der Karten gleichen, hier werden die Paare mitgezählt und die Karten nicht mehr anklickbar gemacht
            if(text.getText().equals(other.text.getText())){
                paarzaehler++;
                selected.setDisable(true);
                other.setDisable(true);
                if(paarzaehler == pairs){
                    //Wenn der Zähler von den Paaren auf 8 steht, gerade die maximale Anzahl der Paare,dann wird diese If Abfrage ausgeführt
                    label.setText("Du hast gewonnen!");
                    Main.tdi.spieler.setGeld(Main.tdi.spieler.getGeld() + 10 * area);
                }
            }
            return text.getText().equals(other.text.getText());
        }
    }
}