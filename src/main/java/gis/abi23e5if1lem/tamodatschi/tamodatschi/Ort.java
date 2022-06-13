package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//Klasse mit den Attributen position x  und y sowie Graphik, dient als Superklasse für Minigame, Shop und vieleicht Bossfight. Entsprechende Setter und Getter-Methoden sind vorhanden. Es gibt zwei Konstruktoren. 
public class Ort {
    private int positionX;
    private int positionY;
    private String grafik = null;

    public String getGrafik() {
        return grafik;
    }

    public void setGrafik(String grafik) {
        this.grafik = grafik;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Ort(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public Ort(int x, int y, String grafik) {
        this.positionX = x;
        this.positionY = y;
        this.grafik = grafik;
    }
}
