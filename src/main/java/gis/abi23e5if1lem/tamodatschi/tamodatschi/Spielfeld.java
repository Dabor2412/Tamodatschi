package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;

public class Spielfeld {

    //Size of map
    private final int sizeX = 42;
    private final int sizeY = 26;

    //Load pregenerated Image for Map and one for boundaries
    /* Wie macht man eine Map:
        1. 42x26 großes Bild machen
        2. Jeden Pixel je nach Aufgabe anmalen:
            2.1. Rot, Betretbar (Alles außer 0)
            2.2. Grün, Textur (Line 40)
            2.3. Blau, Ort/Minigame (line 85)
     */

    private final String layoutTexture = getClass().getResource("images/bounds_new.png").toString();
    private String[] textures = new String[256];
    private ImageView[][] mapTextures = new ImageView[42][26];
    private Ort[][] mapOrte = new Ort[42][26];
    private Boolean[][] mapBounds = new Boolean[42][26];
    private ImageView player;

    private Pane pane;

    /**
     * Konstruktor der Klasse
     * Parameter isInit gibt an ob Tamodatschi schon gestartet worden ist
     */
    public Spielfeld(boolean isInit, Pane pane) {
        this.pane = pane;
    // Stringarray werden Bilder hinzugefügt
        textures[255] = getClass().getResource("images/grass.png").toString();
        textures[245] = getClass().getResource("images/water.png").toString();
        textures[235] = getClass().getResource("images/Sakura_tree_oben.png").toString();
        textures[225] = getClass().getResource("images/japanese_door.png").toString();
        textures[215] = getClass().getResource("images/sand.jpg").toString();
        textures[205] = getClass().getResource("images/banan.png").toString();
        textures[195] = getClass().getResource("images/sand_new.png").toString();
        textures[185] = getClass().getResource("images/oasis.png").toString();
        textures[175] = getClass().getResource("images/harbor.png").toString();
        textures[165] = getClass().getResource("images/cactus.png").toString();
        textures[145] = getClass().getResource("images/palm.png").toString();
        textures[135] = getClass().getResource("images/snow.png").toString();
        textures[125] = getClass().getResource("images/fish_pond.png").toString();;
        textures[115] = getClass().getResource("images/house.png").toString();;
        textures[105] = getClass().getResource("images/pine_tree.png").toString();;
        textures[95] =  getClass().getResource("images/train.png").toString();;
        textures[10] =  getClass().getResource("images/door.png").toString();;
        textures[5] =   getClass().getResource("images/ship_boss.png").toString();
        textures[0] =   getClass().getResource("images/Villain.png").toString();

        if (isInit) {
            initDrawMap(pane);
        }
    }

