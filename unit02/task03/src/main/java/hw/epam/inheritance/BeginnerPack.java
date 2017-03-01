package hw.epam.inheritance;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MM8 on 01.03.2017.
 */
public class BeginnerPack {
    private static Set<Stationary> beginnersSet = new HashSet<>();

    static {
        beginnersSet.add(new Notebook(100, "Moleskin", 100));
        beginnersSet.add(new Pencil(5, "bic", "grey", 1, Hardness.SOFT));
        beginnersSet.add(new Ruler(10, "idk", 15));
        beginnersSet.add(new Eraser(10, "idk"));
    }

    private BeginnerPack() {
    }

    public static Set<Stationary> getBeginnersSet() {
        return Collections.unmodifiableSet(beginnersSet);
    }

    public static BeginnerPack getBeginnerPack() {
        return new BeginnerPack();
    }
}
