package gis.abi23e5if1lem.tamodatschi.tamodatschi;
//hier wird ein Timer erstellt um später draud zugreifen zu können
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
