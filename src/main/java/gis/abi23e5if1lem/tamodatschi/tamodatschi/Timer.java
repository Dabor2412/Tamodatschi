package gis.abi23e5if1lem.tamodatschi.tamodatschi;

public class Timer {
    public void waitSecs(int secs) {
        double startTime = System.currentTimeMillis();
        while(true) {
            if (System.currentTimeMillis() > startTime + (secs * 1000)) {
                break;
            }
        }
    }
}
