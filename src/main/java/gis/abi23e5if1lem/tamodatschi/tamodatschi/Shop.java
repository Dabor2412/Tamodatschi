package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop extends Application {

    private List<Essen> inventar = new ArrayList();
    public Shop(){

    }

    @Override
    public void start(Stage stage) throws Exception {

    }

    private void lootbox1(int gross){
        Random zg = new Random();//ein Zufalsgeneratorobjekt wird erstellt
    spieler.setGeld(spieler.getGeld()-2*Math.pow(gross,2)); //hier Geld festlegen//Preis wird abgebucht
    int boost=Math.round(Math.pow(2,gross)*1000/(zg.nextInt(900)+100));//Größe der Box wird zufällig festgelegt
    switch (zg.nextInt(3)+1) {//Art der Box wird zufällig festgelegt
      case 1 : 
        spieler.setAngrifskraft(spieler.getAngrifskraft()+boost);//Atribut wird geändert
        //hier Label schrift  einstellen
        break;
      case  2: 
         spieler.setVerteidigung(spieler.getVerteidigung()+boost);//Atribut wird geändert
        //hier Label schrift  einstellen
        break;
       case 3: 
         spieler.setLeben(spieler.getLeben()+boost);//Atribut wird geändert
        //hier Label schrift  einstellen
        break;
      default: 
        
    } // end of switch
    }


    public void addInv(Essen gericht){
        inventar.add(gericht);
    }

    public void removeInv(Essen gericht){
        inventar.remove(gericht);
    }


}
