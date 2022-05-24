package gis.abi23e5if1lem.tamodatschi.tamodatschi;

public class Spielfeld {

    private Object[][] map = new Object[50][20];

    public Spielfeld() {

    }

    public void movePlayer(){
        Spieler sp = Main.tdi.spieler;
    }

    public Object[][] getMap() {
        return map;
    }

    public void setMap(Object[][] map) {
        this.map = map;
    }

    public void setMapPoint(Object o, int posX, int posY){
        map[posX][posY] = o;
    }

}
