package gis.abi23e5if1lem.tamodatschi.tamodatschi;
// Minigame ist eine Unterklasse von Ort
public class Minigame extends Ort {
    //es wird festgelegt welches Minispiel ausgeführt wird
    public int minigameId = 0;
    public void start() {
        switch (minigameId){
            case 0:
                SchereSteinPapier ssp = new SchereSteinPapier();
                ssp.start(1);
                break;
            case 1:
                Memory mem = new Memory();
                mem.start(1);
                break;
        }
    }
    //Konstruktor0 
    public Minigame(int x, int y, int minigameId){
        super(x, y);
        this.minigameId = minigameId;
    }
    //Konstrucktor1
    public Minigame(int x, int y, String grafik, int minigameId){
        super(x, y, grafik);
        this.minigameId = minigameId;
    }
}
