package hw.epam.serializ;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by MM8 on 10.03.2017.
 */
public class FilmCollectionTest {
    String fileName = "C://ivan//java//epamhw//unit04//task04//src//main//serialize.txt";
    static FilmCollection filmCollection = new FilmCollection();
    static {
        Actor sidorov = new Actor("Sidorov", 55);
        filmCollection.addFilm(new Film("Brat", 99),
                new Actor[]{new Actor("Bodrov", 35), new Actor("Petrov", 45), sidorov});
        filmCollection.addFilm(new Film("TERMINATOR", 99),
                new Actor[]{new Actor("Shvartz", 35), new Actor("Malish", 15), sidorov});
        filmCollection.addFilm(new Film("Molitava", 99),
                new Actor[]{new Actor("Jedi", 65), new Actor("Japanesse", 45), sidorov});
    }


    @Test
    public void serializationTest() throws Exception {
        filmCollection.saveFilmCollectionToFile(fileName);
        FilmCollection deserializedFilm = filmCollection.loadFilmCollectionFromFile(fileName);
        assertEquals(filmCollection, deserializedFilm);
    }

}