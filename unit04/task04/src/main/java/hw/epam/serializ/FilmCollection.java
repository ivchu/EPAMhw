package hw.epam.serializ;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MM8 on 10.03.2017.
 */
public class FilmCollection implements Serializable {
    private Map<Film, List<Actor>> films = new HashMap<>();

    public void addFilm(Film film, Actor... actors) {
        ArrayList filmActors = new ArrayList();
        for (Actor actor : actors) {
            filmActors.add(actor);
        }
        films.put(film, filmActors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmCollection that = (FilmCollection) o;

        return films.equals(that.films);

    }

    @Override
    public int hashCode() {
        return films.hashCode();
    }

    public void saveFilmCollectionToFile(String fileName) throws IOException {
        checkFileName(fileName);
        FileOutputStream serialeOutput = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(serialeOutput);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        serialeOutput.close();
    }

    private void checkFileName(String fileName) {
        if (fileName == null) {
            throw new NullPointerException("filename cant be null");
        }
    }

    public FilmCollection loadFilmCollectionFromFile(String fileName) throws IOException, ClassNotFoundException {
        checkFileName(fileName);
        FileInputStream serialInput = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(serialInput);
        FilmCollection collection = (FilmCollection) objectInputStream.readObject();
        serialInput.close();
        objectInputStream.close();
        return collection;
    }
}