    /**
     * Zeichnet die Map auf die Pane
     */
    public void initDrawMap(Pane pane){
        this.pane = pane;
        //Dem Feld wird je nach Pixel ein Bild zugewiesen
        Image img = new Image(layoutTexture);
        PixelReader pxr = img.getPixelReader();
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                    mapBounds[i][j] = (pxr.getColor(i,j).getRed() == 0);
            }
        }

        //Auffüllung der Standardfelder ohne Aktionen
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                ImageView imv = new ImageView(new Image(textures[(int) (pxr.getColor(i,j).getGreen()*255)]));
                imv.setFitWidth(24);
                imv.setFitHeight(24);
                imv.setX(i * 24);
                imv.setY(j * 24);
                mapTextures[i][j] = imv;
                pane.getChildren().add(imv);
            }
        }

        //Bildzuweisung der Minigame und Ort/Shopfelder
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                switch ((int) (pxr.getColor(i,j).getBlue()*255)) {
                    case 1: //Normal Ort
                        mapOrte[i][j] = new Ort(i, j);
                        break;
                    case 2: //getSpieler()
                        Main.tdi.getSpieler().setPosX(i);
                        Main.tdi.getSpieler().setPosY(j);
                        break;
                    case 3: //Laden
                        mapOrte[i][j] = new Shop(i, j);
                        break;
                    case 4: //Minigame 0
                        mapOrte[i][j] = new Minigame(i, j, 0);
                        break;
                    case 5: //Minigame 1
                        mapOrte[i][j] = new Minigame(i, j, 1);
                        break;
                    case 6: //Minigame 2
                        mapOrte[i][j] = new Minigame(i, j, 2);
                        break;
                    case 7: //Boss
                        mapOrte[i][j] = new BossFight(i, j);
                        break;
                }
            }
        }
        // Spieler wird Bild zugewiesen und auf die Pane gemalt
        player = new ImageView(new Image(getClass().getResource("images/iGoSleep.jpg").toString()));
        player.setFitHeight(24);
        player.setFitWidth(24);
        player.setX(Main.tdi.getSpieler().getPosX() * 24);
        player.setY(Main.tdi.getSpieler().getPosY() * 24);
        pane.getChildren().add(player);
    }

    /**
     * Draws changed parts of the map on the screen
     * @param pane The main JavaFX pane containing the ImageView's
     */
    public void drawMap(Pane pane){
        this.pane = pane;
        for (Node node: pane.getChildren()
             ) {
            if (node instanceof ImageView) {
                if(node.equals(player)){
                    player.setX(Main.tdi.getSpieler().getPosX() * 24);
                    player.setY(Main.tdi.getSpieler().getPosY() * 24);

                    return;
                }
                ImageView imv = ((ImageView) node);

                int posX = (int) (imv.getX() / 24);
                int posY = (int) (imv.getY() / 24);

                imv.setImage(mapTextures[posX][posY].getImage());
            }
        }
    }
    //Bewegung des Spielers auf der Pane
    public void movePlayer(int chngX, int chngY){
        Spieler spieler = Main.tdi.getSpieler();
       // Wenn der Spieler keinen Hungerwert mehr hat, verliert der Spieler Leben
        if (spieler.getHunger() > 0) {
            spieler.setHunger(spieler.getHunger()-1);
        } else {
            spieler.setLeben(spieler.getLeben()-3);
        }
        // Deathscreen if Players life is lower than 1, it opens a new Alert
        if (spieler.getLeben() < 1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "");
            ImageView imv = new ImageView(new Image(getClass().getResource("images/GameOver.png").toString()));
            imv.setFitHeight(460);
            imv.setFitWidth(741);
            alert.setGraphic(imv);
            alert.setTitle("Game Over");
            alert.setHeaderText("Du bist leider verstorben");
        }
        // Überprüfung des Ortes auf den sich der Spieler bewegt um jeweilige Klasse auszuführen
        if (spieler.getPosY()+chngY >= 0 && spieler.getPosX()+chngX >= 0 && spieler.getPosY()+chngY < sizeY && spieler.getPosX()+chngX < sizeX) {
            if (mapOrte[spieler.getPosX()+chngX][spieler.getPosY()+chngY] instanceof BossFight) {
                ((BossFight) mapOrte[spieler.getPosX()+chngX][spieler.getPosY()+chngY]).start();
            }
            if (!mapBounds[spieler.getPosX()+chngX][spieler.getPosY()+chngY]) {
                spieler.setPosX(spieler.getPosX() + chngX);
                spieler.setPosY(spieler.getPosY() + chngY);
                if (mapOrte[spieler.getPosX()][spieler.getPosY()] != null) {
                    if (mapOrte[spieler.getPosX()][spieler.getPosY()] instanceof Minigame) {
                        ((Minigame) mapOrte[spieler.getPosX()][spieler.getPosY()]).start();
                    }
                    if (mapOrte[spieler.getPosX()][spieler.getPosY()] instanceof Shop) {
                        ((Shop) mapOrte[spieler.getPosX()][spieler.getPosY()]).start();
                    }
                }
            }
        }
    }

    /**
     * Add the texture of a special place to the map
     * @param place
     */
    public void applyOrt(Ort place) {
        mapOrte[place.getPositionX()][place.getPositionY()] = place;
        if(place.getGrafik() != null){
            applyTexture(place.getPositionX(), place.getPositionY(), place.getGrafik());
        }
    }
    public void removeOrt(int x, int y){
        mapOrte[x][y] = null;
    }

    public void applyOrtTexture(Ort place, String grafik) {
        mapOrte[place.getPositionX()][place.getPositionY()] = place;
        applyTexture(place.getPositionX(), place.getPositionY(), grafik);
    }
    public void applyOrtTexture(Ort place, Image grafik) {
        mapOrte[place.getPositionX()][place.getPositionY()] = place;
        applyTexture(place.getPositionX(), place.getPositionY(), grafik);
    }

    public void applyTexture(int x, int y, String grafik) {
        mapTextures[x][y].setImage(new Image(grafik));
    }
    
    public void applyTexture(int x, int y, Image grafik) {
        mapTextures[x][y].setImage(grafik);
    }

    public void applyBounds(int x, int y, boolean blocked) {
        mapBounds[x][y] = blocked;
    }

    public int getSizeX(){
        return 42;
    }

    public int getSizeY(){
        return 26;
    }

    public String[] getTextures() {
        return textures;
    }

}
