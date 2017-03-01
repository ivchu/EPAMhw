package stationery;

/**
 * Created by MM8 on 01.03.2017.
 */
public class Stationery {
    private int cost;
    private String stationeryName;

    public Stationery(String stationeryName, int cost){
        this.stationeryName = stationeryName;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getStationeryName() {
        return stationeryName;
    }
}
