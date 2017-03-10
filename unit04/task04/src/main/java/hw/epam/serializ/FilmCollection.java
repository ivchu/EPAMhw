package hw.epam.serializ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MM8 on 10.03.2017.
 */
public class FilmCollection implements Serializable{
    private Map<Film, List<Actor>> films = new HashMap<>();

    public void addFilm(Film film, Actor... actors){
        ArrayList filmActors = new ArrayList();
        for (Actor actor : actors) {
            filmActors.add(actor);
        }
        films.put(film, filmActors);
    }
}
