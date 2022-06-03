package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ort {
    private String name;
    private int positionX;
    private int positionY;
    private boolean betretbar;
    private String grafik;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isBetretbar() {
        return betretbar;
    }

    public void setBetretbar(boolean betretbar) {
        this.betretbar = betretbar;
    }

    public String getGrafik() {
        return grafik;
    }

    public void setGrafik(String grafik) {
        this.grafik = grafik;
    }

    public Ort(String name, int x, int y, String grafik) {
        this.name = name;
        this.positionX = x;
        this.positionY = y;
        this.grafik = grafik;
    }
}
