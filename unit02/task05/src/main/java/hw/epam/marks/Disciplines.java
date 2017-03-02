package hw.epam.marks;

/**
 * Created by MM8 on 02.03.2017.
 */
public enum Disciplines {
    PHYSICS(Double.class),
    MATH(Double.class),
    PHILOSOPHY(Integer.class),
    ENGLISH(Integer.class),
    PROGRAMMING(Double.class);

    private Class markType;

    Disciplines(Class markType){
        this.markType = markType;
    }

}
