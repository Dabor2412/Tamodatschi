package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ort {
    protected String name;
    protected int positionX;
    protected int positionY;
    protected boolean betretbar;
    protected String grafik = getClass().getResource("images/japanese_door.png").toString();
    public boolean getBetretbar() {
        return this.betretbar;
    }
    public void setBetretbar(boolean betretbar) {
        this.betretbar = betretbar;
    }
    public Ort(String name, int x, int y) {
        this.name = name;
        this.positionX = x;
        this.positionY = y;
    }
}
