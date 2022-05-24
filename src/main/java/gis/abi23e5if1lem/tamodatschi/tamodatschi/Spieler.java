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
        private List essen;
        private int posX;
        private int poxY;
        private int geld;
        List<Essen> list = new ArrayList<Essen>();
        public Spieler () {}

        public int getLeben(){return leben;}

        public void setLeben(int leben){this.leben = leben;}

        public int getAngriffskraft(){return angriffskraft;}

        public void setAngriffskraft(int angriffskraft){this.angriffskraft = angriffskraft;}

        public int getVerteidigung(){return verteidigung;}

        public void setVerteidigung(int verteidigung){this.verteidigung = verteidigung;}

        public List getEssen() {return essen;}

        public void addEssen(){list.add(Essen);}

        public void konsumiereEssen(){list.remove(Essen);}

        public int getGeld() {return geld;}

        public void setGeld(int geld) {this.geld = geld;}

}
