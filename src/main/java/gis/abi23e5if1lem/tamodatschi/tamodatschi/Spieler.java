package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.control.SpinnerValueFactory;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
        private String name;
        private int leben;
        private int angriffskraft;
        private int verteidigung;
        private int hunger;
        private int posX;
        private int poxY;
        private int geld;
        List<Essen> essen = new ArrayList();
        public Spieler () {

        }

        public int getLeben(){
                return leben;
        }

        public void setLeben(int leben){
                this.leben = leben;
        }

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

        public int getPoxY() {
                return poxY;
        }

        public void setPoxY(int poxY) {
                this.poxY = poxY;
        }
}
