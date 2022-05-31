package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    final List<Essen> inventar = new ArrayList<>();
    private Stage primaryStage;

    public void start(){
        this.primaryStage = new Stage();

        this.inventar.add(new Essen("Steak", 1, 1));
        this.inventar.add(new Essen("Kuchen", 1, 1));
        this.inventar.add(new Essen("Pudding", 1, 1));
        this.inventar.add(new Essen("Mandarine", 1, 1));
        this.inventar.add(new Essen("Gummibärchen", 1, 1));

        Scene scene = new Scene(new Pane(), 500, 500);
        this.primaryStage.setTitle("Shop");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();

        loadInterface();
    }

    private void buyItem(Essen essen0) {
        //bezahlen und zum Inventar
        Main.tdi.spieler.setGeld(Main.tdi.spieler.getGeld() - essen0.getPrice());
        Main.tdi.spieler.addEssen(essen0);

        //Objekt aus Liste entfernen
        this.inventar.remove(essen0);

        //neu laden
        loadInterface();
        System.out.println(this.inventar.size());
    }

    private void loadInterface() {
        GridPane root_new = new GridPane();
        root_new.setAlignment(Pos.CENTER);
        root_new.setVgap(20);
        root_new.setHgap(30);

        Label temp = new Label("");
        temp.setPrefWidth(180);
        root_new.add(temp, 0, 0);
        root_new.add(new Label("Buffs"), 1, 0);
        root_new.add(new Label("Preis"), 2, 0);

        for (int i = 0; i < this.inventar.size(); i++) {
            Essen essen = this.inventar.get(i);
            Button tempi = new Button(this.inventar.get(i).getName());
            tempi.setOnAction(e -> buyItem(essen));
            tempi.setPrefWidth(180);
            root_new.add(tempi, 0, (i+1));                                                        //Name
            root_new.add(new Label(String.valueOf(this.inventar.get(i).getBuff())), 1, (i+1));     //Buffs
            root_new.add(new Label(String.valueOf(this.inventar.get(i).getPrice())), 2, (i+1));     //Preis
        }

        Label label1 = new Label();
        root_new.add(label1,1, this.inventar.size() + 1);
        Button lootbox = new Button("Lootbox");
        root_new.add(lootbox,0, this.inventar.size() + 1 );
        lootbox.setOnAction(e -> lootbox1(1, label1));
        lootbox.setPrefWidth(180);

        this.primaryStage.setScene(new Scene(root_new, 750, 600));
        this.primaryStage.show();
    }

    private void lootbox1(int gross, Label label1) {
        Random zg = new Random(); //ein Zufalsgeneratorobjekt wird erstellt
        Main.tdi.spieler.setGeld((int) (Main.tdi.spieler.getGeld()-2*Math.pow(gross,2))); //hier Geld festlegen//Preis wird abgebucht
        int boost = (int) Math.round(Math.pow(2,gross)*1000/(zg.nextInt(900)+100)); //Größe der Box wird zufällig festgelegt
        switch (zg.nextInt(3)+1) {//Art der Box wird zufällig festgelegt
            case 1 :
                Main.tdi.spieler.setAngriffskraft(Main.tdi.spieler.getAngriffskraft()+boost); //Atribut wird geändert
               label1.setText("Du hast ein Angrifskraftboost von "+ boost+" gewonnen");
                break;
            case  2:
                Main.tdi.spieler.setVerteidigung(Main.tdi.spieler.getVerteidigung()+boost); //Atribut wird geändert
                label1.setText("Du hast ein Verteidigungsboost von "+ boost+" gewonnen");
                break;
            case 3:
                Main.tdi.spieler.setLeben(Main.tdi.spieler.getLeben()+boost); //Atribut wird geändert
                label1.setText("Du hast eine erhöhung deiner Leben um "+" gewonnen");
                break;
            default:

        } // end of switch
    }

    public void addInv(Essen gericht){ inventar.add(gericht); }

    public void removeInv(Essen gericht){
        inventar.remove(gericht);
    }
}
