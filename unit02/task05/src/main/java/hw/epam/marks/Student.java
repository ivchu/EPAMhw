package hw.epam.marks;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MM8 on 02.03.2017.
 */
public class Student {
    private Map<Disciplines, Mark> particapatingDisciplines = new HashMap<>();

    public void addDisciplineWithMark (Disciplines discipline, Mark mark){
        if (discipline.canDisciplineAcceptThisKindOfMark(discipline, mark)) {
            particapatingDisciplines.put(discipline, mark);
        }
    }

    public Map<Disciplines, Mark> getParticapatingDisciplines(){
        return Collections.unmodifiableMap(particapatingDisciplines);
    }
}
