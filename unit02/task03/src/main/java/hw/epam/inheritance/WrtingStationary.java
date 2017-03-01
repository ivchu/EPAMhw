package hw.epam.inheritance;

/**
 * Created by MM8 on 01.03.2017.
 */
public abstract class WrtingStationary extends Stationary {
    private String color;
    private double thickness;

    public WrtingStationary(int cost, String manufactor, String color, double thickness) {
        super(cost, manufactor);
        this.color = color;
        this.thickness = thickness;
    }

    public String getColor() {
        return color;
    }

    public double getThickness() {
        return thickness;
    }
}
