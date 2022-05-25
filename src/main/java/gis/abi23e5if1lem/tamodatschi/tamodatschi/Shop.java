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

    private void lootbox1(){
        Random zg = new Random();
    player.setGeld(player.getGeld-5); //hier Geld fetlegen
    int boost=Math.round(1000/(zg.nextInt(900)+100));
    switch (zg.nextInt(3)+1) {
      case 1 : 
        player.setAngrifskraft(player.getAngrifskraft()+boost);
        //hier Label schrift  einstellen
        break;
      case  2: 
         player.setVerteidigung(player.getVerteidigung()+boost);
        //hier Label schrift  einstellen
        break;
       case 3: 
         player.setLeben(player.getLeben()+boost);
        //hier Label schrift  einstellen
        break;
      default: 
        
    } // end of switch
    }

    private void lootbox2(){
        Random zg = new Random();
    player.setGeld(player.getGeld-8); //hier Geld fetlegen
    int boost=Math.round(2000/(zg.nextInt(900)+100));
    switch (zg.nextInt(3)+1) {
      case 1 : 
        player.setAngrifskraft(player.getAngrifskraft()+boost);
        //hier Label schrift  einstellen
        break;
      case  2: 
         player.setVerteidigung(player.getVerteidigung()+boost);
        //hier Label schrift  einstellen
        break;
       case 3: 
         player.setLeben(player.getLeben()+boost);
        //hier Label schrift  einstellen
        break;
      default: 
        
    } // end of switch
    }

    private void lootbox3(){
        Random zg = new Random();
    player.setGeld(player.getGeld-5); //hier Geld fetlegen
    int boost=Math.round(1000/(zg.nextInt(900)+100));
    switch (zg.nextInt(3)+1) {
      case 1 : 
        player.setAngrifskraft(player.getAngrifskraft()+boost);
        //hier Label schrift  einstellen
        break;
      case  2: 
         player.setVerteidigung(player.getVerteidigung()+boost);
        //hier Label schrift  einstellen
        break;
       case 3: 
         player.setLeben(player.getLeben()+boost);
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
