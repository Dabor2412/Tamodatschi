package gis.abi23e5if1lem.tamodatschi.tamodatschi;

public class Essen {

    private String name;
    private int buff;

    public Essen(String name, int buff) {
        this.name = name;
        this.buff = buff;
    }

    public void konsumieren(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getBuffs() {
        return buffs;
    }

    public void setBuffs(int[] buffs) {
        this.buffs = buffs;
    }
}
