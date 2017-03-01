package hw.epam.inheritance;

/**
 * Created by MM8 on 01.03.2017.
 */
public class Ruler extends Stationary{
    private int length;

    public Ruler(int cost, String manufactor, int length) {
        super(cost, manufactor);
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
