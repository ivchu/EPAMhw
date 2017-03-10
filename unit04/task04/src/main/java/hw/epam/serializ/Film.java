package hw.epam.serializ;

import java.io.Serializable;

/**
 * Created by MM8 on 10.03.2017.
 */
public class Film implements Serializable{
    String filmName;
    private int lenght;

    public Film(String filmName, int lenght) {
        this.filmName = filmName;
        this.lenght = lenght;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (lenght != film.lenght) return false;
        return filmName.equals(film.filmName);

    }

    @Override
    public int hashCode() {
        int result = filmName.hashCode();
        result = 31 * result + lenght;
        return result;
    }
}
