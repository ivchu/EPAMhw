package hw.epam.inheritance;

/**
 * Created by MM8 on 01.03.2017.
 */
public class Notebook extends Stationary {
    private int sheetAmount;

    public Notebook(int cost, String manufactor, int sheetAmount) {
        super(cost, manufactor);
        this.sheetAmount = sheetAmount;
    }

    public int getSheetAmount() {
        return sheetAmount;
    }
}
