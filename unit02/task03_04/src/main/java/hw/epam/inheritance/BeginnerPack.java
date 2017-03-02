package hw.epam.inheritance;

import java.util.*;

/**
 * Created by MM8 on 01.03.2017.
 */
public class BeginnerPack {
    private List<Stationary> beginnersList = new ArrayList<>();

    {
        beginnersList.add(new Notebook(100, "Moleskin", 100));
        beginnersList.add(new Pencil(5, "bic", "grey", 1, Hardness.SOFT));
        beginnersList.add(new Ruler(10, "idk", 15));
        beginnersList.add(new Eraser(10, "idk"));
    }

    private BeginnerPack() {
    }

    public List<Stationary> getBeginnersList() {
        return Collections.unmodifiableList(beginnersList);
    }

    public static BeginnerPack getBeginnerPack() {
        return new BeginnerPack();
    }

    public void sortByCost() {
        Comparator<Stationary> costComp = (stationary1, stationary2) ->
                Integer.compare(stationary1.getCost(), stationary2.getCost());
        Collections.sort(beginnersList, costComp);
    }

    public void sortByManufacturer() {
        Comparator<Stationary> manufacturerComp = (stationary1, stationary2) ->
                stationary1.getManufactor().compareTo(stationary2.getManufactor());
        Collections.sort(beginnersList, manufacturerComp);
    }

    public void sortByCostThenManufaturer() {
        Comparator<Stationary> costAndManuComp = (stationary1, stationary2) -> {
            int costResult;
            costResult = Integer.compare(stationary1.getCost(), stationary2.getCost());
            if (costResult == 0) {
                return stationary1.getManufactor().compareTo(stationary2.getManufactor());
            } else return costResult;
        };
        Collections.sort(beginnersList, costAndManuComp);
    }
}
