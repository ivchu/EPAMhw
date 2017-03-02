package hw.epam.inheritance;

/**
 * Created by MM8 on 01.03.2017.
 */
public class Pen extends WrtingStationary {
    PenType penType;

    public Pen(int cost, String manufactor, String color, double thickness, PenType penType) {
        super(cost, manufactor, color, thickness);
        this.penType = penType;
    }

    public PenType getPenType() {
        return penType;
    }
}
