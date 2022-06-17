package gis.abi23e5if1lem.tamodatschi.tamodatschi;

/* Tamodatschi - Software School Project

    Project structure:
        - Main -> Handler before JavaFx is started
        - ...
        - ...

    Window structure:
        - Made up of 16x16 squares in a 1024x576 Window
        -> 42 Squares horizontal
        -> 26 Squares vertical

 */
//Start des Spiels. ein neues Spiel wird inizialisiert.
public class Main {

    public static Tamodatschi tdi = new Tamodatschi();

    public static void main(String[] args) {
        tdi.initGame();
    }
}
