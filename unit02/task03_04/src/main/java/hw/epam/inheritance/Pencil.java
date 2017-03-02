package hw.epam.inheritance;

/**
 * Created by MM8 on 01.03.2017.
 */
public class Pencil extends WrtingStationary {
    private Hardness hardness;

    public Pencil(int cost, String manufactor, String color, double thickness, Hardness hardness) {
        super(cost, manufactor, color, thickness);
        this.hardness = hardness;
    }

    public Hardness getHardness() {
        return hardness;
    }
}
