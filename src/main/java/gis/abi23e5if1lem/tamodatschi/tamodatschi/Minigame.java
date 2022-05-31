package gis.abi23e5if1lem.tamodatschi.tamodatschi;

import java.util.Random;

public class Minigame {
    public void start() {
        Random r = new Random();
        switch (r.nextInt(3)){
            case 0:
                SchereSteinPapier ssp = new SchereSteinPapier();
                ssp.start();
                break;
        }
    }

    public Minigame(){
    }
}
