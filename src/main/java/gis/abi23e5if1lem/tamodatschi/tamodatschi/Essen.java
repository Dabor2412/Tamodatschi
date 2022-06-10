package gis.abi23e5if1lem.tamodatschi.tamodatschi;
//Klasse mit den Attributen Name, Buff und Preis. Entsprechenden Setter- und Gettermethoden sind falls nötig vorhanden.
public class Essen {

    private String name;
    private int buff;
    private int price;

    public Essen(String name, int buff, int preis) {
        this.name = name;
        this.buff = buff;
        this.price = preis;
    }

    public void konsumieren(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuff() {
        return buff;
    }

    public void setBuffs(int buffs) {
        this.buff = buffs;
    }

    public int getPrice() {
        return this.price;
    }
}
