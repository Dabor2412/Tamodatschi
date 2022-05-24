package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Spielfeld {

    protected String grafik = getClass().getResource("images/sand.jpg").toString();

    private ImageView[][] map = new ImageView[64][36];
    private ImageView player;

    /**
     * Class constructor
     * @param isInit Sets whether JavaFX has already started
     */
    public Spielfeld(boolean isInit) {
        if (isInit) {
            genMap();
        }
    }

    /**
     * Draws the map onto the screen
     * @param pane The main JavaFX pane which should contain the ImageView's
     */
    public void initDrawMap(Pane pane){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                pane.getChildren().add(map[i][j]);
            }
        }

        player = new ImageView(new Image(getClass().getResource("images/iGoSleep.jpg").toString()));
        player.setFitHeight(16);
        player.setFitWidth(16);
        player.setX(Main.tdi.spieler.getPosX() * 16);
        player.setY(Main.tdi.spieler.getPosY() * 16);

        pane.getChildren().add(player);
    }

    /**
     * Draws changed parts of the map on the screen
     * @param pane The main JavaFX pane containing the ImageView's
     */
    public void drawMap(Pane pane){
        for (Node node: pane.getChildren()
             ) {
            if (node instanceof ImageView) {
                if(node.equals(player)){
                    player.setX(Main.tdi.spieler.getPosX() * 16);
                    player.setY(Main.tdi.spieler.getPosY() * 16);

                    return;
                }
                ImageView imv = ((ImageView) node);

                int posX = (int) (imv.getX() / 16);
                int posY = (int) (imv.getY() / 16);

                imv.setImage(map[posX][posY].getImage());
            }
        }
    }

    /**
     * Generates an empty map of sand
     */
    public void genMap(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new ImageView(new Image(grafik));
                map[i][j].setFitWidth(16);
                map[i][j].setFitHeight(16);
                map[i][j].setX(i * 16);
                map[i][j].setY(j * 16);
            }
        }
    }

    /**
     * Add the texture of a special place to the map
     * @param place
     */
    public void applyOrt(Ort place){
        ImageView imv = map[place.positionX][place.positionY];

        imv.setImage(new Image(place.grafik));
        imv.setFitHeight(16);
        imv.setFitWidth(16);

        imv.setX(16 * place.positionX);
        imv.setY(16 * place.positionY);
    }

    public void movePlayer(){
        Spieler sp = Main.tdi.spieler;
    }

    public ImageView[][] getMap() {
        return map;
    }

    public void setMap(ImageView[][] map) {
        this.map = map;
    }

    public void setMapPoint(ImageView o, int posX, int posY){
        map[posX][posY] = o;
    }

}
