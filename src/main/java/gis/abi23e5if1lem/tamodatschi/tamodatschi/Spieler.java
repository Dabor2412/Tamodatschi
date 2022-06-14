package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
        private String name;
        private int leben;
        private int angriffskraft;
        private int verteidigung;
        private int hunger;
        private int posX = 0;
        private int posY = 0;
        private int geld;
        List<Essen> essen = new ArrayList<>();
        List<String> item = new ArrayList<>();

        public Spieler () {
                this.geld = 10;
        }

        public int getLeben(){
                return leben;
        }

        public void setLeben(int leben){
                this.leben = leben;
        }

        public int getHunger() {return hunger;}

        public void setHunger(int hunger) {this.hunger = hunger;}

        public int getAngriffskraft(){
                return angriffskraft;
        }

        public void setAngriffskraft(int angriffskraft){
                this.angriffskraft = angriffskraft;
        }

        public int getVerteidigung(){
                return verteidigung;
        }

        public void setVerteidigung(int verteidigung){
                this.verteidigung = verteidigung;
        }

        public List getEssen() {
                return essen;
        }

        public void addEssen(Essen gericht){
                essen.add(gericht);
        }

        public void konsumiereEssen(Essen gericht){
                essen.remove(gericht);
        }

        public List getItems() {
                return item;
        }

        public void addItem(String name) {
                item.add(name);
        }

        public void removeItem(String name) {
                item.remove(name);
        }

        public int getGeld() {
                return geld;
        }

        public void setGeld(int geld) {
                this.geld = geld;
        }

        public int getPosX() {
                return posX;
        }

        public void setPosX(int posX) {
                this.posX = posX;
        }

        public int getPosY() {
                return posY;
        }

        public void setPosY(int posY) {
                this.posY = posY;
        }
}
