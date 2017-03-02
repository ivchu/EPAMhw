package hw.epam.inheritance;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MM8 on 01.03.2017.
 */
public class BeginnerPackTest extends TestCase {


    public void testForBeginnerListInBeginnerPack() {
        final List<Stationary> beginnersList = new ArrayList<>();
        beginnersList.add(new Pencil(5, "bic", "grey", 1, Hardness.SOFT));
        beginnersList.add(new Ruler(10, "idk", 15));
        beginnersList.add(new Eraser(11, "idk"));
        beginnersList.add(new Notebook(100, "Moleskin", 100));

        BeginnerPack beginnerPack = BeginnerPack.getBeginnerPack();
        beginnerPack.sortByCostThenManufaturer();
        List<Stationary> gettingFromBeginnerPack = beginnerPack.getBeginnersList();

        assertEquals(beginnersList, gettingFromBeginnerPack);
    }

    

}