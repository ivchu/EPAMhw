package hw.epam.inheritance;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by MM8 on 01.03.2017.
 */
public class BeginnerPackTest extends TestCase {


    public void testForBeginnerSetInBeginnerPack() {
        final Set<Stationary> beginnersSet = new HashSet<>();
        beginnersSet.add(new Notebook(100, "Moleskin", 100));
        beginnersSet.add(new Pencil(5, "bic", "grey", 1, Hardness.SOFT));
        beginnersSet.add(new Ruler(10, "idk", 15));
        beginnersSet.add(new Eraser(10, "idk"));

        Set<Stationary> gettingFromBeginnerPack = BeginnerPack.getBeginnersSet();

        assertEquals(beginnersSet, gettingFromBeginnerPack);
    }

}