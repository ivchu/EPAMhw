package hw.epam.marks;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MM8 on 02.03.2017.
 */
public class Student {
    private Map<Disciplines, Mark> particapatingDisciplines = new HashMap<>();

    public void addDisciplineWithMark (Disciplines discipline, Mark mark){
        particapatingDisciplines.put(discipline, mark);
    }
}
