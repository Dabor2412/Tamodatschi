package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Spieler-Klasse mit den unten stehenden Attributen und entsprechenden  getter- und Settermethoden
public class Spieler {
        private int leben;
        private int angriffskraft;
        private int hunger;
        private int posX = 0;
        private int posY = 0;
        private int geld;
        private boolean rotation = false;
        //Liste des Essens
        Stack<Essen> essen = new Stack<>();
        List<String> item = new ArrayList<>();
        //Konstrucktor der Spieler erhält 16 Geld und weitere Attribute
        public Spieler () {
                this.geld = 16;
                this.angriffskraft = 5;
                this.leben = 9;
                this.hunger = 80;
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

        public Stack<Essen> getEssen() {
                return essen;
        }

        public void addEssen(Essen gericht){
                essen.push(gericht);
        }

        public void konsumiereEssen(){
                hunger += essen.pop().getBuff();
        }

        public List<String> getItems() {
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

        public boolean isRotated() {
                return rotation;
        }

        public void setRotated(boolean rotation) {
                this.rotation = rotation;
        }
}
