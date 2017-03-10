package hw.epam.serializ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by MM8 on 10.03.2017.
 */
public class Actor implements Serializable{
    private String name;
    private int age;
    private List<Film> films = new ArrayList<>();

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Film> getFilms() {
        return Collections.unmodifiableList(films);
    }

    public void addFilm(Film film){
        films.add(film);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (age != actor.age) return false;
        if (!name.equals(actor.name)) return false;
        return films != null ? films.equals(actor.films) : actor.films == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + (films != null ? films.hashCode() : 0);
        return result;
    }
}
