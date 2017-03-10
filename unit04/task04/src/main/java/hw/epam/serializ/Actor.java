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
}
