package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//Shop ist eine Unterklasse von Ort
public class Shop extends Ort{
    final List<Essen> inventar = new ArrayList<>();
    private Stage primaryStage;
    //Konstruktor0
    public Shop(int x, int y) {
        super(x, y);
    }
    //Konstrucktor1
    public Shop(int x, int y, String grafik) {
        super(x, y, grafik);
    }
    //Shopfenster wird geöffnet und Essensobjekte werden erstellt 
    public void start(){
        this.primaryStage = new Stage();
        this.inventar.clear();
        this.inventar.add(new Essen("Steak", 20, 1));
        this.inventar.add(new Essen("Kuchen", 20, 1));
        this.inventar.add(new Essen("Pudding", 20, 1));
        this.inventar.add(new Essen("Mandarine", 20, 1));
        this.inventar.add(new Essen("Gummibärchen", 20, 1));

        Scene scene = new Scene(new Pane(), 500, 500);
        scene.setOnKeyPressed(e -> {
            System.out.println(e.getSource());
            if (e.getCode().toString() == "ESCAPE") {
                primaryStage.close();
            }
        });
        this.primaryStage.setOnCloseRequest(we -> {
            for(int i = 0; i < inventar.size(); i++) {
                inventar.remove(inventar.get(0));
            }
        });
        this.primaryStage.setTitle("Shop");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();

        loadInterface();
    }

    private void buyItem(Essen essen0) {
        //bezahlen und zum Inventar
        if (istPleite(essen0.getPrice())){
            Main.tdi.getSpieler().setGeld(Main.tdi.getSpieler().getGeld() - essen0.getPrice());
            Main.tdi.getSpieler().addEssen(essen0);

            //Objekt aus Liste entfernen
            this.inventar.remove(essen0);
        }

        //neu laden
        loadInterface();
    }
    //Interface wird neu geladen
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

        Scene scene = new Scene(root_new, 750, 600);

        this.primaryStage.setScene(scene);
        this.primaryStage.show();

        scene.setOnKeyPressed(e -> {
            System.out.println(e.getCode());
            if (e.getCode().toString() == "ESCAPE") {
                this.primaryStage.close();
            }
        });
    }
       //Lootbox kann hierrüber geöffenet werden
    private void lootbox1(int gross, Label label1) {
       if (istPleite(2*Math.pow(gross,2))){
        Random zg = new Random(); //ein Zufallsgeneratorobjekt wird erstellt
        Main.tdi.getSpieler().setGeld((int) (Main.tdi.getSpieler().getGeld()-2*Math.pow(gross,2))); //hier Geld festlegen//Preis wird abgebucht
        int boost = (int) Math.round(Math.pow(2,gross)*1000/(zg.nextInt(900)+100)); //Größe der Box wird zufällig festgelegt
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "");
        ImageView imv = new ImageView(new Image(getClass().getResource("images/lootbox.png").toString()));
        imv.setFitHeight(64);
        imv.setFitWidth(64);
        alert.setGraphic(imv);
        alert.setTitle("Lootbox");
        alert.setHeaderText("Lootbox wurde geöffnet");
        switch (zg.nextInt(3)+1) {//Art der Box wird zufällig festgelegt
            case 1 :
                Main.tdi.getSpieler().setAngriffskraft(Main.tdi.getSpieler().getAngriffskraft() + boost); //Attribut wird geändert
                alert.setContentText("Du hast das Item " + generateItemName() + " gezogen. Es erhöht deine Angriffskraft um " + boost);
                alert.show();
                break;
            case  2:
                Main.tdi.getSpieler().setHunger(Main.tdi.getSpieler().getHunger() + boost); //Attribut wird geändert
                alert.setContentText("Du hast das Item " + generateItemName() + " gezogen. Es sättigt dich um " + boost);
                alert.show();
                break;
            case 3:
                Main.tdi.getSpieler().setLeben(Main.tdi.getSpieler().getLeben() + boost); //Attribut wird geändert
                alert.setContentText("Du hast das Item " + generateItemName() + " gezogen. Es erhöht deine Leben um " + boost);
                alert.show();
                break;
            default:

        }} // end of switch
    }
    //ein Name von Items wird aus zwei Teilen zufällig generiert 
    private String generateItemName() {
        ArrayList<String> arr0 = new ArrayList<>();
        ArrayList<String> arr1 = new ArrayList<>();
        String target;
        try {
            Scanner sc0 = new Scanner(getClass().getResourceAsStream("files/itemName0.txt"));
            Scanner sc1 = new Scanner(getClass().getResourceAsStream("files/itemName1.txt"));

            while(sc0.hasNext()) {
                arr0.add(sc0.nextLine());
            }
            while(sc1.hasNext()) {
                arr1.add(sc1.nextLine());
            }
        } catch(Exception e) { e.printStackTrace(); }

        Random rd = new Random();
        target = arr0.get(rd.nextInt(arr0.size())) + " " + arr1.get(rd.nextInt(arr1.size()));
        Main.tdi.getSpieler().addItem(target);
        System.out.println(target);
        return target;
    }
    //ein Essenobyekt wird ins Inventar des Spielers hinzugefügt
    public void addInv(Essen gericht){ inventar.add(gericht); }

    public void removeInv(Essen gericht){
        inventar.remove(gericht);
    }
    //es wird kontroloiert ob ein Spieler noch genug Geld hat
    public boolean istPleite (double a){
        if (a > Main.tdi.getSpieler().getGeld()) {
            return false;
            //hier label beschreiben
        } else {
            return true;
        }
    }

}
