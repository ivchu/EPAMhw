package hw.epam.inheritance;

/**
 * Created by MM8 on 01.03.2017.
 */
public abstract class Stationary {
    private int cost;
    private String manufacturer;

    public Stationary(int cost, String manufactor) {
        this.cost = cost;
        this.manufacturer = manufactor;
    }

    public int getCost() {
        return cost;
    }

    public String getManufactor() {
        return manufacturer;
    }
}
