package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Spielfeld {

    protected String grafik = getClass().getResource("images/grass.png").toString();
    protected String tree = getClass().getResource("images/Sakura_tree_oben.png").toString();

    private static ImageView[][] map = new ImageView[42][26];
    private static Ort[][] mapOrte = new Ort[42][26];
    private static ImageView player;

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
                ImageView imv = new ImageView(new Image(grafik));
                imv.setFitWidth(24);
                imv.setFitHeight(24);
                imv.setX(i * 24);
                imv.setY(j * 24);
                pane.getChildren().add(imv);
            }
        }

        player = new ImageView(new Image(getClass().getResource("images/iGoSleep.jpg").toString()));
        player.setFitHeight(24);
        player.setFitWidth(24);
        player.setX(Main.tdi.spieler.getPosX() * 24);
        player.setY(Main.tdi.spieler.getPosY() * 24);

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
                    player.setX(Main.tdi.spieler.getPosX() * 24);
                    player.setY(Main.tdi.spieler.getPosY() * 24);

                    return;
                }
                ImageView imv = ((ImageView) node);

                int posX = (int) (imv.getX() / 24);
                int posY = (int) (imv.getY() / 24);

                imv.setImage(map[posX][posY].getImage());
            }
        }
    }

    /**
     * Generates an empty map of sand
     */
    public void genMap(){
        Random rd = new Random();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = new ImageView();
                    if (rd.nextInt(100) <= 95) {
                        map[i][j].setImage(new Image(grafik));
                    } else {
                        map[i][j].setImage(new Image(tree));
                    }
                        map[i][j].setFitWidth(24);
                        map[i][j].setFitHeight(24);
                        map[i][j].setX(i * 24);
                        map[i][j].setY(j * 24);
                }
            }
    }

    /**
     * Add the texture of a special place to the map
     * @param place
     */
    public void applyOrt(Ort place){
        map[place.positionX][place.positionY] = new ImageView(new Image(place.grafik));
        mapOrte[place.positionX][place.positionY] = place;
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

}
